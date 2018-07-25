package com.sher.string;

/**
 * Given a text find substring.
 */
public class FindSubString {

	// Return index of the match, -1 if not found
	// We will use Robin Kaff.
	// Time: O(n+m) // n = length of text, m = substring length
	// Space O(1)
	static class RobinKaff {
		public int findSubString(String text, String subString) {
			int lenText = text.length();
			int lenSubString = subString.length();
			if (lenText == 0 || lenSubString == 0 || lenSubString > lenText)
				return -1;

			long subtHash = getHash(subString);
			String tt = text.substring(0, lenSubString);
			long rollingHash = getHash(tt);
			System.out.println("here :" + subtHash + "," + rollingHash);

			for (int i = 1; i  < lenText - lenSubString - 1; i++) {
				rollingHash = getRollingHash(rollingHash, text.charAt(i -1), text.charAt(i + lenSubString - 1), lenSubString);
				if (rollingHash == subtHash) {
					if (subString.equals(text.substring(i,i + lenSubString)))
						return i;
				}
			}
			return -1;
		}

		final static int base = 31; //use a big prime number like 31 or 101
		//Lets say the textLength = 3;
		private  long getRollingHash(long currentHash, char charToRemove, char charToAdd, int textLen) {
			if (currentHash == 0) {//new hash
				return 0;
			}  else {
				long hash = currentHash - charToRemove;
				hash = hash/base;
				hash += charToAdd * Math.pow(base, textLen - 1);
				return hash;
			}

		}

		private long getHash(String text) {
			if (text.length() == 0) return 0;

			int i = 0; long hash = 0;
			for (char c: text.toCharArray()) {
				hash += c * Math.pow(base, i);
				i++;
			}
			return hash;
		}
	}
	
	public static void main(String arg[]) {
		FindSubString.RobinKaff robin = new FindSubString.RobinKaff();
		int index = robin.findSubString("HelloWorld", "Wor");
		System.out.println(index);

	}
}