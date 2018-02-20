//*************************************************
//NewDeck.java
//
//Makes deck and writes string version to stdout.
//
//Stefanie Molin
//January 23, 2012
//*************************************************

package hearts;

import io.*;//package io from class

public class NewDeck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck d=new Deck();
		IO.stdout.print(d);//writes string version of deck onto stdout
	}

}
