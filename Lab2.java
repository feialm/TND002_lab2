/**
 * @author Fei Alm
 * 
 * TND002, Lab 2
 * 
 * */

package lab2;

import java.io.*; //så att BufferedReader och InputStreamReader ska fungera
import java.io.File;
//import java.io.FileNotFoundException;


public class Lab2 {
	
    //declare a consoleReader, alla funktioiner i class Lab2 som läser i console kan nå denna
	public static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    
	public static File aFile; // måste vara static så att den nås
	public static FileReader myFileReader;//skapar myFileReader som läser av filen


	// questionToUser är en global class konstant
   static  String questionToUser = "You have the following options :\n"
	+ "End : type 'end'\nLoad from file : type 'load' followed by filename\n"
	+ "Save to file : type 'save' followed by filename\nAdd another word : type the word\n"
	+ "List reduced content : type '1'\nList full content : type '2'\n"
	+ "Remove multiple occurences : type '3'\nSort : type '4'\nList occurences : type '5'\nYour choice : ";
	 // Your choice, after that, user choose one of the alternatives

   
	public static void main(String[] args)throws IOException {
		
		/**
		PART A ÄR KOD FÖR ATT TESTA ATT ALLA FUNKTIONER FUNGERAR ATT KOPPLA IHOP 
		**/	
		
		/*
		System.out.println("Välj 0 eller 1: ");// Part A
		BufferedReader val = new BufferedReader(new InputStreamReader(System.in));// Part A
		String valAvOutput = val.readLine();// Part A
		int valAvOutputWord = Integer.parseInt(valAvOutput);// Part A
		
		Word ettord = new Word( "Tjollahopp"); // Part A
		System.out.println(ettord.getWord()); // Part A
		System.out.println(ettord.getCounts()); // Part A
		ettord.increaseCounts(); // Part A, räknar upp counts +1
		System.out.println(ettord.getCounts()); // Part A
		Word.changeOutputFormat(valAvOutputWord); //Part A
		// Skickar med valet
		// anropar klassen, inte objektet ettord för att static method påverkar alla som finns i klassen
		System.out.println(ettord.toString()); //Part A
		
		// varje unikt ord finns bara ett av, increase counts ökar
		// equals methoden, getWord plocka fram den, i foor loop
		// anropa increase counts if samma ord hittas igen
		// skapa nytt objekt för varje nytt ord man skapar
		*/
		
		
		
		/***************************
		 * Här börjar part B, C
		 ***************************/
		Dictionary myDictionary = new Dictionary();
		String [] list;
		BufferedReader reader = null;
		String command = "ett värde";		
		
		do
		{
				
			String answerInput = new String(); // ny sträng för option
			
			//anropar consoleInput, ställa frågan
			//och testar om det skrivs ut valet man skrev in
			answerInput = Lab2.consoleInput().toLowerCase(); //sparar resultatet som man fick tillbaka
			
			//System.out.println(answerInput + "      LALALALALLAALLA"); //fulbugg kontrollera input
			
			//vissa val är i fler än ett ord, split ordet och dela upp i en array;
			// kommandon i första slot
			// filnamn etc o slot två
			
			
			list = answerInput.split(" +");
			command = list[0]; // enklare förstå vad list[0] gör
			
			
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
			  	
			  	//Gör en reader som läser av all text, till EN sträng
			  	reader = new BufferedReader(new FileReader(aFile));
				String aLine;
				String lineOfText = "";
				// !=null, aLine = reader.readLine() ska inte bli nulll, spara tills stöter på tom rad
				while (!((aLine = reader.readLine())==null))
				{
					// sparar aLine till en enda sträng
					lineOfText = lineOfText + " " +  aLine;	
				}			
			  	
				//System.out.println(lineOfText+ "              xbhwckew"); //fulbugg
				
				myDictionary = new Dictionary(lineOfText);
				
				
				
			reader.close(); // gjort en läsare, sen stänga, annars kanske inte andra kan läsa den	
			}
			else if(command.equals("save"))
			{ 
			  
				String saveFileName; // när man sparar en fil och tillger den ett filnamn
				
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
		
	}//måsvinge till main
	
	
	
	
	static String consoleInput()throws IOException {
		String answerByUser = "en sträng";
		//fångar buggar, fel
		try
		{
			//String?? för add word, followed by filename etc?
			System.out.println(questionToUser);
			answerByUser = consoleReader.readLine();
		}
		catch(IOException e) //e = exceptionobjekt, ta reda på en masssa fel om objektet
		{
			
			return "";
		}
		
		return answerByUser;
	}
	


	
} //måsvinge till class Lab2