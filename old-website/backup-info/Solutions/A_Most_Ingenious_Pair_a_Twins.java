import java.util.ArrayList;
import java.util.Scanner;

public class A_Most_Ingenious_Pair_a_Twins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> answerList = new ArrayList<String>();
		
		while(in.hasNext())
		{
			Double te = in.nextDouble();
			Double tr = in.nextDouble();
			
			if(tr == 0 && te == 0)
				break;
			
			double answer = Math.sqrt( 1 - ((tr/te) * (tr/te)) );
			double answer2 = Math.round(answer*1000.0)/1000.0;
			String answer3 = String.valueOf(answer2);
			
			// ensure each output has 3 decimal places
			while(answer3.length() < 5)
			{
				answer3 += "0";
			}
			answerList.add(answer3);
			
		}
		for(String ans : answerList)
			System.out.println(ans);
	}

}