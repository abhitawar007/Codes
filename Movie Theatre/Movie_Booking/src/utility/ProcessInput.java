package utility;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import model.*;

public class ProcessInput 
{
	public String path = new String();
	public ArrayList<Request> requests = new ArrayList<Request>(); 

	public ProcessInput(String path) 
	{
		this.path = path;
		this.parseinput();
	}

	public ArrayList<Request> getRequests() 
	{
		return requests;
	}
	
	public void parseinput() 
	{
		int capacity = 0;
		try 
		{
			Scanner in = new Scanner(new FileReader(path));
			
			String id = new String();
			int size;
			
			while(in.hasNext()) 
			{
			    id = in.next();
			    size = in.nextInt();
			    capacity = capacity + size;
			    int orderid = Integer.parseInt(id.replaceAll("[^0-9]",""));
			    if(capacity > 200) {
			    	System.out.println("Show House Full --> Request ID " + (orderid)
			    			+ " cannot be processed.");
			    	break;
			    }
			    Request temp = new Request(size, orderid);
			    requests.add(temp);
			}
			in.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
}
