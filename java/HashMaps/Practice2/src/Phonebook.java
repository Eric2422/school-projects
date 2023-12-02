import java.util.HashMap;

public class Phonebook {
    public static void 
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // a HashMap to store names and numbers
        HashMap<String, PhoneNumber> phonebook = new HashMap<>();

        // keep looping until the user enters nothing
        String name = " ";
        do {
            System.out.println("Please enter a name:");
            name = input.nextLine();

            // if the name is not in the phonebook
            if (!phonebook.keySet().contains(name)) {
                
            }

        } while (userInput.equals(""));
    }
}