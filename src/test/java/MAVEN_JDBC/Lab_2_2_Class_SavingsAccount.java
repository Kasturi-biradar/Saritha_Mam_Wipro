package MAVEN_JDBC;

class Lab_2_2_Class_SavingsAccount extends Lab_2_2_Class_Account{
	
private static final double MIN_BALANCE = 500.0;

public Lab_2_2_Class_SavingsAccount(Lab_2_2_Class_Person accHolder,double initialBalance) {
	
	super(accHolder,initialBalance < MIN_BALANCE ? MIN_BALANCE : initialBalance);
}
@Override
public boolean withdraw(double amount) {
	if(balance - amount >= MIN_BALANCE) {
		balance -= amount;
		return true;
	}else {
		System.out.println("Cannot withdraw.Minimum balance of INR " + MIN_BALANCE + " must be maintained for " + accHolder.getName());
		return false;
	}
}
}
