import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Transposition_Decryption {
	public static void main(String[] args) {
		// Create Scanner and receive User's Key and Ciphertext Message
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Ciphertext: ");
		String cipherText = scanner.nextLine();
		System.out.println("Enter Key: ");
		String key = scanner.nextLine();
		System.out.print("  Key: ");
		// Turn Key into List so it can be ordered later
		ArrayList<Character> unorderedKey = new ArrayList<Character>();
		for(char c: key.toUpperCase().toCharArray()){
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
		// Arrange Ciphertext into the grid
		double rowNum = Math.ceil((double)cipherText.length() / (double)key.length());
		char[][] grid = new char[(int)rowNum][key.length()];
		int letterCount = 0;
		// Loops to arrange in grid
		for(char c: orderedKey){
			int currCol = unorderedKey.indexOf(c);
			for(int r = 0; r < rowNum; r++){
				try{
					grid[r][currCol] = cipherText.charAt(letterCount);
					letterCount++;
				}catch(java.lang.StringIndexOutOfBoundsException e){
					grid[r][currCol] = ' ';
				}
			}
		}
		// Loop to print grid afterwards - add to a plaintext String as well
		String plaintext = "";
		for(int i = 0; i < rowNum; i++){
			System.out.print("       ");
			for(int j = 0; j < key.length(); j++){
				System.out.print(grid[i][j] + " ");
				plaintext = plaintext + grid[i][j];
			}
			System.out.println("");
		}
		// Output Plain Text
		System.out.println("Plain Text: " + plaintext);
	}
}
