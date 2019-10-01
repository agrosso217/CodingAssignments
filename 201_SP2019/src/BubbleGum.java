
public class BubbleGum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int gumNumber;
		
		for (gumNumber = 1; gumNumber <= 50; gumNumber++)
		{
			if (gumNumber % 2 == 0 && gumNumber % 5 == 0)
			{
				System.out.println("BUBBLE GUM");
			}
			else if (gumNumber % 5 == 0)
			{
				System.out.println("BUBBLE");
			}
			else if (gumNumber % 2 == 0)
			{
				System.out.println("GUM");
			}
			else 
				System.out.println(gumNumber);
		} 
		
	}

}
