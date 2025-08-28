// import java.util.Scanner;
// public class EmployeeNameValidator {
//  // User-defined exception as an inner class
//     static class NameInvalidException extends Exception {
//         public NameInvalidException(String message) {
//             super(message);
//         }
//     }
// // Main method
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//       // Input first and last name
//         System.out.print("Enter First Name: ");
//         String firstName = scanner.nextLine().trim();
//       System.out.print("Enter Last Name: ");
//         String lastName = scanner.nextLine().trim();
// try {
//             validateName(firstName, lastName);
//             System.out.println("\nFull Name is Valid: " + firstName + " " + lastName);
//         } catch (NameInvalidException e) {
//             System.out.println("Name Validation Failed: " + e.getMessage());
//         }
// scanner.close();
//     }
// // Method to validate names
//     public static void validateName(String firstName, String lastName) throws NameInvalidException {
//         if (firstName.isEmpty() || lastName.isEmpty()) {
//             throw new NameInvalidException("First name and Last name must not be blank.");
//         }
//     }
// }
import java.util.Scanner;
public class Lab_3_pro_1{
  static class NameInvalidException extends Exception{
    public NameInvalidException(String message){
      super(message);
    }
  }
  public static void main(String args){
    Scanner scanner = ne Scanner(System.in);
    System.out.println("Enter first name");
    String firstName = scanner.nextLine().trim();
    System.out.println("Enter Last Name");
    String lastName = scanner.nextLine().trim();
    try{
      validateName(firstName, lastName);
      System.out.println("Full Name is Valid: " + firstName + " " + lastName);
    }catch (NameInvalidException e){
      System.out.println("Name validation Failed: " + e,getMessage());
    }
    public static void validateName(String firstName,String lastName) throws NameIncalidException{
      if(firstName.isEmpty() || lastName.isEmpty()){
        throw new NameInvalidException(First name and Last name must nolt be blank.");
      }
    }
  }
