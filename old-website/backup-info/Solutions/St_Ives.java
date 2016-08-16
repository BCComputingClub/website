import java.text.DecimalFormat;
import java.util.*;

public class St_Ives {

	static ArrayList<Double> answerList = new ArrayList<Double>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DecimalFormat twoDecimal = new DecimalFormat("0.00");
		
		while(in.hasNext())
		{
			double next = in.nextDouble();
			
			if(next == 0)
				break;
			
			double ans = 1 + (next) + (next*next) + (next*next*next) + (next*next*next*next);
			
			answerList.add(Double.valueOf(twoDecimal.format(ans)));
		}
		
		for(Double ans : answerList)
		{
			System.out.println(String.format("%.2f", ans));
		}

	}

}
