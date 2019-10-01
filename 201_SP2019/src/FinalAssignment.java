import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class FinalAssignment
{
   public static void main (String args[]) throws IOException
   {
	   System.out.println("Welcome to the Random Number Game!");
	   Scanner scanner = new Scanner(System.in);
		
	   int amountOfPlayers = getAnInt("Enter the amount of players for this game: ");
	   int players[] = new int[amountOfPlayers]; 
	   String playerName[] = new String [amountOfPlayers];
	   for (int i = 0; i < amountOfPlayers; i++) 
	   {
		   System.out.println("Player " + (i + 1) + ", what is your name?:");
		   playerName[i] = scanner.nextLine();
	   }	   
	   int randomNumArr[] = new int [amountOfPlayers];
       Random rand = new Random();
       int roundNumber = 1;

       boolean playAgain = true;
       while (playAgain)
       {
           for (int i = 0; i < amountOfPlayers; i++)
           {
        	   int minValue = getAnInt(playerName[i] + ", enter the minimum possible value for the random number (INTEGERS ONLY): ");
        	   boolean maxMin = true;
        	   while (maxMin == true)
        	   {
        		   int maxValue = getAnInt(playerName[i] + ", enter the maximum possible value for the random number (INTEGERS ONLY): ");
        		   if (maxValue <= minValue) 
        		   {
        			   System.out.println("The maximum value can not be lower than the minimum value!");
        		   } 
        		   else 
        		   {
        			   maxMin = false;	
        			   randomNumArr[i] = rand.nextInt((maxValue - minValue) + 1) + minValue;
        		   }
        	   }
           }
           ArrayList<Integer> incorrectGuesses[] = new ArrayList[amountOfPlayers];
           for(int i = 0; i < amountOfPlayers; i++)
           {
               	incorrectGuesses[i] = new ArrayList<Integer>();
           }

           boolean guessedCorrect[] = new boolean [amountOfPlayers];
           int totalCorrectGuesses = 0;
                  
           while (totalCorrectGuesses != amountOfPlayers)
           {
        	   for (int i=0; i< amountOfPlayers; i++)
               {
        		   if (!guessedCorrect[i])
                   {
        			   int guess = getAnInt(playerName[i] + ", guess your number: ");
                       if (guess != randomNumArr[i])
                       {
                    	   incorrectGuesses[i].add(guess);
                           if (guess > randomNumArr[i])
                        	   System.out.println("***Too High***");
                               else
                            	   System.out.println("***Too Low***");
                       }                          
                       else
                       {
                    	   System.out.println("CORRECT!");
                           guessedCorrect[i] = true;
                           totalCorrectGuesses++;
                       	}                                                     
                   }                  
               }
           }
                    
            for (int i=0; i<amountOfPlayers; i++)
            	players[i] = i + 1;
            for (int i=0; i<amountOfPlayers-1; i++)
            {
                for (int j=i+1; j<amountOfPlayers; j++)
                {
                	if (incorrectGuesses[i].size() > incorrectGuesses[j].size())
                    {
                		ArrayList<Integer> temp = incorrectGuesses[i];
                        int temp2 = players[i];
                              
                        incorrectGuesses[i] = incorrectGuesses[j];
                        players[i] = players[j];
                              
                        incorrectGuesses[j] = temp;
                        players[j] = temp2;
                    }
                }
            }
            
            System.out.println("Ranking:");
            for (int i = 0; i < amountOfPlayers; i++)
            	{
                	System.out.println("\n#" + (i+1) + ": " + playerName[i]);
                    System.out.println("No. of guesses: " + (incorrectGuesses[i].size()+1));
                    System.out.print("Incorrect guesses: ");
                    for (int j = 0; j < incorrectGuesses[i].size(); j++)
                    {
                    	if (j == (incorrectGuesses[i].size() - 1))
                    	{
                    		System.out.print(incorrectGuesses[i].get(j));
                    	}
                    	else
                    	System.out.print(incorrectGuesses[i].get(j) + ", ");
                    }
                    System.out.println();
            	}

    		try 
    		{
    			File outfile = new File("C:\\\\Users\\\\Applejuice217\\\\Desktop\\\\Intro Comp\\\\Round#" + roundNumber);
    			// if file doesnt exists, then create it
    			if (!outfile.exists()) 
    			{
    				outfile.createNewFile();
    			}
    			FileWriter fw = new FileWriter(outfile.getAbsoluteFile());
    			BufferedWriter bw = new BufferedWriter(fw);
    			bw.write("This is the LOG FILE for Round #" + roundNumber);
    			bw.newLine();
    			bw.write("The magic numbers this round were: ");
    			for (int i = 0; i < randomNumArr.length; i++)
    			{
    				if (i == (randomNumArr.length - 1))
                	{
    					bw.write(String.valueOf(randomNumArr[i]));
                	}
                	else
                		bw.write((String.valueOf(randomNumArr[i])) + ", ");
    			}
    			for (int i = 0; i < amountOfPlayers; i++)
            	{
    				bw.newLine();
    				bw.write(playerName[i] + " came in Place #" + (i+1) + " and won this round with " + (String.valueOf(incorrectGuesses[i].size()+1)) + " guesses.");
    				bw.newLine();
    				bw.write(playerName[i] + "'s incorrect guesses were: ");
                    for (int j = 0; j < incorrectGuesses[i].size(); j++)
                    {
                    	if (j == (incorrectGuesses[i].size() - 1))
                    	{
                    		bw.write(String.valueOf(incorrectGuesses[i].get(j)));
                    	}
                    	else
                    		bw.write(String.valueOf(incorrectGuesses[i].get(j) + ", "));
                    }
                    bw.newLine();
                    bw.newLine();
                    bw.flush();
            	}
    			roundNumber++;
    			bw.close();
    		} 
    		catch (IOException e) 
    		{
    				e.printStackTrace();
    		} 
    		
            boolean inputValid = false;
            while (!inputValid)
            {
            	System.out.println("Play again? (yes/no)");
                String playAgainStr = scanner.next();
                if (playAgainStr.equalsIgnoreCase("no") || playAgainStr.equalsIgnoreCase("n"))
                {
                	playAgain = false;
                    inputValid = true;
                    System.out.println("Have a nice day!");
                }                          
                else if (playAgainStr.equalsIgnoreCase("yes") || playAgainStr.equalsIgnoreCase("y"))
                	inputValid = true;
                else
                	System.out.println("Invalid input! Try again.");
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

