/*
 * Question:
 * Design an algorithm and write code to remove the duplicate characters in a string 
 * without using any additional buffer NOTE: One or two additional variables are fine.
 * An extra copy of the array is not
 */

package array_string;

public class Q1_3 {
  
	public static String removeDuplicate1(String str){
		
		if(str == null) return null;
		
		//length of str is 1
		int length = str.length();
		if(length < 2) return str;
		
		//normal case
		boolean[] flag = new boolean[256];
		char[] temp = str.toCharArray();
		int cur = 0;
		int tail = 0;
		
		while(cur < length){
			int no = temp[cur];
			
			//char is no duplicated
			if(!flag[no]){
				flag[no] = true;
				temp[tail] = temp[cur];
				cur++;
				tail++;
			}else {
				cur++;
			}
		}
			
		return str = new String(temp,0,tail);
	}
	
	
	public static void removeDuplicate2(char[] str){
		
		//extreme cases
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		int tail = 1;
		
		for (int i = 1; i < len; i++) { 
			int j;
			for ( j = 0; j < tail; j++) {
				if (str[i] == str[j]) break; 
			}
			if (j == tail) { 
				str[tail] = str[i];
				++tail; 
			}
		}
		
		while(tail< len){
			str[tail] = 0;	
			tail++;
		}
	}
	
	public static void removeDuplicateEff(char[] str){
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		boolean[] hit = new boolean[256]; 
		
		hit[str[0]] = true;
		int tail = 1;
		
		for (int i = 1; i < len; ++i) { 
			if (!hit[str[i]]) {
			str[tail] = str[i]; 
			++tail; 
			hit[str[i]] = true;
			} 
		}
		
		while(tail<len){
			str[tail] = 0;
			tail++;
		}
	}

	
	public static void main(String[] args){
		String str = "daddadd";
		char[] test = str.toCharArray();
//		removeDuplicate2(test);
//		removeDuplicateEff(test);
		System.out.println(test);
	}
}
