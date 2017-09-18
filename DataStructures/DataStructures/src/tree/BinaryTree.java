package tree;

import java.util.Scanner;

public class BinaryTree 
{
	Node rootNode = null;
	public BinaryTree()
	{}
	
	public BinaryTree(boolean manual)
	{
		rootNode = null;
		Scanner in = new Scanner(System.in);
		while(true)
		{
			System.out.println("========= Level Order Tree ==========");
			System.out.println("Enter your choice :");
			System.out.println("0: exit");
			System.out.println("1: printTree");
			System.out.println("2: printLevelOrder");
			System.out.println("3: preOrderPrint");
			System.out.println("4: inOrderPrint");
			System.out.println("5: postOrderPrint");
			System.out.println("6: insert");
			System.out.println("7: insertRecursive");
			System.out.println("8: height");
			
			switch(in.nextInt())
			{
			case 0:
				return;
			case 1:
				System.out.println();
				printTree(rootNode, 0);
				break;
			case 2:
				print(rootNode);
				break;
			case 3:
				System.out.println();
				preOrderPrint(rootNode);
				System.out.println();
				break;
			case 4:
				System.out.println();
				inOrderPrint(rootNode);
				System.out.println();
				break;
			case 5:
				System.out.println();
				postOrderPrint(rootNode);
				System.out.println();
				break;
			case 6:
				System.out.println("value ?");
				rootNode = insert(rootNode, in.nextInt());
				break;
			case 7:
				System.out.println("value ?");
				rootNode = insertRecursive(rootNode, in.nextInt());
				break;
			case 8:
				System.out.println(height(rootNode));
				break;
			}
		}
	}
	public Node getRoot()
	{
		return rootNode;
	}
	void printTree(Node root, int space)
	{
		/*
		 * Prints tree vertically which actually looks like tree
		 *         8
		 *      6
		 *         7
		 *    5  
		 *         3
		 *      2
		 *         1
		 */
		
		if(root == null)
			return;
		
		printTree(root.right, space + 5);
		
		for(int i=0; i<space; i++)
			System.out.print(" ");
		System.out.print(root.data);
		System.out.println();
		
		printTree(root.left, space + 5);
	}
	
	void print(Node root)
	{
		if(root == null)
			return;
		
		int height = height(root);
		
		for(int i=0; i<height; i++)
		{
			printLevel(root, i);
		}
	}
	
	void printLevel(Node root, int level)
	{
		if(root == null)
			return;
		
		if(level == 0)
			System.out.print(root.data + " ");
		else
		{
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}
	}
	
	void preOrderPrint(Node root)
	{
		// root, root.left, root.right
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		preOrderPrint(root.left);
		preOrderPrint(root.right);
		
	}
	
	void inOrderPrint(Node root)
	{
		//root.left, root, root.right
		if(root == null)
			return;
		
		inOrderPrint(root.left);
		System.out.print(root.data + " ");
		inOrderPrint(root.right);
	}
	
	void postOrderPrint(Node root)
	{
		//root.left, root.right, root
		
		if(root == null)
			return;
		
		postOrderPrint(root.left);
		postOrderPrint(root.right);
		System.out.print(root.data + " ");
		
	}

	
	public int height(Node root)
	{
		if(root == null)
			return 0;
		else
		{
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			
			return Math.max(1 + leftHeight, 1 + rightHeight);
		}
	}
	
	public Node insertRecursive(Node root, int val)
	{
		if(root == null)
		{
			root = new Node(val);
			root.left = null;
			root.right = null;
			return root;
		}
		
		if(val < root.data)
			root.left = insertRecursive(root.left, val);
		else if(val > root.data)
			root.right = insertRecursive(root.right, val);
		else
			System.out.println("Node already exists");
		
		return root;
		
	}
	public Node insert(Node root, int val)
	{
		Node newnode = new Node(val);
		Node curr = root;
		while(true)
		{
			if(root == null)
			{
				root = newnode;
				return root;
			}
			
			if(val < curr.data)
			{
				if(curr.left == null)
				{
					curr.left = newnode;
					return root;
				}
				curr = curr.left;
			}
			
			if(val > curr.data)
			{
				if(curr.right == null)
				{
					curr.right = new Node(val);
					return root;
				}
				curr = curr.right;
			}
		}
	}
}
