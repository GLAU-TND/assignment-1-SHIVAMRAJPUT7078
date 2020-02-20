package definition;

import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private List<Integer> listOfNumbers;
    private String emailId;

    public Person(String firstName, String lastName, List<Integer> listOfNumbers, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.listOfNumbers = listOfNumbers;
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

    public List<Integer> getListOfNumbers() {
        return listOfNumbers;
    }

    public void setListOfNumbers(List<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
