# Eco Logger 1.5 by Magnemint (マグネミント#3659)

## Description

Why use `System.out.println` when you can use your own logger that has *colours*?

## Usage

Just import the file into your project and fix the errors -> The errors would just be directory errors.
To call the `Logger.java` class, you need to make a new instance of it. To do that, just put this at
the top of the class you want to use the logger in.

```java
private static final EcoLogManager logger = EcoLogManager.getLogger();
// can be public if you want, I don't advise it though.
```

Then, find a place you want to log the text. There, rather than typing:

```java
System.out.println(string);
```

Type this:

```java
logger.log(enumOfChoice, string);
```

There is also

```java
logger.logWithoutColour(enumOfChoice, string);
```

and

```java
logger.logError(enumOfChoice, string);
/* When using `logger.logError()`, use the LoggerWarningEnum; otherwise
 * it will log is as `Unassigned`. Read line 111 for more
 */
```

(Obviously, replacing `enumOfChoice` and `string` with your desired value.)

You can also customise things like the name of the project, and the
two colours that style the text in the console like so:

```java
logger.clientName = "Johnny"; // Project name usually goes here
logger.infoColour1 = "Cyan"; // First colour in info log
logger.infoColour2 = "Blue"; // Second colour in info log
logger.mildWarningColour = "Yellow"; // Warning colour
logger.importantWarningColour = "Red"; // Error/Failure colour
```

There is also a `logger.saveConsoleToFile()` function. This function allows you to save
every line that Eco Logger logs to the console into a `.txt` file. Usage of this function is as follows:

```java
logger.saveConsoleToFile("C://your/desired/directory/here");
```

Here it will save the file to `C:\your\desired\directory\here\console.txt`.

The function will make the directory if it doesn't exist, and it will add the file `console.txt`
with the console logs in it. It is not yet capable of custom file names yet, so if you add `*.txt*`
to the end of the directory, the extension will be added to the name of the folder.

If for whatever reason Eco Logger is not able to save the console log to the file, it will
spit out:

```java
[(Project Name)] [(Time and Date of Attempt)] [Eco Logger Info] Unable to save console lot to: (directory provided by user)
```

As of version 1.5, we now have new functions to make it easier to log info in the console!

```java
logger.info("Hello!"); //This is the easiest way to log info to my beliefs.
logger.info("This is a new type of debug method", "Bing Bong"); //This is for people who want to get technical; this will print [Demo Java Project] [Tue Apr 18 21:37:18 AWST 2023] [This is a new type of debug method] Bing Bong
	
logger.warn("Just making sure you've starred the repo."); //The new easiest way to get *cough* people to star this repo *cough cough*, I- i mean to log a warning in the console
logger.warn("DO IT!", "star this repo or eat the car"); //Same thing as the second logger.info function, just as a warning
	
logger.alert("You haven't starred the repo... you know what this means >:)"); //The absolute most easiest way to log an error
logger.alert("oh no", "hippity hoppity, either you star or you won't get far"); //Same as the second logger.info and logger.warn, just as an issue/alert/big red scary text
```

Example Class:

```java
public class Main {
	
	private static final EcoLogManager logger = EcoLogManager.getLogger();

	public static void main(String[] args)
	{
		//Customizing inputs
		logger.clientName = "Demo Java Project";
		logger.infoColour1 = "Cyan";
		logger.infoColour2 = "Purple";
		
		logger.log(LoggerCasualEnum.ProjectInfo, "Project Booted");
		logger.logWithoutColour(LoggerCasualEnum.Other, "This does the same thing as logger.log(), but without the fancy colours.");
		logger.logError(LoggerWarningEnum.ProjectWarning, "It appears this text would be orange.");
		logger.logError(LoggerWarningEnum.ProjectError, "This text is red. Spooky!");
		
		logger.saveConsoleToFile("C://github/Eco Logger/console");
	}
}
```

Example Class Output:

`[Demo Java Project] [Tue Apr 18 21:37:15 AWST 2023] [Project Info] Project Booted`

`[Demo Java Project] [Tue Apr 18 21:37:16 AWST 2023] [Other Info] This does the same thing as logger.log(), but without the fancy colours.`

`[Demo Java Project] [Tue Apr 18 21:37:17 AWST 2023] [Project Warning] It appears this text would be orange.`

`[Demo Java Project] [Tue Apr 18 21:37:18 AWST 2023] [Project Issue] This text is red. Spooky!`

`[Demo Java Project] [Tue Apr 18 21:37:18 AWST 2023] [Eco Logger Info] Successfully saved console log to C:\github\Eco Logger\console` //Assuming no errors occured :)

Accepted Colours (ANSI Colour Code):

```
Reset (\u001B[0m)
Black (\u001B[30m)
Red (\u001B[31m)
Green (\u001B[32m)
Yellow (\u001B[33m")
Blue (\u001B[34m)
Purple (\u001B[35m)
Cyan (\u001B[36m)
White (\u001B[37m)
```

Note with `logger.logError()`. 

By default, `LoggerWarningEnum.ProjectError` will log the statement under the
`importantWarningColour`, and `LoggerWarningEnum.ProjectWarning` is the only field
that logs the statemenet as a warning, or under the `mildWarningColour`.

That's it! :) Please star this repo if you use it, I would appreciate it.
