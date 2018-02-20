//*********************************************************
//Set.java
//Set interface
//Pasik
//February 14, 2012
//*********************************************************
package listUtilities;

import java.util.Iterator;

public interface Set {
	public int size();
	public boolean isEmpty();
	public boolean isMember(Object o);
	public void add(Object o);
	public void remove(Object o);
	public Set union(Set that);
	public Set intersection(Set that);
	@SuppressWarnings("rawtypes")
	public Iterator iterator();
	public Set copy();
	public Set empty();
}
