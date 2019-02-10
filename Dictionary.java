package lab2;

import java.util.ArrayList;
import java.io.*;
import java.io.IOException;

public class Dictionary {
	
	private ArrayList<Word> theDictionary;
	// contains all the instances of Word, each instance (objekt)contains one word
	private FileWriter outputWriter; // write out content of theDictionary using method toString()
	// outputWriter ska skriva ut
	// st�r i labbinstruktionen vi ska ha BufferedWriter men det fungerar ej s� har FileWriter ist�llet
	
	
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
		
		// listOfIndividualWords.length hur m�nga ord i str�ngen
		for(int i=0; i < listOfIndividualWords.length; i++)
		{
		
			if(!(listOfIndividualWords[i].isEmpty()))
			{	
			theDictionary.add(new Word(listOfIndividualWords[i]));
			// sparar word objektet i arrayen direkt
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
			
			//testa med debuggern om dessa looparna �r okej
			for(int i =j+1; i< theDictionary.size() ; i++)
			{
				if(compareWords.getWord().toLowerCase().equals(theDictionary.get(i).getWord().toLowerCase()))
				{
					// compareWords.getWord() tar ordet plockar fram som str�ng
					
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
	
	
	
	
	
	public String countOccurences() {

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
			} */
		}
		// ska den vara h�r?
		//String returningOccurences = String.format("There are " + M + " words that occured " + N + " times.");
		
		return M.toString();		
	}
	
	
	

	public void sortDictionaryByCounts() {
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

	

	
	public void setFileName(String filename) throws IOException {
		//n�r man har skrivit save "aName", sparas det namnet man har valt till filen
		
		try
		{		
		outputWriter = new FileWriter(new File(filename));		
		}
		catch(IOException err)
		{
			System.out.println("Something went wrong!");
		}
	}
	
	
	
	

	
	public void saveFile() throws IOException {
		//metoden saveFile sparar en str�ng som har skickats fr�n metoden toString
		try
		{	
			for(int i=0; i < theDictionary.size(); i++)
			{
			outputWriter.write(theDictionary.get(i).getWord() + " ");
			// kallar p� metoden outputWriter som h�mtar ett ord och skriver ut det
			// l�gger till ett " " s� att det blir mellanslag mellan varje ord
			// l�gger in det i ny fil som man sparar texten i
			
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
		String number2 = countOccurences();
		
		String result = String.format("Total words :" + number1 + " and total occurences " + number2 + "\n" );   
		
			for(int i=0; i < theDictionary.size(); i++)
			{
				result = result + theDictionary.get(i).toString() + " \n";
				//l�gger p� alla ord innan return str�ng
				// hela texten efter statistiken
				// toString tar ordet ut textfilen med funktionen get() f�r att bygga upp en str�ng
	
			}
			
			return result; 
	}
		

} //m�svinge till class dictionary