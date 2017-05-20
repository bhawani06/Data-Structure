package linkList;

public class LoopDetection {

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
			LL.insertAtpos(head,4, 3);
			/*
			 * setting a loop
			 */
			LLNode temp=head;
			while(temp.getData()!=4)
			{
				temp=temp.next;  
			}
			temp.next=head.next.next;  //1-2-3-4-5-6-3
			
			loopDetection(head);
			
	}
public static void loopDetection(LLNode head) {

	
	
	LLNode fast=head,slow=head;
	int flag=0;
	while(fast!=null && fast.next!=null)
	{
		fast=fast.next.next;
		slow=slow.next;
		
		if(fast==slow)
		{
			flag=1;
			break;
		}
	}
	if(flag==0)
		System.out.println("No loop");
	else
	{
		System.out.println("Loop "+slow.getData());
		findStartOfLoop(head,fast);
	}
	
	}

public static void findStartOfLoop(LLNode head, LLNode temp)
{
	while(head!=temp)
	{
		head=head.next;
		temp=temp.next;
	}
	System.out.println("Loop starts at: "+head.getData());
	
}
}
