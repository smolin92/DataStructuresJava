//**********************************************
//Deck.java
//
//Blueprint for a deck object
//
//Stefanie Molin
//January 23, 2012
//*********************************************
package hearts;

import io.IO;

public class Deck {
	public final int CARDS_IN_DECK=52;
	private Card[] deck;
	
	public Deck(){
		deck=new Card[CARDS_IN_DECK];
		int count=0;
		while(count<deck.length){
			for(int i=0; i < deck.length/13; i++)
			{
				int s=i+1;
				for(int j=0; j < deck.length/4; j++){
					int v=j+2;
					deck[count]= new Card(s, v);
					count++;
				}	
			}
		}//fills the deck with 13 cards of each suit and 4 of each value
	}
	
	public Deck(Card[] printout){
		deck=printout;
	}
	
	public Deck(String printedDeck) throws Exception{
		String[] printedCards=printedDeck.split(" ");//splits into strings representing each card
		Card[] rebuiltDeck=new Card[printedCards.length];
		for(int i=0; i<printedCards.length; i++){
			rebuiltDeck[i]=new Card(printedCards[i]);
		}//recreates deck
		deck=rebuiltDeck;
	}
	
	public void shuffleDeck(){
		for(int k=0; k<10000; k++){
			int firstIndex=(int)(Math.random()*52);
			int secondIndex=(int)(Math.random()*52);
			Card oneToSwitch=deck[firstIndex];
			Card twoToSwitch=deck[secondIndex];
			deck[firstIndex]= twoToSwitch;
			deck[secondIndex]= oneToSwitch;
		}//shuffles deck
	}
	
	public void deal(){
		Card[] handOne=new Card[deck.length/4];
		Card[] handTwo=new Card[deck.length/4];
		Card[] handThree=new Card[deck.length/4];
		Card[] handFour=new Card[deck.length/4];
		int j=0;
		for(int i=0; i<deck.length; i++){
			handOne[j]=deck[i];
			handTwo[j]=deck[++i];
			handThree[j]=deck[++i];
			handFour[j]=deck[++i];	
			j++;
		}//deals 13 cards to each player
		Deck north=new Deck(handOne);
		Deck east=new Deck(handTwo);
		Deck south=new Deck(handThree);
		Deck west=new Deck(handFour);
		IO.stdout.print("North\n"+north+"\nEast\n"+east+"\nSouth\n"+south+"\nWest\n"+west);
	}
	
	public boolean hasTwoOfClubs(){
		boolean contains=false;
		int CARDS_IN_HAND=13;
		Card twoOfClubs=new Card(Card.CLUBS, 2);
		for(int i=0; i<CARDS_IN_HAND; i++){
			if(deck[i].compareTo(twoOfClubs)==0){
				i=CARDS_IN_HAND;
				contains=true;
			}
		}
		return contains;
	}//checks if a deck contains the two of clubs
	
	public void swap(int i, int j){
		Card temp=this.deck[i];
		this.deck[i]=this.deck[j];
		this.deck[j]=temp;
	}//swaps two cards in a deck
	
	public void bubbleSort(){
		for(int i=0; i<deck.length; i++){
			for(int j=deck.length-1; j>i; j--){
				if(this.deck[j].compareTo(this.deck[j-1])<0){
					this.swap(j, j-1);
				}
			}
		}
	}//uses bubble sort to sort the cards
	
	public String getSpades(){
		String allSpades="";
		for(int i=0; i<deck.length; i++){
			if(deck[i].getSuit().equalsIgnoreCase("S")){
				allSpades+=" "+deck[i].getValue();
			}
		}
		return allSpades;
	}//gives list of all the spades in a hand
	
	public String getHearts(){
		String allHearts="";
		for(int i=0; i<deck.length; i++){
			if(deck[i].getSuit().equalsIgnoreCase("H")){
				allHearts+=" "+deck[i].getValue();
			}
		}
		return allHearts;
	}//gives list of all the hearts in a hand
	
	public String getDiamonds(){
		String allDiamonds="";
		for(int i=0; i<deck.length; i++){
			if(deck[i].getSuit().equalsIgnoreCase("D")){
					allDiamonds+=" "+deck[i].getValue();
			}
		}
		return allDiamonds;
	}//gives list of all the diamonds in a hand
	
	public String getClubs(){
		String allClubs="";
		for(int i=0; i<deck.length; i++){
			if(deck[i].getSuit().equalsIgnoreCase("C")){
				allClubs+=" "+deck[i].getValue();
			}
		}
		return allClubs;
	}//gives list of all the clubs in a hand
	
	public String toString(){
		String deckString="";
		for(int i=0; i<deck.length; i++){
			deckString+=deck[i] + " ";
		}
		return deckString;
	}
}
