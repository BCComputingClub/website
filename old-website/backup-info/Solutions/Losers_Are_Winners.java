import java.util.*;

public class Losers_Are_Winners {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String teamString = "";
		String highestTeam = "";
		double highestPercent = Double.MIN_VALUE;
		
		ArrayList<String> teamList = new ArrayList<String>();
		ArrayList<Double> finalWeight = new ArrayList<Double>();
		ArrayList<Double> initialWeight = new ArrayList<Double>();
		
		ArrayList<String> teamFinalList = new ArrayList<String>();
		ArrayList<Double> teamInitialWeight = new ArrayList<Double>();
		ArrayList<Double> teamFinalWeight = new ArrayList<Double>();
		
		ArrayList<String> answerTeamList = new ArrayList<String>();
		ArrayList<Double> answerPercentList = new ArrayList<Double>();
		
		ArrayList<String> tiedTeamList = new ArrayList<String>();
		
		while(in.hasNext())
		{
			/*
			 * clear all values at this iteration
			 */
			teamList.clear();
			finalWeight.clear();
			initialWeight.clear();
			teamFinalList.clear();
			teamInitialWeight.clear();
			teamFinalWeight.clear();
	
			teamString = "";
			highestTeam = "";
			highestPercent = Double.MIN_VALUE;
			
			int numTeams = in.nextInt();
			
			if(numTeams == 0)
				break;
			
			for(int i = 0; i < (numTeams*2); i++)
			{
				String s = in.next();
				 
				teamList.add(in.next());
				initialWeight.add(in.nextDouble());
				finalWeight.add(in.nextDouble());
			}
			
			for(int i = 0; i < teamList.size(); i++)
			{
				String team = teamList.get(i);
				
				/*
				 * Since each team name is in the list twice, 
				 * we need to check to make sure each team is
				 * only parsed once.
				 */
				if(teamString.contains(team))
					continue;
				
				for(int j = 0; j < teamList.size(); j++)
				{
					/*
					 * if the array values equal, 
					 * then it is the same value
					 */
					if(j == i)
						continue;
					
					String team2 = teamList.get(j);
					teamString += " " + team;
					
					/*
					 * if the team name equals at this point, then they
					 * are confirmed different people and on the same team
					 */
					if(team2.equals(team))
					{
						teamFinalList.add(team);
						teamInitialWeight.add(initialWeight.get(i)+initialWeight.get(j));	
						teamFinalWeight.add(finalWeight.get(j) + finalWeight.get(i));
						break;
					}
				}
			}
			
			for(int i = 0; i < teamFinalList.size(); i++)
			{
				Double ans = (((teamInitialWeight.get(i) - teamFinalWeight.get(i)) * 100.0) / teamInitialWeight.get(i)) *10.0;
				
				/*
				 * if the highestTeam is not intialized, 
				 * this is the first pass
				 */
				if(highestTeam.equals(""))
				{
					highestTeam = teamFinalList.get(i);
					highestPercent = ans;
				}
				/*
				 * if this answer is higher then the current 
				 * highest percent, change the current highest
				 * team and percent 
				 */
				else if(ans > highestPercent)
				{
					highestTeam = teamFinalList.get(i);
					highestPercent = ans;
				}
				/*
				 * Heres were things get ugly. 
				 * If there are two percents in the list
				 * that equal, we need the team that comes
				 * first alphabetically
				 */
				else if(ans == highestPercent)
				{
					/*
					 * take the current highest team and
					 * add them and the current team being
					 * checked to the tiedTeam list
					 */
					tiedTeamList.add(teamFinalList.get(i));
					tiedTeamList.add(highestTeam);
					
					/*
					 * sort the tied list to determine
					 * the highest team
					 */
					Collections.sort(tiedTeamList);
					/*
					 * the first value in a sorted array is 
					 * the highest alphabetically, so use 
					 * that teams values and clear the list
					 */
					highestTeam = tiedTeamList.get(0);
					highestPercent = ans;
					tiedTeamList.clear();
				}
			}
			/*
			 * this is it for this data set, 
			 * so add the current highest team and round
			 * out off the current highest percent
			 */
			answerTeamList.add(highestTeam);
			answerPercentList.add((double)Math.round(highestPercent)/10);
		}
		
		for(int i = 0; i < answerPercentList.size(); i++)
		{
			System.out.println(answerTeamList.get(i) + " " + answerPercentList.get(i) + "%");
		}
	}
}
