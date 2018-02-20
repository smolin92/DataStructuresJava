//***************************************************
//Makekeys.java
//
//makes private and public keys for RSA encryption
//
//by Stefanie Molin
//April 16, 2012
//***************************************************

package rsa;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import io.IO;

public class Makekeys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			if(args.length<1){
				throw new IOException();
			}
			String name=args[0];
			Key k=new Key();
			File pubKey=new File(name +".public.txt");
			int[] pub=k.getPublicKey();
			int[] priv=k.getPrivateKey();
			PrintWriter p=new PrintWriter(pubKey);
			p.print(pub[0]+"\n"+ pub[1]);
			p.close();
			File privKey=new File(name +".private.txt");
			PrintWriter q=new PrintWriter(privKey);
			q.print(priv[0]+"\n"+priv[1]);
			q.close();
		}
		catch(IOException e){
			IO.stdout.print("Please add the name as a command line argument.");
		}
	}
}
