package array_string;

public class UniqueChar {

  public static boolean isUniqueChars2(String str){
		
		boolean[] char_set = new boolean[256];
		
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			System.out.println(val);
			
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
