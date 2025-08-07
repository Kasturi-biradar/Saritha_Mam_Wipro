// import java.util.Scanner                                     
// //User-defined Exception
// class AgeInvalidException extends Exception {
//     public AgeInvalidException(String message) {
//         super(message);
//     }
// }
// public class Lab3program2 {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//       // Get age input from user
//         System.out.print("Enter your age: ");
//         int age = scanner.nextInt();
//       try {
//             validateAge(age);
//             System.out.println("Age is valid: " + age);
//         } catch (AgeInvalidException e) {
//             System.out.println("Error: " + e.getMessage());
//         } scanner.close();
//     } // Method to validate age
//     public static void validateAge(int age) throws AgeInvalidException {
//         if (age <= 15) {
//             throw new AgeInvalidException("Invalid Age: Age must be greater than 15.");
//         }
//     }
// }
import java.util.Scanner;
class AgeInvalidException extends Exception{
  public AgeInvalidException(String message){
    super(message);
  }
}
public class Lab_3_pro_2{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your age: ");
    int age = scanner.nextInt();
    try{
      validateAge(age);
      System.out.println("Age is valid: ",+ age);
    }catch(AgeInvalidException e){
      System.out.println("Error: " + e.getMessage());
    }
  }
  public static void validateAge(int age) throws AgeInvalidException{
    if(age <= 15){
      throw new AgeInvalidException("Invalid Age: Age must be greater than 15.");
    }
  }
}
      
