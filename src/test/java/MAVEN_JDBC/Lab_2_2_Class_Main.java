package MAVEN_JDBC;

public class Lab_2_2_Class_Main {
public static void main(String[] args) {
	Lab_2_2_Class_Person smith = new Lab_2_2_Class_Person("Smith",30);
	Lab_2_2_Class_Person kathy = new Lab_2_2_Class_Person("Kathy",28);
	
	Lab_2_2_Class_SavingsAccount smithAccount = new Lab_2_2_Class_SavingsAccount(smith,2000);
	Lab_2_2_Class_CurrentAccount kathyAccount = new Lab_2_2_Class_CurrentAccount(kathy,3000,1000);
	
	smithAccount.deposite(2000);
	boolean kathyWithdrawal = kathyAccount.withdraw(3500);
	
	System.out.println("Updated Account Details--");
	System.out.println(smithAccount);
	System.out.println(kathyAccount);
}
}
