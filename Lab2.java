/**
 * @author Fei Alm
 * 
 * TND002, Lab 2
 * 
 * */

package lab2;

import java.io.*; //s� att BufferedReader och InputStreamReader ska fungera

public class Lab2 {
	
	// questionToUser �r en global class konstant
	
    String questionToUser = "You have the following options :\n"
	+ "End : type 'end'\nLoad from file : type 'load' followed by filename\n"
	+ "Save to file : type 'save' followed by filename\nAdd another word : type the word\n"
	+ "List reduced content : type '1'\nList full content : type '2'\n"
	+ "Remove multiple occurences : type '3'\nSort : type '4'\nList occurences : type '5'\nYour choice : ";

    // if else sats p� detta
    
    public static BufferedReader consoleReader;
    
	public static void main(String[] args)throws IOException {
		
		System.out.println("V�lj 0 eller 1: ");// Part A
		BufferedReader val = new BufferedReader(new InputStreamReader(System.in));// Part A
		String valAvOutput = val.readLine();// Part A
		int valAvOutputWord = Integer.parseInt(valAvOutput);// Part A
		
		Word ettord = new Word( "Tjollahopp"); // Part A
		System.out.println(ettord.getWord()); // Part A
		System.out.println(ettord.getCounts()); // Part A
		ettord.increaseCounts(); // Part A, r�knar upp counts +1
		System.out.println(ettord.getCounts()); // Part A
		Word.changeOutputFormat(valAvOutputWord); //Part A
		// Skickar med valet
		// anropar klassen, inte objektet ettord f�r att static method p�verkar alla i klassen
		System.out.println(ettord.toString()); //Part A
		
		
		// varje unikt ord finns bara ett av, increase counts �kar
		// equals methoden, getWord plocka fram den, i foor loop
		// anropa increase counts if samma ord hittas igen
		// skapa nytt objekt f�r varje nytt ord man skapar
		
		//String aline;
		
		//String[]arrayOfWords = theWord;
	
	
	
	
	}
	
	
	
}



