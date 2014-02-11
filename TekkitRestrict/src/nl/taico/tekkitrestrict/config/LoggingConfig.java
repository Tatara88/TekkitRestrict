package nl.taico.tekkitrestrict.config;

import java.util.ArrayList;

public class LoggingConfig extends TRConfig {
	public static ArrayList<String> defaultContents(boolean extra){
		ArrayList<String> tbr = new ArrayList<String>(300);
		
		tbr.add("###########################################################################");
		tbr.add("## Configuration file for TekkitRestrict                                 ##");
		tbr.add("## Authors: Taeir, DreadEnd (aka DreadSlicer)                            ##");
		tbr.add("## BukkitDev: http://dev.bukkit.org/server-mods/tekkit-restrict/         ##");
		tbr.add("## Please ask questions/report issues on the BukkitDev page.             ##");
		tbr.add("###########################################################################");
		tbr.add("");
		tbr.add("###########################################################################");
		tbr.add("################################# Logging #################################");
		tbr.add("###########################################################################");
		tbr.add("");
		tbr.add("# The format of the name of the logfile.");
		tbr.add("# Default: \"{TYPE}-{DAY}-{MONTH}-{YEAR}.log\"");
		tbr.add("FilenameFormat: \"{TYPE}-{DAY}-{MONTH}-{YEAR}.log\"");
		if (extra) tbr.add("#:-;-:# FilenameFormat");
		tbr.add("");
		tbr.add("# The format to log a string.");
		tbr.add("# Default: \"[{HOUR}:{MINUTE}:{SECOND}] {INFO}\"");
		tbr.add("LogStringFormat: \"[{HOUR}:{MINUTE}:{SECOND}] {INFO}\"");
		if (extra) tbr.add("#:-;-:# LogStringFormat");
		tbr.add("");
		tbr.add("# Should debug messages be logged?");
		tbr.add("# Default: false");
		tbr.add("LogDebug: false");
		if (extra) tbr.add("#:-;-:# LogDebug");
		tbr.add("");
		tbr.add("###########################################################################");
		tbr.add("################################ Split Logs ###############################");
		tbr.add("###########################################################################");
		tbr.add("");
		tbr.add("# Should tekkitrestrict split the logs into many parts?");
		tbr.add("# (e.g. Chat, Commands, Login/Logout, Warnings, etc.)");
		tbr.add("# Default: true");
		tbr.add("SplitLogs: true");
		if (extra) tbr.add("#:-;-:# SplitLogs");
		tbr.add("");
		tbr.add("# The folder where TekkitRestrict should place the split logs.");
		tbr.add("# NOTE: The path starts at the server root.");
		tbr.add("# Example file: server_root/log/chat/chat-23-10-13.log");
		tbr.add("# Default: \"log\"");
		tbr.add("SplitLogsLocation: \"log\"");
		if (extra) tbr.add("#:-;-:# SplitLogsLocation");
		tbr.add("# There are 9 different levels:");
		tbr.add("# Severe, Warning");
		tbr.add("# Errorlevels: Severe and Warning");
		tbr.add("# Info");
		tbr.add("# Fine, Finer, Finest");
		tbr.add("# Finelevels - Fine, Finer and Finest");
		tbr.add("# All - All levels");
		tbr.add("Splitters:");
		tbr.add("    Logs:");
		tbr.add("        Description: For the login and logout");
		tbr.add("        File: Login");
		if (extra) tbr.add("#:-;-:# Splitters.Logs.File");
		tbr.add("        Level: Info");
		if (extra) tbr.add("#:-;-:# Splitters.Logs.Level");
		tbr.add("        CaseSensitive: true");
		if (extra) tbr.add("#:-;-:# Splitters.Logs.CaseSensitive");
		tbr.add("        Method: Contains");
		if (extra) tbr.add("#:-;-:# Splitters.Logs.Method");
		tbr.add("        Messages:");
		if (extra) tbr.add("#:-;-:# Splitters.Logs.Messages 3");
		tbr.add("        - \" lost connection: disconnect.\"");
		tbr.add("        - \" logged in with entity id \"");
		tbr.add("        - \" lost connection: user was kicked.\"");
		tbr.add("    Chat:");
		tbr.add("        Description: Set this to your own chatformat.");
		tbr.add("        # <Rank> <Name>: <message> --> <(.*)> <(.*)>: (.*)");
		tbr.add("        File: Chat");
		if (extra) tbr.add("#:-;-:# Splitters.Chat.File");
		tbr.add("        Level: Info");
		if (extra) tbr.add("#:-;-:# Splitters.Chat.Level");
		tbr.add("        CaseSensitive: true");
		if (extra) tbr.add("#:-;-:# Splitters.Chat.CaseSensitive");
		tbr.add("        Method: Regex");
		if (extra) tbr.add("#:-;-:# Splitters.Chat.Method");
		tbr.add("        Messages:");
		if (extra) tbr.add("#:-;-:# Splitters.Chat.Messages 1");
		tbr.add("        - \"\\\\[(.*)\\\\] (.*): (.*)\"");
		tbr.add("    Errors:");
		tbr.add("        Description: Logs all errors to a separate file.");
		tbr.add("        File: Error");
		if (extra) tbr.add("#:-;-:# Splitters.Errors.File");
		tbr.add("        Level: ErrorLevels");
		if (extra) tbr.add("#:-;-:# Splitters.Errors.Level");
		tbr.add("        CaseSensitive: true");
		if (extra) tbr.add("#:-;-:# Splitters.Errors.CaseSensitive");
		tbr.add("        Method: Regex");
		if (extra) tbr.add("#:-;-:# Splitters.Errors.Method");
		tbr.add("        Messages: [\".*\"]");
		if (extra) tbr.add("#:-;-:# Splitters.Errors.Messages");
		tbr.add("");
		tbr.add("# Should all commands be logged to a file?");
		tbr.add("# Default: Commands");
		tbr.add("# Possible: a filename or false");
		tbr.add("LogAllCommandsToFile: Command");
		if (extra) tbr.add("#:-;-:# LogAllCommandsToFile");
		tbr.add("");
		tbr.add("# Should NEI Item giving be logged to a file?");
		tbr.add("# Default: SpawnItem");
		tbr.add("# Possible: a filename or false");
		tbr.add("LogNEIGiveToFile: SpawnItem");
		if (extra) tbr.add("#:-;-:# LogNEIGiveToFile");
		tbr.add("");
		tbr.add("# EndsWith is special here, in that it does not look at the arguments, like the other methods do");
		tbr.add("# /fakecommand kick will not match \"kick\" with endswith");
		tbr.add("CommandSplitters:");
		tbr.add("    Private:");
		tbr.add("        File: PrivateChat");
		if (extra) tbr.add("#:-;-:# CommandSplitters.Private.File");
		tbr.add("        Method: Regex");
		if (extra) tbr.add("#:-;-:# CommandSplitters.Private.Method");
		tbr.add("        Commands:");
		if (extra) tbr.add("#:-;-:# CommandSplitters.Private.Commands 6");
		tbr.add("        - \"e?m(sg)?\"");
		tbr.add("        - \"e?tell\"");
		tbr.add("        - \"e?r(eply)?\"");
		tbr.add("        - \"e?reply\"");
		tbr.add("        - \"e?mail\"");
		tbr.add("        - \"e?whisper\"");
		tbr.add("    Punishments:");
		tbr.add("        Description: Should include punishment commands from most plugins automatically");
		tbr.add("        File: Punishment");
		if (extra) tbr.add("#:-;-:# CommandSplitters.Punishments.File");
		tbr.add("        Method: EndsWith");
		if (extra) tbr.add("#:-;-:# CommandSplitters.Punishments.Method");
		tbr.add("        Commands:");
		if (extra) tbr.add("#:-;-:# CommandSplitters.Punishments.Commands 7");
		tbr.add("        - \"kick\"");
		tbr.add("        - \"ban\"");
		tbr.add("        - \"mute\"");
		tbr.add("        - \"jail\"");
		tbr.add("        - \"pardon\"");
		tbr.add("        - \"banip\"");
		tbr.add("        - \"pardonip\"");
		tbr.add("    SpawnItems:");
		tbr.add("        File: SpawnItem");
		if (extra) tbr.add("#:-;-:# CommandSplitters.SpawnItems.File");
		tbr.add("        Method: Regex");
		if (extra) tbr.add("#:-;-:# CommandSplitters.SpawnItems.Method");
		tbr.add("        Commands:");
		if (extra) tbr.add("#:-;-:# CommandSplitters.SpawnItems.Commands 5");
		tbr.add("        - \"i\"");
		tbr.add("        - \"e?item\"");
		tbr.add("        - \"e?give\"");
		tbr.add("        - \"e?more\"");
		tbr.add("        - \"e?un(l(imited)?)?\"");
		tbr.add("");
		tbr.add("###########################################################################");
		tbr.add("############################### Filter Logs ###############################");
		tbr.add("###########################################################################");
		tbr.add("");
		tbr.add("# Should TekkitRestrict filter out certain things from the logs?");
		tbr.add("# Default: true");
		tbr.add("FilterLogs: true");
		if (extra) tbr.add("#:-;-:# FilterLogs");
		tbr.add("");
		tbr.add("# Here you can define the filters.");
		tbr.add("# There are 5 different methods:");
		tbr.add("# Contains - If a logmessage contains ...");
		tbr.add("# StartsWith - If a logmessage starts with ...");
		tbr.add("# EndsWith - If a logmessage ends with ...");
		tbr.add("# Equals - If a logmessage is identical to ...");
		tbr.add("# RegEx - If a logmessage matches ... (please do not use (?i))");
		tbr.add("#");
		tbr.add("# There are multiple types");
		tbr.add("# Console - Filter messages only from the console, NOT the logs");
		tbr.add("# ServerLog - Filter messages only from the server logs");
		tbr.add("# ForgeServerLog - Filter messages only from the forge logs");
		tbr.add("# All - Filter messages everywhere");
		tbr.add("# Console_ServerLog - Filter messages from the console and server logs");
		tbr.add("# Forge_ServerLog - Filter messages from forge logs and the server logs");
		tbr.add("# ");
		tbr.add("# Please make sure every groupname is unique");
		tbr.add("Filters:");
		tbr.add("    SpammyMessages1:");
		tbr.add("        Description: Spammy messages like slotChanging and Sending Triang");
		tbr.add("        Method: regex");
		if (extra) tbr.add("#:-;-:# Filters.SpammyMessages1.Method");
		tbr.add("        CaseSensitive: true");
		if (extra) tbr.add("#:-;-:# Filters.SpammyMessages1.CaseSensitive");
		tbr.add("        Type: console_serverlog");
		if (extra) tbr.add("#:-;-:# Filters.SpammyMessages1.Type");
		tbr.add("        Messages:");
		if (extra) tbr.add("#:-;-:# Filters.SpammyMessages1.Messages 2");
		tbr.add("        - \"Sending Triang: -*\\\\d+, -*\\\\d+\\\\.\\\\d+\"");
		tbr.add("        - \"slotChanging\\\\(\\\\d+\\\\)\"");
		tbr.add("    SpammyMessages2:");
		tbr.add("        Description: Filters out Repair is active.. and Player found.. Disable this if you have eepatch");
		tbr.add("        Method: equals");
		if (extra) tbr.add("#:-;-:# Filters.SpammyMessages2.Method");
		tbr.add("        CaseSensitive: true");
		if (extra) tbr.add("#:-;-:# Filters.SpammyMessages2.CaseSensitive");
		tbr.add("        Type: console_serverlog");
		if (extra) tbr.add("#:-;-:# Filters.SpammyMessages2.Type");
		tbr.add("        Messages:");
		if (extra) tbr.add("#:-;-:# Filters.SpammyMessages2.Messages 2");
		tbr.add("        - \"Repair is active..\"");
		tbr.add("        - \"Player found..\"");
		tbr.add("    MovedWrongly:");
		tbr.add("        Description: Filters incorrect moving warnings from the console.");
		tbr.add("        Method: regex");
		if (extra) tbr.add("#:-;-:# Filters.MovedWrongly.Method");
		tbr.add("        CaseSensitive: true");
		if (extra) tbr.add("#:-;-:# Filters.MovedWrongly.CaseSensitive");
		tbr.add("        Type: console");
		if (extra) tbr.add("#:-;-:# Filters.MovedWrongly.Type");
		tbr.add("        Messages:");
		if (extra) tbr.add("#:-;-:# Filters.MovedWrongly.Messages 2");
		tbr.add("        - \"Got position -*\\\\d+\\\\.\\\\d+, -*\\\\d+\\\\.\\\\d+, -*\\\\d+\\\\.\\\\d+\"");
		tbr.add("        - \"Expected -*\\\\d+\\\\.\\\\d+, -*\\\\d+\\\\.\\\\d+, -*\\\\d+\\\\.\\\\d+\"");
		tbr.add("#    IPLostConnection:");
		tbr.add("#        Description: Filters out xxx.xxx.xxx.xxx:xxxx lost connection");
		tbr.add("#        Method: regex");
		tbr.add("#        CaseSensitive: true");
		tbr.add("#        Type: console_serverlog");
		tbr.add("#        Messages:");
		tbr.add("#        - \"/\\\\d+\\\\.\\\\d+\\\\.\\\\d+\\\\.\\\\d+:\\\\d+ lost connection\"");
		tbr.add("    Join1:");
		tbr.add("        Method: startswith");
		if (extra) tbr.add("#:-;-:# Filters.Join1.Method");
		tbr.add("        CaseSensitive: true");
		if (extra) tbr.add("#:-;-:# Filters.Join1.CaseSensitive");
		tbr.add("        Type: console_serverlog");
		if (extra) tbr.add("#:-;-:# Filters.Join1.Type");
		tbr.add("        Messages:");
		if (extra) tbr.add("#:-;-:# Filters.Join1.Messages 1");
		tbr.add("        - \"Sending serverside check to: \"");
		tbr.add("    Join2:");
		tbr.add("        Description: Filters out the listing of mods a player has when joining");
		tbr.add("        Method: contains");
		if (extra) tbr.add("#:-;-:# Filters.Join2.Method");
		tbr.add("        CaseSensitive: true");
		if (extra) tbr.add("#:-;-:# Filters.Join2.CaseSensitive");
		tbr.add("        Type: console_serverlog");
		if (extra) tbr.add("#:-;-:# Filters.Join2.Type");
		tbr.add("        Messages:");
		if (extra) tbr.add("#:-;-:# Filters.Join2.Messages 1");
		tbr.add("        - \" joined with: [\"");
		tbr.add("    ConnectionErrors:");
		tbr.add("        Description: Filters out Connection reset and End of stream messages.");
		tbr.add("        Method: equals");
		if (extra) tbr.add("#:-;-:# Filters.ConnectionErrors.Method");
		tbr.add("        CaseSensitive: true");
		if (extra) tbr.add("#:-;-:# Filters.ConnectionErrors.CaseSensitive");
		tbr.add("        Type: console_serverlog");
		if (extra) tbr.add("#:-;-:# Filters.ConnectionErrors.Type");
		tbr.add("        Messages:");
		if (extra) tbr.add("#:-;-:# Filters.ConnectionErrors.Messages 2");
		tbr.add("        - \"Connection reset\"");
		tbr.add("        - \"Reached end of stream\"");
		tbr.add("#    PurifyConsole:");
		tbr.add("#        Description: Removes groupmanager info messages");
		tbr.add("#        Method: equals");
		tbr.add("#        CaseSensitive: true");
		tbr.add("#        Type: console");
		tbr.add("#        Messages:");
		tbr.add("#        - \"GroupManager - INFO -  Data files refreshed.\"");
		tbr.add("");
		/*
		tbr.add("###########################################################################");
		tbr.add("############################# Console Enhancer ############################");
		tbr.add("###########################################################################");
		tbr.add("UseLogEnchancer: true");
		tbr.add("EnchanceEssentialsCmd: true");
		tbr.add("ChangeGive: true");
		tbr.add("ShortenErrors: true");
		tbr.add("EnhanceEssentialsCmdDeny: true");
		tbr.add("#RemovePlayerTags: false");
		tbr.add("");
		tbr.add("#Reformat:");
		tbr.add("#    Option1:");
		tbr.add("#        Message: \"\\\\[(.*)\\\\] \\\\[(.*)\\\\] (.*): (.*)\"");
		tbr.add("#        Replacement: \"\\\\[($2)\\\\] ($3): ($4)\"");
		tbr.add("");*/
		tbr.add("###########################################################################");
		tbr.add("############################# Log Hacks/Dupes #############################");
		tbr.add("###########################################################################");
		tbr.add("# NOTE: These will be logged at plugins/tekkitrestrict/log/");
		tbr.add("");
		tbr.add("# When a user is FlyHacking, should it be logged?");
		tbr.add("# Default: true");
		tbr.add("LogFlyHack: true");
		if (extra) tbr.add("#:-;-:# LogFlyHack");
		tbr.add("");
		tbr.add("# When a user is SpeedHacking, should it be logged?");
		tbr.add("# Default: true");
		tbr.add("LogMovementSpeedHack: true");
		if (extra) tbr.add("#:-;-:# LogMovementSpeedHack");
		tbr.add("");
		tbr.add("# When a user is ForcefieldHacking, should it be logged?");
		tbr.add("# Default: true");
		tbr.add("LogForcefieldHack: true");
		if (extra) tbr.add("#:-;-:# LogForcefieldHack");
		tbr.add("");
		tbr.add("# When a player (tries to) dupe, should it be logged?");
		tbr.add("# Default: true");
		tbr.add("LogDupes: true");
		if (extra) tbr.add("#:-;-:# LogDupes");
		tbr.add("");
		tbr.add("###########################################################################");
		tbr.add("############################## Log EE Items ###############################");
		tbr.add("###########################################################################");
		tbr.add("# NOTE: These will be logged at plugins/tekkitrestrict/log/");
		tbr.add("");
		tbr.add("# When a player uses an amulet, should it be logged?");
		tbr.add("# Default: true");
		tbr.add("LogAmulets: true");
		if (extra) tbr.add("#:-;-:# LogAmulets");
		tbr.add("");
		tbr.add("# When a player uses a ring, should it be logged?");
		tbr.add("# Default: true");
		tbr.add("LogRings: true");
		if (extra) tbr.add("#:-;-:# LogRings");
		tbr.add("");
		tbr.add("# When a player uses a Dark Matter Tool, should it be logged?");
		tbr.add("# Default: true");
		tbr.add("LogDMTools: true");
		if (extra) tbr.add("#:-;-:# LogDMTools");
		tbr.add("");
		tbr.add("# When a player uses a Red Matter Tool, should it be logged?");
		tbr.add("# Default: true");
		tbr.add("LogRMTools: true");
		if (extra) tbr.add("#:-;-:# LogRMTools");
		tbr.add("");
		tbr.add("# When a player uses certain EE items, should it be logged?");
		tbr.add("# Default: true");
		tbr.add("LogEEMisc: true");
		if (extra) tbr.add("#:-;-:# LogEEMisc");
		tbr.add("");
		tbr.add("# When a player uses a Destructive EE item, should it be logged?");
		tbr.add("# Default: true");
		tbr.add("LogEEDestructive: true");
		if (extra) tbr.add("#:-;-:# LogEEDestructive");
		tbr.add("");
		tbr.add("###########################################################################");
		tbr.add("###########################################################################");
		tbr.add("###########################################################################");
		
		return tbr;
	}
	
	public static void upgradeFile(){
		upgradeFile("Logging", convertDefaults(defaultContents(true)));
	}
}
