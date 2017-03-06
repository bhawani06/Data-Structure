package dataStruct;

public class DLLNode {

	public int data;
	public DLLNode Prev;
	public DLLNode Next;
	public DLLNode(int val)
	{
		data=val;
		Prev=Next=null;
	}
}
