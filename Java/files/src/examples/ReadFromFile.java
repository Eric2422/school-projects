import java.io.*;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) {
        try {
            File myObject = new File("../../txt/test.txt");
            Scanner myReader = new Scanner(myObject);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();

        } catch(FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}