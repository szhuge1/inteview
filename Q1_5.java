/*
 * Question:
 * Write a method to replace all spaces in a string with ‘%20’
 */

package array_string;

public class Q1_5 {
  
	public static void replaceFun(char[] str){
		//count the number of space
		int spaceCount =0;
		for(int i=0; i<str.length; i++){
			
			if(str[i] == ' '){
				spaceCount++;
			}
		}
		
		//replace it with '%20'
		int newLength = str.length + spaceCount*2;
		char[] temp = str;
		str = new char[newLength];
		int tail = 0;
		for(int j=0; j<temp.length; j++){
			if(temp[j] == ' '){
				str[tail] = '%';
				str[tail+1] = '2';
				str[tail+2] = '0';
				tail = tail + 3;
			}else {
				str[tail] = temp[j];
				tail++;
			}
		}
	}
	
	public static void main(String[] args){
		String test = " ";
		char[] str = test.toCharArray();
		replaceFun(str);
		System.out.println(str);
	}
}
