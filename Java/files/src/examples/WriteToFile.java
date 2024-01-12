import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("../../txt/test.txt");

            myWriter.write("Files in Java might be tricky, but is fun enough!");
            myWriter.close();

            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}