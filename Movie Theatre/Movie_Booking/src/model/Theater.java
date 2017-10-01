package model;

import java.util.ArrayList;

public class Theater 
{
	private int numberOfRows;
	private ArrayList<Request> requests;
	private ArrayList<Row> rows = new ArrayList<Row>();
	int[][] satisfaction;

	public Theater(int seatsPerRow, int numberOfRows, ArrayList<Request> requests) 
	{
		this.requests = requests;
		this.numberOfRows = numberOfRows;
		this.satisfaction = new int[numberOfRows][seatsPerRow];
		for(int i = 0; i < this.numberOfRows; i++) 
			this.rows.add(new Row(seatsPerRow, i, (char)('A' +  i)));
	}
	
	public ArrayList<Request> getRequests()
	{
		return requests;
	}

	public void reserveSeats()
	{
		for(Request req: requests)			// First Come First Serve Allocation
		{
			this.findSeats(req);
		}
	}

	public void findSeats(Request req)
	{
		ArrayList<Seat> vacantSeats = this.findVacancy(req, true);
		int vacancy = vacantSeats.size();

		for(int k = 0; k < rows.size() ; k++)
		{
			if(req.getSize() == 1) 
				break;

			if(vacantSeats.size() < req.getSize()) 
				this.findVacancy(req, false);
			
			if(vacantSeats.get(0).getRowId() != vacantSeats.get(1).getRowId()) 
			{
				vacancy--;
				vacantSeats.remove(0);						// One seat in top row
			}

			else if(vacantSeats.get(req.getSize() -1).getRowId() != vacantSeats.get(req.getSize() -2).getRowId()) 
			{
				vacancy--;
				vacantSeats.remove(req.getSize() -2);		// One seat in bottom row
			}

			else
				break;
		}

		for(int k = 0; k < req.getSize(); k++)				// Out of while loop means found required vacancies
		{
			req.addSeat(vacantSeats.get(k));
			vacantSeats.get(k).setOccupied(true);
		}
		return;
	}
	
	public ArrayList<Seat> findVacancy(Request req, boolean partial) {
		int vacancy = 0;
		ArrayList<Seat> vacantSeats = new ArrayList<Seat>();

		for(int i=rows.size()-1; i>=0; i--)
		{
			if(rows.get(i).getVacancy() > 0)
			{
				vacancy += rows.get(i).getVacancy();
				if (i != 0 && req.getSize() != 2 && partial == true) {
					if (rows.get(i).getVacancy() == 2 && rows.get(i-1).getVacancy() != 20)
						continue;
				}
				if(rows.get(i).getRow_id() %2 == 0)
					vacantSeats.addAll(vacantSeats.size(), rows.get(i).getVacancyLocation());
				else
					vacantSeats.addAll(vacantSeats.size(), rows.get(i).getVacancyLocationReverse());
			}
		}
		return vacantSeats;
	}
	
	public void computeSatisfactionMatrix(int seatsPerRow)
	{
		int baseSatisfaction = 0;
		for(int i = 0; i < this.numberOfRows; i++) {
			baseSatisfaction++;
			for(int j = 0; j < seatsPerRow/2; j++) {
				this.satisfaction[i][j] = baseSatisfaction + j;
				this.satisfaction[i][seatsPerRow - j - 1] = baseSatisfaction + j;
			}
		}
	}
}
