package lab2;

public class Word {
	
	private String theWord = "bajs";
	private int counts = 0; // counts how often a word occurs in text
	private static int outputFormat = 0;
	//classvariabel, f�r den �r underlined i labbanvisningar
	// static, varje ord har inte sitt eget putputformat
	//�ndrar man t.ex outputformat g�ller det f�r alla ord man skrivit in
	
	public Word(String oneWordFromText)
	{
		// constructor som ska anropas, n�r new Words
		// g�ra saker med nya Word
		
		// n�r new word i main, ska den sparas h�r
		// l�gger varje ord i ett litet objekt
		theWord = oneWordFromText;
		counts = 1;
		
		
		// denna Word �r typ klar l�gg det som �r nedanf�r i kommentarer i main
		
		//allt i main{
		// str�ngen man klippte av fr�n main
		// g�ra ett ord av det
		//skicka tillbaka
		// loopa igenom arayyen ordd f�r ord i main
		//}
		
		
	}
	
	
	public String getWord()
	{
		
		return theWord;
		
	}
	
	public int getCounts()
	{
		
		
		return counts;
	}
	
	
	public void increaseCounts()
	{
		// increase value of counts by 1
		
		
		
		
		counts++;
		
		
		
	}
	
	
	public static void changeOutputFormat(int j)
	{
		//classmetod, f�r den �r underlined i labbanvisingar
		// should change the value of outputFormat to 0 or 1 for all instances of Word
		// metoden g�r att anv�ndaren v�ljer hur resultatet av ordet ska visas
		// j �r valet anv�ndaren har gjort
		
		outputFormat = j;
		
	}
	
	
	public String toString()
	{
		
		if( outputFormat == 0)
		{
			String answer1 = String.format("The word is : " + theWord);
			
			return answer1;
		}
		
		if( outputFormat == 1)
		{
			
			String answer2 = String.format("The word " + theWord + " has occured " + counts + " times.");
			
			return answer2;
		}
		
		
		return " ERROR, output format is not 0 or 1 ";//kolla labben vad som ska ske hh�r
		// om man skrev t.ex 5, return this
	}
	

}
