package com.cg.eis.service;

import com.cg.eis.bean.Lab2_Pro3_Employee;

public class Lab2_Pro3_EmployeeServiceImplementatin implements Lab2_Pro3_EmployeeService {

    @Override
    public void addEmployee(Lab2_Pro3_Employee emp) {
        String scheme = findInsuranceScheme(emp.getSalary(), emp.getDesignation());
        emp.setInsuranceScheme(scheme);
    }

    @Override
    public String findInsuranceScheme(double salary, String designation) {
        if (salary >= 50000 && designation.equalsIgnoreCase("Manager")) {
            return "Scheme A";
        } else if (salary >= 20000 && salary < 50000 && designation.equalsIgnoreCase("Programmer")) {
            return "Scheme B";
        } else if (salary >= 5000 && salary < 20000 && designation.equalsIgnoreCase("Clerk")) {
            return "Scheme C";
        } else {
            return "No Scheme";
        }
    }

    @Override
    public void displayEmployee(Lab2_Pro3_Employee emp) {
        System.out.println("\n--- Employee Details ---");
        System.out.println(emp.toString());
    }
}
