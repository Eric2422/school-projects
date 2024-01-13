import java.util.*;

public class Phonebook {
    /**
     * requests user to input three Strings as a phone number
     * @return a PhoneNumber object based on user input
     */
    public static PhoneNumber inputPhoneNumber() {
        Scanner input = new Scanner(System.in);

        String phoneNum = "";

        // until the user enters a String of exactly seven digits
        do {
            // ask them to input a phone number
            System.out.println("\nPlease enter a phone number without any dashes(-) or other formatting(i.e. XXXXXXXXXX): ");
            phoneNum = input.nextLine();

        } while (!phoneNum.matches("\\d{10}"));

        System.out.println();
        
        // split the phone number into three
        // and pass into a new PhoneNumber to return
        return new PhoneNumber(
            phoneNum.substring(0, 3), 
            phoneNum.substring(3, 6), 
            phoneNum.substring(6, 10)
        );
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // a HashMap to store names and numbers
        HashMap<String, PhoneNumber> phonebook = new HashMap<>();

        // keep looping until the user enters nothing
        String name = " ";
        do {
            System.out.println("Please enter a name:");
            name = input.nextLine().trim();

            // if the name is not in the phonebook
            // and the name is not blank
            if (!phonebook.keySet().contains(name) && !name.equals("")) {
                // ask for the phone number
                // and store it into phonebook with name
                phonebook.put(name, inputPhoneNumber());

            } else if (phonebook.keySet().contains(name)) { // if the name is in phonebook
                // print out the name
                System.out.println(phonebook.get(name));
                System.out.println();
            }

        } while (!name.equals(""));

        // print out all the entries in phonebook
        System.out.println("Complete Phonebook: ");

        for (String key : phonebook.keySet()) {
            System.out.print(key + " —— ");
            System.out.println(phonebook.get(key));
        }
    }
}