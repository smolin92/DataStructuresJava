//**********************************************
//Leader.java
//
//Reads 4 hands from stdin (North, East, South,
//and West) and writes which hand contains the
//2 of clubs to stdout.
//
//Stefanie Molin
//January 23, 2012
//*********************************************
package hearts;

import io.*;

public class Leader {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		IO.stdin.readLine();//skips over name
		String north=IO.stdin.readLine();//reads the deck's contents as a string
		IO.stdin.readLine();
		String east=IO.stdin.readLine();
		IO.stdin.readLine();
		String south=IO.stdin.readLine();
		IO.stdin.readLine();
		String west=IO.stdin.readLine();
		Deck n=new Deck(north);//recreates the hands
		Deck e=new Deck(east);
		Deck s=new Deck(south);
		Deck w=new Deck(west);
		if(n.hasTwoOfClubs()){
			IO.stdout.println("North");
		}
		if(e.hasTwoOfClubs()){
			IO.stdout.println("East");
		}
		if(s.hasTwoOfClubs()){
			IO.stdout.println("South");
		}
		if(w.hasTwoOfClubs()){
			IO.stdout.println("West");
		}//determines which player has the two of clubs
	}

}
