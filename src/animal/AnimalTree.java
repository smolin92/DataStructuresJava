//***************************************************
//AnimalTree.java
//
//Class for the animal tree object using binary trees
//
//by Stefanie Molin
//
//March 7, 2012
//**************************************************
package animal;

import io.IO;

public class AnimalTree {
	private BinaryTree animalTree;
	private static BinaryTree temp;
	private static int count=0;

	public AnimalTree(String input){
		String[] a=input.split(" % ");
		temp=new BinaryTree(a[0]);
		animalTree=AnimalTree.parseAnimalTree(a,0);
	}

	public String toString(){
		return animalTree.toString();
	}//prints the tree using the BinaryTree toString() method

	public void play(){
		animalTree=this.play(animalTree);
	}
	
	private BinaryTree play(BinaryTree a){
		String answer="";
		String animal;
		String distinguish;
		String guess;
		String verdict;
		if(a.left().isEmpty()){
			answer=IO.prompt("Is your animal " +a.data()+"? ");
			if(IO.affirmative(answer)){
				IO.stdout.print("Thanks for playing. \n");
				return a;
			}//no left side implies no right side so it must be an animal. if yes then correct
			else{
				guess=a.data().toString();
				animal=IO.prompt("I give up. What is your animal? ");
				distinguish=IO.prompt("Type a question that distinguishes " + guess+" from "+animal+": ");
				verdict=IO.prompt("What is the answer for "+animal+"? ");
				if(IO.affirmative(verdict)){
					BinaryTree addition=new BinaryTree(distinguish, new BinaryTree(animal), new BinaryTree(guess));
					return addition;
				}
				else{
					BinaryTree addition=new BinaryTree(distinguish, new BinaryTree(guess), new BinaryTree(animal));
					return addition;
				}
				//if original guess was wrong, take in user animal, a question, and an answer and build a new tree
				//representative of this
			}
		}
		else{
			answer=IO.prompt(a.data().toString()+" ");
			if(IO.affirmative(answer)){
				a.setLeft(this.play(a.left()));
			}
			else{
				a.setRight(this.play(a.right()));
			}
			//recursively call the play method moving down the tree with left turns for yes and right for no
		}
		return a;
		//return the result of extending the tree in the right spot with the new knowledge
	}
	
	private static BinaryTree parseAnimalTree(String[] input, int index){
		if((input[index].charAt((input[index].length())-1)!=('?'))){
			BinaryTree a=new BinaryTree(input[index]);
			count++;
			return a;	
		}//was an animal so the tree has only one element
		else{
			count++;
			temp=new BinaryTree(input[index], AnimalTree.parseAnimalTree(input, count), AnimalTree.parseAnimalTree(input, count));
		}
		//otherwise increment count and make a new tree with the value at the index as data and the result of
		//parsing the left and right sides
		return temp;
	}
}
