import model.*;
import utility.*;

public class Test 
{
	public static String path = "input.txt";
	
	public static void main(String[] args) 
	{
		ProcessInput input = new ProcessInput(path);
		Theater theater = new Theater(20, 10, input.getRequests());
		theater.reserveSeats();
		GenerateSeatingChart output = new GenerateSeatingChart(theater.getRequests());
		output.generateOutputFile();
	}
}
