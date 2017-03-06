package dataStruct;

import java.util.LinkedList;
import java.util.Queue;

class BST
{
	Node Root;
	public Node insert(Node root, int val)
	{
		if(root==null)
		{
			root=new Node(val);
			root.setLeft(null);
			root.setRight(null);
		}
		if(root.getData()<val)
			return insert(root.getRight(), val);
		return insert(root.getLeft(), val);
	}
	public void levelOrderTraversal()
	{
		if(Root==null)
			return;
		else
		{
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(Root);
			while(!queue.isEmpty())
			{
				Node temp = queue.remove();
				System.out.print(temp.getData());
				if(temp.sibling!=null)
					System.out.println(temp.getData()+"-"+temp.sibling.getData());
				if(temp.hasLeft())
					queue.add(temp.getLeft());
				
				if(temp.hasRight())
					queue.add(temp.getRight());
				
			}
		}
	}
	public void inOrderTraversal(Node root)
	{
		if(root!=null)
		{
			inOrderTraversal(root.getLeft());
			System.out.print(root.getData());
			inOrderTraversal(root.getRight());
		}
	}
	public void insert(Node newNode)
	{
		if(Root==null)
		{
			Root=newNode;	
		}
		else
		{
			insert(Root,newNode);
		}
	}
	private Node insert(Node temp, Node newNode) 
	{
		if(temp==null)
		{
			temp=newNode;
			return temp;
		}
		if(newNode.getData()<temp.getData())
			temp.setLeft(insert(temp.getLeft(), newNode));
		if(newNode.getData()>temp.getData())
			temp.setRight(insert(temp.getRight(), newNode));
		return temp;
		
	}
	public boolean find(Node n) {
		
		if(Root==null)
			return false;
		return find(Root,n);
	}
	private boolean find(Node root, Node n) {
		
		if(root==null)
			return false;

		if(n.getData()==root.getData())
			return true;
		
		if(n.getData()<root.getData())
			return find(root.getLeft(),n);
		if(n.getData()>root.getData())
			return find(root.getRight(),n);
		return false;
	}
	public Node findMax() {
		
		if(Root==null)
			return null;
		else
			return findMax(Root);
	}
	private Node findMax(Node root) {
		if(root==null)
			return null;
		if(root.getRight()!=null)
			return findMax(root.getRight());
		return root;
	}
public Node findMin() {
		
		if(Root==null)
			return null;
		else
			return findMin(Root);
	}
	private Node findMin(Node root) {
		if(root==null)
			return null;
		if(root.getLeft()!=null)
			return findMin(root.getLeft());
		return root;
	}
	public Node delete(Node n) {
		
		if(Root==null)
			return null;
		return delete(Root,n);
		
	}
	private Node delete(Node root, Node n) {
		
		if(root==null)
			return null;
		if(n.getData()<root.getData())
			root.setLeft(delete(root.getLeft(), n));
		else if(n.getData()>root.getData())
			root.setRight(delete(root.getRight(), n)); //its ELSE if!! 

		else if(n.getData()==root.getData())
		{
			if(n.getLeft()==null && n.getRight()==null)
				return null;

			else if(n.getLeft()!=null && n.getRight()!=null)   //its ELSE if!! 
			{
				Node min=findMin(n.getRight());
				n.setData(min.getData());
				n.setRight(delete(n.getRight(),min));
				
			}

			else if(n.getLeft()!=null || n.getRight()!=null)//its ELSE if!! 
			{
				if(n.getLeft()!=null)
					return n.getLeft();
				if(n.getRight()!=null)
					return n.getRight();
			}
		}
		return root;   //Mistake: dont return null chumma!
	}
	public Node lca(Node n1, Node n2) {
		if(Root==null)
			return null;
		else
			return lca(Root,n1,n2);
		
	}
	private Node lca(Node root, Node n1, Node n2) {
		
		if(root==null)
			return null;
		if(n1.getData()<=root.getData() && n2.getData()>=root.getData())
			return root;
		else if(n1.getData()<root.getData() && n2.getData()<root.getData())
			return lca(root.getLeft(),n1,n2);
		else if(n1.getData()>root.getData() && n2.getData()>root.getData())
			return lca(root.getRight(),n1,n2);
			
		return null;
	}
	public boolean isBst() {
		
		if(Root==null)
			return true;
		return isBst(Root);
	}
	private boolean isBst(Node root) {
		
		if(root==null)
			return true;
		Node max = findMax(root.getLeft());
		if(max!=null && max.getData()>root.getData())
		{
			return false;
		}

		Node min = findMin(root.getRight());
		if(min!=null && min.getData()<root.getData())
		{
			return false;
		}
		if(! (isBst(root.getLeft()) && isBst(root.getRight())) )
		{
			return false;
		}
		return true;
	}
	public Node bst2dll() {
		
		if(Root==null)
			return null;
		return bst2dll(Root);
	}
	private Node bst2dll(Node root) {
		
		if(root==null)
			return null;
		if(root.getLeft()!=null)
		{

			Node ltail=bst2dll(root.getLeft());
			 for (; ltail.getRight() != null; ltail = ltail.getRight()); //**main**
			  
			root.setLeft(ltail);
			if(ltail!=null)
			{
				ltail.setRight(root);	
			}
		}
		if(root.getRight()!=null)
		{
			Node rtail=bst2dll(root.getRight());
			 for (; rtail.getLeft() != null; rtail = rtail.getLeft());
			
			root.setRight(rtail);
			if(rtail!=null)
			{
				rtail.setLeft(root);	
			}
		}
		
		return root;
	}
	public void traverseDLL(Node head) {
		
		Node temp =head;
		while(temp!=null)
		{
			System.out.println(temp.getData());
			temp=temp.getRight();
		}
	}
	public boolean isBst(int min, int max) {
		
		if(Root==null)
			return true;
		else
			return isBst(Root,min, max);
	}
	private boolean isBst(Node root, int min, int max) {
		
		if(root==null)
			return true;
		if(root.getData()<min || root.getData() >max)
			return false;
		return isBst(root.getLeft(),min, root.getData()) && isBst(root.getRight(), root.getData(), max);
	}

	int[] inorder = new int[15];
	int size=0;
	public boolean isBstInorder() {
		if(Root==null)
			return true;
		 isBstInorder(Root);
		 for(int i =0;i<inorder.length-2;++i)
		 {
			 System.out.print(inorder[i]+",");
			 if(inorder[i]>inorder[i+1])
				 return false;
		 }
		 return true;
	}
	private void isBstInorder(Node root) {
		if(root==null)
			return;
		
		isBstInorder(root.getLeft());
		inorder[size]=root.getData();
		++size;
		isBstInorder(root.getRight());
	}
	public void SortListtoDLL(DLLNode head, int start, int end) {
		
	}
	public void KthSmallest(int k) {
		if(Root ==null)
			return;
		KthSmallest(Root,k);
		
	}
	 int count=0;
	private void KthSmallest(Node root, int k) {
		
		if(root ==null)
			return;
		KthSmallest(root.getLeft(),k);
		++count;
		if(count==k)
		{
			System.out.println(root.getData());
			return;
		}

		KthSmallest(root.getRight(),k);
	}
	public void KthSmallestNonRecursive(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
public class BST_Implementation {
	
	public static void main(String[] args) {
		BST bst = new BST();
		Node n1=new Node(1),n2 = new Node(2),n3 = new Node(3),n4 = new Node(4),n5 = new Node(5),n6 = new Node(6);
		Node n7=new Node(7),n8 = new Node(8),n9 = new Node(9),n10=new Node(10);
		int x;
		bst.insert(n3);		bst.insert(n2);
		bst.insert(n6);		bst.insert(n5);
		bst.insert(n10);	bst.insert(n7);
		bst.insert(n4);		bst.insert(n1);
		bst.insert(n8);		bst.insert(n9);
	//	bst.inOrderTraversal(n3);
	//	bst.levelOrderTraversal();
	//	System.out.println(bst.find(new Node(11)));
/*		if(bst.findMax()!=null)
			System.out.println(bst.findMax().getData());
		if(bst.findMin()!=null)
			System.out.println(bst.findMin().getData());
			*/

	/*	bst.delete(n6);
		bst.inOrderTraversal(n3);
		*/
		
		//System.out.println(bst.lca(n1,n3).getData());

	//	n5.setRight(new Node(10));
	//	System.out.println(bst.isBst(Integer.MIN_VALUE,Integer.MAX_VALUE));
	//	System.out.println(bst.isBstInorder());
		
		
		
		
		/*bst.bst2dll();
		bst.traverseDLL(bst.findMin());*/
	/**	
	 *  TO DO
	 	DLLNode head = new DLLNode(0);
		DLLNode d1=new DLLNode(1);
		DLLNode d2=new DLLNode(2);
		DLLNode d3=new DLLNode(3);
		DLLNode d4=new DLLNode(4);
		DLLNode d5=new DLLNode(5);
		head.Next=d1; d1.Prev=head;
		d1.Next=d2; d2.Prev=d1;
		d2.Next=d3; d3.Prev=d2;
		d3.Next=d4; d4.Prev=d3;
		d4.Next=d5; d5.Prev=d4;
		bst.SortListtoDLL(head,0,6); **/

		bst.KthSmallest(3);
		bst.KthSmallestNonRecursive(3);
		
	}

}
