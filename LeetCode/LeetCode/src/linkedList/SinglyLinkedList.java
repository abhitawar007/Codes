package linkedList;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class SinglyLinkedList 
{
	Node head = null;
//	public SinglyLinkedList()
//	{
//		
//	}

	public void SinglyLinkedList1(boolean onlyLinkedList)
	{
		while(true)
		{
			System.out.println("\n==========================================");
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
			System.out.println("==========================================");

			System.out.println("Enter your choice :");
			Scanner choice = new Scanner(System.in);

			switch(choice.nextInt())
			{
			case 1:
				printList();
				break;
			case 2:
				InsertEnd(choice.nextInt());
				break;
			case 3:
				InsertStart(choice.nextInt());
				break;
			case 4:
				InsertAt(choice.nextInt(), choice.nextInt());
				break;
			case 5:
				Delete(choice.nextInt());
				break;
			case 6:
				PrintReverse();
				break;
			case 7:
				ReverseList();
				break;
			case 8:
				SortList();
				break;
			case 9:
				GetNodeFromTail(choice.nextInt());
				break;
			case 10:
				RemoveDuplicates();
			case 0:
				return;
			}
		}
	}
	
	public Node GetHead()
	{
		return head;
	}
	
	public int getSize()
	{
		Node curr = head;
		int size = 0;
		while (curr != null)
		{
			size++;
			curr = curr.next;
		}
		return size;
	}

	public void InsertAt(int position, int data)
	{
		Node newNode = new Node(data);
		Node curr = head;
		for(int i=0; i< position - 1; i++)
		{
			if(curr.next != null)
				curr = curr.next;
			else
			{
				System.out.println("out of range!!!");
				return;
			}
		}
		if(position == 0)
		{
			newNode.next = head;
			head = newNode;
		}
		else
		{
			if(head == null)
			{
				System.out.println("List empty.");
				return;
			}
			newNode.next = curr.next;
			curr.next = newNode;
		}

	}
	
	public void Delete(int position)
	{
		Node curr = head;
		if(head == null)
		{
			System.out.println("List Empty!!!");
			return;
		}
		for(int i=0; i<position-1; i++)
		{
			if(curr.next != null)
				curr = curr.next;
			else
			{
				System.out.println("No element there!!!");
				return;
			}
		}
		
		if(position == 0)
			head = head.next;
		else if(curr.next == null)
		{
			System.out.println("No element there!!!");
			return;
		}
		else
			curr.next = curr.next.next;
	}
	
	public void PrintReverse()
	{
		int[] arr = new int[10000];
		int i = 0;
		Node curr = head;
		while(curr != null)
		{
			arr[i] = curr.data;
			curr = curr.next;
			i++;
		}
		
		for(int j=i-1; j>=0; j--)
		{
			System.out.println(arr[j]);
		}
	}
	
	public Node ReverseList()
	{
		ArrayList<Node> arr = new ArrayList<Node>();
		Node curr = head;
		
		while(curr != null)
		{
			arr.add(curr);
			Node temp = curr.next;
			curr.next = null;
			curr = temp;
		}
		
		head = null; 
		
		while(arr.size()>0)
		{
			if(head == null)
			{
				head = arr.remove(arr.size() -1);
			}
			else
			{
				Node newCurr = head;
				while(newCurr.next != null)
				{
					newCurr = newCurr.next;
				}
				newCurr.next = arr.remove(arr.size() - 1);
			}
		}
		return head;
	}
	
	public boolean CompareLists(Node head1, Node head2)
	{
		Node curr1 = head1, curr2 = head2;
		while(curr1 != null || curr2 != null)	// if either of them is not null, go inside
		{
			if(curr1 == null || curr2 == null)	// if either of them is null, the lists do not match
				return false;
			if(curr1.data == curr2.data)
			{
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			else
				return false;
		}
		return true;
	}
	
	public void SortList()
	{
		ArrayList<Node> arr = new ArrayList<Node>();
		
		while(head != null)
		{
			arr.add(head);
			head = head.next;
		}
		
		while(arr.size() > 0)
		{
			head = SortedInsert(head, arr.remove(0));
		}
	}
	
	public Node SortedInsert(Node listHead, Node newNode)
	{
		newNode.Initialize();
		if(listHead == null)
		{
			listHead = newNode;
		}
		else
		{
			if(newNode.data < listHead.data)
			{
				newNode.next = listHead;
				listHead = newNode;
				return listHead;
			}
			Node curr = listHead;
			while(curr.next != null)
			{
				if(newNode.data > curr.next.data)
				{
					curr = curr.next;
				}
				else
					break;
			}
			newNode.next = curr.next;
			curr.next = newNode;
		}
		return listHead;
	}
	
	public Node MergeLists(Node headA, Node headB)
	{
		if (headA == null)
			return headB;
		else if(headB == null)
			return headA;
		
		Node curr, chk, retHead;
		if(headA.data < headB.data)
		{
			curr = headA; chk = headB; retHead = headA;
		}
		else
		{
			curr = headB; chk = headA; retHead = headB;
		}
		
		while(true)
		{
			if(curr.next == null)
			{
				curr.next = chk;
				return retHead;
			}
			if(chk == null)
				return retHead;
			
			if(curr.next.data < chk.data)
				curr = curr.next;
			else
			{
				Node tempNode = chk.next;
				chk.next = curr.next;
				curr.next = chk;
				chk = tempNode;
			}
		}
	}
	
	public void GetNodeFromTail(int positionFromTail)
	{
		ArrayList<Node> arr = new ArrayList<Node>();
		
		Node curr = head;
		while(curr != null)
		{
			arr.add(curr);
			curr = curr.next;
		}
		if(positionFromTail >= arr.size())
		{
			System.out.println("Out of range!!!");
			return;
		}
		System.out.println(arr.remove(arr.size() - 1 - positionFromTail).data);
		
		/*
		 * this is a working answer w/o recursion or array or any stupid stuff
int GetNode(Node *head,int positionFromTail)
{
    int index = 0;
    Node* current = head;
    Node* result = head;
    while(current!=NULL)
    {
        current=current->next;
        if (index++>positionFromTail)
        {
            result=result->next;
        }
    }
    return result->data;
}
		 */
	}

	public void InsertEnd(int _data)
	{
		Node newNode = new Node(_data);
		Node curr = head;
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			while(curr.next != null)
				curr = curr.next;

			curr.next = newNode;
		}
	}
	
	public void RemoveDuplicates()
	{
		Node curr = head;
		if(curr == null)
			return;

		while(curr.next != null)
		{
			if(curr.data == curr.next.data)
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
		return;
	}
	
	public boolean hasCycle(Node head) 
	{
	    Node curr = head;
	    Node target = head;
	    int i = 0;
	    if(head == null)
	        return false;
	    while(curr.next != null)
	    {
	        curr = curr.next;
	        if(curr == target)
	            return true;

	        for(int k=0; k<i; k++)
	            {
	            target = target.next;
	            if(curr == target)
	                return true;
	        }
	        i++; target = head;
	    }
	    return false;
	}


	public void InsertStart(int _data)
	{
		Node newNode = new Node(_data);

		if(head == null)
		{
			head = newNode;
		}
		else
		{
			newNode.next = head;
			head = newNode;
		}
	}

	public void printList()
	{
		Node curr = head;
		while(curr != null)
		{
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
