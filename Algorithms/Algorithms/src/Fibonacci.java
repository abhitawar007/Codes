import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci 
{
	public Fibonacci()
	{
		Scanner in = new Scanner(System.in);
		while(true)
		{
			System.out.println();
			System.out.println("Enter index: ");
			int n = in.nextInt();
			System.out.println("nth Fibonacci :" + nthFibonacci(n));
			System.out.println("nth Fibonacci space saving :" + nthFibonacciSpaceSaving(n));
		}
	}
	
	public int nthFibonacci(int n)
	{
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);
		arr.add(1);
		
		for(int i=2; i<=n; i++)
			arr.add(arr.get(i-1) + arr.get(i-2));
		
		return arr.get(n);
	}
	
	public int nthFibonacciSpaceSaving(int n)
	{
		int a=0, b=1, c=0;
		if(n == 0)
			return a;
		
		for(int i = 2; i<=n; i++)
		{
			c = a + b;
			a = b;
			b = c;
		}
		
		return b; //Because b = c
	}
}
