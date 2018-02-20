//*********************************************************
//ListSetTest.java
//creates a ImmutableList of ints, purges, sorts, and prints
//to stdout. Then creates a ListSet of the original ints
//and prints those to stdout.
//Stefanie Molin
//February 14, 2012
//*********************************************************
package listUtilities;

import io.*;

public class ListSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImmutableList temp=ImmutableList.list(args[0]);
		for(int i=1; i<args.length; i++){
			temp=temp.append(ImmutableList.list(args[i]));
		}//creates ImmutableList of integers
		ImmutableList list=temp.purge().mergeSort();
		IO.stdout.println("Immutable List is " +list);//prints purged and sorted list
		ListSet set=new ListSet(temp);//creates ListSet of original ints
		IO.stdout.println("ListSet is " + set.purgeAndSort());//prints set which is sorted and without duplicates
	}

}
