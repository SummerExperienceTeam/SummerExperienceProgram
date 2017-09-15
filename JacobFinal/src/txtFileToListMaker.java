import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class txtFileToListMaker 
{

	public ArrayList<String> getList(String fileName)
	{
		ArrayList<String> items = new ArrayList<String>();
		  try
		    {
		      File file = new File(fileName);
		      Scanner s = new Scanner(file);
		      while(s.hasNext())
		      {
		    	  	String nextString = s.next();
		        items.add(nextString);
		      }
		    }
		    catch(IOException e)
		    {
		      System.out.println("There was an error creating an ArrayList<String> out of the text file.");
		    }
		  return items;
	}
}
