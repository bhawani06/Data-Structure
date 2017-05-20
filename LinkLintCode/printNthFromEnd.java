package linkList;

public class printNthFromEnd {
	
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
			LLNode nth = printNthFromLast(head,4);
			System.out.println("\n"+nth.getData());
			
	}

	public static LLNode printNthFromLast(LLNode head, int n) 
	{
		// TODO Auto-generated method stub
		if(head==null)
			return null;
		LLNode trav=head,slow=head;
		int i=0;
		while(i<n)
		{
			++i;
			trav=trav.next;
			if(trav==null)
			{
				System.out.println("Larger than length");
				return null;
			}
		}
		while(trav!=null)
		{
			slow=slow.next;
			trav=trav.next;
		}
		return slow;
	}

	

}
