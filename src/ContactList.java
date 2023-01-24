//Aidan Skinner
import java.util.ArrayList;
import java.util.Scanner;
public class ContactList
{
    private ArrayList<Person> contacts;


    public ContactList() {
        this.contacts = new ArrayList<Person>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        Scanner s  = new Scanner(System.in);
        int input = s.nextInt();
        if (input == 1) {
            System.out.println("Select a type of contact to add:\n1. Student\n2. Teacher");
            int typeContact = s.nextInt();
            s.nextLine();
            if (typeContact == 1) {
                System.out.println("First Name:");
                String fN = s.nextLine();
                System.out.println("Last Name:");
                String lN = s.nextLine();
                System.out.println("Phone Number:");
                String pN = s.nextLine();
                System.out.println("Grade:");
                int grade = s.nextInt();
                contacts.add(new Student(fN, lN, pN, grade));
            }
            else if(typeContact == 2) {
                System.out.println("First Name:");
                String fN = s.nextLine();
                System.out.println("Last Name:");
                String lN = s.nextLine();
                System.out.println("Phone Number:");
                String pN = s.nextLine();
                System.out.println("Subject:");
                String subject = s.nextLine();
                contacts.add(new Teacher(fN, lN, pN, subject));
            }
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {

    int size = contacts.size();

    if (sortBy == 0) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 1) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);

                }
            }
        }
        printContacts();
    }

    else if (sortBy == 1) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 1) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
        printContacts();
    }

    else if (sortBy == 2) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 1) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
        printContacts();
    }
}


    public Person searchByFirstName(String firstName) {
        for (Person name : contacts) {
            if (firstName.equals(name.getFirstName())) {
                return name;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person name : contacts) {
            if (lastName.equals(name.getLastName())) {
                return name;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person name : contacts) {
            if (phoneNumber.equals(name.getPhoneNumber())) {
                return name;
            }
        }
        return null;
    }


    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i) instanceof Student ) {
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        Scanner s  = new Scanner(System.in);
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        int userInput = s.nextInt();
        s.nextLine();
        while (true) {
            printMenuOptions();
            if (userInput == 0) {
                break;
            }
            else if (userInput == 1) {
                addContact();
            }
            else if (userInput == 2) {

            }
        }

        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
