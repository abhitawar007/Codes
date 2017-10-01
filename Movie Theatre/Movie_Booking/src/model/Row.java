package model;

import java.util.ArrayList;

public class Row 
{
	ArrayList<Seat> seats = new ArrayList<Seat>();
	public int satisfaction_level;
	private char row_id;

	public Row(int seat, int satisfaction_level, char rowId) 
	{
		this.satisfaction_level = satisfaction_level;
		this.setRow_id(rowId);
		
		for(int i = 0; i < seat; i++) {
			seats.add(new Seat(Character.toString(rowId) + i));
		}
	}

	public char getRow_id() 
	{
		return row_id;
	}

	public void setRow_id(char row_id) 
	{
		this.row_id = row_id;
	}
	
	public ArrayList<Seat> getVacancyLocation()
	{
		ArrayList<Seat> vacancies = new ArrayList<>();
		for(Seat seat: seats)
			if(seat.isOccupied() == false)
				vacancies.add(seat);

		return vacancies;
	}

	public ArrayList<Seat> getVacancyLocationReverse()
	{
		ArrayList<Seat> vacancies = new ArrayList<>();

		for(int i= seats.size() - 1; i>=0; i--)
			if(seats.get(i).isOccupied() == false)
				vacancies.add(seats.get(i));
		return vacancies;
	}

	public int getVacancy() 
	{
		int vacancy = 0;
		for(Seat seat: seats)
			if(seat.isOccupied() == false)
				vacancy++;
		return vacancy;
	}
}
