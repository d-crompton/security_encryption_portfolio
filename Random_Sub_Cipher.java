import java.util.ArrayList;
import java.util.Random;

public class Random_Sub_Cipher {
	// This code will produce a ciphertext alphabet by randomly substituting one letter for another.
	public static void main(String[] args) {
		//Create plain alphabet, will be looped and added to a 2D CipherText Alphabet array
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[][] cipherAlphabet = new char[26][2]; //Create empty alphabet array
		ArrayList<Character> usedLetters = new ArrayList<Character>(); //List makes checking letters easier
		Random rng = new Random(); //Create random number generator object
		int index = 0; //Create iterator index variable
		for(char c: alphabet){
			cipherAlphabet[index][0] = alphabet[index];
			//Get random letter to pair with, and check it hasn't already been used
			char subLetter = '0';
			int rngIndex = 0;
			do{
				rngIndex = rng.nextInt(26);
				subLetter = alphabet[rngIndex];
			}while(usedLetters.indexOf(subLetter) != -1);
			usedLetters.add(subLetter);
			cipherAlphabet[index][1] = subLetter;
			index++;
		}
		//Output PlainText and CipherText alphabets for comparison
		System.out.print("PlainText:  ");
		for(char[] c: cipherAlphabet){
			System.out.print(c[0] + " ");
		}
		System.out.println("");
		System.out.print("CipherText: ");
		for(char[] c: cipherAlphabet){
			System.out.print(c[1] + " ");
		}
	}
}
