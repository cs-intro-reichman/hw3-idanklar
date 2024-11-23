/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String newStr1 = "";
		String newStr2 = "";
		for(int i = 0; i < str1.length(); i++) {
			if (alphabet.indexOf(str1.charAt(i)) != -1) {
				newStr1 += str1.charAt(i); 
			}
		}
		for(int i = 0; i < str2.length(); i++) {
			if (alphabet.indexOf(str2.charAt(i)) != -1) {
				newStr2 += str2.charAt(i); 
			}
		}
		if (newStr1.length() != newStr2.length()) return false;
		for(int i = 0; i < newStr1.length(); i++) {
			if (newStr2.indexOf(newStr1.charAt(i)) == -1) {
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String fixed = "";
		for(int i = 0; i < str.length(); i++) {
			if (alphabet.indexOf(str.charAt(i)) != -1 || str.charAt(i) == ' ') {
				fixed += str.charAt(i); 
			}
		}
		return fixed;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String fixedStr = str.replace(" ", "");
		int length = fixedStr.length();
		String newStr = "";
		while (!fixedStr.isEmpty()) {
			int random = (int)(Math.random() * length);
			newStr += fixedStr.charAt(random);
			fixedStr = fixedStr.substring(0, random) + fixedStr.substring(random + 1);
			length--;
		}
		return newStr;
	}
}
