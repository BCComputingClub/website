import java.util.*;

public class Parlay_Wagering {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ArrayList<Double> answerList = new ArrayList<Double>();
		Scanner in = new Scanner(System.in);
		
		int totalSets = in.nextInt();
			
		for(int i = 0; i < totalSets; i++)
		{
			double bet = in.nextDouble();
			int wagers = in.nextInt();
				for(int j = 0; j < wagers; j++)
				{
					double wager = in.nextDouble();
					String type = in.next();
					
					if(type.toLowerCase().equals("win"))
					{
						if(wager < 0)
						{
							wager = Math.abs(wager);
							int value = (int)((100.0/wager) * 1000.0);
							double value2 = value/1000.0;
							bet = bet+(bet*value2);
							int value3 = (int)(bet * 100);
							bet = (double)(value3/100.0);
							
						}
						else
						{
							int value = (int)((wager/100.0) * 1000.0);
							double value2 = value/1000.0;
							bet = bet+ (bet*value2);
							int value3 = (int)(bet * 100);
							bet = (double)(value3/100.0);
						}
					}
					if(type.toLowerCase().equals("loss"))
					{
						bet = 0;
						break;
					}
					if(type.toLowerCase().equals("tie"))
					{
						continue;
					}
					
				}
				answerList.add(bet);
		}
		System.out.print("\n");
		for(Double doub : answerList)
		{
			System.out.println("$" + doub);
		
		}

	}

}
