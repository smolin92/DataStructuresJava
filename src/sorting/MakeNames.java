//****************************************
//MakeNames.java
//
//creates a list of 1000 unique people
//
//by Stefanie Molin
//
//March 16, 2012
//****************************************

package sorting;

import io.IO;

public class MakeNames {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//try {
			String first=IO.readFile(args[0]);
			String last=IO.readFile(args[1]);
			String[] firstNames=first.split("\n");
			String[] lastNames=last.split("\n");
			int numFirst=firstNames.length;
			int numLast=lastNames.length;

			Person[] peopleDB=new Person[1000];
			while(Person.getCount()<1000){
				int i=Person.getCount();
				peopleDB[i]=new Person(firstNames[(int)(Math.random()*numFirst)],lastNames[(int)(Math.random()*numLast)]);
				IO.stdout.println(peopleDB[i]);
			}//prints list of unique people from id 1000 to id 1999
	}

}
