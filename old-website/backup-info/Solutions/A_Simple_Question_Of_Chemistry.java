import java.text.DecimalFormat;
import java.util.*;

public class A_Simple_Question_Of_Chemistry {

	static ArrayList<Double> input = new ArrayList<Double>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DecimalFormat twoDecimal = new DecimalFormat("0.00");
		while(in.hasNext())
		{
			double temp = in.nextDouble();
			if(temp == 999)
			{
				input.add(temp);
				break;
			}
			input.add(temp);
		}
		
		for(int i = 0; i < input.size(); i++)
		{
			if(input.get(i+1) == 999)
			{
				System.out.println("End of Output");
				break;
			}
			System.out.println(String.format("%.2f", Double.valueOf(twoDecimal.format(input.get(i+1) - input.get(i)))));
		}

	}

}
