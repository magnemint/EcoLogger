# Eco Logger 0.7 by Magnemint (マグネミント#3659)

## Description

Why use `System.out.println` when you can use your own logger that has *colours*?

## Usage

Just import the file into your project and fix the errors -> The errors would just be directory errors.
To call the `Logger.java` class, you need to make a new instance of it. To do that, just put this at
the top of the class you want to use the logger in.

```java
private EcoLogManager logger = EcoLogManager.getLogger();
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

Example Class:

```java
public class Main {
	
	private static final LogManager logger = LogManager.getLogger();

	public static void main(String[] args)
	{
		logger.clientName = "Super Cool Java Project!";
		
		// logger.log()
		logger.infoColour1 = "Green";
		logger.infoColour2 = "Purple";
		
		// logger.logError()
		logger.mildWarningColour = "Yellow";
		logger.importantWarningColour = "Red";		
		
		/* By leaving the above out, they will be switched to their default values of:
		 * "Client Name Goes Here",
		 * Cyan
		 * Green
		 * Yellow
		 * Red
		 */
		
		logger.log(LoggerCasualEnum.Other, "Project Booted");
		logger.logError(LoggerWarningEnum.ProjectWarning, "Cannot access face");
	}
}

```

Example Class Output:

`[Super Cool Java Project!] [Tue Apr 18 21:37:15 AWST 2023] [Other Info] Project Booted`

`[Super Cool Java Project!] [Tue Apr 18 21:37:16 AWST 2023] [Project Warning] Cannot access face`

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
