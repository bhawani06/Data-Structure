package linkList;

public class reverseLinkList {
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
			LL.printLinkList(head);
			System.out.println();
			head = reverseLinklist(head);
			LL.printLinkList(head);
			
	}
	public static LLNode reverseLinklist(LLNode head) 
	{
		if(head==null)
			return null;
		LLNode prev= null,curr=head,next;//=head.next;
		
		while(curr!=null)
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
		return head;
		
	}
}
