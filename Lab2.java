/**
 * @author Fei Alm
 * 
 * TND002, Lab 2
 * 
 * */

package lab2;

import java.io.*; //s� att BufferedReader och InputStreamReader ska fungera
import java.io.File;
import java.io.FileNotFoundException;


public class Lab2 {
	
    //declare a consoleReader, alla funktioiner i class Lab2 som l�ser i console kan n� denna
	public static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    
	static File aFile; // m�ste vara static s� att den n�s
	static FileReader myFileReader;//skapar myFileReader som l�ser av filen


	
	
	// questionToUser �r en global class konstant
   static  String questionToUser = "You have the following options :\n"
	+ "End : type 'end'\nLoad from file : type 'load' followed by filename\n"
	+ "Save to file : type 'save' followed by filename\nAdd another word : type the word\n"
	+ "List reduced content : type '1'\nList full content : type '2'\n"
	+ "Remove multiple occurences : type '3'\nSort : type '4'\nList occurences : type '5'\nYour choice : ";
	 // Your choice, after that, user choose one of the alternatives

    

    
	public static void main(String[] args)throws IOException {
		
		
		// PART A �R KOD F�R ATT TESTA ATT ALLA FUNNKTIONER FUNGERAR ATT KOPPLA IHOP
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
		// anropar klassen, inte objektet ettord f�r att static method p�verkar alla som finns i klassen
		System.out.println(ettord.toString()); //Part A
		
		// varje unikt ord finns bara ett av, increase counts �kar
		// equals methoden, getWord plocka fram den, i foor loop
		// anropa increase counts if samma ord hittas igen
		// skapa nytt objekt f�r varje nytt ord man skapar
		
		//String aline;
		
		//String[]arrayOfWords = theWord;
		
		String answerInput = "en str�ng :)";
		do
		{
			
		answerInput = new String(); // ny str�ng f�r option
		
		//anropar consoleInput och testar om det skrivs ut valet man skrev in
		answerInput = Lab2.consoleInput().toLowerCase(); //sparar resultatet som man fick tillbaka
		
		//vissa val �r i fler � nett ord, split ordet och dela upp i en array;
		// kommandon i f�rsta slot
		// filnamn etc o slot tv�
		
		String[]list = answerInput.split(" +");
		
		
		if (list[0].equals(""))
		{
			System.out.println("Something went wrong");
		}
		

	   if(list[0].equals("end"))
	   {
		   
	   }
	   
	   if(list[0].equals("load"))
	   {
		  aFile = new File(list[1]);
		  	  
		  	try
			  {
				  aFile.createNewFile();
			  }
			  catch(IOException e)
			  {
				 System.out.println("IO Exception"); // if an error occurs
			  }
		  
		  	if(!(aFile.exists())) //testar om filen existerar eller ej
		  	{
		  		System.out.println("No such file exists "); 		
		  	}
		  	
		  	myFileReader = new FileReader(aFile); //skapar l�saren myFileReader som l�ser av inneh�llet i aFile

		  	
		  	//G�r en reader som l�ser av all text, till EN str�ng
		  	BufferedReader reader = new BufferedReader(new FileReader(aFile));
			String aLine;
			String lineOfText;
			// !=null, aLine = reader.readLine() ska inte bli nulll, spara tills st�ter p� tom rad
			while (!((aLine = reader.readLine())==null))
			{
				// sparar aLine till en enda str�ng
				lineOfText = lineOfText + " " +  aLine;	
			}			
		  	
	   }myFileReader.close(); // gjort en l�sare, sen st�nga, annars kanske inte andra kan l�sa den
	 
	   
	   if(.equals(save))
	   {
		   
	   }
	   if(.equals(1))
	   {
		   
	   }
	   if(.equals(2))
	   {
		   
	   }
	   if(.equals(3))
	   {
		   
	   }
	   if(.equals(3))
	   {
		   
	   }
	   if(.equals(4))
	   {
		   
	   }
	   if(.equals(5))
	   {
		   
	   }
	    
		
		}while (!answerInput.equals("end"));
		
	}
	
	
	
	
	static String consoleInput()throws IOException
	{
		String answerByUser = "en str�ng";
		//f�ngar buggar, fel
		try {
		//String?? f�r add word, followed bu filename etc?
		System.out.println(questionToUser);
		answerByUser = consoleReader.readLine();
		}
		catch(IOException e) // e = exceptionobjekt, ta reda p� en masssa fel om objektet
		{
			
			return "";
		}
		
		return answerByUser;
	}
	

	
	
	
}

