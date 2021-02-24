import java.util.ArrayList;
import java.util.Scanner;

public class One_Time_Decryption {

	public static void main(String[] args) {
		// Decryption process taking the ciphertext and random numbers from the encryption code and decrypting it.
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Create alphabet array
		ArrayList<Character> alphabetList = new ArrayList<Character>(); // Create list to get letter indexes for i
		for(char c: alphabet){
			alphabetList.add(c);
		}
		// Recieve Ciphertext and Random Numbers
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Ciphertext:");
		String ciphertext = scanner.nextLine();
		System.out.println("Enter Pad Numbers with the format 'x, y,...");
		String padNumString = scanner.nextLine();
		String[] padNumStringArray = padNumString.split(", ");
		ArrayList<Integer> padNums = new ArrayList<Integer>();
		for(String s: padNumStringArray){
			padNums.add(Integer.valueOf(s));
		}
		// Translating ciphertext letters to plaintext
		int numIndex = 0; //Used to pair each letter with the pad number
		String plaintext = "";
		for(char c: ciphertext.toLowerCase().toCharArray()){
			int i = alphabetList.indexOf(c);
			int iMinusPadNum = i - padNums.get(numIndex);
			numIndex++;
			int modNum = iMinusPadNum % 26;
			if(modNum < 0){
				modNum += 26;
			}
			plaintext += alphabetList.get(modNum);
		}
		System.out.println(plaintext);
	}
}
