package your.dir.here;

import java.util.Date;  

import your.dir.here.enums.LoggerCasualEnum;
import your.dir.here.enums.LoggerWarningEnum;

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
	public String clientName = "Project Name";
	public String infoColour1 = "Cyan";
	public String infoColour2 = "Green";
	public String mildWarningColour = "Red";
	public String importantWarningColour = "Yellow"; 
	
	//Other Random Boolean
	private Boolean useMildColour = false;
	
	// Get Enum Type
	private String consoleTypeAsString;
	private String errorTypeAsString;
	
	//Get Clock
	java.util.Date date = new java.util.Date();  
	
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
	
	//Get clock time for printing
	public Date getTime() 
	{
		return date;
	}
	
	//Log information with info type and what to log
	@SuppressWarnings("rawtypes")
	public void log(Enum consoleType, String text) 
	{
		//Called to update/optimise the user experience in console
		checkCustomisations();
		
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
		System.out.println(infoColour1 + "[" + clientName + "]" + infoColour2 + " [" + getTime() + "] " + infoColour1 + "[" + consoleTypeAsString + "]" + " " + infoColour2 + text + ANSI_RESET);
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
		System.out.println(ANSI_RESET + "[" + clientName + "]" + " [" + getTime() + "] " + "[" + consoleTypeAsString + "]" + " " + text + ANSI_RESET);
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
		//Called to update/optimise the user experience in console
		checkCustomisations();
		
		//Turn the returned enum type into a string to log
		if (errorType == LoggerWarningEnum.ProjectError)
		{	
			errorTypeAsString = "Project Issue";
			useMildColour = false;
			
		} 
		else if (errorType == LoggerWarningEnum.ProjectWarning)
		{
			errorTypeAsString = "Project Warning";
			useMildColour = false;
		}
		else if (errorType == LoggerWarningEnum.Other)
		{
			errorTypeAsString = "Other Issue";
			useMildColour = true;
		}
		else 
		{
			errorTypeAsString = "Unasssigned";
			useMildColour = false;
		}
		
		//Log the info in a clean way without colours
		if (useMildColour == true)
		{
			System.out.println(importantWarningColour + "[" + clientName + "]" + " [" + getTime() + "] " + "[" + errorTypeAsString + "]" + " " + error + ANSI_RESET);
		}
		else 
		{
			System.out.println(importantWarningColour + "[" + clientName + "]" + " [" + getTime() + "] " + "[" + errorTypeAsString + "]" + " " + error + ANSI_RESET);
		}
			
	}
	
	//Checks to see if the user has changed any of the customizable values
	private void checkCustomisations()
	{
		//Sets the strings to lower case to check
		String if1 = infoColour1.toLowerCase();
		String if2 = infoColour2.toLowerCase();
		String mwc = mildWarningColour.toLowerCase();
		String iwc = importantWarningColour.toLowerCase();
		
		//Checks infoColour1 field
		if (if1.equals("none"))
		{
			infoColour1 = ANSI_RESET;
		}
		else if (if1.equals("black"))
		{
			infoColour1 = ANSI_BLACK;
		}
		else if (if1.equals("red"))
		{
			infoColour1 = ANSI_RED;
		}
		else if (if1.equals("green"))
		{
			infoColour1 = ANSI_GREEN;
		}
		else if (if1.equals("yellow")) 
		{
			infoColour1 = ANSI_YELLOW;
		}
		else if (if1.equals("blue"))
		{
			infoColour1 = ANSI_BLUE;
		}
		else if (if1.equals("purple"))
		{
			infoColour1 = ANSI_PURPLE;
		}
		else if (if1.equals("cyan"))
		{
			infoColour1 = ANSI_CYAN;
		}
		else if (if1.equals("white"))
		{
			infoColour1 = ANSI_WHITE;
		}
		else 
		{
			infoColour1 = ANSI_CYAN;
		}
		
		//Checks infoColour2 field
		if (if2.equals("none"))
		{
			infoColour2 = ANSI_RESET;
		}
		else if (if2.equals("black"))
		{
			infoColour2 = ANSI_BLACK;
		}
		else if (if2.equals("red"))
		{
			infoColour2 = ANSI_RED;
		}
		else if (if2.equals("green"))
		{
			infoColour2 = ANSI_GREEN;
		}
		else if (if2.equals("yellow")) 
		{
			infoColour2 = ANSI_YELLOW;
		}
		else if (if2.equals("blue"))
		{
			infoColour2 = ANSI_BLUE;
		}
		else if (if2.equals("purple"))
		{
			infoColour2 = ANSI_PURPLE;
		}
		else if (if2.equals("cyan"))
		{
			infoColour2 = ANSI_CYAN;
		}
		else if (if2.equals("white"))
		{
			infoColour2 = ANSI_WHITE;
		}
		else 
		{
			infoColour2 = ANSI_GREEN;
		}
		
		//Checks mildWarningColour field
		if (mwc.equals("none"))
		{
			mildWarningColour = ANSI_RESET;
		}
		else if (mwc.equals("black"))
		{
			mildWarningColour = ANSI_BLACK;
		}
		else if (mwc.equals("red"))
		{
			mildWarningColour = ANSI_RED;
		}
		else if (mwc.equals("green"))
		{
			mildWarningColour = ANSI_GREEN;
		}
		else if (mwc.equals("yellow")) 
		{
			mildWarningColour = ANSI_YELLOW;
		}
		else if (mwc.equals("blue"))
		{
			mildWarningColour = ANSI_BLUE;
		}
		else if (mwc.equals("purple"))
		{
			mildWarningColour = ANSI_PURPLE;
		}
		else if (mwc.equals("cyan"))
		{
			mildWarningColour = ANSI_CYAN;
		}
		else if (mwc.equals("white"))
		{
			mildWarningColour = ANSI_WHITE;
		}
		else 
		{
			mildWarningColour = ANSI_YELLOW;
		}
		
		//Checks importantWarningColour field
		if (iwc.equals("none"))
		{
			importantWarningColour = ANSI_RESET;
		}
		else if (iwc.equals("black"))
		{
			importantWarningColour = ANSI_BLACK;
		}
		else if (iwc.equals("red"))
		{
			importantWarningColour = ANSI_RED;
		}
		else if (iwc.equals("green"))
		{
			importantWarningColour = ANSI_GREEN;
		}
		else if (iwc.equals("yellow")) 
		{
			importantWarningColour = ANSI_YELLOW;
		}
		else if (iwc.equals("blue"))
		{
			importantWarningColour = ANSI_BLUE;
		}
		else if (iwc.equals("purple"))
		{
			importantWarningColour = ANSI_PURPLE;
		}
		else if (iwc.equals("cyan"))
		{
			importantWarningColour = ANSI_CYAN;
		}
		else if (iwc.equals("white"))
		{
			importantWarningColour = ANSI_WHITE;
		}
		else 
		{
			importantWarningColour = ANSI_RED;
		}
		
	}

}
