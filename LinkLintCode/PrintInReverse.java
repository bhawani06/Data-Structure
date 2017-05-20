package linkList;

public class PrintInReverse {

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
			printInReverse(head);
			
	}
	
	public static void printInReverse(LLNode head) {
		// TODO Auto-generated method stub
		if(head==null)
		{
			return;
		}
		printInReverse(head.next);
		System.out.print(head.data+",");
	}


}
