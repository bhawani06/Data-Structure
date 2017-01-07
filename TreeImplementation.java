package dataStruct;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Node{
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

class Tree
{
	Node Root;
	public void preOrderTraversal(Node root)
	{
		if(root!=null)
		{
			System.out.print(root.getData());
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}
	public void preOrderTraversalNonRecurrsive(Node root) {
		if(root == null)
		{
			return;
		}
		/*
		else
		{
			Stack<Node> s = new Stack<Node>();
			s.push(root);
			while(!s.isEmpty())
			{
				Node temp = s.pop();
				System.out.print(temp.getData());
				if(temp.hasRight())
				{
					s.push(temp.getRight());
				}
				if(temp.hasLeft())
				{
					s.push(temp.getLeft());
				}
			}
			
		}*/

		Stack<Node> s = new Stack<Node>();
		while(true)
		{
			while(root!=null)
			{
				System.out.print(root.getData());
				s.push(root);
				root=root.getLeft();
			}
			if(s.isEmpty())
				break;
			root=s.pop().getRight();
		}
		
	}
	public void inOrderTraversalNonRecurrsive(Node root) {
		if(root == null)
		{
			return;
		}
		Stack<Node> s = new Stack<Node>();
		while(true)
		{
			while(root!=null)
			{
				s.push(root);
				root=root.getLeft();
			}
			if(s.isEmpty())
				break;

			root=s.pop();
			System.out.print(root.getData());
			root = root.getRight();
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
	public void postOrderTraversal(Node root)
	{
		if(root!=null)
		{
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.print(root.getData());
		}
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
	
	public void levelOrderInsert(Node newNode)
	{
		if(Root==null)
		{	Root = newNode;
			return;
		}
		else
		{
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(Root);
			while(!queue.isEmpty())
			{
				Node temp = queue.remove();
				if(temp.hasLeft())
					queue.add(temp.getLeft());
				else
				{	temp.setLeft(newNode);//()=newNode;
					return;
				}
				if(temp.hasRight())
					queue.add(temp.getRight());
				else
				{	temp.setRight(newNode);//()=newNode;
					return;
				}
			}
		
		}
	}
	public int findMax(Node root) {
		// TODO Auto-generated method stub
		int max=Integer.MIN_VALUE,rm,lm;
		if(root==null)
			return max;
		else
		{
			rm=findMax(root.getRight());
			lm=findMax(root.getLeft());
			if(lm>rm)
				max=lm;
			else
				max=rm;
			if(root.getData()>max)
				max=root.getData();
			return max;
		}
	}
	public boolean search(Node root, int data) {
		if(root==null)
			return false;
		else
		{
			if(root.getData()==data)
				return true;
			else
			{
				return search(root.getRight(), data) || search(root.getLeft(), data);
			}
		}
	}
	public Node searchNode(Node root, int data) {
		if(root==null)
			return null;
		else
		{
			if(root.getData()==data)
				return root;
			else
			{
				Node n1= searchNode(root.getRight(), data);
				if(n1==null)	
					n1= searchNode(root.getLeft(), data);

				return n1;
			}
		}
	}
	public boolean searchNonRecurssive(Node root, int data)
	{
	
		if(Root==null)
			return false;
		else
		{
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(Root);
			while(!queue.isEmpty())
			{
				Node temp = queue.remove();
				if(temp.getData()==data)
					return true;
				if(temp.hasLeft())
					queue.add(temp.getLeft());
				
				if(temp.hasRight())
					queue.add(temp.getRight());
				
			}
		}
		return false;
	}
	public int sizeOfTree(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		else
		{
			return sizeOfTree(root.getLeft())+sizeOfTree(root.getRight())+1;
		}
	}
	public int sizeOfTreenonRecurssive(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		else
		{
			int size=0;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(Root);
			while(!queue.isEmpty())
			{
				Node temp = queue.remove();
				++size;
				if(temp.hasLeft())
					queue.add(temp.getLeft());
				
				if(temp.hasRight())
					queue.add(temp.getRight());
				
			}
		return size;
		}
	}
	public void delete(Node root) {
		// TODO Auto-generated method stub
		if(root!=null)
		{
			delete(root.getLeft());
			delete(root.getRight());
			root=null;
		}
	}
	public void LevelOrderReverse(Node n1) {
		if(Root==null)
			return;
		else
		{
			Queue<Node> queue = new LinkedList<Node>();
			Stack<Node> s = new Stack<Node>();
			queue.add(Root);
			while(!queue.isEmpty())
			{
				Node temp = queue.remove();
				s.push(temp);
				//System.out.print(temp.getData());
				if(temp.hasLeft())
					queue.add(temp.getLeft());
				
				if(temp.hasRight())
					queue.add(temp.getRight());
				
			}
			while(!s.isEmpty())
			{
				System.out.print(s.pop().getData());
			}
		}
	}
	public int findHeight(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		int lt = findHeight(root.getLeft());
		int rt= findHeight(root.getRight());
		if(rt>lt)
			return rt+1;
		else
			return lt+1;
		
		
	}
	public int findHeightNonRecurssive(Node root) {
		if(root==null)
			return 0;
		else
		{
			int ht=0;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(Root);
			queue.add(null);
			while(!queue.isEmpty())
			{
				Node temp = queue.remove();
				
				if(temp==null && queue.isEmpty()==false)
				{
					queue.add(null);
					++ht;
				}
				
				if(temp.hasLeft())
					queue.add(temp.getLeft());
				
				if(temp.hasRight())
					queue.add(temp.getRight());
				
			}
		return ht;
		}
	}
	public int findNumOfLeaf(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		if(root.getLeft()==null && root.getRight()==null)
		return 1;
		else
			return findNumOfLeaf(root.getLeft()) + findNumOfLeaf(root.getRight());
	}
	
	public int findNumOfFullNode(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		if(root.getLeft()!=null && root.getRight()!=null)
		{
			System.out.println(root.getData());
			return 1+findNumOfFullNode(root.getLeft())+findNumOfFullNode(root.getRight());
		}
		else
			return findNumOfFullNode(root.getRight())+ findNumOfFullNode(root.getLeft());
		
		
	}
	public int findNumOfhalfNode(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		if(root.getLeft()==null && root.getRight()!=null)
			return 1+findNumOfhalfNode(root.getRight());
		if(root.getLeft()!=null && root.getRight()==null)
			return 1+findNumOfhalfNode(root.getLeft());

		if(root.getLeft()!=null && root.getRight()!=null)
			return findNumOfhalfNode(root.getRight())+findNumOfhalfNode(root.getLeft());
			
		return 0;
	}
	public boolean structurallyIdentical(Node root1, Node root2) {
		if(root1==null && root2==null )
		{
			return true;
		}

		if(root1==null || root2==null )
			return false;
		
		return (structurallyIdentical(root1.getLeft(),root2.getLeft())&&structurallyIdentical(root1.getRight(),root2.getRight())&&root1.getData()==root2.getData());
			
	}
	public int diameterOfTree(Node root) {
		if(root==null)
			return 0;
		else
		{
			int l_ht = findHeight(root.getLeft());
			int r_ht = findHeight(root.getRight());
			return Integer.max(Integer.max(diameterOfTree(root.getLeft()), diameterOfTree(root.getRight())),l_ht+r_ht+1);
		}
		
	}
	public int widthOfTree(Node root) {
		if(root==null)
			return 0;
		else
		{
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(null);
			int maxSum=0,maxlevel=0,currSum=0,currlevel=0;
			while(!queue.isEmpty())
			{
				Node temp = queue.remove();
				
				if(temp==null)
				{
					if(!queue.isEmpty())
					{
						queue.add(null);
						currSum=0;
						++currlevel;
					}
				}
				else
				{
					currSum+=temp.getData();
					if(currSum>maxSum)
					{	maxSum=currSum;
						maxlevel=currlevel;
					}
					
					if(temp.hasLeft())
						queue.add(temp.getLeft());
					
					if(temp.hasRight())
						queue.add(temp.getRight());
				}
				
			}
			return maxSum;
		}
	}
	public void printRoot2Leaf(Node root, int[] path, int pathlen) {
		if(root==null)
			return;

		path[pathlen]=root.getData();
		++pathlen;
		if(root.getLeft()==null && root.getRight()==null)
		{
			printPath(path,pathlen);
		}
		printRoot2Leaf(root.getLeft(),path,pathlen);	
		printRoot2Leaf(root.getRight(),path,pathlen);	
			
	}

	private void printPath(int[] path, int pathlen) {
		System.out.println();
		for(int i = 0; i<pathlen;++i)
		{
			System.out.print(path[i]+",");
			
		}
			
	}
	
	public boolean haspathSum(Node root,int sum) {

		if(root==null)
			return false;
		if(root.getData()==sum)
			return true;
		return haspathSum(root.getLeft(),sum-root.getData()) || haspathSum(root.getRight(),sum-root.getData());
	}
	public int addBT(Node root) {
		if(root==null)
			return 0;
		return root.getData()+addBT(root.getLeft())+addBT(root.getRight());
	}
	public int addBTnonRecurssive(Node root) 
	{
		if(Root==null)
			return 0;
		else
		{
			int sum=0;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(Root);
			while(!queue.isEmpty())
			{
				Node temp = queue.remove();
				sum+=temp.getData();
				if(temp.hasLeft())
					queue.add(temp.getLeft());
				
				if(temp.hasRight())
					queue.add(temp.getRight());
				
			}
		
		return sum; 
		}
		
	}
	public void mirrorofBT(Node root) {
		if(root==null)
			return;
		mirrorofBT(root.getLeft());
		mirrorofBT(root.getRight());
		Node temp;
		temp=root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
			
	}
	public boolean areMirors(Node root1, Node root2) {

		if(root1==null && root2==null)
			return true;
		return (areMirors(root1.getLeft(),root2.getRight())&& areMirors(root1.getRight(),root2.getLeft()) && (root1.getData()==root2.getData()));
	}
	public void buildBT(int[] preorder, int[] inorder, int i, int j, int k, int l) {
		
	}
	int[] path=new int[100];
	int pathlen=0;
	public boolean getLCA(Node root, int val) {

		if(root == null)
			return false;
		
		if(root.getData() == val)
		{
			return true;
		}
		if(printAllAncestors(root.getLeft(),val)|| printAllAncestors(root.getRight(),val) )
		{
			path[pathlen]=root.getData();
			++pathlen;
			return true;
		}
		return false;
	}
	public boolean printAllAncestors(Node root, int val) {

		if(root == null)
			return false;
		
		if(root.getData() == val)
		{
			return true;
		}
		if(printAllAncestors(root.getLeft(),val)|| printAllAncestors(root.getRight(),val) )
		{
			System.out.print(root.getData());
			path[pathlen]=root.getData();
			++pathlen;
			return true;
		}
		return false;
	}

	/**
	 * idea is to get the path from root for both the nodes & printh the path from the
	 * first mismatch. 
	 */
	public void LCA(Node root,int val1, int val2) {

		getLCA(root, val1);
		int[] p1=path;
		int p1_len=pathlen;
		path = new int[100];
		pathlen=0;
		getLCA(root, val2);
		int[] p2=path;
		int p2_len=pathlen,i,j;
		for(i=p1_len,j=p2_len;i>0;--i,--j )
		{
			if(j==0)
				break;
			if(p1[i]!=p2[j])
				break;
		}
		System.out.println(p1[i]);
		
		
	}
	public void zigzagLevelOrder(Node root) {
	if(Root==null)
		return;
	else
	{
		boolean l2r=true;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty())
		{
			Node temp = queue.remove();
			if(temp!=null)
			{
				System.out.print(temp.getData());
				if(!l2r)
				{
					if(temp.hasLeft())
						queue.add(temp.getLeft());
					
					if(temp.hasRight())
						queue.add(temp.getRight());
				}
				else
				{
					if(temp.hasRight())
						queue.add(temp.getRight());
					if(temp.hasLeft())
						queue.add(temp.getLeft());
					
				}
			}
			else
			{
				if(!queue.isEmpty())
				{
					queue.add(null);
					l2r=!l2r;
				}
			}
			
			
		}
	}
		
		
	}
	public void verticalSum(Node root, int key,	HashMap<Integer, Integer>hm) {
		if(root==null)
			return;
		verticalSum(root.getLeft(),key-1,hm);
		verticalSum(root.getRight(),key+1,hm);
		if(!hm.containsKey(key))
		{
			hm.put(key, root.getData());
		}
		else
		{
			hm.put(key, hm.get(key)+root.getData()); 
		}
			
	}
	public void siblingTree(Node root) {
		
		if(root ==null)
			return;
		if(root.hasLeft())
			root.getLeft().sibling=root.getRight();
		if(root.hasRight())
			if(root.sibling!=null)
				root.getRight().sibling=root.sibling.getLeft();
			else
				root.getRight().sibling=null;

		siblingTree(root.getLeft());
		siblingTree(root.getRight());
			
		
	}
	public void siblingTreeNonRecurssive(Node root) {
		
		if(root==null)
			return;
		else
		{
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(null);
			while(!queue.isEmpty())
			{
				Node temp = queue.remove();
				if(temp != null)
				{
					temp.sibling=queue.peek();
					if(temp.hasLeft())
						queue.add(temp.getLeft());
					
					if(temp.hasRight())
						queue.add(temp.getRight());
				}
				else
				{
					if(!queue.isEmpty())
						queue.add(null);
				}
				
				
			}
		}
	}
	public void printKdistance(Node root,int k) {
		if(root == null)
			return;
		printKdistance(root.getLeft(), k-1);
		printKdistance(root.getRight(), k-1);
		if(k==0)
			System.out.println(root.getData());
		
	}
	public void isSubTree(Node root1, Node root2) {
		Node search = searchNode(root1, root2.getData());
		if(search!=null)
		{
			if(structurallyIdentical(root2, search))
				System.out.println("true");
			else
				System.out.println("false");
		}

	}
	/**
	 * 
	 Given a binary tree and a integer value K, the task is to
	  find all nodes in given binary tree having K leaves in 
	  subtree rooted with them.
	 */
	public int K_Leaves(Node root,int k) {
		if(root==null)
			return 0;
		
		if(root.getLeft()==null && root.getRight()==null)
			return 1;
		int leaves =(K_Leaves(root.getLeft(),k) + K_Leaves(root.getRight(),k));
		if(k==leaves)
		{
			System.out.println(root.getData());
		}
		return leaves;
		
		
		
		
	}
	/**
	 *Given a binary tree with a value associated with each node, we need
	 *to choose a subset of these nodes such that sum of chosen nodes is
	 *maximum under a constraint that no two chosen node in subset should
	 *be directly connected that is, if we have taken a node in our sum then
	 *we can’t take its any children in consideration and vice
	 */
	public void getMaxSum(Node n1) {
		
		
	}
	
}
public class TreeImplementation {

	public static void main(String[] args) {
		
		Tree t = new Tree();
		Node n1=new Node(1),n2 = new Node(2),n3 = new Node(3),n4 = new Node(4),n5 = new Node(5),n6 = new Node(6);
		Node n7=new Node(7),n8 = new Node(8),n9 = new Node(9),n10=new Node(10);
		t.levelOrderInsert(n1);
		t.levelOrderInsert(n2);
		t.levelOrderInsert(n3);
		t.levelOrderInsert(n4);
		t.levelOrderInsert(n5);
		n4.setLeft(n10);
	//	n4.setRight(new Node(11));
		n5.setLeft(n6);
		n5.setRight(n9);
		n6.setLeft(n7);
		n6.setRight(n8);
		
		Tree t1 = new Tree();
		Node nq1=new Node(1),nq2 = new Node(2),nq3 = new Node(3),nq4 = new Node(4),nq5 = new Node(5),nq6 = new Node(6);
		Node nq7=new Node(7),nq8 = new Node(8),nq9 = new Node(9),nq10=new Node(10);
		t1.levelOrderInsert(nq1);
		t1.levelOrderInsert(nq2);
		t1.levelOrderInsert(nq3);
		t1.levelOrderInsert(nq4);
		t1.levelOrderInsert(nq5);
		nq4.setLeft(nq10);
		//nq4.setRight(new Node(11));
		nq5.setLeft(nq6);
		nq5.setRight(nq9);
		nq6.setLeft(nq7);
		
		nq6.setRight(nq8);
/*
		System.out.println(t.diameterOfTree(n1));
		System.out.println(t.widthOfTree(n1));
		int[] path=new int[256];
		t.printRoot2Leaf(n1,path,0);
		System.out.println(t.haspathSum(n1,14));
		System.out.println(t.addBT(n1));
		System.out.println(t.addBTnonRecurssive(n1));

		t.mirrorofBT(n1);
		t.levelOrderTraversal();
		System.out.println();
		t1.mirrorofBT(nq1);
		t1.levelOrderTraversal();
		System.out.println();
		t.levelOrderTraversal();
		System.out.println((t.areMirors(n1,nq1)));
		*/
		
		/**
		 * saved to do later 
		 

		Tree t2 = new Tree();
		int[] inorder = {4,2,5,1,3},preorder={1,2,4,5,3};
		//t2.buildBT(preorder,inorder,0,5,0,5);  
		 * 
		 */
	/*	t.printAllAncestors(n1,7);
		System.out.println();
		t.LCA(n1,4,6);
		t.zigzagLevelOrder(n1);
		
		HashMap<Integer, Integer>hm = new HashMap<Integer,Integer>();
		t.verticalSum(n1,0,hm);
		Iterator it = hm.entrySet().iterator();
	   for(int k:hm.keySet())
	   {
		   System.out.println(k+"--->"+hm.get(k));
	   }
	   
		t.siblingTree(n1);
		t.levelOrderTraversal();
		
		t.siblingTreeNonRecurssive(n1);
		t.levelOrderTraversal();
		*/
	//	t.printKdistance(n1,3);

		//t.isSubTree(n1,nq1);
	//	t.K_Leaves(n1,2);
	//	t.getMaxSum(n1);
	}
	
	
}
