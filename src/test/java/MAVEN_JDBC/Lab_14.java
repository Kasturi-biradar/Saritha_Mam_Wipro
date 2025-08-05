package MAVEN_JDBC;
//import java.time.ZonedDateTime;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.Scanner;
//public class Lab_14 {
//
//    public static void printDateTimeForZone(String zoneId) {
//        try {
//            ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of(zoneId));
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");
//
//            System.out.println("Current Date and Time in " + zoneId + ": " + dateTime.format(formatter));
//        } catch (Exception e) {
//            System.out.println("Invalid Zone ID: " + zoneId);
//        }
//    }
//
//    // ✅ Main method
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter Zone ID (e.g., Asia/Tokyo, US/Pacific): ");
//        String zoneInput = scanner.nextLine();
//
//        printDateTimeForZone(zoneInput);
//
//        scanner.close();
//    }
//}
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Lab_14{
	public static void printDateTimeForZone(String zoneId) {
		try {
			ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of(zoneId));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss z");
			System.out.println("Current Date and Time in " + zoneId + ": " + dateTime.format(formatter));
		}catch(Exception e) {
			System.out.println("Invalid Zone Id: " + zoneId);
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Zone ID (e.g., Asia/Tokyo, US/Pacific):");
		String zoneInput  = scanner.nextLine();
		printDateTimeForZone(zoneInput);
		scanner.close();
	}
}