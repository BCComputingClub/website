import java.util.*;

public class Not_One_Bit_More {

	static ArrayList<Integer> answerList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext())
		{
			int Lo = in.nextInt();
			int Hi = in.nextInt();
			int x = in.nextInt();
			
			int ans = 0;
			
			if(Lo == 0 && Hi == 0 && x == 0)
				break;
			if(x == 0)
			{
				answerList.add(ans);
				break;
			}
			
			for(int i=Lo; i <= Hi; i++)
			{
				int k = 0;
				//System.out.println(i);
				if(i == 1)
					continue;
				
				for(int j = Integer.bitCount(i); j >= 1; j = Integer.bitCount(j))
				{
					k++;
					if(j == 1)
					{
						break;
					}
				}
				if(k == x)
				{
					ans++;
					//System.out.println("ans " + ans);
				}
				if(Lo == Hi)
				{
					break;
				}
			}
			answerList.add(ans);
		}
		
		for(int i : answerList)
		{
			System.out.println(i);
		}

	}

}
