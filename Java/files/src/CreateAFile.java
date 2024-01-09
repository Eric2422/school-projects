// import the file class
import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        try {
            File myObject = new File("filename.txt");

            if (myObject.createNewfile()) {
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