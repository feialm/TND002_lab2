package lab2;

public class Word {
	
	private String theWord = "Hej";
	
	private int counts = 0; //counts how often a word occurs in text
	
	private static int outputFormat = 0;
	
	//classvariabel, för den är underlined i labbanvisningar
	// static, varje ord har inte sitt eget putputformat
	//ändrar man t.ex outputformat gäller det för alla ord man skrivit in
	
	public Word(String oneWordFromText) {
		// constructor som ska anropas, när new Word
		
		// när new word i main, ska den sparas här
		// lägger varje ord i ett litet objekt
		theWord = oneWordFromText;
		counts = 1;
		
		
		// Word är klar
	}
	
	
	public String getWord()
	{
		
		return theWord;
		
	}
	
	public int getCounts()
	{	
		
		return counts;
	}
	
	
	
	
	public void increaseCounts(){
		// increase value of counts by 1
		
		counts++;
	}
	
	
	
	public static void changeOutputFormat(int j) {
		//classmetod, för den är underlined i labbanvisingar
		// should change the value of outputFormat to 0 or 1 for all instances of Word
		// metoden gör att användaren väljer hur resultatet av ordet ska visas
		// j är valet användaren har gjort i main, valAvOutput
		
		outputFormat = j;	
	}
	
	
	public String toString() {
		
		if( outputFormat == 0)
		{
			String answer1 = String.format("The word is : " + theWord + "\n");
			
			return answer1;
		}
		
		if( outputFormat == 1)
		{
			
			String answer2 = String.format("The word: " + theWord + " has occured: " + counts + " times.");
			
			return answer2;
		}
		
		
		return " ERROR, output format is not 0 or 1 ";//kolla labben vad som ska ske hhär
		// om man skrev t.ex 10, return this
	}
	

}//måsvinge till class Word