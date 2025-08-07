// import com.cg.eis.exception.EmployeeException;
// import java.util.Scanner;
// public class EmployeeMain {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         // Input employee details
//         System.out.print("Enter Employee ID: ");
//         int empId = scanner.nextInt();
//         scanner.nextLine(); // Consume newline
//         System.out.print("Enter Employee Name: ");
//         String empName = scanner.nextLine();
//         System.out.print("Enter Employee Salary: ");
//         double salary = scanner.nextDouble();
//         try {
//             validateSalary(salary);
//             System.out.println("\nEmployee Details:");
//             System.out.println("ID: " + empId);
//             System.out.println("Name: " + empName);
//             System.out.println("Salary: " + salary);
//         } catch (EmployeeException e) {
//             System.out.println("Exception Occurred: " + e.getMessage());
//         }
//         scanner.close();
//     }
//     // Method to validate salary
//     public static void validateSalary(double salary) throws EmployeeException {
//         if (salary < 3000) {
//             throw new EmployeeException("Salary must not be less than 3000.");
//         }
//     }
// }
import com.cg.eis.exception.EmployeeException;
import java.util.Scanner;
public class Lab_3_pro_3{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Employee ID: ");
    int empId = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Employee Name: ");
    String empName = scanner.nextLine();
    System.out.print("Enter Employee Salary: ");
    double salary = scanner.nextDouble();
    try{
      validateSalary(salary);
      System.out.println("Employee Details: ");
      System.out.println("ID: " + empId);
      System.out.println("Name: " + empName);
      System.out.println("Salary: " + salary);
    }catch(EmployeeException e){
      System.out.println("Exception Occurred: " + e.getMessage());
    }
    public static void validateSalary(double salary) throws EmployeeException{
      if(salary < 3000){
        throw ne EmployeeException("Salary must not be less than 3000.");
      }
    }
  }
