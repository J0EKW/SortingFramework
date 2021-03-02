package Src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Class;
import java.lang.reflect.Method;

/**Handles functionality when accessed through a CLI */
public class CLIHandler {
    
    //Attributes
    private Scanner sc;
    private ArrayList<Command> commands;



    //Constructor
    /**Handles functionality when accessed through a CLI */
    public CLIHandler() {
        this.sc = new Scanner(System.in);
        this.commands = new ArrayList<Command>();
        Runnable endRun = () -> endCommand();
        Runnable helpRun = () -> helpCommand();
        Runnable sortRun = () -> sortCommand();
        Runnable sortFileRun = () -> sortFileCommand();

        commands.add(new Command("END", "Terminates the Program", endRun));
        commands.add(new Command("HELP", "Gives brief description for all commands", helpRun));
        commands.add(new Command("SORT", "Sorts a given input by algorithm given", sortRun));
        commands.add(new Command("SORTFILE", "Sorts a given file by algorithm given", sortFileRun));
    }

    

    //Methods & Functions
    /**Manages the CLI inputs */
    public void management() {
        String input;

        while(true) {
            input = getInput();

            for (Command command : commands) {
                if (command.getCall().equals(input)) {
                    command.getFunction().run();
                }
            }
        }
    }

    /**Closes Scanner object */
    private void closeScanner() {
        sc.close();
    }

    /**Reads console line for user input
     * 
     * @return  User input from command line
     */
    private String getInput() {
        return sc.nextLine();
    }

    /**Ends Program when called */
    private void endCommand() {
        closeScanner();
        System.exit(0);
    }

    /**Lists all commands when called */
    private void helpCommand() {
        for (Command command : commands) {
            System.out.println(command.getCall() + ": " + command.getDescription());
        }
    }

    /**Sorts a set of inputs given be user, either by value (True) or length (False) */
    private void sortCommand() {
        String input = getInput().replaceAll("[\\s]+", " ");
        String[] info = input.split(" |,");
        String sort = info[0];
        if (checkAlgorithm(sort)) {
            boolean compare = Boolean.parseBoolean(info[1]);
            String[] data = Arrays.copyOfRange(info, 2, info.length);
            printArray(splitArray(sort, compare, data));
        } else {
            System.out.println("That algorithm can't be found");
        }
    }

    /**Sorts a set of inputs from a given file, either by value or length */
    private void sortFileCommand() {
        String input = getInput().replace("[\\s]+", " ");
        String[] info = input.split(" ");
        String sort = info[0];
        if (checkAlgorithm(sort)) {
            boolean compare = Boolean.parseBoolean(info[1]);
            String[] data = dataFromFile(info[2]);
            dataToFile(info[2], splitArray(sort, compare, data));
            System.out.println("The file has been updated");
        } else {
            System.out.println("That algorithm can't be found");
        }
        
    }

    /**Splits the given input into Numeric types and Alpha types, sorts them separately, then recombines them
     * 
     * @param sort  The name of the sorting algorithm
     * @param compare   Indicates if the values should be sorted by Value or Length
     * @param input The dataset to be sorted
     * 
     * @return  A sorted dataset, the sorted numerics first, the sorted alpha types second
     */
    public String[] splitArray(String sort, boolean compare, String[] input) {
        ArrayList<String> numValue = new ArrayList<String>();
        ArrayList<String> alphValue = new ArrayList<String>();
        for (String i : input) {
            try {
                Double.parseDouble(i);
                numValue.add(i);
            } catch (NumberFormatException e) {
                alphValue.add(i);
            }
        }
        String[] num = numValue.toArray(new String[numValue.size()]);
        String[] alpha = alphValue.toArray(new String[alphValue.size()]);
        try {
            
            int i = 0;
            if (num.length > 1) {
                num = (String[]) execute(sort, compare, num);
                for (String n : num) {
                    input[i] = n;
                    i++;
                }
            }
            if (alpha.length > 1) {
                alpha = (String[]) execute(sort, compare, alpha);
                for (String a : alpha) {
                    input[i] = a;
                    i++;
                }
            }
            
            return input;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        

    }

    /**Sorts the dataset by the algorithm and comparison given. 
     * 
     * @param sort  The name of the sorting algorithm
     * @param compare   Indicates if the values should be sorted by Value or Length
     * @param input The dataset to be sorted
     * 
     * @return  The direct result of the chosen sorting algorithm
     */
    private Object execute(String sort, boolean compare, String[] input) {
        try {
            Class<?> name = Class.forName("Src.Sorting." + sort);

            Class<?>[] arg = new Class[2];
            arg[0] = String[].class;
            arg[1] = boolean.class;

            Method method = name.getMethod("algorithm", arg);
            return method.invoke(name, input, compare);

        } catch (Exception e) {
            System.out.println("That sorting algorithm can't be found");
            return null;
        }
    }

    private boolean checkAlgorithm(String sort) {
        try {
            Class<?> name = Class.forName("Src.Sorting." + sort);

            Class<?>[] arg = new Class[2];
            arg[0] = String[].class;
            arg[1] = boolean.class;
            String[] testInput = {"5", "3", "9", "2"};
            Method method = name.getMethod("algorithm", arg);
            method.invoke(name, testInput, false);

        } catch (Exception e) {
            System.out.println(e.getCause().toString());
            return false;
        }
        return true;
    }
    /**Reads data from a given file
     * 
     * @param fileName  The name (and path) of the file chosen
     * @return  The data of the files
     */
    public String[] dataFromFile(String fileName) {
        try {
            FileReader file = new FileReader(fileName);
            Scanner fileSc = new Scanner(file);
            String[] data = fileSc.nextLine().split(",");
            file.close();
            fileSc.close();
            return data;

        } catch (FileNotFoundException e) {
            System.out.println("This file cannot be found");
            return null;
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    /**Writes data to a given file. This method will overwrite the preexisting data, since this is only called when the file contents has been sorted
     * 
     * @param fileName  The name (and path) of the file to be overwritten
     * @param data  The data to be written to the file
     */
    public void dataToFile(String fileName, String[] data) {
        try {
            FileWriter file = new FileWriter(fileName, false);
            for (String s : data) {
                file.write(s + ",");
            }
            file.close();

        } catch (FileNotFoundException e) {
            System.out.println("This file cannot be found");
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
    
    /**Prints the contents of a given array
     * 
     * @param input An array to be printed
     */
    private static void printArray(String[] input) {
        for (String i : input) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}

