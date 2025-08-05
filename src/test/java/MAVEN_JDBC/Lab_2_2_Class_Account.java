package MAVEN_JDBC;

class Lab_2_2_Class_Account {
private static long accCounter = 1000;
protected double accNum;
protected double balance;
protected Lab_2_2_Class_Person accHolder;

public Lab_2_2_Class_Account(Lab_2_2_Class_Person accHolder,double initialBalance) {
	this.accNum = accCounter++;
	this.accHolder = accHolder;
	this.balance = initialBalance;
}
public void deposite(double amount) {
	balance += amount;
}
public boolean withdraw(double amount) {
	if(balance - amount >= 0) {
		balance -= amount;
		return true;
	}else {
		System.out.println("Withdrawal failed for " + accHolder.getName());
		return false;
	}
}
public double getBalance() {
	return balance;
}
public String toString() {
	return "Account No: " + accNum + ", Holder: " + accHolder.getName() + " , Balance: INR " + balance;
}
}
