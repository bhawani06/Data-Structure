package linkList;

public class CheckIfPalindrome {
	public static void main(String[] args) {
		LLNode head=new LLNode();
		head.setData(2);
		LinkListImplementation LL =new LinkListImplementation(head);
		head=LL.insertAtBegining(head,1);
		//	LL.insertAtBegining(0);
			LL.insertAtEnd(head,2);
			LL.insertAtEnd(head,1);
			//LL.insertAtEnd(head,7);
			//LL.insertAtEnd(head,8);
			LL.insertAtpos(head,3, 3);
			LL.insertAtpos(head,3, 3);
			LL.printLinkList(head);
			Boolean res = CheckIfPalindrome(head);
			System.out.println("\n"+res);
			
	}

public static Boolean CheckIfPalindrome(LLNode head) 
{
		// TODO Auto-generated method stub
	if(head==null)
		return false;
	LLNode mid = FindMidOfLinklist(head);
	LLNode head1=mid.next;
	mid.next=null;
	head1=reverseLinklist(head1);
	LLNode temp= head, temp1=head1;
	while(temp!=null && temp1!=null)
	{
		if(temp.data != temp1.data)
		{
			return false;
		}
		temp=temp.next;
		temp1=temp1.next;
	}
	return true;
}
public static LLNode FindMidOfLinklist(LLNode head) {
	// TODO Auto-generated method stub
	if(head==null)
	{
		return null;
	}
	LLNode fast=head,slow=head;
	int i=1;
	while(fast.next!=null)
	{
		fast=fast.next;
		if(i%2==0)
		{
			slow=slow.next;
		}
		++i;
	}
	return slow;
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
