package tests;
import tree.BinaryTree;

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

			switch(in.nextInt())
			{
			case 0:
				return;
			case 1:
				new SinglyLinkedList(in);
			case 2:
				new BinaryTree(in);
			}

		}
	}
}
