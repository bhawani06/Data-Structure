package linkList;

public class merge2SortedLinkKList {

	public static void main(String[] args) {
		LLNode head=new LLNode();
		head.setData(2);
		LinkListImplementation LL =new LinkListImplementation(head);
		head=LL.insertAtBegining(head,1);
		//	LL.insertAtBegining(0);
			LL.insertAtEnd(head,6);
			LL.insertAtEnd(head,8);
			//LL.insertAtEnd(head,7);
			//LL.insertAtEnd(head,8);
			LL.insertAtpos(head,5, 3);
			LL.insertAtpos(head,3, 3);
			
			LLNode head1=new LLNode();
			head1.setData(2);
			LinkListImplementation LL1 =new LinkListImplementation(head1);
			head1=LL1.insertAtBegining(head1,1);
			//	LL.insertAtBegining(0);
			//	LL1.insertAtpos(head1,2, 3);
			//	LL1.insertAtpos(head1,1, 3);
				LL.insertAtEnd(head1,3);
				System.out.println();
				
				
			head = merge2sortedList(head,head1);
			LL.printLinkList(head);
			
	}

private static LLNode merge2sortedList(LLNode head, LLNode head1) {
	
		
		LLNode headr=new LLNode(),res=new LLNode();//new LLNode();
		res=headr;
		while(head1!=null && head !=null)
		{
			if(head1.data < head.data)
			{
				res.next=head1;
				head1=head1.next;
			}
			else
			{
				res.next=head;
				head=head.next;
			}

			res=res.next;
		}
		while(head1!=null)
		{
			res.next=head1;
			head1=head1.next;
			res=res.next;
		}
		while(head!=null)
		{
			res.next=head;
			head=head.next;
			res=res.next;
		}
		return headr.next;	
	}
}
