import java.util.Scanner;
public class ScannerTryCatch
{
	public static void main(String[] args) 
	{
		 System.out.print("Enter the amount of numbers you want to check: ");
		 Scanner myScanner = new Scanner(System.in);
		 int amount = myScanner.nextInt();
		for (int count = 0; count < amount; count++)
		{
		   int x = checkNumber();
		   System.out.println( "x is " + x);
		   System.out.println( "2x is " + doubleMyNumber(x));
		   System.out.println( "3x is " + tripleMyNumber(x));
		   System.out.println();
		}
	}
	 
	 static void printYikes() 
	 {
	  System.out.println("Yikes");
	 }
	 
	 static int doubleMyNumber(int a) 
	 {
	  int b = a * 2;
	  return b;
	 }
	 
	 static int tripleMyNumber(int c) 
	 {
	  int d = c * 3;
	  return d;
	 }
	 
	 static int checkNumber ()
	 {
		 int enteredNumber = 0;
		 Scanner myScanner = new Scanner(System.in);
		 String enteredString = "";
		 boolean numberError = false;
		 do 
		 {
			try 
			{
				System.out.println("Enter the value of your number: ");
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