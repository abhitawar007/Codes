package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IntegerToEnglishWords 
{
	private Map<String, String> map;
	public IntegerToEnglishWords()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number < trillion");
		double n = in.nextDouble();
		map = new HashMap<>();
		fillMap();

		System.out.println(englishWord(n));
	}

	public String englishWord(double num)
	{
		String ans = "";
		String s = Integer.toString((int)num);
		int n = s.length();
		for(int i = n-1; i>=0; i--)
		{
			char ch = s.charAt(i);
			
			
			if(i == n-4)
				ans = " Thousand " + ans;
			if(i == n-7)
				ans = " Million " + ans;
			if(i == n-10)
				ans = " Billion " + ans;
			if(ch == '0' && i != n-1)
				continue;

			if((n-1-i) % 3 == 0)
			{
				if(i>0)
				{
					if(s.charAt(i-1) == '1')
					{
						ans = map.get(Character.toString(s.charAt(i-1)) + Character.toString(ch)) + ans;
						continue;
					}
					if(ch == '0')
						continue;
				}
				ans = map.get(Character.toString(ch)) + ans;
				continue;
			}

			if((n-1-i)%3 ==1)
			{
				if(ch == '1')
					continue;
				ans = map.get(Character.toString(ch) + "d") + " " + ans;
				continue;
			}
			
			if((n-1-i)%3 == 2)
				ans = map.get(Character.toString(ch)) + " Hundred " + ans;
		}
		return ans;
	}

	public void fillMap()
	{
		map.put("0", "Zero");
		map.put("1", "One");
		map.put("2", "Two");
		map.put("3", "Three");
		map.put("4", "Four");
		map.put("5", "Five");
		map.put("6", "Six");
		map.put("7", "Seven");
		map.put("8", "Eight");
		map.put("9", "Nine");
		map.put("10", "Ten");
		map.put("11", "Eleven");
		map.put("12", "Twelve");
		map.put("13", "Thirteen");
		map.put("14", "Fourteen");
		map.put("15", "Fifteen");
		map.put("16", "Sixteen");
		map.put("17", "Seventeen");
		map.put("18", "Eightteen");
		map.put("19", "Nineteen");
		map.put("1d", "");
		map.put("0d", "");		
		map.put("2d", "Twenty");
		map.put("3d", "Thirty");
		map.put("4d", "Fourty");
		map.put("5d", "Fifty");
		map.put("6d", "Sixty");
		map.put("7d", "Seventy");
		map.put("8d", "Eighty");
		map.put("9d", "Ninety");





	}

}
