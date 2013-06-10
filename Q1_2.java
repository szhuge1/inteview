/* Question:
 * Write code to reverse a C-Style String 
 * (C-String means that “abcd” is represented as five characters, including the null character )
 */

/* Ans:
 * This is a classic interview question The only “gotcha” is to try to do it in place, 
 * and to be care- ful for the null character
 */

package array_string;

public class Q1_2 {
	
    static void reverse1(char[] target){

        int head = 0;
        int tail = target.length - 2;
        while(head < tail){
            char temp = target[head];
            target[head] = target[tail];
            target[tail] = temp;
            head++;
            tail--;
        }
   }

   public static void main(String[] args){
        char [] test = {'1','2','3','3','1','5','\0'};
        reverse1(test);
        System.out.println(test);
   }
}
