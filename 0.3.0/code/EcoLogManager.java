package your.dir.here;

import java.time.Clock;
import java.time.Instant;

import your.dir.here.enums.LoggerCasualEnum;
import your.dir.heree.enums.LoggerWarningEnum;

public class EcoLogManager {
	
	/*
	 *@author magnemint
	*/
	
	// Create a callable instance of the Logger
	private static final EcoLogManager LOGGER = new EcoLogManager();
	public static final EcoLogManager getLogger() { return LOGGER; }
	
	/* Project Customizability Variables -> These variables
	 * are set to these values by default, but can be changed
	 * anytime by a user implementing them!
	*/
	public String clientName = "Client Name Goes Here";
	public String infoColour1 = ANSI_CYAN;
	public String infoColour2 = ANSI_GREEN;
	public String mildWarningColour = ANSI_YELLOW; // As of version 0.3 I don't do anything ;D
	public String importantWarningColour = ANSI_RED; // As of version 0.3 I don't do anything ;D
	
	// Get Enum Type
	private String consoleTypeAsString;
	private String errorTypeAsString;
	
	// Get Java Clock
	Clock clock = Clock.systemDefaultZone();
	Instant instant = clock.instant();
	
	//ANSI escape codes to add colour to console
	@SuppressWarnings("unused")
	private static final String ANSI_RESET = "\u001B[0m";
	
	@SuppressWarnings("unused")
	private static final String ANSI_BLACK = "\u001B[30m";
	
	@SuppressWarnings("unused")
	private static final String ANSI_RED = "\u001B[31m";
	
	@SuppressWarnings("unused")
	private static final String ANSI_GREEN = "\u001B[32m";
	
	@SuppressWarnings("unused")
	private static final String ANSI_YELLOW = "\u001B[33m";
	
	@SuppressWarnings("unused")
	private static final String ANSI_BLUE = "\u001B[34m";
	
	@SuppressWarnings("unused")
	private static final String ANSI_PURPLE = "\u001B[35m";
	
	@SuppressWarnings("unused")
	private static final String ANSI_CYAN = "\u001B[36m";
	
	@SuppressWarnings("unused")
	private static final String ANSI_WHITE = "\u001B[37m";
	
	//Log information with info type and what to log
	@SuppressWarnings("rawtypes")
	public void log(Enum consoleType, String text) 
	{
		//Turn the returned enum type into a string to log
		if (consoleType == LoggerCasualEnum.ProjectInfo)
		{	
			consoleTypeAsString = "Project Info";
		} 
		else if (consoleType == LoggerCasualEnum.Other) 
		{
			consoleTypeAsString = "Other Info";
		} 
		else 
		{
			consoleTypeAsString = "Unasssigned";
		}
			
		//Log the info in a clean way with colours
		System.out.println(infoColour1 + "[" + clientName + "]" + infoColour2 + " [" + instant + "] " + infoColour1 + "[" + consoleTypeAsString + "]" + " " + infoColour2 + text + ANSI_RESET);
	}
	
	//Log information with info type and what to log without colour
	@SuppressWarnings("rawtypes")
	public void logWithoutColour(Enum consoleType, String text)
	{
		//Turn the returned enum type into a string to log
		if (consoleType == LoggerCasualEnum.ProjectInfo)
		{	
			consoleTypeAsString = "Project Info";
		} 
		else if (consoleType == LoggerCasualEnum.Other) 
		{
			consoleTypeAsString = "Other Info";
		} 
		else 
		{
			consoleTypeAsString = "Unasssigned";
		}
				
		//Log the info in a clean way without colours
		System.out.println(ANSI_RESET + "[" + clientName + "]" + " [" + instant + "] " + "[" + consoleTypeAsString + "]" + " " + text + ANSI_RESET);
	}
	
	/*
	 * Log an error -> TODO: This should not be used as a replacement for the printStackTrace() 
	 * ... function intergrated with errors for debugging, this
	 * ... should only be used to log minor errors, or
	 * ... warnings. Errors would be a bit of an exaggeration.
	 * ... ALWAYS print the stacktrace of an error.
	*/
	@SuppressWarnings("rawtypes")
	public void logError(Enum errorType, String error)
	
	{
		//Turn the returned enum type into a string to log
		if (errorType == LoggerWarningEnum.ProjectError)
		{	
			errorTypeAsString = "Project Issue";
		} 
		else if (errorType == LoggerWarningEnum.ProjectWarning)
		{
			errorTypeAsString = "Project Warning";
		}
		else if (errorType == LoggerWarningEnum.Other)
		{
			errorTypeAsString = "Other Issue";
		}
		else 
		{
			errorTypeAsString = "Unasssigned";
		}
		
		//Log the info in a clean way without colours
		System.out.println(ANSI_RED + "[" + clientName + "]" + " [" + instant + "] " + "[" + errorTypeAsString + "]" + " " + error + ANSI_RESET);
	}

}
