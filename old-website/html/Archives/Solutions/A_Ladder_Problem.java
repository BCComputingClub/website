import java.util.*;

public class A_Ladder_Problem {

	static ArrayList<String> tempList = new ArrayList<String>();
	static String[] numbers = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			tempList.clear();
			String permute = "";
			String temp3 = in.nextLine();
			String[] temp1 = temp3.split(" "); 
			
			int rungs = Integer.valueOf(temp1[0]);
			
			int step = Integer.valueOf(temp1[1]);
			
			// break if the input is only 0s
			if(rungs == 0 && step == 0)
			{
				break;
			}
			
			
			for(int j = 0; j < temp1.length; j++)
			{
				//continue to add values to the string equal
				//to the number of of letters needed
				for(int i = 0; i < Integer.valueOf(temp1[j]); i++)
				{
					permute += String.valueOf(numbers[j]);
				}
			}
			permuteString("", permute, 1);
		}
			
	}

	public static void permuteString(String beginningString, String endingString, int index) {
	    if (endingString.length() <= 1)
	    {
	    	tempList.add(beginningString + endingString);
	    	
	    	//The problem does not take into account duplicated values
	    	//Thus, convert the list to a set to eliminate any duplicate 
	    	Set<String> hs = new LinkedHashSet<String>(tempList);
			tempList.clear();
			tempList.addAll(hs);
	    }
	    else
	      for (int i = 0; i < endingString.length(); i++) {
	        try {
	          String newString = endingString.substring(0, i) + endingString.substring(i + 1);
	          permuteString(beginningString + endingString.charAt(i), newString, index);
	        } catch (StringIndexOutOfBoundsException exception) {
	          exception.printStackTrace();
	        }
	      }
	}
}
