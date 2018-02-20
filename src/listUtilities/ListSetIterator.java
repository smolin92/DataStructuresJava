//*********************************************************
//ListSetIterator.java
//Iterator interface implementation for ListSets
//Stefanie Molin
//February 14, 2012
//*********************************************************
package listUtilities;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class ListSetIterator implements Iterator{
	private int nextIndex;
	private ListSet set;
	
	public ListSetIterator(ListSet s){
		this.nextIndex=0;
		this.set=s;
	}
	
	public boolean hasNext(){
		return this.nextIndex < this.set.size();
	}
	
	public Object next(){
		return this.set.getList().nth(nextIndex++);
	}
	
	public void remove(){
	}
}
