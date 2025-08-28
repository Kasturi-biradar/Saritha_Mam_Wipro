package MAVEN_JDBC;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Scanner;
//public class Lab_12 {
//
//    public void calculateExpiryDate(String purchaseDateStr, int warrantyYears, int warrantyMonths) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate purchaseDate = LocalDate.parse(purchaseDateStr, formatter);
//        LocalDate expiryDate = purchaseDate.plusYears(warrantyYears).plusMonths(warrantyMonths);
//        System.out.println("Warranty Expiry Date: " + expiryDate.format(formatter));
//    }
//    	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Lab_12 wc = new Lab_12();
//
//        System.out.print("Enter purchase date (dd-MM-yyyy): ");
//        String date = sc.nextLine();
//
//        System.out.print("Enter warranty period in years: ");
//        int years = sc.nextInt();
//
//        System.out.print("Enter warranty period in months: ");
//        int months = sc.nextInt();
//
//        wc.calculateExpiryDate(date, years, months);
//
//        sc.close();
//    }
//}
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Lab_12{
	public void calculateExpiryDate(String purchaseDateStr,int warrantyYears,int warrentyMonths) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate purchaseDate = LocalDate.parse(purchaseDateStr, formatter);
		LocalDate expiryDate = purchaseDate.plusYears(warrantyYears).plusMonths(warrentyMonths);
		System.out.println("Warrenty Expiry Date: "+ expiryDate.format(formatter));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lab_12 wc = new Lab_12();
		System.out.println("Enter purchase date(dd-mm-yyyy)");
		String date = sc.nextLine();
		System.out.println("Enter warranty period in years: ");
		int years = sc.nextInt();
		System.out.println("Enter warrenty period in months: ");
		int months = sc.nextInt();
		wc.calculateExpiryDate(date, years, months);
	}
}
