package algorithms;

import linkedList.SinglyLinkedList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import linkedList.Node;

public class AddTwoNumbers 
{
	public AddTwoNumbers()
	{
		SinglyLinkedList sll1 = new SinglyLinkedList();
		SinglyLinkedList sll2 = new SinglyLinkedList();
		sll1.InsertEnd(0);
		sll1.InsertEnd(4);
		sll1.InsertEnd(3);
		sll1.InsertEnd(6);
		
		sll2.InsertEnd(7);
		sll2.InsertEnd(6);
		sll2.InsertEnd(4);
		
		SinglyLinkedList ansList = addNumbers(sll1, sll2);
		ansList.printList();
	}
	
	public SinglyLinkedList addNumbers(SinglyLinkedList l1, SinglyLinkedList l2)
	{
		Node curr1 = l1.GetHead(), curr2 = l2.GetHead();
		SinglyLinkedList retList = new SinglyLinkedList();
		
		int carry = 0;
		for (int i=0; i< Math.max(l1.getSize(), l2.getSize()) | carry !=0; i++)
		{
			int newValue = ((curr1 != null)? curr1.data : 0) + ((curr2 != null)? curr2.data : 0 )+ carry;
			carry = newValue/10;
			carry = carry % 10;
			newValue = newValue % 10;
			
			retList.InsertEnd(newValue);
			if(curr1 != null)
				curr1 = curr1.next;
			if(curr2 != null)
				curr2 = curr2.next;
		}
		return retList;
	}
	
	
}
