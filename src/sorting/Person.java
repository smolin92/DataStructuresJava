//****************************************
//Person.java
//
//Blueprint for a person object
//
//by Stefanie Molin
//
//March 7, 2012
//****************************************

package sorting;

public class Person implements Comparable<Person>{
	private String firstName;
	private String lastName;
	private static int count=0;
	private static int id=1000;
	private int iDNumber;
	
	public Person(String fn, String ln){
		this.firstName=fn;
		this.lastName=ln;
		this.iDNumber=Person.id;
		Person.id++;
		Person.count++;
	}
	
	public Person(String fn, String ln, int num){
		this.firstName=fn;
		this.lastName=ln;
		this.iDNumber=num;
	}
	
	public String getName(){
		return this.firstName + " " + this.lastName;
	}
	
	public int getID(){
		return this.iDNumber;
	}
	
	public static int getCount(){
		return Person.count;
	}
	
	public String toString(){
		return this.firstName + " " + this.lastName + " " + this.iDNumber;
	}
	
	public int compareTo(Person other){
		if(this.lastName.compareTo(other.lastName)<0){
			return -1;
		}
		else if(this.lastName.compareTo(other.lastName)>0){
			return 1;
		}
		else{
			if(this.firstName.compareTo(other.firstName)<0){
				return -1;
			}
			else if(this.firstName.compareTo(other.firstName)>0){
				return 1;
			}
			else{
				if(this.iDNumber<other.iDNumber){
					return -1;
				}
				else if(this.iDNumber>other.iDNumber){
					return 1;
				}
				else{
					return 0;
				}//only happens if the two people are the same person
			}
		}
	}
}
