package linkList;

import java.util.HashMap;

public class RemoveDuplicatedInUnsorted {

	public static void main(String[] args) {
		LLNode head=new LLNode();
		head.setData(2);
		LinkListImplementation LL =new LinkListImplementation(head);
		head=LL.insertAtBegining(head,21);
		//	LL.insertAtBegining(0);
			LL.insertAtEnd(head,2);
			LL.insertAtEnd(head,5);
			//LL.insertAtEnd(head,7);
			//LL.insertAtEnd(head,8);
			LL.insertAtpos(head,3, 3);
			LL.insertAtpos(head,21, 3);
			head = removeDuplicatedInUnsorted(head);
			LL.printLinkList(head);
			
	}
	
	

public static LLNode removeDuplicatedInUnsorted(LLNode head) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hm = new HashMap<>();
		if(head==null)
			return null;
		LLNode temp = new LLNode();
		temp.next= head;
		while(temp.next!=null)
		{
			if(hm.containsKey(temp.next.getData()))
			{
					temp.next=temp.next.next;
			}
			else
			{
				hm.put(temp.next.getData(), 1);
				temp=temp.next;
			}
		}
		
		return head;
	}

}
