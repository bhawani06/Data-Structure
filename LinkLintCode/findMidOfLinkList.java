package linkList;

public class findMidOfLinkList {
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
			LLNode mid = FindMidOfLinklist(head);
			System.out.println(mid.getData());
			
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

}
