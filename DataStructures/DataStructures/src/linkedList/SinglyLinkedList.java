package linkedList;

import java.util.Scanner;

public class SinglyLinkedList
{
	private Node head = null;

	public SinglyLinkedList(Scanner choice)
	{
		while(true)
		{
			System.out.println("\n=============== Linked List ===========================");
			System.out.println("1. Print");
			System.out.println("2. InsertEnd");
			System.out.println("3. InsertBeginning");
			System.out.println("4. InsertAt(position, data)");
			System.out.println("5. Delete(position)");
			System.out.println("6. PrintReverse()");
			System.out.println("7. ReverseList()");
			System.out.println("8. SortList()");
			System.out.println("9. GetNodeFromTail(positionFromTail)");
			System.out.println("10. RemoveDuplicates()");
			System.out.println("11. hasCycle()");
			System.out.println("0: Quit");
			System.out.println("================== Linked List ========================");

			System.out.println("Enter your choice :");

			switch(choice.nextInt())
			{
			case 1:
				printList();
				break;
			case 2:
				System.out.println("Enter the element to insert : ");
				insertEnd(choice.nextInt());
				break;
			case 3:
				//				insertStart(choice.nextInt());
				break;
			case 4:
				//				insertAt(choice.nextInt(), choice.nextInt());
				break;
			case 5:
				System.out.println("Enter the position to delete : ");
				head = delete(choice.nextInt());
				break;
			case 6:
				//				printReverse();
				break;
			case 7:
				head = reverseList();
				break;
			case 8:
				//				sortList();
				break;
			case 9:
				//				getNodeFromTail(choice.nextInt());
				break;
			case 10:
				//				removeDuplicates();
			case 0:
				return;
			}
		}
	}

	public void printList()
	{
		Node curr = head;
		System.out.println();
		while(curr != null)
		{
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

	public void insertEnd(int data)
	{
		if(head == null)
		{
			head = new Node(data); 
			return;
		}

		Node curr = head;

		while(curr.next != null)
			curr = curr.next;

		curr.next = new Node(data);
	}
	
	public Node delete(int position)
	{
		if(head == null)
		{
			System.out.println("List empty!!!");
			return head;
		}
		
		if(position == 0)
		{
			head = head.next;
			return head;
		}
		
		Node curr = head;
		for(int i=0; i<position - 1; i++)
		{
			if(curr.next == null)
			{
				System.out.println("Out of index");
				return head;
			}
			curr = curr.next;
		}
		
		if(curr.next == null)
		{
			System.out.println("Out of index");
			return head;
		}
		
		curr.next = curr.next.next;
		return head;
	}

	public Node reverseList()
	{
		if(head == null)
			return null;
		
		if(head.next == null)
			return head;

		Node curr = head;
		Node tempNext = curr.next;
		curr.next = null;
		if(tempNext.next == null)
		{
			tempNext.next = curr;
			return tempNext;
		}
		Node tempNextNext;
		while(tempNext != null)
		{
			if(tempNext.next == null)
			{
				tempNext.next = curr;
				return tempNext;
			}

			tempNextNext = tempNext.next;
			tempNext.next = curr;
			curr = tempNext;
			tempNext = tempNextNext;
		}

		return tempNext;
	}

}