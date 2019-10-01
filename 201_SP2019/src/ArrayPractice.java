import java.util.Scanner;
public class ArrayPractice
{
	public static void main(String[] args) 
	{
		 int amount = getAnInt("Enter the amount of numbers you want to check: ");
		 int[] amountOfNumbers = new int [amount];
		 int total = 0;
		 for (int count = 0; count < amountOfNumbers.length; count++)
		{
			amountOfNumbers[count] = getAnInt("Enter the integer value for Number " + (count + 1) + ": ");
			total = total + amountOfNumbers[count];
			 
		}
		 System.out.println("The sum of the total amount of numbers is: " + total);
		 System.out.println("The average amount of the total numbers is: " + (total / amountOfNumbers.length));
		
	}
	
	static int getAnInt(String prompt)
	{
		int enteredNumber = 0;
		Scanner myScanner = new Scanner(System.in);
		boolean numberError = false;
		String enteredString = "";
		do 
		 {
			try 
			{
				System.out.print(prompt);
				enteredString = myScanner.next();
				enteredNumber = Integer.parseInt(enteredString.trim());
				System.out.println();
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