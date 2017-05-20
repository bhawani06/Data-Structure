package linkList;

public class SwapInPairs {

	public static void main(String[] args) {
		LLNode head=new LLNode();
		head.setData(2);
		LinkListImplementation LL =new LinkListImplementation(head);
		head=LL.insertAtBegining(head,1);
		//	LL.insertAtBegining(0);
			LL.insertAtEnd(head,5);
			LL.insertAtEnd(head,6);
			//LL.insertAtEnd(head,7);
			//LL.insertAtEnd(head,8);
			LL.insertAtpos(head,4, 3);
			LL.insertAtpos(head,3, 3);
			LL.printLinkList(head);
			System.out.println("\nRotating :");
			head = reverseInPairs(head);
			LL.printLinkList(head);
			
	}
	
	public static LLNode reverseInPairs(LLNode head) {
		// TODO Auto-generated method stub
		if(head==null)
			return null;
		LLNode c = new LLNode()	,f,s,d = new LLNode();
		d.next=head;
		c=d;
		while(c.next!=null && c.next.next!=null)
		{
			f=c.next;
			s=c.next.next;
			c.next=s;
			f.next=s.next;
			s.next=f;
			c=c.next.next;
		}
		return d.next;
	}


}
