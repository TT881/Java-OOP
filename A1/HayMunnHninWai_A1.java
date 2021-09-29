// Full Name - Hay Munn Hnin Wai
// Tutorial - T04
// Hi Sir, This is my own work & Kindly check the below code with some comments. 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

enum SuitEnum
{
	Spade('S'),
	Heart('H'),
	Diamond('D'),
	Club('C');
	
private final char suit;

	  // Constructor 
	SuitEnum (char suit)
	{
		this.suit = suit;
	}
	  //Accessor method
	public char getsuit ()
	{ 	
		return this.suit;
	}
}
enum RankEnum
{
	Two('2'),
	Three('3'),
	Four('4'),
	Five('5'),
	Six('6'),
	Seven('7'),
	Eight('8'),
	Nine('9'),
	Ten	('T'),
	Jack('J'),
	Queen('Q'),
	King('K'),
	Ace('A');
	
	private final char rank;
	
	  //Constructor
	RankEnum (char rank)
	{
		this.rank = rank;
	}
	
	//Accessor method
	public char getrank ()
	{
		return this.rank;
	}
}
class PlayingCard
{
	private SuitEnum suit;
	private RankEnum rank;
	 
	public PlayingCard()
	{
		 
	}
	public PlayingCard ( SuitEnum suit, RankEnum rank)
	{
		setCard(suit, rank);
		 
	}
	public PlayingCard (PlayingCard pc)
	{
		this(pc.suit, pc.rank);
		 
	}
	public SuitEnum getSuit()
	{
		return this.suit;
		 
	}
	public RankEnum getRank()
	{
		return this.rank;
		 
	}
	public void setCard ( SuitEnum suit, RankEnum rank)
	{
		this.suit = suit;
		this.rank = rank;
		 
	}
	public String toString()
	{
		return String.format( "%c%c ", suit.getsuit(), rank.getrank());
		 
	}
	 
}
class MyInt
{
	private int n;
	
	MyInt()
	{
		
	}
	
	public void setInt(int n)
	{
		this.n = n;
	}
	
	public int getInt()
	{
		return n;
	}
}
class HayMunnHninWai_A1
 {
	private final int MAXC = 13 ;
	private final int MAXD = 52;
	
	public static String [] cardArray;
	
	// Create an Object to access PlayingCard Method 
	private static PlayingCard c = new PlayingCard();
	 
	 // ArrayList of Playing Card 
	private void deckOfCards (ArrayList <PlayingCard> cardList)
	{
		for (SuitEnum suit : SuitEnum.values())
		{
			for(RankEnum rank : RankEnum.values())
			cardList.add (new PlayingCard(suit,rank));       // Added to the PlayingCard ( Suit , Rank ) 
		}
	}
	 // Print Deck from ArrayList 
	private void printDeck (ArrayList <PlayingCard> values)
	{
		System.out.printf("Printing from ArrayList\n\n");
		int a = 0;
		
        for (int j = 0; j < (MAXD/MAXC) ; j++)
        {
			for(int k = 0; k < MAXC ; k++)
			{
				System.out.printf("%s ",values.get(a));
				a++;
			}
			System.out.println();
		}    
		
		//............ (OR) ........... 
		/* for (PlayingCard pc: values)
		{
			System.out.print( pc +" ");
			a++;
			if ( a % MAXC == 0 )
			{
				System.out.println();
			}
			
		}*/	
		
		System.out.println("--------------------------" +
						   "--------------------------");
						   					   
				 
	} 
	 // Copy the ArrayList to cardArray
	private void listToArray (ArrayList <PlayingCard> cardList, PlayingCard[] cardArray)
	{
		int x = 0;
	
		for(PlayingCard c : cardList)
		{	
			cardArray[x] = c;
			x++;
		}	
	} 
	
	//.................(OR) ............
	/* private void listToArray(ArrayList<PlayingCard> cardList, PlayingCard[] cardArray)
	{
		// arraylist to array conversion
		for(int i = 0; i < cardList.size(); i++)
		{
			// store all the cards from arrayList into cardArray as new objects
			// by calling PlayingCard's copy constructor
			cardArray[i] = new PlayingCard(cardList.get(i));
		}
	} */
	
	// Print all the 52 playing cards from cardArray
	private void printDeck(PlayingCard[] cardArray)
	{
		System.out.printf("Printing from Array\n\n");
		
		int b = 0;
		
		    // Print the rows
		for (int i = 0; i<(MAXD/MAXC); i++)
		{
			// Print the columns
			for(int j = 0; j < MAXC; j++)
			{
				System.out.printf("%s ", cardArray[b]);
				b++;
			}
			System.out.println();
		}
		System.out.println("--------------------------" +
						   "--------------------------");
		
	}
	//transfer PlayingCard array to String array
	private void transfer (PlayingCard[] cardArray, String[] strArray)
	{
		int i = 0;
		for (PlayingCard c : cardArray)
		{
			strArray[i] = c.toString();
			i++;
		}		
	}
	
	//display the string array
	private void displayStringArray (String[] strArray)
	{
		System.out.printf("Printing from string array%n%n");
		int c = 0;
		for (int i = 0; i < (MAXD/MAXC); i++)
		{
			for (int j = 0; j < MAXC; j++)
			{
				System.out.printf("%s ",strArray [c]);
				c++;
			}
			System.out.println();
		}
		System.out.println("--------------------------" +
						   "--------------------------");
	}
	
	//Shuffle The Deck 50 times 
	private void shuffle (PlayingCard[] cardArray)
	{
		int x = 65;
		int i,j;
		for (int a = 0; a < x; a++)
		{
			i = (int)(Math.random()*MAXD);
			j = (int)(Math.random()*MAXD);
			PlayingCard temp1 = cardArray[i];
			PlayingCard temp2 = cardArray[j];
			cardArray[i] = temp2;
			cardArray[j] = temp1;
			
		}
	}
	
	// Swap the positions of the playing cards 
	private void swap(String[] str, int i, int j)
	{
		String temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
		
	public static void main ( String [] args )
	{
		HayMunnHninWai_A1 a1 = new HayMunnHninWai_A1 ();
		// Task-3a 
		ArrayList<PlayingCard> cardList = new ArrayList<PlayingCard> ();
		a1.deckOfCards (cardList );	
		a1.printDeck(cardList);
		
		// Task-3b 
		PlayingCard[]cardArray= new PlayingCard[ cardList.size()];
		a1.listToArray(cardList, cardArray);
		a1.printDeck(cardArray);
		
		// Task- 3c 
		String[] cardString = new String [cardList.size()];
		a1.transfer(cardArray, cardString);
		a1.displayStringArray(cardString);
		a1.shuffle(cardArray);
		
		System.out.println("Shuffle the cards - Array version");
		a1.printDeck(cardArray);
		
					
	}
	
 }
 
	
	
	
	 
	 
	 
	 