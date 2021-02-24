import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class One_Time_Encryption {

	public static void main(String[] args) {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Create alphabet array
		ArrayList<Character> alphabetList = new ArrayList<Character>(); // Create list to get letter indexes for i
		for(char c: alphabet){
			alphabetList.add(c);
		}
		// Retrieve Plaintext Message
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Message: ");
		String plaintext = scanner.nextLine();
		ArrayList<Integer> randomNumArray = new ArrayList<Integer>(); // Array used to store random number for each letter, output at end
		Random rng = new Random(); //Used to create random numbers
		String ciphertext = "";
		for(char c: plaintext.toLowerCase().toCharArray()){
			int i = alphabetList.indexOf(c);
			int randomNum = rng.nextInt(89) + 10; // 2 digit random number - as range starts at 0, adding 10 to make sure it is double digits
			randomNumArray.add(randomNum);
			int sum = i + randomNum;
			int modSum = sum % 26;
			ciphertext += alphabet[modSum];
		}
		// Output the ciphertext and the random numbers
		System.out.println("Ciphertext: " + ciphertext);
		System.out.print("Random Numbers: ");
		for(int n: randomNumArray){
			System.out.print(n + ", ");
		}
	}
}
