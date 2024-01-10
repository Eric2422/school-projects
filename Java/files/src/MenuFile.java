import java.io.*;

public class MenuFile {
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
            System.out.println("An error occured: ");
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
            FileWriter myWriter = new FileWriter(fileDir + fileName);

            myWriter.write(input);
            myWriter.close();
            return true;

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {

    }
}