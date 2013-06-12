/* Question:
 * Write code to remove duplicates from an unsorted linked list FOLLOW UP 
 * How would you solve this problem if a temporary buffer is not allowed?
 */

package linked_list;

import java.util.Hashtable;

public class Q2_1 {

  public static void deleteDuplicate1(LinkedListNode n){

		Hashtable table = new Hashtable();
		LinkedListNode previous = null;

		while(n!=null){
			if(table.containsKey(n.data)) previous.next = n.next;
			else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}

	}

	public static void deleteDups2(LinkedListNode head) {
		if(head == null) return;
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;

		while(current != null){
			LinkedListNode runner = head;
			while(runner != current){
				if( runner.data == current.data){
					LinkedListNode tmp = current.next;
					previous.next = tmp;
					current = tmp;
					break;
				}
				runner = runner.next;
			}
			if(runner == current){
				previous = current;
				current = current.next;
			}
		}
	}
	
	public static void deleteDups4(LinkedListNode head){
		if(head ==  null) return;
		
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;
		
		while(current != null){
			LinkedListNode runner = head;
			while(runner != current){
				if(runner.data == current.data){
					previous.next = current.next;
					current = current.next;
					break;
				}
				runner = runner.next;
			}
			
			if(runner == current) {
				previous = current;
				current = current.next;
			}
			
		}
	}

	public static void deleteDups3(LinkedListNode head){
		if(head == null) return;

		LinkedListNode runner = head;
		
		while(runner != null){
			LinkedListNode previous = runner;
			LinkedListNode current = previous.next;
			while(current != null){
				if(current.data ==  runner.data){
					current = current.next;
					previous.next = current;
				}else{
					previous = current;
					current = current.next;
				}
			}
			runner = runner.next;
		}

	}

	public static void main(String[] args){
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(1);
		LinkedListNode n4 = new LinkedListNode(3);
		LinkedListNode n5 = new LinkedListNode(1);
		LinkedListNode n6 = new LinkedListNode(2);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		deleteDups3(n1);
		LinkedListNode tmp = n1;
		while(tmp != null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
}
