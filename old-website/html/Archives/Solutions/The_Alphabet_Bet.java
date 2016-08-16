import java.text.DecimalFormat;
import java.util.*;

public class The_Alphabet_Bet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		DecimalFormat fourDecimal = new DecimalFormat("#.####");
		int loop = in.nextInt();
		
		float vowlCount = 0;
		float totalCount = 0;
		
		for(int i = 0; i < loop; i++)
		{
			String next = in.next().toLowerCase();
			
			char[] charArray = next.toCharArray();
			for(int j = 0; j < charArray.length; j++)
			{
				if(charArray[j] == 'a' || charArray[j] == 'e' ||
						charArray[j] == 'i' || charArray[j] == 'o'
						|| charArray[j] == 'u')
				{
					vowlCount++;
				}
				totalCount++;
				}
			}
		
		System.out.println((int)vowlCount);
		System.out.println((int)totalCount);
		System.out.println(Double.valueOf(fourDecimal.format(vowlCount/totalCount)));
		if(vowlCount/totalCount > 0.1923)
		{
			System.out.println("Ann wins!");
		}
		else
		{
			System.out.println("Bill wins!");
		}

	}

}
