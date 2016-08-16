import java.util.*;

public class Palindrometer {

	static ArrayList<Integer> answerList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext())
		{
			String temp = in.next();
			/*
			 * Need to remember the original size
			 * to concatenate the leading zeros
			 */
			int size = temp.length();
			
			int od = Integer.valueOf(temp);
			
			
			if(od == 0)
			{
				break;
			}
			int count = 0;
			
			while(!isPal(String.valueOf(od),size))
			{
				/*
				 * continually add 1 to the od reading
				 * while tracking the number of new miles
				 * with count.
				 */
				od++;
				count++;
			}
			answerList.add(count);
		}
		
		for(int ans : answerList)
		{
			System.out.println(ans);
		}

	}
	
	static public boolean isPal(String od, int length)
	{
		/*
		 * Need to convert the integer to a string, 
		 * but it needs the leading zeros to check
		 * for a palindrome. 
		 */
		while(od.length() < length)
			od = "0" + od;
		
		StringBuffer temp = new StringBuffer(od);
		StringBuffer temp1 = new StringBuffer(od);
		
		System.out.println(od);
		
		temp = temp.reverse();
		
		return temp.toString().equals(temp1.toString());
		
	}

}
