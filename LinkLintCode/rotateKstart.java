package linkList;

public class rotateKstart {
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
			System.out.println("\nrotating 3");
			head = rotateKStart(head,3);
			LL.printLinkList(head);
			
	}
	// make 1-2-3-4-5-6-7-8-Null as 4-5-6-7-8-1-2-3-null (k=3)
		public static LLNode rotateKStart(LLNode head,int k) 
		{
			LLNode rotStart = new LLNode(),rotPrev = new LLNode(),trav=head;
			int i = 0;
			if(head==null)
			{
				return null;
			}
			while(trav.next!=null)  
			{					
				if(i==k-1)
				{
					rotPrev=trav;
					rotStart=trav.next;
				}
				++i;
				trav=trav.next;
			}

			rotPrev.next=null;
			trav.next=head;
			head= rotStart;
			return head;
		}

}
