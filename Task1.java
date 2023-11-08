import java.util.Random;
import java.util.Scanner;

class GuessGame
{
	int tries=0;
	
	public void generateNumber()
	{
		Random rand=new Random();
		int randomNum=rand.nextInt(100);
		
		guess(randomNum);
	}
	
	public void guess(int randomNum) 
	{ Scanner sc=new Scanner(System.in);
	
		System.out.println("  ***** GUESS THE NUMBER *****");
		System.out.println(" ");
		System.out.println("    Guess Number between 1-100");
		
		int guess=sc.nextInt();
		
			while(guess<0 || guess>100)
			{
				System.out.println(" Guess Number Between 1-100");
				guess=sc.nextInt();
			}
		while(guess!=randomNum)
		{
			tries++;
			if(guess<randomNum)
			{
				
				System.out.println("Too Low");
				System.out.println(" ");
				System.out.println("Guess Again!!!");
				guess=sc.nextInt();
				while(guess<0 || guess>100)
				{
					System.out.println(" Guess Number Between 1-100");
					guess=sc.nextInt();
				}
			}
			else if(guess>randomNum)
			{
				
				System.out.println("Too High");
				System.out.println(" ");
				System.out.println("Guess Again!!!");
				guess=sc.nextInt();
				while(guess<0 || guess>100)
				{
					System.out.println(" Guess Number Between 1-100");
					guess=sc.nextInt();
				}
			}
		}
		
		System.out.println("🎉🎉🎉 Yeahhh!!! You Won!!! 🎉🎉🎉");
		System.out.println("Number of Tries "+ tries);
		System.out.println(" ");
		System.out.println(" You want to play again or exit");
		System.out.println(" Press 1 for play again || press 0 to exit");
		int choice=sc.nextInt();
		if(choice==1)
		{
			generateNumber();
		}
		else {
			System.exit(choice);
		}
	}

}




public class Task1
{
  public static void main(String[] args) 
  {
	GuessGame g=new GuessGame();
	g.generateNumber();
  }
}
