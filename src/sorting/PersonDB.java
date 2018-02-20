//****************************************
//PersonDB.java
//
//collection of unique people
//
//by Stefanie Molin
//
//March 16, 2012
//****************************************
package sorting;

public class PersonDB {
	private Person[] array;
	private final int NUM_OF_PEOPLE=1000;
	private int comps;
	private int swaps;
	
	public PersonDB(Person[] people){
		this.array=people;
		this.comps=0;
		this.swaps=0;
	}
	
	public String toString(){
		String result="";
		for(int i=0; i<NUM_OF_PEOPLE; i++){
			result+=array[i].toString()+"\n";
		}
		return result;
	}
	
	public int getComps(){
		return comps;
	}
	
	public int getSwaps(){
		return swaps;
	}
	
	private static int left(int i){
		return 2*i+1;
	}
	
	private static int right(int i){
		return 2*i+2;
	}
	
	private static int lastInternal(int out){
		return (out/2)-1;
	}
	
	private static boolean isLeaf(int i, int out){
		return i>PersonDB.lastInternal(out);
	}
	
	private void makeHeap(int top, int out){
		this.makeHeap(this.array[top],top,out);
	}
	
	private void makeHeap(Person p, int top, int out){
		if(PersonDB.isLeaf(top, out)){
			this.array[top]=p;
			this.swaps++;
			return;
		}
		this.comps++;
		int larger=PersonDB.right(top)<out && 
				(this.array[PersonDB.right(top)]).compareTo(this.array[PersonDB.left(top)])>0 ?
				PersonDB.right(top) : PersonDB.left(top);
		this.comps++;
		if(p.compareTo(this.array[larger])>0){
			this.array[top]=p;
			this.swaps++;
			return;
		}
		this.array[top]=this.array[larger];
		this.swaps++;
		this.makeHeap(p, larger, out);
	}
	
	public void heapsort(){
		for(int i=PersonDB.lastInternal(this.array.length);i>=0; i--){
			this.makeHeap(i, this.array.length);
		}
		for(int i=this.array.length-1; i>0; i--){
			this.swap(0,i);
			this.makeHeap(0, i);
		}
	}
	
	public void swap(int i, int j){
		Person temp=this.array[i];
		this.array[i]=this.array[j];
		this.array[j]=temp;
		this.swaps+=3;
	}
	
	private int pivotIndex(int top, int out){
		double one=Math.random();
		double two=Math.random();
		double three=Math.random();
		
		if(one<(two+three)/2){
			return top+(int)(Math.min(two, three)*(out-top));
		}
		else if(one>(two+three)/2){
			return top+(int)(Math.max(two, three)*(out-top));
		}
		else{
			return top+(int)(one*(out-top));
		}
		//uses median of 3 to improve quicksort pivot selection

		
		//return top;
	}
	
	private int split(int top, int bot, int pivotIndex){
		Person pivot=this.array[pivotIndex];
		this.swap(pivotIndex, bot);
		int i=top;
		for(int j=top; j<bot; j++){
			this.comps++;
			if(this.array[j].compareTo(pivot)<0){
				this.swap(j, i++);
			}
		}
		this.swap(i, bot);
		return i;
	}
	
	public void quicksort(){
		this.quicksort(0,NUM_OF_PEOPLE);
	}
	
	private void quicksort(int top, int out){
		if(top<out-1){
			int mid=this.split(top, out-1, this.pivotIndex(top,out));
			this.quicksort(top,mid);
			this.quicksort(mid+1,out);
		}
	}
}
