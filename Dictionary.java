package lab2;

import java.util.ArrayList;
import java.io.*;
import java.io.IOException;

public class Dictionary {
	
	private ArrayList<Word> theDictionary;
	// contains all the instances of Word, each instance (objekt)contains one word
	private BufferedWriter outputWriter; // write out content of theDictionary using method toString()
	// putputWriter ska skriva ut
	
	
	public Dictionary()
	{
		theDictionary = new ArrayList<Word>();
		
	}
	
	
	public Dictionary(String arg1) //don't return anything, so don't need any type before Dictionarym just public
	{
		
		this.addWords(arg1);
		
	}

	
	public void addWords(String arg2)
	{
		String[] listOfIndividualWords = arg2.split(" +");
		
		// listOfIndividualWords.length hur många ord i strängen
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
		return theDictionary.size(); //size() returns number of elements in list theDictionary
	}
	
	
	
	
	
	public void removeDuplicates()
	{

		for(int j = 0; j <theDictionary.size(); j++)
		{
			Word compareWords = theDictionary.get(j);
			
			//testa med debuggern om dessa looparna är okej
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
					//eftersom att arrayens längd ändras när man tar bort ett värde
					// man hoppar över ett värde annars eftersom de rör sig åt två motsatta håll, loopen och objekten
				}	
			}	
		}		
	}
	
	
	
	
	
	
	public String countOccurences()
	{

		int M = 1;//how many words that occur N times
		int N=0; //how many times a word occurs
		int howmanyOccurences[] = new int[theDictionary.size()]; //skapar ny array
		int compareOccurences[] = new int[theDictionary.size()];
		
		for(int i = 0; i <theDictionary.size(); i++ )
		{
			howmanyOccurences[i] = theDictionary.get(i).getCounts();
			
			for(int j = i+1; j < theDictionary.size(); j++)
			{
				compareOccurences[j] = theDictionary.get(j).getCounts();
				
				if(compareOccurences[j]==howmanyOccurences[i])
				{
					
					//turn how many times a word occur to an int
					
					N = howmanyOccurences[i];
					M++;
					
				}		
			}	

		}
		// ska den vara här?
		String returningOccurences = String.format("There are " + M + " words that occured " + N + " times.");
		return returningOccurences;		
	}
	
	
	

	public void sortDictionaryByCounts()
	{
		// sortDictionaryByCounts() should sort the entries of theDictionary by
		// their number of counts. After sorting, the first entry should be that with
		// the largest number of counts.
		
		int sortingA[] = new int[theDictionary.size()];
		
		// sorting array
		for(int pass = 1; pass <= theDictionary.size()-1; pass++ )
		{

			for(int k=0; k < theDictionary.size(); k++)
			{

				sortingA[k] = theDictionary.get(k).getCounts();
				
				if(sortingA[k] < sortingA[k+1])
				{
					int aux = sortingA[k];
					sortingA[k]=sortingA[k+1];
					sortingA[k+1]=sortingA[k];			
				}	
			}	
		}	
	}
	
	
	
	
	
	
	public void setFileName(String filename) throws IOException
	{
	
		try
		{
			
		}
		catch
		{
			
			
		}
		
		
		
		// outputwriter
	}
	
	
	
	
	
	
	
	public void saveFile()
	{
		
		
		
	}
	
	
	
	
	
	
	
	public String toString()
	{
	
		
		// skapar string med allt som ska skrivas ut
	}
	
	
	
	
	

}