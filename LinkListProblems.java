package dataStruct;

import java.util.HashMap;

public class LinkListProblems {
	public static void main(String[] args) 
	{
		LLNode head=new LLNode();
		head.setData(2);
		LinkListImplementation LL =new LinkListImplementation(head);
		head=LL.insertAtBegining(head,1);
		//	LL.insertAtBegining(0);
			LL.insertAtEnd(head,5);
			LL.insertAtEnd(head,6);
			LL.insertAtEnd(head,7);
			LL.insertAtEnd(head,8);
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
				LL.insertAtEnd(head1,1);
				System.out.println();
			//	LL.printLinkList(head1);
		/*	LLNode mid =FindMidOfLinklist(head);
			System.out.println("\n mid element:"+mid.getData());
			LLNode Nth= printNthFromLast(head,4);
			if(Nth!=null)
				System.out.println(" Nth from last "+Nth.getData());	
			System.out.println(count(head,3));
			loopDetection(head);

			head=reverseLinklist(head);
			System.out.println();			
			findIntersectingNode(head, head1);
			
			head=	reverseInPairs(head);
			LL.printLinkList(head);
			Boolean result= CheckIfPalindrome(head1);
			System.out.println(result);

			LL.printLinkList(head);System.out.println();
			head=removeDuplicatedInSorted(head);
			LL.printLinkList(head);
			LL.printLinkList(head1);System.out.println();	
			head=removeDuplicatedInUnsorted(head1);
			LL.printLinkList(head1);
			
			printInReverse(head);
			josephusCircle(head,1); 
			head = rotateKStart(head,3);	
			LL.printLinkList(head);
			*/
				LL.printLinkList(head1);
			LLNode res = AddTwoNumbers(head,head1);
		
	}
	/* 385+321 = 706
	 * input is 2 "reversed digit" nos
	 * 1-2-3 + 
	 * 5-8-3 =
	 * 6-0-7
	 */
	public static LLNode AddTwoNumbers(LLNode head,LLNode head1) {
		// TODO Auto-generated method stub
		return null;
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
				System.out.println(rotPrev.data);
			}
			++i;
			trav=trav.next;
		}

		rotPrev.next=null;
		trav.next=head;
		head= rotStart;
		return head;
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


public static void printInReverse(LLNode head) {
		// TODO Auto-generated method stub
		if(head==null)
		{
			return;
		}
		printInReverse(head.next);
		System.out.print(head.data);
	}


public static LLNode removeDuplicatedInUnsorted(LLNode head) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hm = new HashMap<>();
		if(head==null)
			return null;
		LLNode temp = new LLNode();
		temp.next= head;
		while(temp.next!=null)
		{
			if(hm.containsKey(temp.next.getData()))
			{
					temp.next=temp.next.next;
			}
			else
			{
				hm.put(temp.next.getData(), 1);
				temp=temp.next;
			}
		}
		
		return head;
	}


public static LLNode removeDuplicatedInSorted(LLNode head) {
		// TODO Auto-generated method stub
		
		LLNode temp=head;
		if(head==null)
			return null;
		while(temp.next!=null &&temp!=null)
		{
			if(temp.data!=temp.next.data)
				temp=temp.next;
			else
				temp.next=temp.next.next;
		}
		return head;
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


public static LLNode reverseInPairs(LLNode head) {
		// TODO Auto-generated method stub
		if(head==null)
			return null;
		LLNode c = new LLNode()	,f,s,d = new LLNode();
		d.next=head;
		c=d;
		while(c.next!=null && c.next.next!=null)
		{
			f=c.next;
			s=c.next.next;
			c.next=s;
			f.next=s.next;
			s.next=f;
			c=c.next.next;
		}
		return d.next;
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


public static void loopDetection(LLNode head) {
	/*
	 * setting a loop
	 */
	LLNode temp=head;
	while(temp.getData()!=6)
	{
		temp=temp.next;  
	}
	temp.next=head.next.next;  //1-2-3-4-5-6-3
	
	
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

	
/* Counts the no. of occurences of a node

(search_for) in a linked list (head)*/
	static int count(LLNode head,int search_for)
    {
        LLNode current = head;
        int count = 0;
        while (current != null)
        {
            if (current.getData() == search_for)
                count++;
            current = current.next;
        }
        return count;
    }
}

