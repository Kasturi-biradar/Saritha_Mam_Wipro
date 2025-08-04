package MAVEN_JDBC;

public class Lab5 {
public static void main(String[] args) {
	if(args.length == 0) {
		System.out.println("Please Enter a number as command line argument.");
		return;
	}
	int number = Integer.parseInt(args[0]);
	
	if(number>0) {
		System.out.println("The number is positive.");
	}else if(number < 0) {
		System.out.println("The number is negative");
	}else {
		System.out.println("The number is zero");
	}
}
}
