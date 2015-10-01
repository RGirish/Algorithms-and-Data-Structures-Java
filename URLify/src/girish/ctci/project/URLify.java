/**
 * @author Girish Raman
 * From 'Cracking the Coding Interview'
 * 
 * This program replaces the spaces within a string with %20, making it suitable for a url.
 * (I have no idea why I did it using a char[]. :/ but well, this works too.) 
 */
package girish.ctci.project;

public class URLify {

	public static void main(String[] args){
		String string = "Hey, Girish! How you doin man?!          ";
		System.out.println(URLifyString(string));
	}
	
	static String URLifyString(String string){
		char[] characterSequence = string.toCharArray();
		int pointer = characterSequence.length-1;		
		int i = characterSequence.length-1;
		while(characterSequence[i] == ' ') i--;
		for( ; i>=0 ; --i){
			System.out.println(i);
			while(i>=0 && characterSequence[i] != ' '){
				characterSequence[pointer] = characterSequence[i];
				pointer--;
				System.out.println(i);
				i--;
			}
			while(i>=0 && characterSequence[i] == ' '){
				characterSequence[pointer] = '0';pointer--;
				characterSequence[pointer] = '2';pointer--;
				characterSequence[pointer] = '%';pointer--;
				System.out.println(i);
				i--;
			}
			i++;
		}
		return String.valueOf(characterSequence);
	}	
}