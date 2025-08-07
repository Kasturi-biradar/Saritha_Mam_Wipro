// import java.util.Arrays;
// import java.util.Scanner;
// public class ProductSorter {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//       // Step 1: Input number of products
//         System.out.print("Enter the number of products: ");
//         int n = scanner.nextInt();
//         scanner.nextLine(); // Consume newline
//       // Step 2: Create string array
//         String[] products = new String[n];
//         // Step 3: Input product names
//         System.out.println("Enter product names:");
//         for (int i = 0; i < n; i++) {
//             System.out.print("Product " + (i + 1) + ": ");
//             products[i] = scanner.nextLine();
//         }

//         // Step 4: Sort the array
//         Arrays.sort(products);

//         // Step 5: Display sorted product names
//         System.out.println("\nSorted Product Names:");
//         for (String product : products) {
//             System.out.println(product);
//         }

//         scanner.close();
//     }
// }
import java.util.Arrays;
import java.util.Scanner;
public class Lab3_Pro_4{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of products");
    int n = scanner.nextInt();
    scanner.nextLine();
    String[] products = new String[n];
    System.out.println("Enter a products names");
    for(int i=0;i<n;i++){
      System.out.println("Products " + (i+1) +": ");
      products[i] = scanner.nextLine();
    }
    Arrays.sort(products);

    System.out.println("Sorted Product Names");
    for(String product : products){
      System.out.println(product);
    }
  }
      
