import java.util.ArrayList;
import java.util.Scanner;

public class Shift_Decryption {
	// Code used to decrypt a message using the shift cipher where the key is 7
	public static void main(String[] args) {
		//Placing plain text Alphabet in a list - this is so index of each plain text char can be found quickly
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Create alphabet array
		int key = 9;
		ArrayList<Character> alphabetList = new ArrayList<Character>();
		for(char c: alphabet){ // Adding each letter into the list
			alphabetList.add(c);
		}
		Scanner scanner = new Scanner(System.in); // Creating Scanner for User Input
		System.out.println("Enter your message");
		String ciphertextMsg = scanner.nextLine(); // Accepting User's Plain Text message
		System.out.println("Cipher Text: " + ciphertextMsg);
		scanner.close();
		//Loop through letters in Cipher Text string, convert to plaintext
		String outputText = "";
		for(char c: ciphertextMsg.toCharArray()){
			int index = alphabetList.indexOf(c);
			if(index != -1){ //If symbol is not in the alphabet, do not add to ciphertext (removes spaces)
				//Check if index + k goes out of bounds, if so wrap around
				if((index - key) < 0){
					int i = (alphabetList.size()) + (index - key);
					outputText += alphabetList.get(i);
				}else{
					outputText += alphabetList.get(index - key);
				}
			}
		}
		// Output decrypted message
		System.out.println("Decrypted Message: " + outputText);
	}
}
