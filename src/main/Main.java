package main;

import definition.ManageContactList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManageContactList list = new ManageContactList();
        System.out.println("Welcome to the Contact List App");
        int choice = 0;
        while (choice != 5) {
            System.out.println("Press 1 to add a new contact\n" + "Press 2 to view all contacts\n" + "Press 3 to search for a contact\n" +
                    "Press 4 to delete a contact\n" + "Press 5 to exit program");
            choice = sc.nextInt();
            switch (choice) {
                case (1):
                    list.addNewContact();
                    break;
                case 2:
                    list.viewAllContact();
                    break;
                case 3:
                    list.searchContact();
                    break;
                case 4:
                    list.deleteContact();
                    break;
                case 5:
                    break;
            }
        }


        /*list.addNewContact();
        //System.out.println(" show");
        //list.viewAllContact();
        System.out.println("add a person");

        list.addNewContact();

        System.out.println("-----------------------------");
        list.searchContact();
        list.deleteContact();*/

    }
}
