package tests;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import tree.BinaryTree;
import tree.Node;

public class Test_Tree {

	@Test
	public void test() 
	{
		//print inorder traversal of two trees
		BinaryTree tree1 = new BinaryTree();
		BinaryTree tree2 = new BinaryTree();
		
		Node t1 = tree1.getRoot();
		Node t2 = tree2.getRoot();
		t1 = tree1.insert(t1, 15);
		t1 = tree1.insert(t1, 11);
		t1 = tree1.insert(t1, 19);
		t1 = tree1.insert(t1, 17);
		t1 = tree1.insert(t1, 13);

		t2 = tree1.insert(t2, 14);
		t2 = tree1.insert(t2, 12);
		t2 = tree1.insert(t2, 16);
		t2 = tree1.insert(t2, 20);
		t2 = tree1.insert(t2, 18);
		t2 = tree1.insert(t2, 22);
		t2 = tree1.insert(t2, 24);
		
		String ret = inOrderTwoTrees(t1, t2);
		assertEquals(ret, "11 12 13 14 15 16 17 18 19 20 22 24 ");
	}
	
	String inOrderTwoTrees(Node t1, Node t2)
	{
		Vector<Integer> vec1 = new Vector<>(); 
		vec1 = inOrder(t1, vec1);
		
		Vector<Integer> vec2 = new Vector<>();
		vec2 = inOrder(t2, vec2);
		
		String ans ="";
		
		for(int i=0, j=0; i<vec1.size() & j<vec2.size(); i++, j++)
			ans += vec1.elementAt(i) + " " + vec2.elementAt(j) + " ";
		
		if(vec1.size() < vec2.size())
			for(int i=vec1.size(); i<vec2.size(); i++)
				ans += vec2.elementAt(i) + " ";
		
		else if(vec2.size() < vec1.size())
		{
			for(int i=vec2.size(); i<vec1.size(); i++)
				ans += vec1.elementAt(i) + " ";
		}
		System.out.println("ans: " + ans);
		return ans;
	}
	
	Vector<Integer> inOrder(Node root, Vector<Integer> vec)
	{
		if(root == null)
			return vec;
		
		vec = inOrder(root.left, vec);
		vec.add(root.data);
		vec = inOrder(root.right, vec);
		
		return vec;
	}

}
