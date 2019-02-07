/**
 * @author Fei Alm
 * 
 * TND002, Lab 2
 * 
 * */

package lab2;

import java.io.*; //så att BufferedReader och InputStreamReader ska fungera
import java.io.File;
import java.io.FileNotFoundException;


public class Lab2 {
	
    //declare a consoleReader, alla funktioiner i class Lab2 som läser i console kan nå denna
	public static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    
	public static File aFile; // måste vara static så att den nås
	public static FileReader myFileReader;//skapar myFileReader som läser av filen
	public String saveFileName; // när man sparar en fil och tillger den ett filnamn


	
	
	// questionToUser är en global class konstant
   static  String questionToUser = "You have the following options :\n"
	+ "End : type 'end'\nLoad from file : type 'load' followed by filename\n"
	+ "Save to file : type 'save' followed by filename\nAdd another word : type the word\n"
	+ "List reduced content : type '1'\nList full content : type '2'\n"
	+ "Remove multiple occurences : type '3'\nSort : type '4'\nList occurences : type '5'\nYour choice : ";
	 // Your choice, after that, user choose one of the alternatives

   
	public static void main(String[] args)throws IOException {
		
		
		// PART A ÄR KOD FÖR ATT TESTA ATT ALLA FUNNKTIONER FUNGERAR ATT KOPPLA IHOP
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
		

		/***************************
		 * Här börjar part B, C
		 ***************************/
		Dictionary myDictionary = new Dictionary();
		
		do
		{
			
		System.out.println(questionToUser);
		BufferedReader inputToLab = new BufferedReader(new InputStreamReader(System.in));
		String answerInput = inputToLab.readLine();
			
		answerInput = new String(); // ny sträng för option
		
		//anropar consoleInput och testar om det skrivs ut valet man skrev in
		answerInput = Lab2.consoleInput().toLowerCase(); //sparar resultatet som man fick tillbaka
		
		//vissa val är i fler ä nett ord, split ordet och dela upp i en array;
		// kommandon i första slot
		// filnamn etc o slot två
		
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
		  	
		  	myFileReader = new FileReader(aFile); //skapar läsaren myFileReader som läser av innehållet i aFile

		  	
		  	//Gör en reader som läser av all text, till EN sträng
		  	BufferedReader reader = new BufferedReader(new FileReader(aFile));
			String aLine;
			String lineOfText;
			// !=null, aLine = reader.readLine() ska inte bli nulll, spara tills stöter på tom rad
			while (!((aLine = reader.readLine())==null))
			{
				// sparar aLine till en enda sträng
				lineOfText = lineOfText + " " +  aLine;	
			}			
		  	
	   }myFileReader.close(); // gjort en läsare, sen stänga, annars kanske inte andra kan läsa den
	 
	   
	   if(list[0].equals("save"))
	   { 
		   saveFileName = list[1];
		   
		  myDictionary.setFileName(saveFileName);
		   
		   
		   
		   
		   
		   //read INTE write
		  //man ska skriva save + namn på en textfil
		  // spara i gammal textfil om namnet är samma eller skapa ny om man väljer ett nytt namn
		   
		   
	   }
	   if(list[0].equals(1))
	   {
		   
	   }
	   if(list[0].equals(2))
	   {
		   
	   }
	   if(list[0].equals(3))
	   {
		   
	   }
	   if(list[0].equals(3))
	   {
		   
	   }
	   if(list[0].equals(4))
	   {
		   
	   }
	   if(list[0].equals(5))
	   {
		   
	   }
	    
		
		}while (!answerInput.equals("end"));
		
	}
	
	
	
	
	static String consoleInput()throws IOException // Part A???
	{
		String answerByUser = "en sträng";
		//fångar buggar, fel
		try {
		//String?? för add word, followed bu filename etc?
		System.out.println(questionToUser);
		answerByUser = consoleReader.readLine();
		}
		catch(IOException e) // e = exceptionobjekt, ta reda på en masssa fel om objektet
		{
			
			return "";
		}
		
		return answerByUser;
	}
	

	
	
	
}