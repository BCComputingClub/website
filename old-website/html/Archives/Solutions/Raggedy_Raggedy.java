import java.util.*;

public class Raggedy_Raggedy {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		ArrayList<String> inputList = new ArrayList<String>();
		ArrayList<Integer> lineCountList = new ArrayList<Integer>();
		
		int raggedy = 0;
		String breakLine = "";
		
		while(in.hasNext())
		{
			/// get first integer value;
			raggedy = in.nextInt(); 
			
			// end input
			if(raggedy == 0)
				break;
			
			// start data set
			while(in.hasNext())
			{
				String line = in.nextLine();
				
				//if the line is empty, break out of this while loop
				if(line.isEmpty())
				{
					break;
				}
				
				inputList.add(line);
			}
			
			// count each line
			for(String string : inputList)
			{
				String[] temp = string.split(" ");
				lineCountList.add(temp.length);
			}
			boolean fixed = false;
			
			
		}
		
		
	}

}
