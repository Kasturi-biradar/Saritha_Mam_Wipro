package MAVEN_JDBC;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab_13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Enter first date (dd-MM-yyyy): ");
        String firstDateStr = sc.nextLine();

        System.out.print("Enter second date (dd-MM-yyyy): ");
        String secondDateStr = sc.nextLine();

        LocalDate date1 = LocalDate.parse(firstDateStr, formatter);
        LocalDate date2 = LocalDate.parse(secondDateStr, formatter);

        if (date1.isAfter(date2)) {
            LocalDate temp = date1;
            date1 = date2;
            date2 = temp;
        }

        Period period = Period.between(date1, date2);

        System.out.println("\n--- Duration Between Dates ---");
        System.out.println("Years : " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days  : " + period.getDays());

        sc.close();
    }
}
