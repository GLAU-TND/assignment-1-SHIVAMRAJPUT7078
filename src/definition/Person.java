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
}
