package main;

import definition.ManageContactList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManageContactList list = new ManageContactList();
        System.out.println("add a person");

        list.addNewContact();
        System.out.println(" show");
        list.viewAllContact();
        System.out.println("add a person");

        list.addNewContact();
        System.out.println(" show");
        list.viewAllContact();

    }
}
