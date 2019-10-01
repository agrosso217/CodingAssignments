import java.util.*;

public class MultiRandomGame {
  
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
	
	public static void randomGame()
	{
		int j = 1;
		boolean b = true;
		Scanner scanner = new Scanner(System.in);
		
		int amountOfPlayers = getAnInt("Enter the amount of players for this game: ");
		int players[] = new int[amountOfPlayers]; 
	
		String playerName[] = new String [amountOfPlayers];
		for (int i = 0; i < amountOfPlayers; i++) 
        {
            System.out.println("Player " + (i + 1) + ", what is your name?:");
        	playerName[i] = scanner.nextLine();
        }
		
		int correctOrWrong[] = new int[amountOfPlayers];
		int numberOfGuesses[] = new int[amountOfPlayers];
		for(int i = 0; i < amountOfPlayers; i++)
		{
			Random random = new Random();
			int minValue = getAnInt(playerName[i] + ", enter the minimum possible value for the random number (INTEGERS ONLY): ");
			boolean maxMin = true;
			while (maxMin == true)
			{
				int maxValue = getAnInt(playerName[i] + ", enter the maximum possible value for the random number (INTEGERS ONLY): ");
				if (maxValue <= minValue) 
				{
					System.out.println("The maximum value can not be lower than the minimum value!");
				} else 
				{
					maxMin = false;	
					players[i] = random.nextInt(maxValue - minValue) + minValue;
				}
			}
			correctOrWrong[i] = 0;
			numberOfGuesses[i] = 0;
		}

		int guess[] = new int[amountOfPlayers];
		while (b) 
		{
			System.out.println("Round #" + j);
			for(int i = 0; i < amountOfPlayers; i++)
			{
				if(correctOrWrong[i] == 0)
				{
					guess[i] = getAnInt(playerName[i] + ", guess your number: ");
					correctOrWrong[i] = play(guess[i], players[i]);
					numberOfGuesses[i]++;

				}
				b = false;
			}
			j++;
		
			for(int i = 0; i < amountOfPlayers; i++)
			{
				if(correctOrWrong[i] != 1)
					b=true;
			}
		}
	
		int number[] = new int[amountOfPlayers];
		for(int i = 0; i < amountOfPlayers; i++)
		{
			number[i] = numberOfGuesses[i];
		}
		
		for(int i = 0; i < amountOfPlayers; i++)
		{
			for(int k = i; k < amountOfPlayers; k++)
			{
				if(number[i] > number[k])
				{
					int tmp = number[i];
					number[i] = number[k];
					number[k] = tmp;
				}
			}
		}
		
		int rank[] = new int[amountOfPlayers];
		for(int i = 0; i < amountOfPlayers; i++)
		{
			for(int k = 0; k < amountOfPlayers; k++)
			{
				if(numberOfGuesses[i] == number[k])
					rank[i] = k + 1;
			}
		}
  
		System.out.println("Player: Number of Guesses:");
		for(int i = 0; i < amountOfPlayers; i++)
		{
			System.out.println(playerName[i] + "\t" + numberOfGuesses[i]);  
		}
	}
	
	public static int play(int guess, int no)
	{
		if(guess == no)
		{
			System.out.println("***Correct***");
			return 1;
		}
		else
		{
			if(guess > no)
			{
				System.out.println("***Too High***");
				return 0;
			}
			else
			{
				System.out.println("***Too Low***");
				return 0;
			}
		}
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
				if (enteredNumber < 0)
                {
                    System.out.println("You have entered a negative number!");
                    numberError =  true;
                }
                else
                    numberError = false;
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
