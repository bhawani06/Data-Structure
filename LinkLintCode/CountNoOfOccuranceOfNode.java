package linkList;


public class CountNoOfOccuranceOfNode {

	public static void main(String[] args) {
		LLNode head=new LLNode();
		head.setData(2);
		LinkListImplementation LL =new LinkListImplementation(head);
		head=LL.insertAtBegining(head,21);
		//	LL.insertAtBegining(0);
			LL.insertAtEnd(head,2);
			LL.insertAtEnd(head,5);
			//LL.insertAtEnd(head,7);
			//LL.insertAtEnd(head,8);
			LL.insertAtpos(head,3, 3);
			LL.insertAtpos(head,21, 3);
			int c = count(head,21);
			System.out.println("\n 21 occurs "+c);
			
	}
/* Counts the no. of occurence of a node

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
