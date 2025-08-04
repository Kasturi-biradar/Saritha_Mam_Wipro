package MAVEN_JDBC;
import java.util.Scanner;
public class Lab7 {
	String name;
    int age;
    String phoneNumber;

    public void setDetails(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public void displayDetails() {
        System.out.println(" Person Details");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      Lab7 person = new  Lab7();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        person.setDetails(name, age, phone);
        person.displayDetails();

        sc.close();
    }
}

