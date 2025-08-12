


package com.cg.eis.pl;

import java.util.Scanner;
import com.cg.eis.bean.Lab2_Pro3_Employee;
import com.cg.eis.service.Lab2_Pro3_EmployeeService;
import com.cg.eis.service.Lab2_Pro3_EmployeeServiceImplementatin;

public class Lab2_Pro3_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lab2_Pro3_EmployeeService service = new Lab2_Pro3_EmployeeServiceImplementatin();

        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();

        scanner.nextLine(); 
        System.out.println("Enter Employee Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Salary:");
        double salary = scanner.nextDouble();

        scanner.nextLine(); // Consume leftover newline
        System.out.println("Enter Designation:");
        String designation = scanner.nextLine();

        Lab2_Pro3_Employee emp = new Lab2_Pro3_Employee(id, name, salary, designation);
        service.addEmployee(emp);

        service.displayEmployee(emp);

        scanner.close();
    }
}
