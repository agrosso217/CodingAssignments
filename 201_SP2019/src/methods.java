import java.util.Scanner;
public class methods {
 public static void main(String[] args)
 {
  Scanner myScanner = new Scanner(System.in);

  System.out.print("Enter the amount of numbers you want to check: ");
  int amount = myScanner.nextInt();
  System.out.println();
  for (int count = 0; count < amount; count++)
  {
   System.out.print("Enter the value of x: ");
   int x = myScanner.nextInt();
   System.out.print("Enter the value of y: ");
   int y = myScanner.nextInt();
   printYikes();
   System.out.println( "x is " + x );
   System.out.println( "2x is " + doubleMyNumber(x));
   System.out.println( "3x is " + tripleMyNumber(x));
   System.out.println( "The sum of x and y is " + addMyNumber(x, y));
   System.out.println();
  }
 }
 static void printYikes() {
  System.out.println("Yikes");
 }
 static int doubleMyNumber(int a) {
  int b = a * 2;
  return b;
 }
 static int tripleMyNumber(int c) {
  int d = c * 3;
  return d;
 }
 static int addMyNumber (int e, int f) {
  int g = e + f;
  return g;
 }
}
