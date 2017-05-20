package linkList;

public class RemoveDuplicatedInSorted {

	public static void main(String[] args) {
		LLNode head=new LLNode();
		head.setData(2);
		LinkListImplementation LL =new LinkListImplementation(head);
		head=LL.insertAtBegining(head,1);
		//	LL.insertAtBegining(0);
			LL.insertAtEnd(head,5);
			LL.insertAtEnd(head,5);
			//LL.insertAtEnd(head,7);
			//LL.insertAtEnd(head,8);
			LL.insertAtpos(head,3, 3);
			LL.insertAtpos(head,3, 3);
			head = removeDuplicatedInSorted(head);
			LL.printLinkList(head);
			
	}
	
	public static LLNode removeDuplicatedInSorted(LLNode head) {
		// TODO Auto-generated method stub
		
		LLNode temp=head;
		if(head==null)
			return null;
		while(temp.next!=null &&temp!=null)
		{
			if(temp.data!=temp.next.data)
				temp=temp.next;
			else
				temp.next=temp.next.next;
		}
		return head;
	}
}
