//Aidan Skinner
import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class ContactList
{
    private ArrayList<Person> contacts;

    // Constructor for array list of Person
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
        // Asks user for input of 1 or 2 for student or teacher
        System.out.println("Select a type of contact to add:\n1. Student\n2. Teacher");
        int typeContact = s.nextInt();
        s.nextLine();
        if (typeContact == 1) {
            // Creates a new student and adds to contacts
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
            // Creates a new teacher and adds to contacts
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

    // Uses bubble sort to sort by first name then prints out the contacts in that order
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

    // Uses bubble sort to sort by last name then prints out the contacts in that order
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

    // Uses bubble sort to sort by phone number and then prints out the contacts in that order
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
        Scanner s = new Scanner(System.in);
        // Traverses contacts and compares the first name with the user input
        for (Person name : contacts) {
            if (firstName.equals(name.getFirstName())) {
                System.out.println(name);
                return name;
            }
        }
        // If the user input for the search is not in contacts
        System.out.println(firstName + " is not in the list.");
        return null;
    }

    public Person searchByLastName(String lastName) {
        Scanner s = new Scanner(System.in);
        // Traverses contacts and compares the last name with the user input
        for (Person name : contacts) {
            if (lastName.equals(name.getLastName())) {
                System.out.println(name);
                return name;
            }
        }
        // If the user input for the search is not in contacts
        System.out.println(lastName + " is not in the list.");
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        Scanner s = new Scanner(System.in);
        // Traverses contacts and compares the phone number with the user input
        for (Person num : contacts) {
            if (phoneNumber.equals(num.getPhoneNumber())) {
                System.out.println(num);
                return num;
            }
        }
        // If the user input for the search is not in contacts
        System.out.println("#" + phoneNumber + " is not in the list.");
        return null;
    }


    /**
     * Lists just the Student objects in the Contact List
     */

    // Prints all students by traversing contacts and seeing if it is an instance of student
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
        int userInput = 0;
        // Infinite loop to print the menu unless 0 is typed
        // The user input determines which methods to run
        while (true) {
            printMenuOptions();
            userInput = s.nextInt();
            s.nextLine();
            if (userInput == 0) {
                break;
            }
            else if (userInput == 1) {
                addContact();
            }
            else if (userInput == 2) {
                sort(0);
            }
            else if (userInput == 3) {
                sort(1);
            }
            else if (userInput == 4) {
                sort(2);
            }
            else if (userInput == 5) {
                listStudents();
            }
            else if (userInput == 6) {
                System.out.println("Enter a Name: ");
                searchByFirstName(s.nextLine());
            }
            else if (userInput == 7) {
                System.out.println("Enter a Name: ");
                searchByLastName(s.nextLine());
            }
            else if (userInput == 8) {
                System.out.println("Enter a Phone Number: ");
                searchByPhoneNumber(s.nextLine());
            }
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
