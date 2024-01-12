// import the file class
import java.io.File;
import java.io.IOException;

public class CreateAFile {
    public static void main(String[] args) {
        try {
            File myObject = new File("../../txt/test.txt");

            if (myObject.createNewFile()) {
                System.out.println("File created: " + myObject.getName());

            } else {
                System.out.println("File already exists.");
            }
            
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}