/**
 * 
 */
package com.github.dreadslicer.tekkitrestrict;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateConfigFiles {

	public static String s = File.separator;
	
	public static void v09(){
		tekkitrestrict.loadWarning("The config file version differs from the current one.");
		tekkitrestrict.loadWarning("Backing up old config files and writing new ones.");
		
		String path = "plugins"+s+"tekkitrestrict"+s;
		String bpath = path+"config_backup";
		File temp = new File(bpath);
		temp.mkdirs();
		bpath += s;
		
		tekkitrestrict tr = tekkitrestrict.getInstance();
		
		tr.backupConfig(path + "General.config.yml", bpath + "General.config.yml");
		tr.backupConfig(path + "Advanced.config.yml", bpath + "Advanced.config.yml");
		tr.backupConfig(path + "ModModifications.config.yml", bpath + "ModModifications.config.yml");
		tr.backupConfig(path + "DisableClick.config.yml", bpath + "DisableClick.config.yml");
		tr.backupConfig(path + "DisableItems.config.yml", bpath + "DisableItems.config.yml");
		tr.backupConfig(path + "Hack.config.yml", bpath + "Hack.config.yml");
		tr.backupConfig(path + "LimitedCreative.config.yml", bpath + "LimitedCreative.config.yml");
		tr.backupConfig(path + "Logging.config.yml", bpath + "Logging.config.yml");
		tr.backupConfig(path + "TPerformance.config.yml", bpath + "TPerformance.config.yml");
		tr.backupConfig(path + "MicroPermissions.config.yml", bpath + "MicroPermissions.config.yml");
		tr.backupConfig(path + "SafeZones.config.yml", bpath + "SafeZones.config.yml");
		tr.backupConfig(path + "EEPatch.config.yml", bpath + "EEPatch.config.yml");
		
		tr.saveDefaultConfig(true);
		tr.reloadConfig();
		
		tekkitrestrict.loadWarning("New config files have been written. Please set the required settings in the new config files.");
	}
	
	public static void v11(){
		//System.out.println("Updating the config files from v1.1 to v1.3...");
		tekkitrestrict.log.info("Updating the config files from v1.1 to v1.3...");
		
		General11To13();
		TPerformance11To13();
		
		//System.out.println("The config files were successfully updated!");
		tekkitrestrict.log.info("The config files were successfully updated!");
	}
	
	public static void v12(){
		//System.out.println("Updating the config files from v1.1 to v1.3...");
		tekkitrestrict.log.info("Updating the config files from v1.1 to v1.3...");
		
		General11To13();
		TPerformance11To13();
		
		//System.out.println("The config files were successfully updated!");
		tekkitrestrict.log.info("The config files were successfully updated!");
	}
	
	private static void General11To13(){
		//File genConfig = new File("C:\\Users\\Taico\\Desktop\\All Ozonelayer\\Ozonelayer 2\\plugins\\tekkitrestrict_old"+s+"General.config.yml");
		File genConfig = new File("plugins"+s+"tekkitrestrict"+s+"General.config.yml");
		tekkitrestrict.getInstance().backupConfig(genConfig.getPath(), "plugins"+s+"tekkitrestrict"+s+"General.config_backup.yml");
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(genConfig));
		} catch (FileNotFoundException e2) {
			//System.out.println("[UpdateConfig] Cannot Find General.config.yml! (" + genConfig.getAbsolutePath() + ")");
			tekkitrestrict.loadWarning("Cannot Find General.config.yml! (" + genConfig.getAbsolutePath() + ")");
			return;
		}
		
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			while ((line = input.readLine()) != null){
				lines.add(line);
			}
			input.close();
		} catch (IOException e) {
			//System.out.println("[UpdateConfig] Cannot read General.config.yml! (" + genConfig.getAbsolutePath() + ")");
			tekkitrestrict.loadWarning("Cannot read General.config.yml! (" + genConfig.getAbsolutePath() + ")");
			try {
				input.close();
			} catch (IOException e1) {}
			return;
		}
		
		int ccoption = 0, veroption = 0;
		for (int i = 0;i < lines.size();i++){
			String l = lines.get(i);
			if (l.contains("UseAutoRPTimer:")){
				ccoption = i;
			} else if (l.contains("ConfigVersion:")) {
				veroption = i+1;
			}
		}
		if (ccoption == 0 || veroption == 0){
			tekkitrestrict.loadWarning("General.config.yml is malformed and cannot be patched!");
			tekkitrestrict.loadWarning("Please make a backup of the file, delete it and restart the server to let a new one generate.");
			return;
		}
		lines.add(ccoption, "# Patch ComputerCraft once to prevent some server crashes with\n# ComputerCraft computers.\n# Default: true\nPatchComputerCraft: true\n");
		lines.remove(veroption);
		lines.add(veroption, "ConfigVersion: 1.3");
		
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(genConfig));
			for (String line2 : lines){
				output.append(line2);
				output.newLine();
			}
			output.close();
		} catch (IOException e) {
			//System.out.println("Unable to write changes to General.config.yml!");
			tekkitrestrict.loadWarning("Unable to write changes to General.config.yml!");
			return;
		}
	}
	
	private static void General12To13(){
		//File genConfig = new File("C:\\Users\\Taico\\Desktop\\All Ozonelayer\\Ozonelayer 2\\plugins\\tekkitrestrict_old"+s+"General.config.yml");
		File genConfig = new File("plugins"+s+"tekkitrestrict"+s+"General.config.yml");
		tekkitrestrict.getInstance().backupConfig(genConfig.getPath(), "plugins"+s+"tekkitrestrict"+s+"General.config_backup.yml");
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(genConfig));
		} catch (FileNotFoundException e2) {
			//System.out.println("[UpdateConfig] Cannot Find General.config.yml! (" + genConfig.getAbsolutePath() + ")");
			tekkitrestrict.loadWarning("Cannot Find General.config.yml! (" + genConfig.getAbsolutePath() + ")");
			return;
		}
		
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			while ((line = input.readLine()) != null){
				lines.add(line);
			}
			input.close();
		} catch (IOException e) {
			//System.out.println("[UpdateConfig] Cannot read General.config.yml! (" + genConfig.getAbsolutePath() + ")");
			tekkitrestrict.loadWarning("Cannot read General.config.yml! (" + genConfig.getAbsolutePath() + ")");
			try {
				input.close();
			} catch (IOException e1) {}
			return;
		}
		
		int veroption = 0;
		for (int i = 0;i < lines.size();i++){
			if (lines.get(i).contains("ConfigVersion:")) {
				veroption = i;
			}
		}
		if (veroption == 0){
			tekkitrestrict.loadWarning("General.config.yml is malformed and cannot be patched!");
			tekkitrestrict.loadWarning("Please make a backup of the file, delete it and restart the server to let a new one generate.");
			return;
		}
		lines.remove(veroption);
		lines.add(veroption, "ConfigVersion: 1.3");
		
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(genConfig));
			for (String line2 : lines){
				output.append(line2);
				output.newLine();
			}
			output.close();
		} catch (IOException e) {
			//System.out.println("Unable to write changes to General.config.yml!");
			tekkitrestrict.loadWarning("Unable to write changes to General.config.yml!");
			return;
		}
	}
	
	private static void TPerformance11To13(){
		File perfConfig = new File("plugins"+s+"tekkitrestrict"+s+"TPerformance.config.yml");
		tekkitrestrict.getInstance().backupConfig(perfConfig.getPath(), "plugins"+s+"tekkitrestrict"+s+"TPerformance.config_backup.yml");
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(perfConfig));
		} catch (FileNotFoundException e2) {
			//System.out.println("Cannot Find TPerformance.config.yml! (" + perfConfig.getAbsolutePath() + ")");
			tekkitrestrict.loadWarning("Cannot Find TPerformance.config.yml! (" + perfConfig.getAbsolutePath() + ")");
			return;
		}
		
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			while ((line = input.readLine()) != null){
				lines.add(line);
			}
			input.close();
		} catch (IOException e) {
			//System.out.println("Cannot read TPerformance.config.yml! (" + perfConfig.getAbsolutePath() + ")");
			tekkitrestrict.loadWarning("Cannot read TPerformance.config.yml! (" + perfConfig.getAbsolutePath() + ")");
			try {
				input.close();
			} catch (IOException e1) {}
			return;
		}
		
		int mcoption = 0, radoption = 0;
		for (int i = 0;i < lines.size();i++){
			String l = lines.get(i);
			if (l.contains("# Default: 4000")){
				mcoption = i;
			} else if (l.contains("MaxChunks: ")) {
				if (mcoption != i-1){
					tekkitrestrict.loadWarning("TPerformance.config.yml is malformed and cannot be patched!");
					tekkitrestrict.loadWarning("Please make a backup of the file, delete it and restart the server to let a new one generate.");
					return;
				}
			} else if (l.contains("# The default is 128 blocks (8 chunks).")){
				radoption = i;
			}
		}
		if (mcoption == 0 || radoption == 0){
			tekkitrestrict.loadWarning("TPerformance.config.yml is malformed and cannot be patched!");
			tekkitrestrict.loadWarning("Please make a backup of the file, delete it and restart the server to let a new one generate.");
			return;
		}
		
		lines.remove(radoption);
		lines.add(radoption, "# The default for TekkitRestrict is 128 blocks (8 chunks).\n# Minecraft's default is 256 blocks (16 chunks).\n#\n# Recommended: 128-256");
		
		
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(perfConfig));
			for (String line2 : lines){
				output.append(line2);
				output.newLine();
			}
			output.close();
		} catch (IOException e) {
			//System.out.println("Unable to write changes to General.config.yml!");
			tekkitrestrict.loadWarning("Unable to write changes to TPerformance.config.yml!");
			return;
		}
	}
}