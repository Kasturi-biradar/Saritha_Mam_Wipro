package MAVEN_JDBC;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Lab_14 {
   public void printDateTimeForZone(String zoneIdStr) {
        try {
            ZoneId zoneId = ZoneId.of(zoneIdStr); // Convert string to ZoneId
            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId); // Get date and time

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

            System.out.println("Current Date and Time in " + zoneIdStr + ": " +
                    zonedDateTime.format(formatter));
        } catch (Exception e) {
            System.out.println("Invalid Zone ID. Please try again with a valid one.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      Lab_14 printer = new Lab_14();

        System.out.print("Enter Zone ID (e.g., Asia/Tokyo, Europe/London): ");
        String inputZone = sc.nextLine();

        printer.printDateTimeForZone(inputZone);

        sc.close();
    }
}
