package nl.taico.tekkitrestrict;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import nl.taico.tekkitrestrict.Log.Warning;
import nl.taico.tekkitrestrict.lib.RandomString;

public class PatchCC {
	private static final String s = File.separator;
	private static Character nul = '\000';
	public static void start(){
		final File patched = new File("mods"+s+"ComputerCraft"+s+"lua"+s+"rom"+s+"patched3"+s);
		if (patched.exists()) return;
		
		BufferedReader input = null;
		final File file = new File("mods"+s+"ComputerCraft"+s+"lua"+s+"rom"+s+"startup"+s);
		if (!file.exists()){
			Warning.load("[CCPatch] ComputerCraft file cannot be found! (" + file.getAbsolutePath() + ")", false);
			return;
		}
		
		try {
			input = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e2) {
			Warning.load("[CCPatch] ComputerCraft file cannot be found! (" + file.getAbsolutePath() + ")", false);
			return;
		}
		
		
		final LinkedList<String> lines = new LinkedList<String>();
		try {
			String line;
			while ((line = input.readLine()) != null){
				lines.add(line);
			}
			input.close();
		} catch (IOException e) {
			Warning.load("[CCPatch] Cannot read ComputerCraft file! (" + file.getAbsolutePath() + ")", false);
			try {
				input.close();
			} catch (IOException e1) {}
			return;
		}
		boolean rebootPatch = true, rsCrashPatch = true, nulPatch = true;
		for (final String curline : lines){
			if (curline == null) continue;
			if (curline.contains("os.reboot = nil") || curline.contains("os.reboot=nil")) rebootPatch = false;
			else if (curline.contains("bypassAntiRedstoneCrashBug = rs.setOutput") || curline.contains("rs.setOutput = function(side, bool)")) rsCrashPatch = false;
			
			if (!rebootPatch && !rsCrashPatch) break;
		}
		
		if (!rebootPatch && !rsCrashPatch && !nulPatch){
			try {
				patched.createNewFile();
			} catch (IOException e) {
				Warning.load("[CCPatch] Unable to write patched file!", false);
				return;
			}
			return;
		}

		if (rebootPatch){
			tekkitrestrict.log.info("[CCPatch] Adding reboot patch...");
			lines.add(0, "os.reboot = nil");
			tekkitrestrict.log.info("[CCPatch] Reboot patch added.");
		} else {
			tekkitrestrict.log.info("[CCPatch] Reboot patch already found, skipping reboot patch...");
		}
		
		if (rsCrashPatch) {
			final String extra = new RandomString(10).nextString();
			tekkitrestrict.log.info("[CCPatch] Adding redstone crash patch...");
			lines.add(extra+"bypassAntiRedstoneCrashBug = rs.setOutput");
			lines.add("rs.setOutput = function(side, bool)");
			lines.add("    sleep(0.05)");
			lines.add("    "+extra+"bypassAntiRedstoneCrashBug(side, bool)");
			lines.add("end");
			tekkitrestrict.log.info("[CCPatch] Redstone crash patch added.");
		} else {
			tekkitrestrict.log.info("[CCPatch] Redstone crash patch already found, skipping redstone crash patch...");
		}
		
		if (nulPatch){
			
			boolean corrupt = false;
			final char d = RandomString.randomChar();
			for (int i = 0;i<lines.size();i++){
				final String l = lines.get(i);
				final String l2 = l.replace(nul, d);
				if (!l.equals(l2)){
					corrupt = true;
					lines.set(i, l2);
				}
			}
			
			if (corrupt){
				tekkitrestrict.log.info("[CCPatch] Your Computers startupfile was corrupt and has been repaired!");
			}
			
			/*
			char d = RandomString.randomChar();
			for (char c : BrokenRandomString.symbols){
				for (String line : lines){
					line.replace(c, d);
				}
			}*/
			
		}
		
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(file));
			for (final String line2 : lines){
				output.append(line2);
				output.newLine();
			}
			output.close();
		} catch (IOException e) {
			Warning.load("[CCPatch] Unable to write changes to file!", false);
			return;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			Warning.other("[CCPatch] Unable to write patched file!", false);
			return;
		}
		tekkitrestrict.log.info("[CCPatch] Patching completed!");
		return;
	}
}
