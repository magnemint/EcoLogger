package your.dir.here;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import your.dir.here.enums.LoggerCasualEnum;
import your.dir.here.enums.LoggerWarningEnum;

public class EcoLogManager {
	
	/*
	 *@author magnemint
	*/
	
	//Create a ArrayList for the saveConsoleToFile() function
	ArrayList<String> console = new ArrayList<>();
	
	//Create a callable instance of the Logger
	private static final EcoLogManager LOGGER = new EcoLogManager();
	public static final EcoLogManager getLogger() { return LOGGER; }
	
	/* Project Customizability Variables -> These variables
	 * are set to these values by default, but can be changed
	 * anytime by a user implementing them!
	*/
	public String clientName = "Project Name";
	public String infoColour1 = "Cyan";
	public String infoColour2 = "Green";
	public String mildWarningColour = "Yellow";
	public String importantWarningColour = "Red"; 
	
	//Other Random Boolean
	private Boolean useMildColour = false;
	
	//Get Enum Type
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
		else if (consoleType == LoggerCasualEnum.EcoLogger)
		{
			consoleTypeAsString = "Eco Logger Info";
		}
		else 
		{
			consoleTypeAsString = "Unasssigned";
		}
			
		//Log the info in a clean way with colours
		String toLog = infoColour1 + "[" + clientName + "]" + infoColour2 + " [" + getTime() + "] " + infoColour1 + "[" + consoleTypeAsString + "]" + " " + infoColour2 + text + ANSI_RESET;
		System.out.println(toLog);
		
		//Add it to the ArrayList, and make it look nice
		String toLogToFile = "[" + clientName + "]" + " [" + getTime() + "] " + "[" + consoleTypeAsString + "]" + " " + text;
		console.add(toLogToFile + "\n");
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
		String toLog = ANSI_RESET + "[" + clientName + "]" + " [" + getTime() + "] " + "[" + consoleTypeAsString + "]" + " " + text + ANSI_RESET;
		System.out.println(toLog);
		
		//Add it to the ArrayList, and make it look nice
		String toLogToFile = "[" + clientName + "]" + " [" + getTime() + "] " + "[" + consoleTypeAsString + "]" + " " + text;
		console.add(toLogToFile + "\n");
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
			useMildColour = true;
		}
		else if (errorType == LoggerWarningEnum.Other)
		{
			errorTypeAsString = "Other Issue";
			useMildColour = false;
		}
		else 
		{
			errorTypeAsString = "Unasssigned";
			useMildColour = false;
		}
		
		//Log the info in a clean way without colours
		if (useMildColour == true)
		{
			//This is for the console -> save it as a variable so we can easily change it
			String toLog = mildWarningColour + "[" + clientName + "]" + " [" + getTime() + "] " + "[" + errorTypeAsString + "]" + " " + error + ANSI_RESET;
			System.out.println(toLog);
			
			//Change the toLog variable so it doesn't look nasty when we save it to the file
			String toLogAtFile = "[" + clientName + "]" + " [" + getTime() + "] " + "[" + errorTypeAsString + "]" + " " + error;
			console.add(toLogAtFile + "\n");
		}
		else 
		{
			//This is for the console -> save it as a variable so we can easily change it
			String toLog = importantWarningColour + "[" + clientName + "]" + " [" + getTime() + "] " + "[" + errorTypeAsString + "]" + " " + error + ANSI_RESET;
			System.out.println(toLog);
			
			//Change the toLog variable so it doesn't look nasty when we save it to the file
			String toLogAtFile = "[" + clientName + "]" + " [" + getTime() + "] " + "[" + errorTypeAsString + "]" + " " + error;
			console.add(toLogAtFile + "\n");
		}
			
	}
	
	//Checks to see if the user has changed any of the customizable values
	private void checkCustomisations()
	{
		//Sets the strings to lower case to check
		infoColour1 = infoColour1.toLowerCase();
		infoColour2 = infoColour2.toLowerCase();
		mildWarningColour = mildWarningColour.toLowerCase();
		importantWarningColour = importantWarningColour.toLowerCase();
		
		//Checks infoColour1 field
		if (infoColour1.equals("none"))
		{
			infoColour1 = ANSI_RESET;
		}
		else if (infoColour1.equals("black"))
		{
			infoColour1 = ANSI_BLACK;
		}
		else if (infoColour1.equals("red"))
		{
			infoColour1 = ANSI_RED;
		}
		else if (infoColour1.equals("green"))
		{
			infoColour1 = ANSI_GREEN;
		}
		else if (infoColour1.equals("yellow")) 
		{
			infoColour1 = ANSI_YELLOW;
		}
		else if (infoColour1.equals("blue"))
		{
			infoColour1 = ANSI_BLUE;
		}
		else if (infoColour1.equals("purple"))
		{
			infoColour1 = ANSI_PURPLE;
		}
		else if (infoColour1.equals("cyan"))
		{
			infoColour1 = ANSI_CYAN;
		}
		else if (infoColour1.equals("white"))
		{
			infoColour1 = ANSI_WHITE;
		}
		
		//Checks infoColour2 field
		if (infoColour2.equals("none"))
		{
			infoColour2 = ANSI_RESET;
		}
		else if (infoColour2.equals("black"))
		{
			infoColour2 = ANSI_BLACK;
		}
		else if (infoColour2.equals("red"))
		{
			infoColour2 = ANSI_RED;
		}
		else if (infoColour2.equals("green"))
		{
			infoColour2 = ANSI_GREEN;
		}
		else if (infoColour2.equals("yellow")) 
		{
			infoColour2 = ANSI_YELLOW;
		}
		else if (infoColour2.equals("blue"))
		{
			infoColour2 = ANSI_BLUE;
		}
		else if (infoColour2.equals("purple"))
		{
			infoColour2 = ANSI_PURPLE;
		}
		else if (infoColour2.equals("cyan"))
		{
			infoColour2 = ANSI_CYAN;
		}
		else if (infoColour2.equals("white"))
		{
			infoColour2 = ANSI_WHITE;
		}
		
		//Checks mildWarningColour field
		if (mildWarningColour.equals("none"))
		{
			mildWarningColour = ANSI_RESET;
		}
		else if (mildWarningColour.equals("black"))
		{
			mildWarningColour = ANSI_BLACK;
		}
		else if (mildWarningColour.equals("red"))
		{
			mildWarningColour = ANSI_RED;
		}
		else if (mildWarningColour.equals("green"))
		{
			mildWarningColour = ANSI_GREEN;
		}
		else if (mildWarningColour.equals("yellow")) 
		{
			mildWarningColour = ANSI_YELLOW;
		}
		else if (mildWarningColour.equals("blue"))
		{
			mildWarningColour = ANSI_BLUE;
		}
		else if (mildWarningColour.equals("purple"))
		{
			mildWarningColour = ANSI_PURPLE;
		}
		else if (mildWarningColour.equals("cyan"))
		{
			mildWarningColour = ANSI_CYAN;
		}
		else if (mildWarningColour.equals("white"))
		{
			mildWarningColour = ANSI_WHITE;
		}
		
		//Checks importantWarningColour field
		if (importantWarningColour.equals("none"))
		{
			importantWarningColour = ANSI_RESET;
		}
		else if (importantWarningColour.equals("black"))
		{
			importantWarningColour = ANSI_BLACK;
		}
		else if (importantWarningColour.equals("red"))
		{
			importantWarningColour = ANSI_RED;
		}
		else if (importantWarningColour.equals("green"))
		{
			importantWarningColour = ANSI_GREEN;
		}
		else if (importantWarningColour.equals("yellow")) 
		{
			importantWarningColour = ANSI_YELLOW;
		}
		else if (importantWarningColour.equals("blue"))
		{
			importantWarningColour = ANSI_BLUE;
		}
		else if (importantWarningColour.equals("purple"))
		{
			importantWarningColour = ANSI_PURPLE;
		}
		else if (importantWarningColour.equals("cyan"))
		{
			importantWarningColour = ANSI_CYAN;
		}
		else if (importantWarningColour.equals("white"))
		{
			importantWarningColour = ANSI_WHITE;
		}
		
	}
	
	//Function to save the console to a file
	public String saveConsoleToFile(String dir)
	{
		//Attempts to save it to the directory the user gave
		try {
			
			//Turn the location they gave into a directory
			File saveSpot = new File(dir);
			
			//Make the directory if it doesn't exist
			if (!saveSpot.exists())
			{
				saveSpot.mkdirs();
			}
			
			//Create the printstreams needed
			PrintStream ps = new PrintStream(saveSpot + "/console.txt");
			PrintStream normal = System.out;
			
			//Create a suitable log to save
			String consoleLog = console.toString();
			String almostReadyConsoleLog = consoleLog.substring(1, consoleLog.length() - 1);
			String readyConsoleLog = almostReadyConsoleLog.replace(",", "");
			
			//Change the console log to the file we made
			System.setOut(ps);
			
			//Put the console into the file
			ps.print(readyConsoleLog);
			
			//Return back to the normal console
			System.setOut(normal);
			
			this.log(LoggerCasualEnum.EcoLogger, "Successfully saved console log to: " + saveSpot);
			
			//Success -> returns success
			return "Successfully save console to file";
		} 
		catch (Exception e)
		{
			this.log(LoggerCasualEnum.EcoLogger, "Successfully saved console log to: " + dir);
			
			//Failiure -> returns the error
			return "Unable to save console to file: [" + e + "]";
		}
	}
}
