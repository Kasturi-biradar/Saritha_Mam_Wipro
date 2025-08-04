package MAVEN_JDBC;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Lab_11 {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Enter a date (dd-MM-yyyy): ");
        String input = sc.nextLine();

        LocalDate inputDate = LocalDate.parse(input, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(inputDate, currentDate);
        System.out.println("\n--- Duration from entered date to current date ---");
        System.out.println("Years : " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days  : " + period.getDays());
    }
}
