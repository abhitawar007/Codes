package utility;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GenerateSeatingChart 
{
	private ArrayList<Request> requests;

	public GenerateSeatingChart(ArrayList<Request> requests) {
		this.requests = requests;
	}

	public void generateOutputFile() {
		try{
		    PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		    for(Request req: requests)
		    {
		    	writer.print("R" + String.format("%03d", req.getRequestID()) + " ");
		    	for(int i = 0; i < req.getSeats().size(); i++)
		    	{
		    		writer.print(req.getSeats().get(i).getSeatId());
		    		if (i != req.getSeats().size() - 1)
		    			writer.print(",");
		    	}
		    	writer.println("");
		    }
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
		
	}
	

}
