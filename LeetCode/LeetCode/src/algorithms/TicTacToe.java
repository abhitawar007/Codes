package algorithms;

import java.util.Scanner;

public class TicTacToe 
{
	private int n;
	private int[][] arr;
	private Scanner in;
	public TicTacToe()
	{
		in = new Scanner(System.in);
		while(true)
		{
			System.out.println("\n============== Tic Tac Toe ============================");
			System.out.println("0: Quit");
			System.out.println("1. Print");
			System.out.println("2. Populate");
			System.out.println("3: Find winner");
			System.out.println("4: Play");
			System.out.println("================ Tic Tac Toe ============================");

			System.out.println("Enter your choice :");

			Scanner choice = new Scanner(System.in);

			switch(choice.nextInt())
			{
			case 1:
				print();
				break;
			case 2:
				populate();
				break;
			case 3:
				int ans = findWinner();
				if(ans == -1)
					System.out.println("~~ No Winner ~~");
				else
					System.out.println("Winner is ==> " + ans);
				break;
			case 4:
				int ans1 = play();
				if(ans1 == -1)
					System.out.println("~~ No Winner ~~");
				else
					System.out.println("Winner is ==> " + ans1);
				break;
			}
		}
	}

	public void print()
	{
		System.out.println();
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	public void populate()
	{
		System.out.println("Enter the dimensions");
		n = in.nextInt();

		arr = new int[n][n];

		System.out.println("Enter the elements (either 1 or 0)");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.println("arr [" + i +"][" + j + "]  :  ");
				arr[i][j] = in.nextInt();
			}
		}
	}

	public int findWinner()
	{
		//check horizontal
		for(int i=0; i<n; i++)
		{
			int temp = arr[i][i];
			for(int j=0; j<n; j++)
			{
				if(arr[i][i] != arr[i][j])
				{
					temp = arr[i][j];
					break;
				}
			}
			if(temp == arr[i][i])
			{
				return temp;
			}
		}

		//check vertical
		for(int i=0; i<n; i++)
		{
			int temp = arr[i][i];
			for(int j=0; j<n; j++)
				if(arr[i][i] != arr[j][i])
				{
					temp = arr[j][i];
					break;
				}

			if(temp == arr[i][i])
				return temp;
		}

		// check diagonal
		int temp = arr[0][0];
		for(int i=0; i<n; i++)
			if(arr[i][i] != arr[0][0])
			{
				temp = arr[i][i];
				break;
			}

		if(temp == arr[0][0])
			return temp;

		// Other diagonal
		temp = arr[0][n-1];

		for(int i=0; i<n; i++)
			if(arr[i][n-1-i] != arr[0][n-1])
			{
				temp = arr[i][n-1-i];
				break;
			}

		if(temp == arr[0][n-1])
			return temp;

		return -1;
	}

	public int play()
	{
		System.out.println("Enter the dimensions");
		n = in.nextInt();
		arr = new int[n][n];
		System.out.println("Enter the element (either 0 or 1) ");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.println("arr [" + i + "][" + j + "]  :  ");
				int ans = insert(i, j, in.nextInt());
				if(ans != -1)
					return ans;
			}
		}
		return -1;
	}

	public int insert(int row, int col, int val)
	{
		arr[row][col] = val;

		boolean win = true;

		//check horizontal
		if(col == n-1)
		{
			for(int i=0; i<n; i++)
				if(val != arr[row][i])
				{
					win = false;
					break;
				}
			if(win)
				return val;
		}

		//check vertical
		win = true;
		if(row == n-1)
		{
			for(int i=0; i<n; i++)
				if(val != arr[i][col])
				{
					win = false;
					break;
				}
			if(win)
				return val;

			//check other diagonal
			win = true;
			if(col == 0)
			{
				for(int i=0; i<n; i++)
					if(val != arr[0][n-1])
					{
						win = false;
						break;
					}
				if(win)
					return val;
			}
		}

		// check diagonal
		win = true;
		if(row == col && row == n-1)
		{
			for(int i=0; i<n; i++)
				if(val != arr[0][0])
				{
					win = false;
					break;
				}
			if(win)
				return val;
		}

		// No winner
		return -1;

	}
}






