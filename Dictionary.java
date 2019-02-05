package lab2;

import java.util.ArrayList;
import java.io.*;

public class Dictionary {
	
	private ArrayList<Word> theDictionary;
	// contains all the instances of Word, each instance (objekt)contains one word
	private BufferedWriter outputWriter; // write out content of theDictionary using method toString()
	
	
	public String Dictionary(String arg1) throws IOException
	{
		
		
		this.addWords(arg1);
		
	}
	
	public void String addWords(String arg2)
	{
		String[] listOfIndividualWords = arg2.split(" +");
		
	}
	
	public int numberOfWords()
	{
		
	}
	
	public void removeDuplicates()
	{
		
	}
	
	public String countOccurences()
	{
		
	}
	
	public void sortDictionaryByCounts()
	{
		
	}
	
	public void setFileName(String a)
	{
	
		File nameOfFile = new File(theDictionary);
		
		
		
		// outputwriter
		// try catch
	}
	
	public void saveFile()
	{
		
	}
	
	public String toString()
	{
	// skapar string med allt som ska skrivas ut
	}
	
	
	

}