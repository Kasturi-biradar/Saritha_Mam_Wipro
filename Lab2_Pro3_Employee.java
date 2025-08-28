package com.cg.eis.bean;

public class Lab2_Pro3_Employee {
    private int id;
    private String name;
    private double salary;
    private String designation;
    private String insuranceScheme;

    public Lab2_Pro3_Employee(int id, String name, double salary, String designation) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }

public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDesignation() { return designation; }
    public String getInsuranceScheme() { return insuranceScheme; }

    public void setInsuranceScheme(String insuranceScheme) {
        this.insuranceScheme = insuranceScheme;
    }
 public String toString() {
        return "Employee ID: " + id +
               "\nName: " + name +
               "\nSalary: " + salary +
               "\nDesignation: " + designation +
               "\nInsurance Scheme: " + insuranceScheme;
    }
}
