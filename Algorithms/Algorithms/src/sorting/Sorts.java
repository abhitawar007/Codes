package sorting;

import java.util.Scanner;

public class Sorts 
{
	public Sorts()
	{
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter the size of array : ");
		int n = in.nextInt();
		int[] arr = new int[n];
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		System.out.println("Enter elements : ");
		
		for(int i=0; i<n; i++)
		{
			int val = in.nextInt();;
			arr[i] = val;
			arr1[i] = val;
			arr2[i] = val;
		}
		
		
		System.out.println("Unsorted array => ");
		print(arr);
		
		System.out.println("Bubble sort => ");
		print(bubbleSort(arr));
		
		System.out.println("Selection sort => ");
		print(selectionSort(arr1));
		
		System.out.println("Insertion sort => ");
		print(insertionSort(arr2));
	}
	
	public void print(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		System.out.println();
	}
	public int[] bubbleSort(int[] arr)
	{
		for(int i=0; i<arr.length - 1; i++)
		{
			for(int j=0; j<arr.length - 1; j++)
			if(arr[j] > arr[j+1])
			{
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
		return arr;
	}
	
	public int[] selectionSort(int[] arr)
	{
		int[] ans = new int[arr.length];
		
		for(int i=0; i<ans.length; i++)
		{
			int min = 999;
			for(int j=0; j<arr.length; j++)
			{
				if(arr[j] < min)
				{
					int temp = arr[j];
					arr[j] = min;
					min = temp;
				}
			}
			ans[i] = min;
		}
		return ans;
	}
	
	public int[] insertionSort(int[] arr)
	{
		for(int i=1; i<arr.length; i++)
		{
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j] > key)
			{
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
		return arr;
	}
}