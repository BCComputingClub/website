import java.util.*;

public class Mirror_Mirror {

	static ArrayList<String> answerList = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			String next = in.nextLine();
			
			if(next.equals("***"))
				break;
			/*
			 * Using StringBuffer as it has a reverse() function
			 */
			
			StringBuffer ans = new StringBuffer(next);
			answerList.add(ans.reverse().toString());
		}
		
		for(String ans : answerList)
			System.out.println(ans);

	}

}
