package dataStruct;
class bNode{
	int Data;
	bNode Left;
	bNode Right;

	bNode(int val)
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
	public bNode getLeft()
	{
		return Left;
	}
	public bNode getRight()
	{
		return Right;
	}
	public void setLeft(bNode newNode)
	{
		Left=newNode;
	}public void setRight(bNode newNode)
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

class BST
{
	bNode root;
	public bNode insert(bNode root, int val)
	{
		if(root==null)
		{
			root=new bNode(val);
			root.setLeft(null);
			root.setRight(null);
		}
		if(root.getData()<val)
			return insert(root.getRight(), val);
		return insert(root.getLeft(), val);
	}
}
public class BST_Implementation {

}
