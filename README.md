# Eco Logger 0.3.0 by Magnemint (マグネミント#3659)

## Description

Why use `System.out.println` when you can use your own logger that has *colours*?

## Usage

Just import the file into your project and fix the errors -> The errors would just be directory errors.
To call the `Logger.java` class, you need to make a new instance of it. To do that, just put this at
the top of the class you want to use the logger in.

```java
private Logger logger = Logger.getLogger();
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
```

(Obviously, replacing `enumOfChoice` and `string` with your desired value.

You can also customise things like the name of the project, and the
two colours that style the text in the console like so:

```java
logger.clientName = "Johnny";
logger.infoColour1 = "\u001B[30m";
logger.infoColour2 = "\u001B[35m";
// Info colour 1 & 2 will become easier to style rather than using ANSI codes soon.
```

Example Class:

```java
public class Main {
	
	private static final LogManager logger = LogManager.getLogger();

	public static void main(String[] args)
	{
		logger.clientName = "Super Cool Java Project!";
		logger.infoColour1 = "\u001B[36m";
		logger.infoColour2 = "\u001B[32m";
		
		/* By leaving the above out, they will be switched to their default values of:
		 * "Client Name Goes Here",
		 * Cyan
		 * Green
		 */
		
		logger.log(LoggerCasualEnum.Other, "Project Booted");
	}
}

```

Example Class Output:

`[Super Cool Java Project!] [2023-04-18T11:52:48.223106300Z] [Other Info] Project Booted`

That's it! :) Please star this repo if you use it, I would appreciate it.
