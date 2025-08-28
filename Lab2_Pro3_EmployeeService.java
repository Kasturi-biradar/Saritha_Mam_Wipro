package com.cg.eis.service;

import com.cg.eis.bean.Lab2_Pro3_Employee;

public interface Lab2_Pro3_EmployeeService {
    public void addEmployee(Lab2_Pro3_Employee emp);
    public String findInsuranceScheme(double salary, String designation);
    public void displayEmployee(Lab2_Pro3_Employee emp);
}
