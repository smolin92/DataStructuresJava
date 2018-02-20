//*********************************************************
//ImmutableList.java
//
//from Pasik edited by Stefanie Molin
//February 14, 2012
//*********************************************************

package listUtilities;

public class ImmutableList {
	private final Object data;
	private final ImmutableList next;
	public static final ImmutableList NIL=new ImmutableList();

	private ImmutableList(Object d, ImmutableList n){
		data=d;
		next=n;
	}

	private ImmutableList(){
		data=null;
		next=null;
	}

	/*factory methods for creating or extending Immutable Lists*/
	public static ImmutableList list(Object d){
		return new ImmutableList(d, ImmutableList.NIL);
	}

	public ImmutableList push(Object d){
		return new ImmutableList(d, this);
	}

	/*accessors*/
	public Object head(){
		return data;
	}

	public ImmutableList tail(){
		return next;
	}

	/*isEmpty test*/
	public boolean isEmpty(){
		return this==ImmutableList.NIL;
	}

	/*x.length() returns the number of elements in x.
	 * base case: an empty list has zero elements.
	 * otherwise: a list has one more element than its tail 
	 */
	public int length(){
		return this.isEmpty() ? 0 : 1+this.tail().length();
	}

	/*x.find(y) returns ImmutableList.NIL if y is not an element of x
	 * and returns the sublist of x whose head is y if y is an element of x.
	 * base case: return the list itself if it is empty or if its head equals
	 * 			the object.
	 * otherwise: find the object in the tail
	 */
	public ImmutableList find(Object d){
		return this.isEmpty() || d.equals(this.head()) ? this : this.tail().find(d);
	}

	/*this.append(that) returns a new ImmutableList with all the elements of this followed
	 * by all elements of that.
	 * base case: appending that onto the empty list is just that.
	 * otherwise: append that onto the tail of this and then push the head of this 
	 * onto the result.
	 */
	public ImmutableList append(ImmutableList that){
		return this.isEmpty() ? that : this.tail().append(that).push(this.head());
	}

	/*x.reverse() returns a list with all elements in reverse order.
	 * base case: reversing an empty list is the empty list.
	 * otherwise: reverse the tail, and then append a one-element list containing the head
	 * onto the end.
	 */
	public ImmutableList reverse(){
		return this.isEmpty() ? this: this.tail().reverse().append(list(this.head()));
	}

	/*the nth element of a list (indexed from zero)
	 * base case: if n is zero, return the head.
	 * otherwise: return the n-1'st element of the tail.
	 */
	public Object nth(int n){
		return this.isEmpty() || n<0 ? null : n==0 ? this.head() : this.tail().nth(n-1);
	}

	/*x.delete(y) returns a new list with all elements of x except those that equal y.
	 * base case: an empty list has no elements, so return the empty list.
	 * otherwise: if the head is equal to y, return the result of deleting y from the tail.
	 * otherwise: return the result of deleting y from the tail, but then push the head onto
	 * the result.
	 */
	public ImmutableList delete(Object d){
		return this.isEmpty() ? this: 
			d.equals(this.head()) ? this.tail().delete(d) : this.tail().delete(d).push(this.head());
	}

	/*x.insert(y) assumes that x is a list of Comparables in order and returns a new list with all the
	 * elements of x in addition to the new element y, inserted in the correct position.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ImmutableList insert(Comparable d){
		return this.isEmpty() || d.compareTo(this.head()) <0 ? this.push(d):
			this.tail().insert(d).push(this.head());
	}

	public String toString(){
		return this.isEmpty() ? "()" : "(" + this.head().toString() + (this.tail().isEmpty() ? "" : " ")
				+ this.tail().toString().substring(1);
	}

	public static ImmutableList parseIntList(String s){
		int openBracket=s.indexOf('(');
		int closeBracket=s.indexOf(')');
		if(openBracket!=0 || closeBracket!=s.length()-1)
			throw new IllegalArgumentException(s);

		String[] intStrings=s.substring(openBracket+1, closeBracket).split(" ");
		ImmutableList result=ImmutableList.NIL;

		for(int i=intStrings.length-1; i>=0; i--)
			result=result.push(Integer.parseInt(intStrings[i]));

		return result;
	}

	public ImmutableList purge(){
		if(this.isEmpty()||this.length()==1){
			return this;
		}//base case
		ImmutableList temp=ImmutableList.list(this.head());
		ImmutableList placeHolder=this.tail().delete(this.head());
		return temp.append(placeHolder.purge());
	}//otherwise start a new list with the head, delete it from the tail of the original
	//and append the result of purging that to the head

	public ImmutableList merge(int top1, int top2, int out){
		ImmutableList result=ImmutableList.NIL;
		String[] temp=new String[out-top1];
		int i=top1;
		int j=top2;
		int k=0;
		
		while(i<top2 && j<out){
			temp[k++]=(Integer.parseInt(this.nth(i).toString())<Integer.parseInt(this.nth(j).toString())) ? this.nth(i++).toString() :
				this.nth(j++).toString();
		}
		
		while(i<top2) temp[k++]=this.nth(i++).toString();
		while(j<out) temp[k++]=this.nth(j++).toString();
		
		for(k=0; k<temp.length; k++){
			result=result.insert(temp[k]);
		}
		return result;
	}
	
	private ImmutableList mergeSort(int top, int out){
		ImmutableList temp=ImmutableList.NIL;
		if(top<out-1){
			int mid=(top+out)/2;
			mergeSort(top,mid);
			mergeSort(mid,out);
			temp=temp.append(merge(top, mid, out));
		}
		return temp;
	}

	public ImmutableList mergeSort(){
		return mergeSort(0, this.length());
	}
}
