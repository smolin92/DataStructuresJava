//**********************************************
//Card.java
//
//Blueprint for a card object
//
//Stefanie Molin
//January 23, 2012
//*********************************************
package hearts;

public class Card implements Comparable<Card>{
	public final static int CLUBS=1;
	public final static int DIAMONDS=2;
	public final static int HEARTS=3;
	public final static int SPADES=4;
	private int suit;
	private int value;
	
	public Card(int s, int v){
		suit=s;
		value=v;
	}
	
	public Card(String readingCard) throws Exception{
		String shape;
		String faceValue;
		
		if(readingCard.length()==2){
			faceValue=readingCard.substring(0,1);
			shape=readingCard.substring(1,2);
		}
		else{
			throw new Exception("Improper card format!");
		}
		
		if(shape.equalsIgnoreCase("C")){
			suit=CLUBS;
		}
		else if(shape.equalsIgnoreCase("D")){
			suit=DIAMONDS;
		}
		else if(shape.equalsIgnoreCase("H")){
			suit=HEARTS;
		}
		else{
			suit=SPADES;
		}
		
		if(faceValue.equalsIgnoreCase("A")){
			value=14;
		}
		else if(faceValue.equalsIgnoreCase("K")){
			value=13;
		}
		else if(faceValue.equalsIgnoreCase("Q")){
			value=12;
		}
		else if(faceValue.equalsIgnoreCase("J")){
			value=11;
		}
		else if(faceValue.equalsIgnoreCase("T")){
			value=10;
		}
		else{
			value=Integer.parseInt(faceValue);
		}
	}//creates a new card with strings(use to recreate a deck from a string)

	public int compareTo(Card other){
		if(this.suit < other.suit){
			return -1;
		}//suit is earlier alphabetically
		else if(this.suit > other.suit){
			return 1;
		}//suit is later alphabetically
		else{
			if(this.value < other.value){
				return -1;
			}//value is less than other card
			else if(this.value > other.value){
				return 1;
			}//value is greater than other card
			else{
				return 0;
			}//same card (should not happen in fair deck)
		}//compare the suit because the value is the same
	}

	public String getSuit(){
		if(suit==SPADES)
			return "S";
		else if(suit==HEARTS)
			return "H";
		else if(suit==DIAMONDS)
			return "D";
		else
			return "C";//clubs
	}//turns the value of suits into words so the player can understand

	public String getValue(){
		if(value==13)
			return "K";
		else if(value==12)
			return "Q";
		else if(value==11)
			return "J";
		else if(value==10)
			return "T";
		else if(value==14)
			return "A";
		else
			return Integer.toString(value);
	}//turns the value of certain cards (face cards) into strings for easier understanding

	public String toString(){
		String playingCard=getValue() + getSuit();
		return playingCard;
	}//returns the card as a unit with both the value and suit
}
