package MAVEN_JDBC;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Lab_15 {

    String firstName;
    String lastName;
    String phoneNumber;
    LocalDate dateOfBirth;

    public String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
    public int calculateAge(LocalDate dob) {
        LocalDate currentDate = LocalDate.now();
        if ((dob != null) && (!dob.isAfter(currentDate))) {
            return Period.between(dob, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public void displayPersonDetails() {
        String fullName = getFullName(firstName, lastName);
        int age = calculateAge(dateOfBirth);

        System.out.println("\n--- Person Details ---");
        System.out.println("Full Name   : " + fullName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Age         : " + age + " years");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lab_15 person = new Lab_15();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Enter First Name: ");
        person.firstName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        person.lastName = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        person.phoneNumber = sc.nextLine();

        System.out.print("Enter Date of Birth (dd-MM-yyyy): ");
        String dobInput = sc.nextLine();
        person.dateOfBirth = LocalDate.parse(dobInput, formatter);

        person.displayPersonDetails();

        sc.close();
    }
}
