import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Transposition_Encrypt {
	public static void main(String[] args) {
		//Create Scanner and receive User's Key and Plaintext Message
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Message: ");
		String plainText = scanner.nextLine();
		System.out.println("Enter Key: ");
		String key = scanner.nextLine();
		//Output User's inputs to console
		System.out.println("Message: " + plainText);
		System.out.print("  Key: ");
		// Turn Key into List so it can be ordered
		ArrayList<Character> unorderedKey = new ArrayList<Character>();
		for (char c: key.toUpperCase().toCharArray()){
			System.out.print(c + " ");
			unorderedKey.add(c);
		}
		// Create another list that will be ordered, unordered Key list will be used later
		ArrayList<Character> orderedKey = new ArrayList<Character>();
		orderedKey.addAll(unorderedKey);
		Collections.sort(orderedKey);
		// Output the order of the columns based on the key
		System.out.println("");
		System.out.print("Order: ");
		for(char c: key.toUpperCase().toCharArray()){
			System.out.print(orderedKey.indexOf(c)+1 + " ");
		}
		System.out.println("");
		//Arrange Message into Grid
		plainText = plainText.replaceAll(" ",""); // Remove whitespace
		double rowNum = Math.ceil((double)plainText.length() / (double)key.length());
		char[][] grid = new char[(int)rowNum][key.length()];
		int letterCount = 0;
		for(int i = 0; i < rowNum; i++){
			System.out.print("       ");
			for(int j = 0; j < key.length(); j++){
				if(letterCount < plainText.length()){
					grid[i][j] = plainText.charAt(letterCount);
				}else{
					grid[i][j] = ' ';
				}
				System.out.print(grid[i][j] + " ");
				letterCount++;
			}
			System.out.println("");
		}
		// Retrieve the ciphertext from the grid
		String cipherText = "";
		for(char c: orderedKey){
			int currCol = unorderedKey.indexOf(c);
			for(int k = 0; k < rowNum; k++){
				cipherText = cipherText + grid[k][currCol];
			}
		}
		System.out.println(cipherText);
	}

}
