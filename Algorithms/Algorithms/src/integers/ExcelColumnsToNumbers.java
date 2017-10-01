package integers;

public class ExcelColumnsToNumbers 
{
	public ExcelColumnsToNumbers()
	{
	/*
	 * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28 
	 */
		System.out.println(excelColumnsToInt("A") + " " + excelColumnsToInt("AA") + " " + excelColumnsToInt("AAA"));
	}
	
	

	public int excelColumnsToInt(String s)
	{
		int ans = 0;
		for(char ch:s.toCharArray())
		{
			ans *= 26;
			ans += ch - 'A' + 1;
		}
		return ans;
	}
}