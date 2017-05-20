package linkList;

public class LinkListImplementation {
	//LLNode head = new LLNode();
	public LinkListImplementation(LLNode h)
	{
	/*	insertAtBegining(h,1);
		//	LL.insertAtBegining(0);
		insertAtEnd( h,5);
		insertAtEnd(h,6);
		insertAtpos(h,4, 3);
		insertAtpos(h,3, 3);
		printLinkList(h);*/
	}

	public LinkListImplementation()
	{
		
	}

	public LLNode insertAtBegining(LLNode head,int val)
	{
		LLNode newNode = new LLNode();
		newNode.setData(val);
		newNode.setNext(null);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			newNode.setNext(head);
			head= newNode;
		}
		return head;
	}

	public LLNode insertAtEnd(LLNode head,int val)
	{
		LLNode newNode = new LLNode();
		newNode.setData(val);
		newNode.setNext(null);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			LLNode trav= new LLNode();
			trav=head;
			while(trav.next!=null)
			{
				trav=trav.next;
			}
			trav.next=newNode;
		}
		
		return head;
	}
	public LLNode insertAtpos(LLNode head,int val,int pos)
	{
		LLNode newNode = new LLNode();
		newNode.setData(val);
		newNode.setNext(null);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			LLNode trav= new LLNode();
			trav=head;
			int count =1;
			while(trav.next!=null&&count<pos-1)
			{
				trav=trav.next;
				++count;
			}
			newNode.next = trav.next;
			trav.next=newNode;
		}
		return head;
	}
	public void printLinkList(LLNode head )
	{
		LLNode trav= new LLNode();
		trav=head;
		while(trav!=null)
		{
			System.out.print(trav.getData()+",");
			trav=trav.next;
		}
	}
	public LLNode delAtBeg(LLNode head)
	{
		if(head==null)
			return null;
		LLNode temp = head;
		
		head=head.next;
		return head;
	}
	private LLNode deleteVal(LLNode head, int i) {
		if(head ==null)
			return null;
		else
		{
			LLNode prev=head;
			LLNode trav = head;
			while(trav.next!=null && trav.getData()!=i)
			{
				prev=trav;
				trav=trav.next; 
			}
			if(trav==head)
			{
				head=head.next;
			}
			prev.next=trav.next;
			
		}
		return head;
	}

	public LLNode deleteAtEnd(LLNode head) {
		if(head ==null)
			return null;
		else
		{
			LLNode prev=head;
			LLNode trav = head;
			while(trav.next!=null)
			{
				prev=trav;
				trav=trav.next;
			}
			prev.next=null;
			
		}
		return head;
	}

	public static void main(String[] args) {
		LLNode head = new LLNode();
		head.setData(2);
		LinkListImplementation LL = new LinkListImplementation(head);
		head=LL.insertAtBegining(head,1);
	//	LL.insertAtBegining(0);
		LL.insertAtEnd(head,5);
		LL.insertAtEnd(head,6);
		LL.insertAtpos(head,4, 3);
		LL.insertAtpos(head,3, 3);
		System.out.println();
		LL.printLinkList(head);

		head=LL.delAtBeg(head);
		head=LL.deleteAtEnd(head);

		head=LL.deleteVal(head,77);
		System.out.println();
		LL.printLinkList(head);
		
	}

}
