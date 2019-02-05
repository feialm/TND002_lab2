package lab2;

import java.util.ArrayList;
import java.io.*;

public class Dictionary {
	
	private ArrayList<Word> theDictionary;
	private BufferedWriter outputWriter; // write out content of theDictionary using method toString()
	
	
	public default Dictionary()
	{

		
	}
	
	public String Dictionary(String arg1)
	{
		
		
		this.addWords(arg1);
		
	}
	
	public void String addWords(String arg2)
	{
		String[] listOfIndividualWords = arg2.split(" +");
		
	}
	
	
	
	
	
	
	
	
	

}
