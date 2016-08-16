import java.util.*;

public class Line_of_Sight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		ArrayList<Double> answerList = new ArrayList<Double>();
		while(in.hasNext())
		{
			double w1 = in.nextDouble();
			double h1 = in.nextDouble();
			double w2 = in.nextDouble();
			double h2 = in.nextDouble();
			double x = in.nextDouble();
			double y = in.nextDouble();
			
			double m1 = ((y+ (h2/2.0))/(x-(w2/2.0)));
			m1 = Math.round(m1 * 10.0)/10.0;
			double m2 = ((y+ (h2/2.0))/(x+(w2/2.0)-w1));
			m2 = Math.round(m2 * 10.0)/10.0;
			double height = w1/(1/m1-1/m2)-(y+h2/2);
			height = Math.round(height * 10.0)/10.0;
			double a = .5*(w2)*(height);
			a = Math.round(a * 10.0)/10.0;
			
			answerList.add(Math.round((a/(w1*h1)*100.0) * 10.0)/10.0);
		}
		for(Double doub : answerList)
			System.out.println(doub);
		
		
	}

}
