Welcome to the Sorting Framework! This program allows you to sort a set of data given either by input or by fileName using the built in sorting algorithms (Insertion, Merge, and Bogo; which you won't be needing), with the potential to add your own algorithms. The framework accepts sets of integers, floats, strings, or a combination of the three. The following will go into more detail about certain aspects.

Created by Joseph Krystek-Walton, 23/02/2021
https://www.linkedin.com/in/joseph-krystek-walton-1046b01bb/
------------------------------------------------------------------------   SETING UP
------------------------------------------------------------------------
To use any of the framework, you need a Java Development Kit. The one this framework was developed on was JDK 1.8.0_261, so that one is recommended. Instructions on installation for MacOS, Windows, or Linux can be found here (https://docs.oracle.com/en/java/javase/15/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A).

To run the unit tests in this framework, you need JUnit. The one used for this framework was junit-4.10, so that one is recommended. Instructions on installation for MacOS, Windows or Linux can be found here (https://www.tutorialspoint.com/junit/junit_environment_setup.htm).

It's important that you know where your JUnit file is stored, JDK's location shouldn't need to be known.



------------------------------------------------------------------------   BUILD AND RUN
------------------------------------------------------------------------
The framework can be built and run from the SortingFramework directory. To build the core program without the unit tests, navigate to the SortingFramework directory and input the following commands:

BUILD
    Powershell: javac .\Src\*.java .\Src\Sorting\*.java
    Bash: $ javac Src/*.java Src/Sorting/*java

RUN
    Powershell: java Src.Main
    Bash: java Src.Main

After this command, you're running the framework. A section further down will detail what you can do here. As for the unit tests, they need to be built with refrence JUnit, and so are slightly different. The term JUNIT_PATH is used; this is in reference to where you've stored the .jar file for JUnit.

BUILD
    Powershell: javac -cp ".;JUNIT_PATH\junit-4.10.jar" .\Tests\*.java
    Bash: $ javac -cp ".;C:/JUNIT/junit-4.10.jar" Tests/*.java

RUN
    Powershell: java -cp ".;JUNIT_PATH\junit-4.10.jar" Tests.UnitTestRunner
    Bash: $ java -cp ".;C:/JUNIT/junit-4.10.jar" Tests.UnitTestRunner

On running, you should see a list of all the tests being run.



------------------------------------------------------------------------   COMMANDS
------------------------------------------------------------------------
When running the core files, you have 4 possible commands you can input:

HELP
    Gives a brief description of all the commands in the framework.

END
    Terminates the program whilst also closing the line scanner.

SORT
    Enables the user to input a sorting algorithm name ("Insertion", "Merge", "Bogo"), a true/false statement indicating sort by length or sort by value respectively, and a set of data separated by commas or any number of whitespaces. These data can be integers, float values or strings, and sets don't have to have uniform values. The output will be put in the command line after executing. You will be able to write these after exectuing SORT.

SORTFILE
    Enables the user to input a sorting algorithm, a true/false statement indicating sort by length or sort by value respectively, and a filename (and path) that leads to a set of data. These data can be integers, float values or strings, and sets don't have to have uniform values. The output will be overwritten to the original file. You will be able to input these after executing SORTFILE.



------------------------------------------------------------------------   ADDING AN ALGORITHM
------------------------------------------------------------------------
The way the SORT Command works is it will take your first word of your input (The algorithm name), then look for a class in the Sorting folder with a name that's the same as your first word, then execute the algorithm method in that class. Therefore, you can add your own algorithm by adding a .java file with the name of the algorithm you want, adding a method to the class with the signature "public static String[] algorithm(String[] input, boolean compare)", then add the algorithm to that method. It's recommended to extend the sort abstract class, to gain additional functionality.

Once this is done, and you rebuild, your algorithm should be accessible.
