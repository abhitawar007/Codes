import java.util.Scanner;

public class equations 
{
	public int equations1()
	{
		/*
		 * Largest rectangular sub-matrix whose sum is 0
		 */
		int arr[][] = new int[][] {{1, 2, 3}, {-3, -2, -1}, {1, 2, 3}};
		
		int n = arr.length;
		int m = arr[0].length;
		
		for(int i=n; i>0; i--)
		{
			for(int j=m; j>0; j--)
			{
				for(int x=0; x<i; x++)
				{
					for(int y=0; y<j; y++)
					{
						int sum = 0;
						int count = 0;
						for(int k=x; k<i; k++)
						{
							for(int p=y; p<j; p++)
							{
								sum += arr[k][p];
								count = count +1;
							}
						}
						if(sum == 0)
						{
							System.out.println("ans = " + count);
							return count;
						}
					}
				}
			}
		}
		return 0;
		
	}
	
	public equations()
	{
		/*
		 * a + b = x
		 * a XOR b = y
		 * queries give values of x and y in a line.
		 * Find non-negative integer solution (a, b) with smallest possible 'a'. 
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of queries");
		int n = in.nextInt();

		for(int i=0; i<n; i++)
		{
			long x = in.nextLong();
			long y = in.nextLong();
			long a = -1, b = -1;

			for(b=0; b<=99999999; b++)
			{
				if(((x - b) ^ b) == y)
				{
					a = x - b;
					break;
				}
			}
			if(a != -1)
				System.out.println(Math.min(a, b) + " " + Math.max(a, b));
			else
				System.out.println("-1");
		}

	}
}
