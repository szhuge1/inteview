
/*Question: 
 *Implement an algorithm to determine if a string has all unique characters 
 *What if you can not use additional data structures?
 */

/* Ans:
 * For simplicity, assume char set is ASCII (if not, we need to increase the storage size 
 * The rest of the logic would be the same) NOTE: This is a great thing to point out to your interviewer!
 */

package array_string;

public class Q1_1 {

  public static boolean isUniqueChars2(String str){
		
		boolean[] char_set = new boolean[256];
		
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			
			if(char_set[val]) return false;
			char_set[val] = true;
		}
		
		return true;
	}
	
	public static boolean isUniqueChars(String str) {
		
		int checker = 0;
		
		for(int i=0 ; i<str.length() ; i++){
			int val = str.charAt(i) - 'a';
			
			if ((checker & (1 << val)) > 0) return false;
			System.out.println(1<<val);
			checker |= (1 << val);
			System.out.println("checker: " + checker);
		}
		
		return true;
	}
}
