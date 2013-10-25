import java.util.Scanner;


public class stuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int thing=0;
		Scanner keyboard= new Scanner (System.in);
		
		while (thing >=0){
			System.out.println("type a thing you will get rid of me by typing a number less than 0");
			thing = keyboard.nextInt();
			System.out.println("you typed \n\n" + thing);
			
		}
		System.out.println("i'm done.");
	}

}
