package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum 
{
	public TwoSum()
	{
		/*
		 * Given an array of integers, 
		 * return indices of the two numbers such that they add up to a specific target.
		 * You may assume that each input would have exactly one solution, 
		 * and you may not use the same element twice. 
		 */
		Scanner reader = new Scanner(System.in);

		System.out.println("Enter the size of array:");
		int size = reader.nextInt();
		int[] nums = new int[size];
		
		System.out.println("Enter the array:");
		for (int i=0; i< size; i++)
			nums[i] = reader.nextInt();
		
		System.out.println("Enter the target:");
		int target = reader.nextInt();
		
		reader.close();
		
		System.out.println("twoSum:" + Arrays.toString(twoSum(nums, target)));
		System.out.println("twoSumMapTwoPass:" + Arrays.toString(twoSumMapTwoPass(nums, target)));
		System.out.println("twoSumMapOnePass:" + Arrays.toString(twoSumMapOnePass(nums, target)));
	}
	
	public int[] twoSum(int[] nums, int target) 
	{
        for(int i=0; i< nums.length; i++)
        {
        	for (int j=i+1; j<nums.length; j++)
        	{
        		if(nums[i] + nums[j] == target)
        			return new int[] {i, j};
        	}
        }
        return null; //Exception
    }
	
	public int[] twoSumMapTwoPass(int[] nums, int target)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0; i<nums.length; i++)
			map.put(nums[i], i);
		
		for(int i=0; i<nums.length; i++)
			if (map.containsKey(target - nums[i]))
				return new int[] {i, map.get(target - nums[i])};

		return null;
		
	}
	
	public int[] twoSumMapOnePass(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i=0; i<nums.length; i++)
		{
			int compliment = target - nums[i];
			if(map.containsKey(compliment))
				return new int[] {map.get(compliment), i};
			map.put(nums[i], i);
		}
		return null;
	}
}
