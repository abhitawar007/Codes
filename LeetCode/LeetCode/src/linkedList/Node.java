package linkedList;

public class Node 
{
	public int data;
	public Node next;
	public Node prev;
	
	public Node(int _data)
	{
		data = _data;
		Initialize();
	}

	public void Initialize()
	{
		next = null;
		prev = null;
	}

}
