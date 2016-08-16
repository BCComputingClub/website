import java.util.*;

public class A_Contesting_Decision {

	static ArrayList<String> teamList = new ArrayList<String>();
	static ArrayList<Integer> pointList = new ArrayList<Integer>();
	static ArrayList<Integer> penPointsList = new ArrayList<Integer>();
	static ArrayList<Integer> answerList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// first int tells the number of teams
		int loop = in.nextInt();
		
		for(int i = 0; i < loop; i++)
		{
			String teamName = in.next();
			
			///Gather each score of this team in an array
			int[] scoreArray = {in.nextInt(), in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()};
			
			///Initialize values to store final output
			int points = 0;
			int penPoints = 0;
			int totalPoints = 0;
			
			///Iterate the array of scores. Every 2 indices is 1 problem score, so increment by 2
			for(int j = 0; j < scoreArray.length; j+=2)
			{
				///j+1 is the submission time, which is only recorded if they got the problem right
				/// if they did not get the problem right, no points or penalties are given
				if(scoreArray[j+1] > 0)
				{
					///Track how many problems the team got right
					points++;
					
					/// j is the number of times they submitted a problem
					/// if j is any greater then 1, then the time submitted need to be added
					/// to [j]-1 * 20 to account for +20 penalty points per incorrect submission
					totalPoints += ((scoreArray[j] -1) *20) + scoreArray[j+1];
					
					///Penalty points only matter if they submitted the problem 
					/// more then once, thus [j]-1
					penPoints += (scoreArray[j] - 1);
				}
			}
			
			///These values will be stored in a look-up table,
			/// where the index of (teamName) == index of (points), ect, for the same team
			teamList.add(teamName);
			pointList.add(points);
			penPointsList.add(penPoints);
			answerList.add(totalPoints);
		}
		
		///Have to find the highest scoring team (based on correct submissions)
		/// but we cant just sort the lists or the look-up table indices will be broken
		 
		///Integer.Min_VALUE guarantees that any value found will be higher, and thus 
		/// this value will be reset at the first run of the loop
		/// if you were looking for the lowest value in the list, use Integer.MAX_VALUE
		
		int currentLowest = Integer.MIN_VALUE;
		int currentLowestIndex = -1;
		
		for(int i = 0; i < pointList.size(); i++)
		{
			if(pointList.get(i) > currentLowest)
			{
				currentLowest = pointList.get(i);
				currentLowestIndex = i;
			}
			///The problem states that if two teams equal, the team with the
			/// lowest penPoints wins, this is where look-up tables are nice
			else if(pointList.get(i) == currentLowest)
			{
				if(penPointsList.get(i) < penPointsList.get(currentLowestIndex))
				{
					currentLowest = pointList.get(i);
					currentLowestIndex = i;
				}
			}
		}
		
		System.out.println(teamList.get(currentLowestIndex) + " " + pointList.get(currentLowestIndex) + " " + answerList.get(currentLowestIndex));
		
	}

}
