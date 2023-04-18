package your.directory.here;

import java.time.Clock;
import java.time.Instant;

import your.directory.here.enums.LoggerCasualEnum;
import your.directory.here.enums.LoggerWarningEnum;

public class ClientLogger {
	
	//Create a callable instance of the Logger
	private static final ClientLogger LOGGER = new ClientLogger();
	public static final ClientLogger getLogger() { return LOGGER; }
	
	//Client Name
	private String clientName = "Client Name Goes Here";
	
	//Get Enum Type
	private LoggerCasualEnum casualEnum;
	private LoggerWarningEnum errorEnum;
	private String consoleTypeAsString;
	private String errorTypeAsString;
	
	//Get Java Clock
	Clock clock = Clock.systemDefaultZone();
	Instant instant = clock.instant();
	
	//ANSI escape codes to add colour to console
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_PURPLE = "\u001B[35m";
	private static final String ANSI_CYAN = "\u001B[36m";
	private static final String ANSI_WHITE = "\u001B[37m";
	
	//Log information with info type and what to log
	public void log(Enum consoleType, String text) 
	{
		//Turn the returned enum type into a string to log
		if (consoleType == casualEnum.ClientInfo)
		{	
			consoleTypeAsString = "Client Info";
		} 
		else if (consoleType == casualEnum.LoginStatus) 
		{
			consoleTypeAsString = "Login Status";
		} 
		else if (consoleType == casualEnum.Misc)
		{
			consoleTypeAsString = "Misc";
		}
		else 
		{
			consoleTypeAsString = "Unasssigned";
		}
			
		//Log the info in a clean way with colours
		System.out.println(ANSI_CYAN + "[" + clientName + "]" + ANSI_GREEN + " [" + instant + "] " + ANSI_CYAN + "[" + consoleTypeAsString + "]" + " " + ANSI_GREEN + text + ANSI_RESET);
	}
	
	//Log information with info type and what to log without colour
	public void logWithoutColour(Enum consoleType, String text)
	{
		//Turn the returned enum type into a string to log
		if (consoleType == casualEnum.ClientInfo)
		{	
			consoleTypeAsString = "Client Info";
		} 
		else if (consoleType == casualEnum.LoginStatus) 
		{
			consoleTypeAsString = "Login Status";
		} 
		else if (consoleType == casualEnum.Misc)
		{
			consoleTypeAsString = "Misc";
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
	public void logError(Enum errorType, String error)
	{
		//Turn the returned enum type into a string to log
		if (errorType == errorEnum.LoginFaliure)
		{	
			errorTypeAsString = "Login Faliure";
		} 
		else if (errorType == errorEnum.Other)
		{
			errorTypeAsString = "Other";
		}
		else 
		{
			errorTypeAsString = "Unasssigned";
		}
		
		//Log the info in a clean way without colours
		System.out.println(ANSI_RED + "[" + clientName + "]" + " [" + instant + "] " + "[" + errorTypeAsString + "]" + " " + error + ANSI_RESET);
	}

}
