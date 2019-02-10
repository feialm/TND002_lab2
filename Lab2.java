/**
 * @author Fei Alm
 * 
 * TND002, Lab 2
 * 
 * */

package lab2;

import java.io.*; //s� att BufferedReader och InputStreamReader ska fungera
import java.io.File;
//import java.io.FileNotFoundException;


public class Lab2 {
	
    //declare a consoleReader, alla funktioiner i class Lab2 som l�ser i console kan n� denna
	public static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    
	public static File aFile; // m�ste vara static s� att den n�s
	public static FileReader myFileReader;//skapar myFileReader som l�ser av filen


	// questionToUser �r en global class konstant
   static  String questionToUser = "You have the following options :\n"
	+ "End : type 'end'\nLoad from file : type 'load' followed by filename\n"
	+ "Save to file : type 'save' followed by filename\nAdd another word : type the word\n"
	+ "List reduced content : type '1'\nList full content : type '2'\n"
	+ "Remove multiple occurences : type '3'\nSort : type '4'\nList occurences : type '5'\nYour choice : ";
	 // Your choice, after that, user choose one of the alternatives

   
	public static void main(String[] args)throws IOException {
		
		/**
		PART A �R KOD F�R ATT TESTA ATT ALLA FUNKTIONER FUNGERAR ATT KOPPLA IHOP 
		**/	
		
		/*
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
		*/
		
		
		
		/***************************
		 * H�r b�rjar part B, C
		 ***************************/
		Dictionary myDictionary = new Dictionary();
		String [] list;
		BufferedReader reader = null;
		String command = "ett v�rde";		
		
		do
		{
				
			String answerInput = new String(); // ny str�ng f�r option
			
			//anropar consoleInput, st�lla fr�gan
			//och testar om det skrivs ut valet man skrev in
			answerInput = Lab2.consoleInput().toLowerCase(); //sparar resultatet som man fick tillbaka
			
			//System.out.println(answerInput + "      LALALALALLAALLA"); //fulbugg kontrollera input
			
			//vissa val �r i fler �n ett ord, split ordet och dela upp i en array;
			// kommandon i f�rsta slot
			// filnamn etc o slot tv�
			
			
			list = answerInput.split(" +");
			command = list[0]; // enklare f�rst� vad list[0] g�r
			
			
			if (command.equals(""))
			{
				System.out.println("Something went wrong");
			}
			else if(command.equals("load"))
			{
			   
			   aFile = new File(list[1]);
			   
			  
			  	if(!(aFile.exists())) //testar om filen existerar eller ej
			  	{
			  		System.out.println("No such file exists "); 		
			  	}
			  	
			  	//G�r en reader som l�ser av all text, till EN str�ng
			  	reader = new BufferedReader(new FileReader(aFile));
				String aLine;
				String lineOfText = "";
				// !=null, aLine = reader.readLine() ska inte bli nulll, spara tills st�ter p� tom rad
				while (!((aLine = reader.readLine())==null))
				{
					// sparar aLine till en enda str�ng
					lineOfText = lineOfText + " " +  aLine;	
				}			
			  	
				//System.out.println(lineOfText+ "              xbhwckew"); //fulbugg
				
				myDictionary = new Dictionary(lineOfText);
				
				
				
			reader.close(); // gjort en l�sare, sen st�nga, annars kanske inte andra kan l�sa den	
			}
			else if(command.equals("save"))
			{ 
			  
				String saveFileName; // n�r man sparar en fil och tillger den ett filnamn
				
				if(!(command.equals("text")))
				{
					//a control so user don't overwrite old file with same name
					saveFileName = list[1];   
					myDictionary.setFileName(saveFileName);
					myDictionary.saveFile();
				}
				else
				{
					System.out.println("Can't overwrite a file!");
				}
				   
			}
			else if(command.equals("1"))
			{
				int a = 0;
				Word.changeOutputFormat(a);
				System.out.println(myDictionary.toString());
				
			}
			else if(command.equals("2"))
			{
				int b = 1;
				Word.changeOutputFormat(b);
				System.out.println(myDictionary.toString());
			}
			else if(command.equals("3"))
			{
			   myDictionary.removeDuplicates();

			}
			else if(command.equals("4"))
			{
			   myDictionary.sortDictionaryByCounts();
			}
			else if(command.equals("5"))
			{
				System.out.println(myDictionary.countOccurences());
			}
			else //Add another word
			{	
				if(!(command.equals("end"))) {
					myDictionary.addWords(list[0]); // skickar med till metoden
				}
			}
		    
			
		}while (!(command.equals("end")));
		
	}//m�svinge till main
	
	
	
	
	static String consoleInput()throws IOException {
		String answerByUser = "en str�ng";
		//f�ngar buggar, fel
		try
		{
			//String?? f�r add word, followed by filename etc?
			System.out.println(questionToUser);
			answerByUser = consoleReader.readLine();
		}
		catch(IOException e) //e = exceptionobjekt, ta reda p� en masssa fel om objektet
		{
			
			return "";
		}
		
		return answerByUser;
	}
	


	
} //m�svinge till class Lab2