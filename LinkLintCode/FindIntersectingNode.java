package linkList;

import java.util.HashMap;

public class FindIntersectingNode {
	public static void main(String[] args) 
	{
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
			
			/**
			 * Creating List 2
			 */
			LLNode head1=new LLNode();
			head1.setData(2);
			LinkListImplementation LL1 =new LinkListImplementation(head1);
			head1=LL1.insertAtBegining(head1,1);
			//	LL.insertAtBegining(0);
				LL1.insertAtpos(head1,2, 3);
				LL1.insertAtpos(head1,1, 3);
				LL.insertAtEnd(head1,3);
				System.out.println();
				
				findIntersectingNode(head,head1);

	}
	
	



public static void findIntersectingNode(LLNode head, LLNode head1) {
		// TODO Auto-generated method stub
		/**
		 * Create an intersection
		 */
	
		head1.next.next.next.next =head.next.next;
		
		
		
		int n=0,m=0,d;
		LLNode t1=head1,t=head;
		while(t!=null)
		{
			t=t.next;
			++n;
		}
		while(t1!=null)
		{
			t1=t1.next;
			++m;
		}
		d=(n>m)? n-m:m-n;
		LLNode fast = null,slow = null;
		if(n>m)
		{
			 fast = head;
			while(d>0)
			{
				--d;
				fast=fast.next;
			}
			slow=head1;
		}
		if(m>n)
		{
			 fast = head1;
			while(d>0)
			{
				--d;
				fast=fast.next;
			}
			slow=head;
		}
		while(slow!=null && fast!=null)
		{
			if(slow==fast)
			{
				System.out.println("MEETING at: "+slow.data);
				break;
			}
			slow=slow.next;
			fast=fast.next;
		}
		
	}



}

