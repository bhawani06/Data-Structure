package dataStruct;

public class Node{
	private int Data;
	private Node Left;
	private Node Right;
	public Node sibling;
	Node(int val)
	{
		Data=val;
		Left=Right=null;
	}
	public int getData()
	{
		return Data;
	}
	public void setData(int val)
	{
		Data=val;
	}
	public Node getLeft()
	{
		return Left;
	}
	public Node getRight()
	{
		return Right;
	}
	public void setLeft(Node newNode)
	{
		Left=newNode;
	}public void setRight(Node newNode)
	{
		Right=newNode;
	}
	public boolean hasLeft()
	{
		if(Left!=null)
			return true;
		return false;
		
	}
	public boolean hasRight()
	{
		if(Right!=null)
			return true;
		return false;
		
	}
}