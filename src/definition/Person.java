package definition;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private ArrayList<Long> listOfNumbers;
    private String emailId = "----------";

    public Person(String firstName, String lastName, List<Long> listOfNumbers, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.listOfNumbers = (ArrayList<Long>) listOfNumbers;
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Long> getListOfNumbers() {
        return listOfNumbers;
    }

    public void setListOfNumbers(List<Long> listOfNumbers) {
        this.listOfNumbers = (ArrayList<Long>) listOfNumbers;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "First Name:  " + firstName + "\n" +
                "Last Name : " + lastName + "\n" +
                "Contact Number(s): " + listOfNumbers.toString() +
                "Email address: " + emailId;
    }
}
