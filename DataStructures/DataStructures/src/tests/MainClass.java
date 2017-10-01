package tests;
import tree.*;
import java.util.Scanner;

import linkedList.*;
public class MainClass 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);

		while(true)
		{
			System.out.println("========= Datastructures ==========");
			System.out.println("Enter your choice of datastructure:");
			System.out.println("0: exit");
			System.out.println("1: LinkedList");
			System.out.println("2: Binary Tree");
			System.out.println("3: AVL Tree");

			switch(in.nextInt())
			{
			case 0:
				return;
			case 1:
				new SinglyLinkedList(in);
				break;
			case 2:
				new BinaryTree(in);
				break;
			case 3:
				new AVLTree(in);
				break;
			}

		}
	}
}
