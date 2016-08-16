import java.text.DecimalFormat;
import java.util.*;

public class NFL_Quarterback_Ranking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String next;
		ArrayList arrayList = new ArrayList();
		
			String name = in.nextLine();
			DecimalFormat fourDecimal = new DecimalFormat("#.####");
			double passesAttempted = Double.valueOf(in.nextLine());
			double passesCompleted = Double.valueOf(in.nextLine());
			
			double totalYards = Double.valueOf(in.nextLine());
			double touchdownPass = Double.valueOf(in.nextLine());
			double intercept = Double.valueOf(in.nextLine());
			
			double completePercent = ((((passesCompleted/passesAttempted)*100) - 30) *.05);
			if(completePercent < 0)
			{
				completePercent = 0;
			}
			else if (completePercent > 2.375)
			{
				completePercent = 2.375;
			}
			double yardsGained = (((totalYards/passesAttempted)-3)*.25);
			if(yardsGained < 0)
			{
				yardsGained = 0;
			}
			else if (yardsGained > 2.375)
			{
				yardsGained = 2.375;
			}
			double touchdownPasses = (((touchdownPass/passesAttempted)*100)*.2);
			if (touchdownPasses > 2.375)
			{
				touchdownPasses = 2.375;
			}
			
			double noInterceptions = 2.375-(((intercept/passesAttempted)*100)*.25);
			
			if(noInterceptions < 0)
			{
				noInterceptions = 0;
			}
			
			double rating = (((completePercent + yardsGained + touchdownPasses + noInterceptions)/6)*100);
			System.out.println(name + ": " + Double.valueOf(fourDecimal.format(rating)));

	}

}
