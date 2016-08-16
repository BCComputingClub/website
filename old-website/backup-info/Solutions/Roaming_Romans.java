import java.text.DecimalFormat;
import java.util.*;

public class Roaming_Romans {

	static ArrayList<String> answerList = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DecimalFormat twoDecimal = new DecimalFormat("0.00");
		DecimalFormat threeDecimal = new DecimalFormat("#.###");
		float k = (float) (5280.0/4854.0);
		
		while(in.hasNext())
		{
			Double miles = in.nextDouble();
			if(miles == 0.0)
				break;
			
			double i = miles * k;
			miles = Double.valueOf(twoDecimal.format(miles));
			
			double romans = Double.valueOf(twoDecimal.format(i));
			double temp = Double.valueOf(threeDecimal.format(i));
			
			int paces = (int) (temp*1000);

			
			String answer = String.format("%.2f", miles) + " English miles equals " + romans + " Roman miles or " + paces + " paces.";
			
			answerList.add(answer);
			
		}
		
		for(String ans : answerList)
			System.out.println(ans);

	}

}
