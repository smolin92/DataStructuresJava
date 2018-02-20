//***************************************************
//BinaryTree.java
//
//Binary tree representation
//
//by Pasik
//
//March 7, 2012
//**************************************************

package animal;

public class BinaryTree {
	@SuppressWarnings("rawtypes")
	private Comparable data;
	private BinaryTree left;
	private BinaryTree right;
	public final static BinaryTree NIL=new BinaryTree();
	
	private BinaryTree(){
		this.data=null;
		this.left=null;
		this.right=null;
	}
	
	@SuppressWarnings("rawtypes")
	public BinaryTree(Comparable data, BinaryTree left, BinaryTree right){
		this.data=data;
		this.left=left;
		this.right=right;
	}
	
	@SuppressWarnings("rawtypes")
	public BinaryTree(Comparable data){
		this(data, BinaryTree.NIL, BinaryTree.NIL);
	}
	
	@SuppressWarnings("rawtypes")
	public Comparable data(){
		return this.data;
	}
	
	public BinaryTree left(){
		return this.left;
	}
	
	public BinaryTree right(){
		return this.right;
	}
	
	@SuppressWarnings("rawtypes")
	public void setData(Comparable d){
		this.data=d;
	}
	
	public void setLeft(BinaryTree t){
		this.left=t;
	}
	
	public void setRight(BinaryTree t){
		this.right=t;
	}
	
	public boolean isEmpty(){
		return this==BinaryTree.NIL;
	}
	
	@SuppressWarnings("rawtypes")
	public BinaryTree insertX(Comparable d){
		return this.insertX(new BinaryTree(d));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BinaryTree insertX(BinaryTree newNode){
		Comparable d=newNode.data();
		if(this.isEmpty()) return newNode;
		if(d.compareTo(this.data())<0){
			if(this.left().isEmpty()) this.setLeft(newNode);
			else this.left().insertX(newNode);
		}
		else{
			if(this.right().isEmpty()) this.setRight(newNode);
			else this.right().insertX(newNode);
		}
		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public BinaryTree insert(Comparable d){
		return this.insert(new BinaryTree(d));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BinaryTree insert(BinaryTree newNode){
		Comparable d=newNode.data();
		if(this.isEmpty()) return newNode;
		return d.compareTo(this.data())<0 ? new BinaryTree(this.data(), this.left().insert(newNode), this.right()):
			new BinaryTree(this.data(), this.left(), this.right().insert(newNode));
	}
	
	private String elementsString(String order){
		if(this.isEmpty()) return "";
		String dataStr=this.data().toString();
		String leftStr=this.left().elementsString(order);
		String rightStr=this.right().elementsString(order);
		if(order.equals("PreOrder")){
			return dataStr + (leftStr!="" ? " % " : "") + leftStr +
					(rightStr!="" ? " % " : "") + rightStr;
		}
		if(order.equals("InOrder")){
			return leftStr + (leftStr!="" ? " " : "") + dataStr +
					(rightStr!="" ? " " : "") + rightStr;
		}
		if(order.equals("PostOrder")){
			return leftStr + (leftStr!="" ? " " : "") + rightStr +
					(rightStr!="" ? " " : "") + dataStr;
		}
		throw new IllegalArgumentException("Bad Order: " + order);
	}
	
	public String toString(){
		return this.toString("PreOrder");
	}
	
	public String toString(String order){
		//return order + "<" + elementsString(order) + ">";
		return elementsString(order);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BinaryTree insertDL(Comparable d){
		BinaryTree dl=new BinaryTree(d);
		BinaryTree p;
		if(this.isEmpty()){
			dl.setLeft(dl);
			dl.setRight(dl);
			return dl;
		}
		if(d.compareTo(this.data())<0){
			dl.setLeft(this.left());
			dl.setRight(this);
			this.setLeft(dl);
			dl.left().setRight(dl);
			return dl;
		}
		for(p=this; p.right()!=this && d.compareTo(p.right().data())>0; p=p.right());
		dl.setLeft(p);
		dl.setRight(p.right());
		p.setRight(dl);
		dl.right().setLeft(dl);
		return this;
	}
	
	public BinaryTree appendDL(BinaryTree that){
		if(this.isEmpty()) return that;
		if(that.isEmpty()) return this;
		BinaryTree thisEnd=this.left();
		BinaryTree thatEnd=that.left();
		thisEnd.setRight(that);
		that.setLeft(thisEnd);
		thatEnd.setRight(this);
		this.setLeft(thatEnd);
		return this;
	}
	
	public BinaryTree tree2DL(){
		if(this.isEmpty()) return this;
		BinaryTree a=this.left().tree2DL();
		BinaryTree b=this.right().tree2DL();
		this.setLeft(this);
		this.setRight(this);
		return a.appendDL(this.appendDL(b));
	}
}
