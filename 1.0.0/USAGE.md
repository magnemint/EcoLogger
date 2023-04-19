# Eco Logger 1.0 by Magnemint (マグネミント#3659)

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

```[(Project Name)] [(Time and Date of Attempt)] [Eco Logger Info] Unable to save console lot to: (directory provided by user)```

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
