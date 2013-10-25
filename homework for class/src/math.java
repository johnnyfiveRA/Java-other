import java.util.Scanner;

public class math {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int u = 2;
		int v = 3;
		int w = 5;
		int x = 7;
		int y = 11;
		
		int result1, result2;
		
		result1 = u + v * w + x;
		result2 = u + y % v * w + x;
		
		assert result1 == result2;
		
		System.out.println("results were " + result1 + " for question 1 and " + result2 + " for number 2");
		
		// code snippet for homework
		
		int testscore;
		Scanner keyboard=new Scanner(System.in);
		boolean val=true;
		
		while (val)
		{
			System.out.println("Please enter a test score so I can test them. Be careful an invalid one will end me.");
			testscore=keyboard.nextInt();
			
			if (testscore >= 0 && testscore <= 100)
			{
			System.out.println("This is a valid test score");
		}
		else {
			System.out.println("Test Score is not valid");
			val=false;
		}
		}
	}

}
