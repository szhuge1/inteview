
/*
 * Question:
 * Write a method to decide if two strings are anagrams or not
 */

package array_string;

import java.util.Arrays;

public class Q1_4 {
  
	public static boolean checkAnagrams1(String str1, String str2){
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		Arrays.sort(chars1);
		str1 = new String(chars1);
		Arrays.sort(chars2);
		str2 = new String(chars2);
		
		return str1.equalsIgnoreCase(str2);
	}
	
	public static void main(String[] args){
		
		String str1 = "asdf";
		String str2 = "fdsa";
		System.out.println(checkAnagrams1(str1, str2));
	}
}
