package lab2;

import java.util.ArrayList;
import java.io.*;

public class Dictionary {
	
	private ArrayList<Word> theDictionary;
	// contains all the instances of Word, each instance (objekt)contains one word
	private BufferedWriter outputWriter; // write out content of theDictionary using method toString()
	// putputWriter ska skriva ut
	
	public Dictionary(String arg1) //don't return anything, so don't need any type before Dictionarym just public
	{
		
		this.addWords(arg1);
		
	}
	
	
	public void addWords(String arg2)
	{
		String[] listOfIndividualWords = arg2.split(" +");
		
		// listOfIndividualWords.length hur m�nga ord i tr�ngen
		for(int i=0; i < listOfIndividualWords.length; i++)
		{
		
			if(!(listOfIndividualWords[i].isEmpty()))
			{	
			theDictionary.add(new Word(listOfIndividualWords[i]));
			// sparar word objektet i arrayen direkt
			}
		}
	}
	
	
	
	
	public int numberOfWords()
	{
		return theDictionary.size(); //size() sreturns number of elements in list theDictionary
	}
	
	
	
	
	
	public void removeDuplicates()
	{

		for(int j = 0; j <theDictionary.size(); j++)
		{
			Word compareWords = theDictionary.get(j);
			
			//testa med debuggern om dessa looparna �r okej
			for(int i =j+1; i< theDictionary.size() ; i++)
			{
				if(compareWords.equals(theDictionary.get(i)))
				{
					
					for( int k = 0; k < theDictionary.get(i).getCounts(); k++ )
					{
						compareWords.increaseCounts();
						// if compareWords is 5, and theDictionary.get(i) is 2
						// compareWords will be 7 due to calling at function increaseCounts
					}
					
					theDictionary.remove(i); //removes object when done counting
					
					i-=1;
					//eftersom att arrayens l�ngd �ndras n�r man tar bort ett v�rde
					// man hoppar �ver ett v�rde annars eftersom de r�r sig �t tv� motsatta h�ll, loopen och objekten
				}	
			}	
		}		
	}
	
	
	public String countOccurences()
	{
		return "bajs";
		
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
	
		
		
		s
		// skapar string med allt som ska skrivas ut
	}
	
	
	

}