import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BufferedWriterExample 
{
	public static void main(String[] args) 
	{
		BufferedReader reader = null;
		ArrayList <String> myFileLines = new ArrayList <String>();
		try 
		{
			String content = "This is the content to write into file";
			File outfile = new File("C:\\\\Users\\\\Applejuice217\\\\Desktop\\\\Intro Comp\\\\BuffWrite");
			// if file doesnt exists, then create it
			if (!outfile.exists()) 
			{
				outfile.createNewFile();
			
			}
			FileWriter fw = new FileWriter(outfile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			String sCurrentLine;
			reader = new BufferedReader(new FileReader("C:\\Users\\Applejuice217\\Desktop\\Intro Comp\\mary.txt"));
			while ((sCurrentLine = reader.readLine()) != null) 
			{
				myFileLines.add(sCurrentLine);
				bw.write(sCurrentLine);
				bw.newLine();
				bw.flush();   //Always a good habit to flush when you are through
			}
			bw.close();
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
		
	}
}
		