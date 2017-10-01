package model;

import java.util.ArrayList;

public class Request 
{
	private int size;
	private int requestID;
	private int satisfaction;
	private ArrayList<Seat> seats;

	public Request(int size, int id) 
	{
		seats = new ArrayList<>();
		
		this.size = size;
		this.requestID = id;
	}

	public int getSize() 
	{
		return size;
	}

	public void setSize(int size) 
	{
		this.size = size;
	}

	public int getRequestID() 
	{
		return requestID;
	}

	public void setRequestID(int requestID) 
	{
		this.requestID = requestID;
	}
	
	public int getSatisfaction() 
	{
		return satisfaction;
	}
	
	public void addSeat(Seat seat)
	{
		seats.add(seat);
	}

	public ArrayList<Seat> getSeats() 
	{
		return seats;
	}
}
