//*********************************************************
//ListSet.java
//uses ImmutableLists to implement the set interface
//Stefanie Molin
//February 14, 2012
//*********************************************************

package listUtilities;

import java.util.Iterator;

public class ListSet implements Set{
	private ImmutableList input=ImmutableList.NIL;
	
	public ListSet(ImmutableList list){
		input=input.append(list);
	}
	
	public ListSet(String intString){
		input=ImmutableList.parseIntList(intString);
	}
	
	public ImmutableList getList(){
		return input;
	}
	
	public int size(){
		return input.length();
	}
	public boolean isEmpty(){
		return input.isEmpty();
	}
	public boolean isMember(Object o){
		return input.find(o).equals(ImmutableList.NIL) ? false : true;
	}
	public void add(Object o){
		input.push(o);
	}
	public void remove(Object o){
		input.delete(o);
	}
	public Set union(Set that){
		return (Set) input.append(((ListSet) that).getList());
	}
	public Set intersection(Set that){
		return (Set) input.append(((ListSet) that).getList()).purge();
	}
	@SuppressWarnings("rawtypes")
	public Iterator iterator(){
		return new ListSetIterator(this);
	}
	public Set copy(){
		ImmutableList copy=ImmutableList.NIL;
		return (Set) copy.append(input);
	}
	public Set empty(){
		input=ImmutableList.NIL;
		return (Set) input;
	}
	public ListSet purgeAndSort(){
		return new ListSet(input.purge().mergeSort());
	}
	public String toString(){
		return this.input.isEmpty() ? "{}" : "{ " + this.input.head().toString() 
				+ (this.input.tail().isEmpty() ? "" : " ")
				+ this.input.tail().toString().substring(1,input.tail().toString().length()-1)+ " }";
	}
}
