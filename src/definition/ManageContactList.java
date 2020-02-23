package definition;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageContactList {
    Scanner sc = new Scanner(System.in);
    MyLinkedList<Person> list = new MyLinkedList<>();

    public boolean deleteContact() {
        System.out.println("Here are all your contacts: ");
        viewOnlyName();
        System.out.println("Press the number against the contact to delete it: 1");
        int number = Integer.parseInt(sc.nextLine().trim());
        System.out.println(list.get(number - 1).getFirstName() + "'s contact deleted from list!");
        list.delete(list.get(number - 1));
        viewAllContact();

        return true;
    }

    private boolean viewOnlyName() {
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(i + 1 + " : " + list.get(i).getFirstName());
        }
        return true;
    }

    public void searchContact() {
        System.out.println("You could search for a contact from their first names:");
        String firstName = sc.nextLine().trim();
        Person person1 = new Person(firstName);
        MyLinkedList<Person> list1 = new MyLinkedList<>();
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).getFirstName().equals(person1.getFirstName())) {
                list1.add(list.get(i)); // person1
            }


        }
        System.out.println(list1.getSize() + " results found");
        System.out.println("-------- * -------- * -------- * --------");
        for (int i = 0; i < list1.getSize(); i++) {

       /* }
        for (Person value : list1) {*/
            //if(list1.get(i).getFirstName().equals(person1.getFirstName())){

            System.out.println(list1.get(i));
            //System.out.println(list1.get(i).getListOfNumbers());
            System.out.println("-------- * -------- * -------- * --------");
            //}

        }
    }

    public boolean viewAllContact() {
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
            System.out.println(" ******************************************** ");
        }
        return true;
    }

    public boolean addNewContact() {

        ArrayList<Long> contactList = new ArrayList<Long>();
        System.out.println("You have chosen to add a new contact: ");
        System.out.println("Please enter the name of the Person:");
        System.out.println("First Name: ");
        String firstName = sc.nextLine();
        System.out.println("Last Name: ");
        String lastName = sc.nextLine();
        System.out.println("Contact Number: ");
        long contactNumber = Long.parseLong(sc.nextLine().trim());//  sc.nextLong();
        contactList.add(contactNumber);
        System.out.println("Would you like to add another contact number? (y/n): ");
        char choice = sc.nextLine().charAt(0);
        switch (choice) {
            case 'y':
                System.out.println("Contact Number: ");
                contactList.add(Long.parseLong(sc.nextLine().trim()));
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
        list.add(person);
        return true;
    }
}






