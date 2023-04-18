# Custom Logger by Magnemint (マグネミント#3659)

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

That's it! :) Please star this repo if you use it, I would appreciate it.
