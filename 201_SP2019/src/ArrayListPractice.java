import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class ArrayListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> students = new ArrayList<String>();
		
		students.add("Fred");
		students.add("Sue");
		students.add("Mike");
		
		int arraySize = students.size();
		System.out.println("Size is: " + arraySize);
		
		String name = students.get(1);
		System.out.println("Name is: " + name);
		
		students.add("Tom");
		
		arraySize = students.size();
		System.out.println("Size is: " + arraySize);
		
		for (int i = 0; i < students.size(); i++)
		{
			System.out.println("Student # " + i + " is named: " + students.get(i));
		}
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Gimme a name to delete: ");
		String nameToDel = keyboard.nextLine();
		
		for (int i = 0; i < students.size(); i++)
		{
			if (nameToDel.compareTo(students.get(i)) == 0)
			{
				students.remove(i);
				System.out.println("We removed " + nameToDel + " from index #: " + i);
			}
		}
		
		for (int i = 0; i < students.size(); i++)
		{
			System.out.println("Student # " + i + " is named: " + students.get(i));
		}
		
		Random myRand = new Random();
		for (int i = 0; i < students.size(); i++)
		{
			if (nameToDel.compareTo(students.get(i)) == 0)
			{
				students.remove(i);
				System.out.println("We removed " + nameToDel + " from index #: " + i);
			}
		int randNum = myRand.nextInt(3);
		
		System.out.println("Random number is: " + randNum);
		}
	}

}
