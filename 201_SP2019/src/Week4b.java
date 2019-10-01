
public class Week4b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int grade = 80;
		
		if (grade >= 90) {
			System.out.println("Yay - you got an A!");
		}
			else if (90 > grade && grade >= 80){
				System.out.println("Got a B - good effort");
		}
			else if (80 > grade && grade >= 70){
				System.out.println("You got a C - yikes");
			}
			else 
				System.out.println("You got an F");
	}

}
