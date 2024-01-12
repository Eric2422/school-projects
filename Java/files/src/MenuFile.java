import java.io.*;
import java.util.Scanner;

public class MenuFile {
    public enum Option {
        CREATE,
        READ,
        WRITE;
    }

    // the directory where all the txt files are stored
    public static final String fileDir = "../txt/";

    /**
     * Creates an empty file
     * Prints a message if an error occurs
     * 
     * @param  fileName the name of the file. Includes the file name extension but does not include a directory
     * @return a boolean representing wheter the file was successfully created or not
     */
    public static boolean createFile(String fileName) {
        try {
            File file = new File(fileDir + fileName);

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
     * Write the input to the file
     * 
     * @param  fileName the name of the file. Includes the file name extension but does not include the directory
     * @param  input    the String that is written into the file
     * @return a boolean representing whether the input was sucessfully written to the file. Returns false if the file doesn't exist
     */
    public static boolean writeFile(String fileName, String input) {
        try {
            File file = new File(fileDir + fileName);
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
     * Reads the file specified by the fileName
     * 
     * @param  fileName the name of the file to be read
     * @return the content of the txt file as a String
    */
    public static String readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            // stores all the lines of the txt file
            String data = "";

            // read all the lines from the file
            while (myReader.hasNextLine()) {
                String data += myReader.nextLine();
            }

            return data;

        } catch (IOException e) {
            // print out the error message
            System.out.println("Error:");
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        while (true) {
            System..out.println("Enter a")
        }
    }
}