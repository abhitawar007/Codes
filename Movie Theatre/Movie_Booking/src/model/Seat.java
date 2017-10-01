package model;

public class Seat 
{
	int satisfaction = 0;
	String seatId = "";
	boolean occupied = false;
	char rowId;
	int seatNumber;

	public Seat(String seatId) 
	{
		this.setSeatId(seatId);
		this.rowId = seatId.charAt(0);
		computeSatisfaction();
	}
	
	private void computeSatisfaction() 
	{
		char rowId = seatId.charAt(0);
		this.seatNumber = Integer.parseInt(seatId.replaceAll("[^0-9]",""));
		if (seatNumber <= 10)
			this.satisfaction = (int) (rowId - 'A') + seatNumber;
		else
			this.satisfaction = (int) (rowId - 'A') + 11 - seatNumber%10;
	}
	
	public char getRowId() 
	{
		return rowId;
	}
	
	public int getSeatNumber() 
	{
		return seatNumber;
	}

	public String getSeatId() 
	{
		return seatId;
	}

	public void setSeatId(String seatId) 
	{
		this.seatId = seatId;
	}
	
	public boolean isOccupied() 
	{
		return occupied;
	}
	
	public void setOccupied(boolean occupied) 
	{
		this.occupied = occupied;
	}

}
