//***************************************************
//Animal.java
//
//Plays the animal game
//
//by Stefanie Molin
//
//March 7, 2012
//**************************************************
package animal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import io.IO;

public class Animal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String knowledge=IO.readFile(args[0]);
			File updated=new File(args[0]);
			AnimalTree animal=new AnimalTree(knowledge);
			int again=1;
			while(again==1){
				String answer=IO.prompt("Do you want to play? ");
				if(!(IO.affirmative(answer))) {
					again=0;
				}
				else animal.play();//plays game
			}
			
			PrintWriter output=new PrintWriter(updated);
			output.print(animal.toString());
			output.close();//updates the knowledge file
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			IO.stderr.print("File Not Found");
		}//deals with bad files
		
	}

}
