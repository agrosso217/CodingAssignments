import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BufferedReaderExample 
{
	public static void main(String[] args) 
	{
		BufferedReader reader = null;
		ArrayList <String> myFileLines = new ArrayList <String>();
		try 
		{
			String sCurrentLine;
			reader = new BufferedReader(new FileReader("C:\\Users\\Applejuice217\\Desktop\\Intro Comp\\mary.txt"));
			while ((sCurrentLine = reader.readLine()) != null) 
			{
				myFileLines.add(sCurrentLine);
			}
		} 
		catch (IOException e) 
		{
				e.printStackTrace();
				System.out.print(e.getMessage());
		} 
		finally 
		{
			try 
			{
				if (reader != null)
					reader.close();
			} 
			catch (IOException ex) 
			{
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
		for (int i = myFileLines.size() - 1; i >= 0; i--)               //to print in reverse order
		{
			String myLine = myFileLines.get(i);
			//System.out.println(myLine);
			for (int c = 0; c <= myLine.length(); c++)
			{
				if ((myLine.substring(c, c+1)).contentEquals(" "))		//character must be a space
				{
					String lineNum = myLine.substring(0, c);			//the line number is all characters 											
					System.out.println(lineNum);						//from 0 to the position of the space
					break;
				}
			}
		}
	}
}