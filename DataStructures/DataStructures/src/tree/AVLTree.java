package tree;

import java.util.Scanner;
import java.util.Stack;

public class AVLTree 
{
	private Node rootNode = null;
	public AVLTree(Scanner in)
	{
		rootNode = null;
		while(true)
		{
			System.out.println("========= AVL Tree ==========");
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
				// NOT using recursion
				System.out.println();
				preOrderPrint(rootNode);
				System.out.println();
				break;
			case 4:
				// NOT using recursion
				System.out.println();
				inOrderPrint(rootNode);
				System.out.println();
				break;
			case 5:
				// NOT using recursion
				System.out.println();
				postOrderPrint(rootNode);
				System.out.println();
				break;
			case 6:
				System.out.println("value ?");
				rootNode = insert(rootNode, in.nextInt());
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


	void preOrderPrint(Node root, boolean recursion)
	{
		// root, root.left, root.right using recursion
		if(root == null)
			return;

		System.out.print(root.data + " ");
		preOrderPrint(root.left, true);
		preOrderPrint(root.right, true);
	}

	void preOrderPrint(Node root)
	{
		Stack<Node> stack = new Stack<>();
		Node curr = root;

		while(curr != null)
		{
			System.out.print(curr.data + " ");
			stack.push(curr);
			curr = curr.left;
		}

		while(!stack.isEmpty())
		{
			curr = stack.pop();
			if(curr.right != null)
			{
				curr = curr.right;
				while(curr != null)
				{
					System.out.print(curr.data + " ");
					stack.push(curr);
					curr = curr.left;
				}
			}
		}
	}
	void inOrderPrint(Node root, boolean recursion)
	{
		//root.left, root, root.right
		if(root == null)
			return;

		inOrderPrint(root.left, true);
		System.out.print(root.data + " ");
		inOrderPrint(root.right, true);
	}

	void inOrderPrint(Node root)
	{
		Stack<Node> stack = new Stack<>();
		Node curr = root;
		while(curr != null)
		{
			stack.push(curr);
			curr = curr.left;
		}

		while(!stack.isEmpty())
		{
			curr = stack.pop();
			System.out.print(curr.data + " ");

			if(curr.right != null)
			{
				curr = curr.right;
				while(curr != null)
				{
					stack.push(curr);
					curr = curr.left;
				}
			}
		}
	}

	void postOrderPrint(Node root, boolean recursion)
	{
		//root.left, root.right, root

		if(root == null)
			return;

		postOrderPrint(root.left, true);
		postOrderPrint(root.right, true);
		System.out.print(root.data + " ");
	}

	void postOrderPrint(Node root)
	{
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		Node curr = root;
		s1.push(curr);

		while(!s1.isEmpty())
		{
			curr = s1.pop();
			s2.push(curr);
			if(curr.left != null)
				s1.push(curr.left);
			if(curr.right != null)
				s1.push(curr.right);
		}

		while(!s2.isEmpty())
			System.out.print(s2.pop().data + " ");
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

	// Insert helper methods

	public int balance(Node root)
	{
		return height(root.left) - height(root.right);
	}

	public Node rotateRight(Node root)
	{
		Node leftChild = root.left;
		Node t2 = leftChild.right;
		
		// Perform rotation
		leftChild.right = root;
		root.left = t2;
		
		return leftChild;
	}

	public Node rotateLeft(Node root)
	{
		Node rightChild = root.right;
		Node t4 = rightChild.left;
		
		// Perform rotation
		rightChild.left = root;
		root.right = t4;
		
		return rightChild;
	}

	public Node insert(Node root, int val)
	{
		// Insert like BST
		if(root == null)
			return (new Node(val));

		if(val < root.data)
			root.left = insert(root.left, val);
		else if(val > root.data)
			root.right = insert(root.right, val);
		else // No duplicates
			return root;

		// Check the balance
		int balance = balance(root);

		// balance > 1 => y is left child
		// balance < -1 => y is right child
		// Check which child x is using val

		if(balance > 1 && val < root.left.data)
		{
			// case 1: Left Left
			return rotateRight(root);
		}

		if(balance > 1 && val > root.left.data)
		{
			// case 2: Left Right
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}

		if(balance < -1 && val > root.right.data)
		{
			// case 3: Right Right
			return rotateLeft(root);
		}

		if(balance < -1 && val < root.right.data)
		{
			// case 4: Right Left
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		
		return root;
	}
// Insert ends
}

