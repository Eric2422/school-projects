import java.io.*;
import java.util.*;

public class MenuFile {
    // all the valid options that the user can type
    public enum Option {
        CREATE,
        WRITE,
        READ,
        QUIT;
    }

    // the directory where all the txt files are stored
    public static final String fileDir = "../txt/";

    public static final Scanner input = new Scanner(System.in);

    /**
     * Creates an empty file
     * Prints a message if an error occurs
     * 
     * @param  file the file to be created
     * @return a boolean representing wheter the file was successfully created or not
     */
    public static boolean createFile(File file) {
        try {
            // try to create the file
            // return whether a new file was created or not
            return file.createNewFile();
            
        } catch (IOException e) {
            // print out the error message
            System.out.println("Error:");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Write the input to the file. Overwrites previous content
     * 
     * @param  file  The file to be written to
     * @param  input The String that is to be written into the file
     * @return a boolean representing whether the input was sucessfully written to the file. Returns false if the file doesn't exist
     */
    public static boolean writeFile(File file, String input) {
        try {
            FileWriter writer = new FileWriter(file);

            // if the file does not exist
            if (!file.exists()) {
                return false;
            }
            
            // write the input to the file
            writer.write(input);
            writer.close();
            return true;

        } catch (IOException e) {
            // print out the error message
            System.out.println("Error:");
            e.printStackTrace();
            return false;
        }
    }

    /** 
     * Reads the file specified by the File object
     * 
     * @param  file the file to be read
     * @return the content of the txt file as a String
    */
    public static String readFile(File file) {
        try {
            Scanner fileReader = new Scanner(file);

            // stores all the lines of the txt file
            String data = "";

            // read all the lines from the file
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }

            return data;

        } catch (IOException e) {
            // print out the error message
            System.out.println("Error:");
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Continuously prompt the user for an input until they enter a valid option
     * Once enter a valid input, return the corresponding Option enum
     * 
     * @return an Option enum that corresponds to the user's option
     */
    public static Option getUserOption() {
        // continuously prompt the user for an input
        while (true) {
            // print out the prompt
            System.out.println("Enter one of the following options(case-insensitive): ");
            for (Option option : Option.values) {
                System.out.println(option);
            }
            System.out.println();

            // get the trimmed and capitalized user input
            String userInput = input.nextLine().toUpperCase().trim();

            // try to convert the userInput to a valid Option and return it
            try {
                return Option.valueOf(userInput);

            } catch (IllegalArgumentException | NullPointerException e) { // if the userInput was not a valid option
                // print a message
                System.out.println("Invalid option");
                System.out.println();
            }
        }
    }

    /**
     * Asks the user to input a file name
     * Gets the file and returns it
     * 
     * @return the file that the user types in
     */
    public static File getUserFile() {
        // keep looping until the user types a valid file name
        while (true) {
            // get the file name from the user
            System.out.println("Enter the file name(include the file name extension): ");
            String fileName = input.nextLine().trim();

            /* Use a regex pattern to check if the file name is valid
             * Must contain one or more characters that are not periods(.),
             * followed by a period(.),
             * followed one or more characters that are not periods(.)
             */
            if (Pattern.matches("[^\\.]+\\.[^\\.]+", fileName)) {
                // return a File object that points to the file
                return new File(fileDir + fileName);

            } else { // if is not a valid fileName
                System.out.println("Invalid file name");
                System.out.println();
            }
        }
    }

    /** 
     * Continously prompts the user to input their birthday until they enter a valid one
     * 
     * @param  age an int that represents how old the user is
     * @return a Calendar object that stores the player's birth date
     */
    public static Calendar getUserBirthday(int age) {
        Calendar birthday = Calendar.getInstance();
        
        // prevent the calendar from accepting invalid dates
        birthday.setLenient(false);

        System.out.println();

        // continously prompt the user to enter their birthday until they enter a valid one
        while (true) {
            try {
                // print the prompt
                System.out.print("Enter your birthday(MM/DD or M/D): ");
                String[] userDate = input.nextLine().split("/");

                // set the month and day of `birthday` based on user input
                // if the date is invalid, it willl throw an ArrayIndexOutOfBoundsException
                birthday.set(Calendar.MONTH, userDate[0]);
                birthday.set(Calendar.DAY_OF_MONTH, userDate[1]);

                /* If the user's birthday has already passed
                 * Set the birth year to currenttYear - age
                 * Else
                 * Set the birth year to currentYear - age - 1
                 */
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                birthday.set(
                    Calendar.YEAR,
                    (Calendar.getInstance().after(birthday)) ? currentYear - age : currentYear - age - 1
                );

                return birthday;

            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid date");
                System.out.println();
            }
        }
    }

    /**
     * Get biographical information from the user(i.e. name, age, what grade they're in, birthday)
     * Formats the information into a String to be written into a txt file
     * 
     * @return a formatted String containing the information that the user inputted
     */
    public static String getUserBioInfo() {
        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println();
        System.out.println("Enter your age: ");
        int age = input.nextInt();

        // clear the line
        input.nextLine();

        // continuously prompts the user to enter their grade until they enter a number from 1-12
        int grade = -1;
        do {
            try {
                System.out.println();
                System.out.println("Enter your current grade level(1-12): ");
                grade = input.nextInt();

            } catch (InputMismatchException e) {
            } 

        } while (!(grade >= 1 && grade <= 12));

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Calendar birthday = getUserBirthday(age);

        String data = "Name: " + name + "\n";
        data       += "Age: " + age + "\n";
        data       += "Grade: " + grade + "\n";

        // date formatted as MM/DD
        data       += "Birthday: " + birthday.get(Calendar.MONTH) + "/" + birthday.get(Calendar.DAY_OF_MONTH);

        return data;
    }

    public static void main(String[] args) {
        while (true) {
            // let the user choose an option
            Option userOption = getUserOption();

            // ask the user to input the file name
            File userFile = getUserFile();

            switch (userOption) {
                case CREATE -> {
                    // create the file
                    // print a message depending on whether the operation was successful
                    System.out.println(
                        (createFile(userFile)) ? "File successfully created" : "File already exists"
                    );
                }

                case WRITE  -> {
                    // if the file does not exist
                    // print out a message
                    if (!userFile.exists()) {
                        System.out.println("File does not exist. CREATE the file first.");

                    } else { // if it exists
                        // get the user's bio info and write it to the file
                        writeFile(userFile, getUserBioInfo());
                        System.out.println("Information successfully written to file");
                    }
                }

                case READ   -> {
                    String data = readFile(userFile);

                    // if the file is empty, print out a warning
                    // if the file has content, print it out
                    System.out.println(
                        (data.equals("")) ? "The file is empty. Please WRITE to it first." : data
                    );
                }

                case QUIT   -> {
                    return;
                }
            }
        }
    }
}