package Lab4;





import java.io.*;

public class Lab4_Pro1_FileContentReverse {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Kavya Para\\eclipse-workspace\\Wipro\\src\\test\\java\\Lab4\\Lab4_File1.txt";  // Make sure this file exists in your project root or give full path

        try {
            // Step 1: Read the content from the file
            FileReader fr = new FileReader(filePath);
            StringBuilder content = new StringBuilder();

            int ch;
            while ((ch = fr.read()) != -1) {
                content.append((char) ch);
            }
            fr.close();

            // Step 2: Reverse the content
            String reversedContent = content.reverse().toString();

            // Step 3: Write the reversed content back to the file
            FileWriter fw = new FileWriter(filePath);
            fw.write(reversedContent);
            fw.close();

            System.out.println("File content reversed and updated successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
