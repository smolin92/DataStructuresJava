//**********************************************
//Deal.java
//
//Reads string version of a deck from stdin,
//recreates it, and writes 4 separate 13-card
//hands in string versions to stdout.
//
//Stefanie Molin
//January 23, 2012
//*********************************************
package hearts;

import io.*;

public class Deal {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String shuffledDeck=IO.stdin.readLine();//reads the deck's contents as a string
		Deck d=new Deck(shuffledDeck);//recreates the deck
		d.deal();//deals the deck out to the four players and prints their hands to stdout
	}

}
