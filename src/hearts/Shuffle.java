//**********************************************
//Shuffle.java
//
//Reads string version of a deck from stdin,
//recreates it, shuffles, and writes the string
//version to stdout.
//
//Stefanie Molin
//January 23, 2012
//*********************************************

package hearts;

//import java.io.IOException;

import io.*;

public class Shuffle {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String printedDeck=IO.stdin.readLine();//reads the deck's contents as a string
		Deck d=new Deck(printedDeck);//recreates the deck
		d.shuffleDeck();//shuffles deck
		IO.stdout.print(d);//writes shuffle deck onto stdout
	}

}
