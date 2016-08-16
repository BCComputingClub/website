import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;

public class Distance_Force {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int next;

		/*
		 * Array list to hold the answers to each
		 * data set. Iterate and print after parsing.
		 */
		ArrayList<Double>answer = new ArrayList<Double>();
		
		while(in.hasNext())
		{
			ArrayList<Point> pointList = new ArrayList<Point>();
			ArrayList<Double> answerList = new ArrayList<Double>();
			
			next = in.nextInt();
			
			/*
			 * break at designated EOF
			 */
			if(next == 0)
			{
				break;
			}
			
			/*
			 * Java.awt.Point take an X and Y integer value.
			 */
			for(int i = 0; i < next; i++)
				pointList.add(new Point(in.nextInt(), in.nextInt()));
			
			
			
			Point vertex = pointList.get(pointList.size()-1);
			
			Point adjacent = new Point(0,0); 
			
			Point tempPoint = new Point(0,0);
			
			/*
			 * Decrementing for loop.  
			 * This allows the collection being looped through to be modified (values added/removed) 
			 * without crashing the loop!
			 */
			for(int i = pointList.size()-1; i >= 0; i--)
			{
				/*
				 * Initialize a minimum distance to it's MAX VALUE, 
				 * any distance found SHOULD (almost must) be shorter then this.
				 */
				double minDistance = Double.MAX_VALUE;
				
				for(int j = pointList.size()-1; j >= 0; j--)
				{
					adjacent = pointList.get(j);
					
					/*
					 * if the current adjacent == the current vertex, the distance will be 0.
					 */
					if(vertex == adjacent)
						continue;
					/*
					 * Distance formula:
					 * Root((x2-x1)^2 + (y2-y1)^2)
					 * check the distance between this point and every other point in the list.
					 */
					if(minDistance > (double)Math.sqrt((((adjacent.x - vertex.x)*(adjacent.x - vertex.x)) + ((adjacent.y - vertex.y)*(adjacent.y - vertex.y)))))
					{
						tempPoint = adjacent;
						minDistance = (double)Math.sqrt((((adjacent.x - vertex.x)*(adjacent.x - vertex.x)) + ((adjacent.y - vertex.y)*(adjacent.y - vertex.y))));
					}
				}
				/*
				 * add the smallest path found to the local answer list
				 */
				if(minDistance!=Double.MAX_VALUE)
					answerList.add(minDistance);
				/*
				 * The shortest distance between the current point and another point 
				 * has been found, so remove the current point from the list.
				 * This guarantees no replicated points or paths.
				 */
				pointList.remove(vertex);
				/*
				 * Make the closest adjacent point the new vertex, and start over.
				 */
				vertex = tempPoint;
				if(pointList.size() <= 1)
					break;
			}
			
			double dis = 0.0;
			
			/*
			 * for-each loop syntax
			 * add up all the values in this sets answerList and add the final 
			 * Result to the answer array.
			 */
			for(Double doub : answerList)
				dis+=doub;
			answer.add(dis);

			/*
			 * End. Start parsing the new data set
			 */
		}
		
		/*
		 * print out the answers in order. For-each loops start at index 0.
		 * Round to 2 decimal places (100 = .00, 1000 = .000, ect)
		 * (both decimal values must be the same, as in not (*100)/10)
		 */
		for(Double doub : answer)
			System.out.println((double)Math.round(doub*100)/100);
	}

}
