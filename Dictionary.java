package lab2;

import java.util.ArrayList;
import java.io.*;
import java.io.IOException;

public class Dictionary {
	
	private ArrayList<Word> theDictionary;
	// contains all the instances of Word, each instance (objekt)contains one word
	private FileWriter outputWriter; // write out content of theDictionary using method toString()
	// outputWriter ska skriva ut
	// står i labbinstruktionen vi ska ha BufferedWriter men det fungerar ej så har FileWriter istället

	
	public Dictionary() {
		
		theDictionary = new ArrayList<Word>();
		
	}
	
	
	public Dictionary(String arg1) {
		 //don't return anything, so don't need any type before Dictionarym just public
		theDictionary = new ArrayList<Word>();
		this.addWords(arg1);
		
	}

	
	public void addWords(String arg2) {
		String[] listOfIndividualWords = arg2.split(" +");
		
		
		String regex = "\\d+"; // \\d = any digit
		
		// listOfIndividualWords.length hur många ord i strängen
		for(int i=0; i < listOfIndividualWords.length; i++)
		{
		
			if(!(listOfIndividualWords[i].isEmpty()))
			{	
			
				
				if(!(listOfIndividualWords[i].matches(regex) && !listOfIndividualWords[i].equals(null))) // spara endast ord, inga siffror
				{
					
					theDictionary.add(new Word(listOfIndividualWords[i]));
					// sparar word objektet i arrayen direkt
					
				}
			}
		}
	}
	
	
	
	
	public int numberOfWords() {
		
		return theDictionary.size(); //size() returns number of elements in list theDictionary
	}
	
	

	
	public void removeDuplicates() {

		for(int j = 0; j <theDictionary.size(); j++)
		{
			Word compareWords = theDictionary.get(j);
			//testa med debuggern om dessa looparna är okej
			for(int i =j+1; i< theDictionary.size() ; i++)
			{
				if(compareWords.getWord().toLowerCase().equals(theDictionary.get(i).getWord().toLowerCase()))
				{
					// compareWords.getWord() tar ordet plockar fram som sträng
					
					/**
					for( int k = 0; k < theDictionary.get(i).getCounts(); k++ )
					{
						compareWords.increaseCounts();
						// if compareWords is 5, and theDictionary.get(i) is 2
						// compareWords will be 7 due to calling at function increaseCounts
					}*/
					
					compareWords.increaseCounts();
					theDictionary.remove(i); //removes object when done counting
					
					i-=1;
					//eftersom att arrayens längd ändras när man tar bort ett värde
					// man hoppar över ett värde annars eftersom de rör sig åt två motsatta håll, loopen och objekten
				}	
			}	
		}		
	}
	

	
	
	/**
	public void removeDuplicates() {
		
		
		for (int i = 0; i < theDictionary.size()-1; i++) {
			
			for (int j =i+1; j < theDictionary.size(); j++) {
				
				if( theDictionary.get(i).getWord().toLowerCase().contentEquals(theDictionary.get(j).getWord().toLowerCase())) {
					
					theDictionary.get(i).increaseCounts();
					theDictionary.remove(j);
					j = j-1;
					
				}	
			}			
		}
	}
	*/
	
	
	/**
	
	/**
	 * 
	 * 	public String countOccurences() {

		Integer M = 0;//how many words that occur N times
		int N=0; //how many times a word occurs
		// int howmanyOccurences[] = new int[theDictionary.size()]; //skapar ny array
		// int compareOccurences[] = new int[theDictionary.size()];
		
		for(int i = 0; i <theDictionary.size(); i++ )
		{
			M += theDictionary.get(i).getCounts();
			
			// howmanyOccurences[i] = theDictionary.get(i).getCounts();
			
			/** for(int j = i+1; j < theDictionary.size(); j++)
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
		//String returningOccurences = String.format("There are " + M + " words that occured " + N + " times.");
		
		return M.toString();		
	}

	**/
	
	
	public String countOccurences() {

		Integer M = 0;//how many words that occur N times
		int counter=1; //how many times a word occur
		int N = 0;

		String result = "";
		

		for (int i = 0; i < theDictionary.size(); i++) {
			
			if(theDictionary.get(i).getCounts() >= counter) {
				counter = theDictionary.get(i).getCounts();
			}		
		}
		
		Integer[] array = new Integer[counter+1];
		
		// fyller array med nollor
		for(int i = 0; i < array.length; i++) {
			array[i]=0;
		}
		
		for(int j = 0; j < array.length; j++) {
			for (int i = 0; i < theDictionary.size(); i++ ) {
				
				if(theDictionary.get(i).getCounts()== j+1) {
					array[j]++;
				}
			}
			
				if (array[j]!=0) {
					
					M = array[j];
					N = j+1;
					result+= "There are " + M + " words that occured " + N + " times. \n";
				}
		}
		
		return result;
	}
	
	
	

	public void sortDictionaryByCounts() {
		// sortDictionaryByCounts() should sort the entries of theDictionary by
		// their number of counts. After sorting, the first entry should be that with
		// the largest number of counts.
	
		
		// sorting array
		for(int pass = 1; pass <= theDictionary.size()-1; pass++ )
		{

			for(int k=0; k < theDictionary.size()-1; k++)
			{
				
				if(theDictionary.get(k).getCounts() < theDictionary.get(k+1).getCounts())
				{
					Word aux = theDictionary.get(k);
					theDictionary.set(k, theDictionary.get(k+1));
					theDictionary.set(k+1,aux);		
				}	
			}	
		}	
	}

	

	
	public void setFileName(String filename)throws IOException {
		//när man har skrivit save "aName", sparas det namnet man har valt till filen
		
		outputWriter = new FileWriter(new File(filename));		

	}
	
	
	
	

	
	public void saveFile() throws IOException {
		//metoden saveFile sparar en sträng som har skickats från metoden toString
		try
		{	
			for(int i=0; i < theDictionary.size(); i++)
			{
			outputWriter.write(theDictionary.get(i).getWord() + " ");
			// kallar på metoden outputWriter som hämtar ett ord och skriver ut det
			// lägger till ett " " så att det blir mellanslag mellan varje ord
			// lägger in det i ny fil som man sparar texten i
			
			}
		}
		catch(IOException err)
		{
			System.out.println("ERROR when saving the file!");
		}
		outputWriter.close();
	}
	
	
	
	
	public String toString() {
		
		int number1 = numberOfWords();
		int number2 = 0;
		
		for (int i = 0; i < theDictionary.size(); i++)
		{
			number2 = number2 + theDictionary.get(i).getCounts();
			
		}
		
		String result = String.format("Total words: " + number1 + " and total occurences " + number2  + " \n");   
		
			for(int i=0; i < theDictionary.size(); i++)
			{
				result = result + theDictionary.get(i).toString() + " \n";
				//lägger på alla ord innan return sträng
				// hela texten efter statistiken
				// toString tar ordet ut textfilen med funktionen get() för att bygga upp en sträng
	
			}
			
			return result; 
	}
		

} //måsvinge till class dictionary