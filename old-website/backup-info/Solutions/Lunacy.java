import java.text.DecimalFormat;
import java.util.*;

public class Lunacy {

	static ArrayList<String> answerList = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DecimalFormat twoDecimal = new DecimalFormat("#.##");
		
		while(in.hasNext())
		{
			double next = in.nextDouble();
			if(next == -1.0)
				break;
			
			/**
			 * twoDecimal.format(average) formats the decimal to the appropriate decimal point
			 * Double.valueOf() converts the Double object returned to a double value
			 * String.format(format, value) ensures that two decimal places will always be printed
			 * 	equally, "%.3f" ensures three decimal places, ect.
			 */
			
			answerList.add("Objects weighing " + String.format("%.2f", next) + " on Earth will weight " +
							String.format("%.2f", Double.valueOf(twoDecimal.format(next * 0.167))) + 
							" on the moon.");
			
		}
		
		for(String ans : answerList)
			System.out.println(ans);

	}

}
