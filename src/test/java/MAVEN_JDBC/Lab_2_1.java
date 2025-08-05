package MAVEN_JDBC;

public class Lab_2_1 {
	static class Person {
		private String name;
		private int age;
		
		public Person(String name,int age) {
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
	}
	
	static class Account{
		private long accCounter = 1000;
		private long accNum;
		private double balance;
		private Person accHolder;
		
		public Account(Person accHolder,double initialBalance) {
			this.accNum = accCounter++;
			this.accHolder = accHolder;
			if(initialBalance >= 500 ) {
				this.balance = initialBalance;
			}else {
				System.out.println("Initial balance must be at least INR 500.");
				this.balance = 500;
			}
		}
		public void deposite(double amount) {
			balance += amount;
		}
		public void withdraw(double amount) {
			if(balance - amount >= 500) {
				balance -= amount;
			}else {
				System.out.println("Insufficient balance.Minimumk INR 500 must be maintained.");
			}
		}
		public double getBalance() {
			return balance;
		}
		public long getAccNum() {
			return accNum;
		}
		public Person getAccHolder() {
			return accHolder;
		}
	}
	public static void main(String[] args) {
		Person smith = new Person("Smith",30);
		Person kathy = new Person("Kathy",28);
		
		Account smithAccount = new Account(smith,2000);
		Account kathyAccount = new Account(kathy,3000);
		
		smithAccount.deposite(2000);
		kathyAccount.withdraw(2000);
		System.out.println(smith.getName() + "'s updated balance: INR " + smithAccount.getBalance());
		System.out.println(kathy.getName() + "'s updated balance: INR " + kathyAccount.getBalance());
		
	}
}
