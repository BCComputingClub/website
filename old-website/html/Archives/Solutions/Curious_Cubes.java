import java.util.*;

public class Curious_Cubes {

	static ArrayList<Integer> answerList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext())
		{
			int next = in.nextInt();
			
			if(next == -1)
				break;
			///The root of any number x can be re-written as 
			/// x^(1/k) where k == the root
			
			/// This problem also states to truncate the number,
			/// hence the cast to int. 
			answerList.add((int)(Math.pow(next, (1.0/3.0))));
		}
		
		for(int ans : answerList)
			System.out.println(ans);

	}

}
