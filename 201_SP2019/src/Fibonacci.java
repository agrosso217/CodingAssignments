
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AJ Grosso's Fibonacci Code Assignment
		
		int fibFirst = 0;
		int fibSec = 0;
		int fibTotal = 0;

		while (fibTotal < 875)
		{
			while(fibFirst == 0 && fibSec == 0)
			{
				fibFirst++;
				fibSec++;
				System.out.print(fibFirst + ", ");
				System.out.print(fibSec);
			}
			
			fibTotal = fibFirst + fibSec;
			
			fibFirst = fibSec;
			fibSec = fibTotal;
			
			System.out.print(", " + fibTotal);
		}
	}
}
