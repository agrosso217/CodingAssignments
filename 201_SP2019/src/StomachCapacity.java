
public class StomachCapacity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int STOMACH_CAPACITY = 10;
		
		int sto_content = 0;
		
		while (sto_content < STOMACH_CAPACITY)
		{
			//Im still hungry ... take a bite
			System.out.print("Taking a bite...");
			sto_content++;
			System.out.println("Content is " + sto_content);
		}
		
		for (sto_content = 0; sto_content <= STOMACH_CAPACITY; sto_content++)
		{
			System.out.print("FORLOOP: Taking a bite...");
			System.out.println("Content is " + sto_content);
			if (sto_content % 2 == 0)
			{
				System.out.println("Must be on an even bite!!");
			}
		}
		sto_content = 50;
		do
		{
			System.out.print("DO_WHILE: Taking a bite...");
			sto_content++;
			System.out.println("Content is " + sto_content);
		}
		while (sto_content < STOMACH_CAPACITY);
	}

}
