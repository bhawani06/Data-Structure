package linkList;

public class Add2LLNumbers {

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
			
			LLNode head1=new LLNode();
			head1.setData(2);
			LinkListImplementation LL1 =new LinkListImplementation(head1);
			head1=LL1.insertAtBegining(head1,1);
			//	LL.insertAtBegining(0);
			//	LL1.insertAtpos(head1,2, 3);
			//	LL1.insertAtpos(head1,1, 3);
				LL.insertAtEnd(head1,3);
				System.out.println();
				
				
			head = AddTwoNumbers(head,head1);
			LL.printLinkList(head);
			
	}
	/* 385+321 = 706
	 * input is 2 "reversed digit" nos
	 * 1-2-3 + 
	 * 5-8-3 =
	 * 6-0-7
	 */
	public static LLNode AddTwoNumbers(LLNode trav,LLNode trav1) {
		// TODO Auto-generated method stub
		if(trav == null && trav1==null)
			return null;
		if( trav1==null)
			return trav;
		if( trav==null)
			return trav1;
		LLNode res = new LLNode(),trav2=new LLNode();
		int sum,carry=0;
			trav2= res;
		while(trav!=null && trav1!=null)
		{
			sum = trav.getData()+trav1.getData()+carry;
			if(sum>10)
			{
				sum=sum%10;
				carry=(1);
			}
			else
				carry=(0);
			trav2.setData(sum);
			trav2.setNext(new LLNode());

			
			trav=trav.next;
			trav1=trav1.next;
			trav2=trav2.next;
		}
		if(trav!=null)
		{
			trav2.setData(trav.data+carry);
			carry=0;
			trav2.next=null;
			trav2= trav2.next;
			trav= trav.next;
		}
		while(trav1!=null)
		{
			trav2.setData(trav1.data+carry);
			carry=0;
			trav2.next=null;
			trav2= trav2.next;
			trav1= trav1.next;
		}
		return res;
	}
}
