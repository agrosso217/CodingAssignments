import java.util.Random;
import java.util.Scanner;
public class RandomNumberGame 
{
	public static void main(String[] args) 
	{
		 System.out.println("Welcome to the Random Number Game!");
		 
		 randomGame();
		 int playAgain = 1;
		 
		 while (playAgain == 1)
		 {
			 playAgain = getAnInt("Do you want to play the game again? (0 = No or 1 = Yes): ");
			 if (playAgain == 1)
			 {
				 randomGame();
			 }
			 else if (playAgain == 0)
			 {
				 System.out.println("Thank you for playing and have a nice day!");
				 playAgain = 0;
			 }
		 }
	}
	
	static void randomGame()
	{
		int attempts = 0;
		int guessedNumber;
		boolean win = false;
		Scanner myScanner = new Scanner(System.in);
		Random random = new Random();
		 
		int maximum = getAnInt("Enter the MAXIMUM random number (Integers Only!): ");
		int[] amountOfNumbers = new int [maximum + 1];
		 
		int randomNumber = random.nextInt(maximum + 1);
		 
		while (win == false)
		{
			guessedNumber = getAnInt("Please guess the random number (Integers Only!): ");
			 
			if (guessedNumber > randomNumber)
			{
				amountOfNumbers[attempts] = guessedNumber;
				System.out.println("***Too High***");
				attempts++;
			} 
			else if (guessedNumber < randomNumber)
			{
				amountOfNumbers[attempts] = guessedNumber;
				System.out.println("***Too Low***");
			    attempts++;
			}
			else if (guessedNumber == randomNumber)
			{
				System.out.println("***Correct***");
				win = true;
			}
		}
		System.out.println("It took you " + (attempts + 1) + " to guess the correct number!");
		System.out.print("Your incorrect guesses were: " + amountOfNumbers[0]);
		for (int i = 1; i < attempts; i++)
		{
			System.out.print(", " + amountOfNumbers[i]);
		}
		System.out.println();
	}
	
	static int getAnInt(String numberPrompt)
	{
		int enteredNumber = 0;
		Scanner myScanner = new Scanner(System.in);
		boolean numberError = false;
		String enteredString = "";
		do 
		 {
			try 
			{
				System.out.print(numberPrompt);
				enteredString = myScanner.next();
				enteredNumber = Integer.parseInt(enteredString.trim());
				numberError = false;  //if we haven't bailed out, then the number must be valid.
			}
				catch(Exception e) 
				{
					System.out.println("Your entry: \"" + enteredString + "\" is invalid...Please try again: ");
					numberError = true;  //Uh-Oh...We have a problem.
				}
		 }
		 while (numberError == true ); //Keep asking the user until the correct number is entered.
		 return enteredNumber;
	}
}
