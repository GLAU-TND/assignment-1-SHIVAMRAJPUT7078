package definition;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageContactList {
    MyLinkedList<Person> list = new MyLinkedList<>();

    boolean addNewContact() {
        ArrayList<Long> contactList = new ArrayList<Long>();
        Scanner sc = new Scanner(System.in);
        System.out.println("You have chosen to add a new contact: ");
        System.out.println("Please enter the name of the Person:");
        System.out.println("First Name: ");
        String firstName = sc.nextLine();
        System.out.println("Last Name: ");
        String lastName = sc.nextLine();
        System.out.println("Contact Number: ");
        long contactNumber = sc.nextLong();
        contactList.add(contactNumber);
        System.out.println("Would you like to add another contact number? (y/n): ");
        char choice = sc.nextLine().charAt(0);
        switch (choice) {
            case 'y':
                System.out.println("Contact Number: ");
                contactList.add(sc.nextLong());
                break;
            case 'n':
                break;
        }
        System.out.println("Would you like to add email address? (y/n):");
        String emaiID = "----------";
        choice = sc.nextLine().charAt(0);
        switch (choice) {
            case 'y':
                System.out.println("Email Address: ");
                String email = sc.nextLine().trim();
                emaiID = new String(email);
                break;
            case 'n':
                break;
        }
        Person person = new Person(firstName, lastName, contactList, emaiID);
        list.addContact(person);
        return true;
    }
}
