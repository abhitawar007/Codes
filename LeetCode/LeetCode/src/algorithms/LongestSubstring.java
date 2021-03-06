package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class LongestSubstring 
{
	public LongestSubstring()
	{
		/*
		 * Given a string, find the length of the longest substring without repeating characters.
		 * Examples:
		 * Given "abcabcbb", the answer is "abc", which the length is 3.
		 * Given "bbbbb", the answer is "b", with the length of 1.
		 * Given "pwwkew", the answer is "wke", with the length of 3. 
		 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring
		 */
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = reader.nextLine();
		reader.close();
		
		// Tests
		System.out.println(lengthOfSubstring(str));
		System.out.println(lengthOfLongestSubstring(str));
	}
	
	public int lengthOfSubstring(String str)
	{
		char[] charArray = str.toCharArray();
		
		int ret = 0;
		Vector<Character> vec = new Vector<Character>();
		for(int i=0; i<charArray.length; i++)
		{
			if (vec.contains(charArray[i]))
			{
				int tempInt = vec.size();
				if (tempInt > ret)
					ret = tempInt;
				while(vec.firstElement() != charArray[i])
					vec.remove(0);
				vec.remove(0);
			}
			vec.add(charArray[i]);
		}
		
		return Math.max(ret, vec.size());
	}
	
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
                
            }
        }
        return ans;
    }
}
