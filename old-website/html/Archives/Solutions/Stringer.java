import java.util.*;

public class Stringer {

	static ArrayList<String> tempList = new ArrayList<String>();
	static String charArray = "";
	static char[] charArray2 = {};
	static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	static ArrayList<String> answerList = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext())
		{
			tempList.clear();
			charArray = "";
			String temp3 = in.nextLine();
			String[] temp4 = temp3.split(" "); 
			
			int alpha = Integer.valueOf(temp4[0]);
			
			int index = Integer.valueOf(temp4[1]);
			
			// break if the input is only 0s
			if(index == 0 && alpha == 0)
			{
				break;
			}
			
			// take in the entire line and split it for use
			String temp = in.nextLine();
			String[] temp1 = temp.split(" "); 
			
			//while the temp1 still has values, we still need to add 
			//values to the string
			for(int j = 0; j < temp1.length; j++)
			{
				//continue to add values to the string equal
				//to the number of of letters needed
				for(int i = 0; i < Integer.valueOf(temp1[j]); i++)
				{
					charArray += String.valueOf(alphabet[j]);
				}
			}
			permuteString("", charArray, index);
			
			//Since all permutations were stored in tempList, 
			//and the loop broke once we hit the specified index,
			//we can simply extract the last value in the list 
			//as the answer.
			answerList.add((tempList.get(tempList.size()-1)));
		}
		
		//after all input is parsed, output the stored answers.
		for(int i = 0; i < answerList.size(); i++)
		{
			System.out.println(answerList.get(i));
		}
	}
	
	// calculates all the permutations of the input string
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

	          //the problem explicitly states that M could be too large to compute
	          //all possible values, thus we should check if the tempList is larger
	          //then the needed index, break the loop
	          if(tempList.size() > index)
	        	  return;
	          permuteString(beginningString + endingString.charAt(i), newString, index);
	        } catch (StringIndexOutOfBoundsException exception) {
	          exception.printStackTrace();
	        }
	      }
	}

}
