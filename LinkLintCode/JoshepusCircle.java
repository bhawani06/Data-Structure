package linkList;

public class JoshepusCircle {

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
			 josephusCircle(head,7);
			
	}
	
	public static void josephusCircle(LLNode head,int m) {
		// TODO Auto-generated method stub
	if(head==null)
		return;
	int n =1,i;
	LLNode temp=head;
	while(temp.next!=null)
	{
		temp=temp.next;
	}
	temp.next=head;
	temp=head.next;
	while(temp!=head)
	{
		temp=temp.next;
		++n;
	}
	//System.out.println(n);
	i=1;
	temp=head;
	while(n>0)
	{
		if(i==m-1)
		{
			temp.next=temp.next.next;
			--n;
			i=1;
		}
		else
		{
			++i;
		}
		temp=temp.next;
	}
	System.out.println("left guy"+temp.data);
	}


}
