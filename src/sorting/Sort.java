//****************************************
//Sort.java
//
//uses heapsort and quicksort to sort an
//array of people
//
//by Stefanie Molin
//
//March 16, 2012
//****************************************

package sorting;

import java.io.IOException;

import io.IO;

public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IO.stdin.
		try{
			Person[] list=new Person[1000];
			
			for(int i=0;i<1000;i++){
				String[] info=IO.stdin.readLine().split(" ");
				list[i]=new Person(info[0], info[1], Integer.parseInt(info[2]));
			}//rebuilds array of people
			PersonDB dataBase=new PersonDB(list);

			if(args.length<1){
				throw new IOException();
			}//makes sure either quicksort or heapsort was selected
			
			if(args[0].substring(1).equals("h")){
				dataBase.heapsort();
				if(args.length>1 && args[1].substring(1).equalsIgnoreCase("stats")){
					IO.stdout.println("Element Comps: " +dataBase.getComps()+ " Swaps: "+dataBase.getSwaps());
				}
				else{
					IO.stdout.print(dataBase);
				}
			}
			else if(args[0].substring(1).equalsIgnoreCase("q")){
				dataBase.quicksort();
				if(args.length>1 && args[1].substring(1).equalsIgnoreCase("stats")){
					IO.stdout.println("Element Comps: " +dataBase.getComps()+ " Swaps: "+dataBase.getSwaps());
				}
				else{
					IO.stdout.print(dataBase);
				}
			}
			else{
				throw new IOException();
			}
		}
		catch(IOException e){
			IO.stdout.println("-h for heapsort\n-q for quicksort");
		}
	}
}
