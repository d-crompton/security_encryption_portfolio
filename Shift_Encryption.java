import java.util.ArrayList;
import java.util.Scanner;

public class Shift_Encryption {
	// Code used to encrypt a message using the shift cipher - key is 7
	public static void main(String[] args) {
		//Placing plain text Alphabet in a list - this is so index of each plain text char can be found quickly
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Create alphabet array
		int key = 4;
		ArrayList<Character> alphabetList = new ArrayList<Character>();
		for(char c: alphabet){ // Adding each letter into the list
			alphabetList.add(c);
		}
		Scanner scanner = new Scanner(System.in); // Creating Scanner for User Input
		System.out.println("Enter your message");
		String plaintextMsg = scanner.nextLine(); // Accepting User's Plain Text message
		System.out.println("Plain Text: " + plaintextMsg);
		scanner.close();
		//Loop through letters in Plain Text string, convert to ciphertext
		String ciphertext = "";
		int index = 0; // Used in finding each letters place in list and then finding the ciphertext letter
		for(char c: plaintextMsg.toLowerCase().toCharArray()){
			index = alphabetList.indexOf(c);
			if(index != -1){ //If symbol is not in alphabet, do not add to ciphertext (removes spaces)
				//Check if index + k goes out of bounds, if so wrap around
				if((index + key) > (alphabetList.size()-1)){
					int r = (index + key) - (alphabetList.size());
					ciphertext += alphabetList.get(r);
				}else{
					ciphertext += alphabetList.get(index + key);
				}
			}
		}
		System.out.println("Encrypted Message: " + ciphertext); // Output ciphertext
	}

}
