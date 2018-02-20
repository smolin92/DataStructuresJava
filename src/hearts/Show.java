//**********************************************
//Show.java
//
//Reads 4 hands from stdin and prints them to 
//stdout in an easy to understand manner.
//
//Stefanie Molin
//January 23, 2012
//*********************************************
package hearts;

import io.*;

public class Show {

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
		n.bubbleSort();
		s.bubbleSort();
		e.bubbleSort();
		w.bubbleSort();//sorts hands
		
		IO.stdout.print("\n\t\t\t\tNORTH");
		IO.stdout.print("\n\t\t\t\tClubs:"+n.getClubs());
		IO.stdout.print("\n\t\t\t\tDiamonds:"+n.getDiamonds());
		IO.stdout.print("\n\t\t\t\tHearts:"+n.getHearts());
		IO.stdout.print("\n\t\t\t\tSpades:"+n.getSpades());
		IO.stdout.print("\nWEST\t\t\t\t\t\t\t\tEAST");
		IO.stdout.print("\nClubs:"+w.getClubs()+ "\t\t\t\t\t\t\t\tClubs:"+e.getClubs());
		IO.stdout.print("\nDiamonds:" + w.getDiamonds()+"\t\t\t\t\t\t\tDiamonds:"+e.getDiamonds());
		IO.stdout.print("\nHearts:"+w.getHearts()+"\t\t\t\t\t\t\tHearts:"+e.getHearts());
		IO.stdout.print("\nSpades:"+w.getSpades()+"\t\t\t\t\t\t\tSpades:"+e.getSpades());
		IO.stdout.print("\n\t\t\t\tSOUTH");
		IO.stdout.print("\n\t\t\t\tClubs:"+s.getClubs());
		IO.stdout.print("\n\t\t\t\tDiamonds:"+s.getDiamonds());
		IO.stdout.print("\n\t\t\t\tHearts:"+s.getHearts());
		IO.stdout.print("\n\t\t\t\tSpades:"+s.getSpades()+"\n");
		}//prints formatted

}
