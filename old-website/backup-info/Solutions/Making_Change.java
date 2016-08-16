import java.util.*;

public class Making_Change_2 {

	static int[] cents = {25,10,5,1};
	static ArrayList<String> answerList = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext())
		{
			int[][] changeArray = new int[5][5];
			
			for(int i = 0; i < 5; i++)
			{
				changeArray[i][0] = in.nextInt();
			}
			
			if(changeArray[1][0] == 0 && changeArray[2][0] == 0 && 
					changeArray[3][0] == 0 && changeArray[4][0] == 0
					&& changeArray[0][0] == 0)
			{
				break;
			}
			
			int[] bool = {0,0,0,0};
			ArrayList<int[][]> runArray = new ArrayList<int[][]>();
			
			for(int i = 0; i < 4; i++)
			{
				int[][] clone = copy2d(changeArray);
				
				runArray.add(run(clone,bool));
				bool[i] = 1;
			}
			
			int lowestIndex = -1;
			int lowestCount = Integer.MAX_VALUE;
			
			for(int i = 0; i < runArray.size(); i++)
			{
				int currentValue = 0;
				
				int[][] current = runArray.get(i);
				if(current[4][0] > 0)
				{
					continue;
				}
				for(int j = 0; j < 4; j++)
				{
					currentValue += current[j][1];
				}

				if(currentValue < lowestCount)
				{
					lowestCount = currentValue;
					lowestIndex = i;
				}
			}
			if(lowestIndex > -1)
			{
				changeArray = runArray.get(lowestIndex);
			
				answerList.add("Dispense " + changeArray[0][1] + " quarters, " + 
							changeArray[1][1] + " dimes, " + 
							changeArray[2][1] + " nickels, and " + 
							changeArray[3][1] + " pennies.");
			}
			else
			{
				answerList.add("Cannot dispense the desired amount.");
			}
		}
		
		for(String ans : answerList)
		{
			System.out.println(ans);
		}

	}
	
	static public int[][] run(int[][] change, int[] bool)
	{
		
		for(int i = 0; i < 4; i++)
		{
			if(bool[i] == 0)
			{
				while(change[4][0] >= cents[i] && change[i][0] > 0)
				{
					change[i][1] += 1;
					change[i][0] -= 1;
					change[4][0] -= cents[i];
				}
			}
		}
		
		
		if(change[4][0] > 0)
		{
			change[4][0] = 1;
		}
		return change;
	}

	private static int[][] copy2d(int[][] nums) 
	{
        int[][] copy = new int[nums.length][];

        for (int i = 0; i < copy.length; i++) {
                int[] member = new int[nums[i].length];
                System.arraycopy(nums[i], 0, member, 0, nums[i].length);
                copy[i] = member;
        }

        return copy;
	}

}
