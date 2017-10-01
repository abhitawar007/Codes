package integers;

import java.util.Scanner;

public class SpiralMatrix 
{
	public SpiralMatrix()
	{
		int[][] mat = {{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}};
		
		printSpiral(mat);
	}
	
	public void printSpiral(int[][] mat)
	{
		int rowBegin = 0;
		int colBegin = 0;
		int rowEnd = mat.length;
		int colEnd = mat[0].length;
		
		while(rowBegin <= rowEnd && colBegin <= colEnd)
		{
			// traverse right
			for(int i=colBegin; i<colEnd; i++)
				System.out.print(mat[rowBegin][i] + " ");
			rowBegin++;
			
			// traverse down
			for(int i=rowBegin; i<rowEnd; i++)
				System.out.print(mat[i][colEnd-1] + " ");
			colEnd--;
			
			// traverse left
			for(int i=colEnd - 1; i>=colBegin; i--)
				System.out.print(mat[rowEnd-1][i] + " ");
			rowEnd--;
			
			//traverse up
			for(int i=rowEnd - 1; i>=rowBegin; i--)
				System.out.print(mat[i][colBegin] + " ");
			colBegin++;
		}
	}
}

