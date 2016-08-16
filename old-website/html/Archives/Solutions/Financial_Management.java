import java.text.DecimalFormat;
import java.util.*;
	
public class Financial_Management {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		double statements = 0;
		DecimalFormat twoDecimal = new DecimalFormat("#.##");
		for(int i = 0; i < 12; i++)
		{
			statements += in.nextDouble();
		}
		
		double average = statements/12.0;
		
		/**
		 * twoDecimal.format(average) formats the decimal to the appropriate decimal point
		 * Double.valueOf() converts the Double object returned to a double value
		 * String.format(format, value) ensures that two decimal places will always be printed
		 * 	equally, "%.3f" ensures three decimal places, ect.
		 */
		System.out.println("$" + String.format("%.2f", Double.valueOf(twoDecimal.format(average))));
			
	}

}
