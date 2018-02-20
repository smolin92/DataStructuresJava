//***************************************************
//Encode.java
//
//encodes or decodes based on RSA encryption key
//
//by Stefanie Molin
//April 16, 2012
//***************************************************

package rsa;

import java.io.IOException;

import io.IO;

public class Encode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String d=args[0];
			String mess=IO.stdin.readLine();
			String temp;
			while((temp=IO.stdin.readLine()) != null){
				mess+="\n"+temp;
			}
			String[] message=mess.split("\n");
			
			if(d.contains("private")){
				int[] priv=new int[2];
				String[] nums=IO.readFile(args[0]).split("\n");
				for(int i=0; i<priv.length; i++){
					priv[i]=Integer.parseInt(nums[i]);
				}
				IO.stdout.println(Key.decode(message, priv));
			}
		
			if(d.contains("public")){
				int[] pub=new int[2];
				String[] nums=IO.readFile(args[0]).split("\n");
				for(int i=0; i<pub.length; i++){
					pub[i]=Integer.parseInt(nums[i]);
				}
				IO.stdout.println(Key.encode(message, pub));
			}
		} 
		catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
