//Aidan Skinner
public class Person {
    // TODO: Complete the Person class
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor for Person object
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
