package MAVEN_JDBC;

class Lab_2_2_Class_CurrentAccount extends Lab_2_2_Class_Account{
private double overdraftLimit;

public Lab_2_2_Class_CurrentAccount(Lab_2_2_Class_Person accHolder, double initialBalance,double overdreaftLimit) {
	super(accHolder,initialBalance);
	this.overdraftLimit = overdraftLimit;
}
@Override
public boolean withdraw(double amount) {
	if(balance - amount >= -overdraftLimit) {
		balance -= amount;
		return true;
	}
	else {
		System.out.println("Overdraft limit exceeded for" + accHolder.getName());
		return false;
	}
}
}
