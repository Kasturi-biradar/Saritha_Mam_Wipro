package MAVEN_JDBC;

public class Lab9 {
public static String addToItSelf(String str) {
	return str + str;
}

public static String replaceOddPositions(String str) {
	String result = "";
	for(int i = 0;i < str.length();i++) {
		if(i % 2 == 0) {
			result += str.charAt(i);
		}else {
			 result += "#";
		}
	}
	return result;
}

public static String removeDuplicates(String str) {
	String result = "";
	for(int i=0;i<str.length();i++) {
		char ch = str.charAt(i);
		if(result.indexOf(ch)==-1) {
			result += ch;
		}
	}
	return result;
}
public static String changeOddToUpper(String str) {
	String result = "";
	for(int i=0;i<str.length();i++) {
		char ch= str.charAt(i);
		if(i % 2 != 0) {
			result += Character.toUpperCase(ch);
		}else {
			result += ch;
		}
	}
	return result;
}
public static void main(String[] args) {
	String str = "hello";
	System.out.println(str);
	System.out.println(addToItSelf(str));
	System.out.println(replaceOddPositions(str));
	System.out.println(removeDuplicates(str));
	System.out.println(changeOddToUpper(str));
}
}

