package MAVEN_JDBC;

import java.util.Scanner;  

public class Lab8 {

    enum Gender { M, F }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter gender (M/F): ");
        String input = sc.nextLine().toUpperCase();

        if (input.equals("M")) {
            System.out.println("Gender is: " + Gender.M);
        } else if (input.equals("F")) {
            System.out.println("Gender is: " + Gender.F);
        } else {
            System.out.println("Invalid gender. Only M or F allowed.");
        }
        sc.close();
    }
}
