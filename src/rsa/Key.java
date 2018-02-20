//***************************************************
//Key.java
//
//key object for use in RSA encryption
//
//by Stefanie Molin
//April 16, 2012
//***************************************************

package rsa;

import java.util.Random;

public class Key {
	private int p;
	private int q;
	private int N;
	private int e;
	private int d;
	private Random rn;
	
	public Key(){
		rn=new Random();
		
		p=rn.nextInt(64)+64;
		if(p==128){
			p--;
		}//ensures that p won't be over 128 if 128 is chosen
		if(!prime(p)){
			p=nextPrime(p);
		}//makes sure p is prime if not already
		q=rn.nextInt(64)+64;
		if(q==128){
			q--;
		}//ensures that q won't be over 128 if 128 is chosen
		if(!prime(q)){
			q=nextPrime(q);
		}//makes sure q is prime if not already
		
		N=p*q;
		e=0;
		int[] result=extendedGCD(e, (p-1)*(q-1));
		int t=result[0];
		int s=result[1];
		while(e==0 || e==1 || e==(p-1)*(q-1) || ((p-1)*(q-1))%e==0 || t<0){
			e=rn.nextInt((p-1)*(q-1));
			while((e*t+(p-1)*(q-1)*s)!=1){
				e=rn.nextInt((p-1)*(q-1));
				result=extendedGCD(e, (p-1)*(q-1));
				t=result[0];
				s=result[1];
			}
			
		}//ensures that e is smaller than (p-1)(q-1) and coprime but not 0 or 1 which wouldn't encrypt properly
		
		d=t;//returns multiplicative inverse
		
		p=0;//destroys p
		q=0;//destroys q
	}
	
	private static boolean prime(int n){
		int sqrtN=(int)Math.sqrt(n);
		boolean[] sieve=new boolean[sqrtN];
		int i;
		for(i=2;i<sqrtN;i++){
			sieve[i]=true;
		}
		for(int p=2;p<sqrtN;p++){
			if(sieve[p]){
				for(i=2*p;i<sqrtN;i+=p){
					sieve[i]=false;
				}
			}
		}
		for(i=2;i<sqrtN;i++){
			if(sieve[i] && n%i==0){
				return false;
			}
		}
		return true;
	}
	
	private static int nextPrime(int n){
		while(true){
			if(prime(++n)){
				return n;
			}
		}
	}
	
	private static int[] extendedGCD(int a, int b){
		int[] array=new int[2];
		if(b==0){
			array[0]=1;
			array[1]=0;
			return array;
		}
		int q=a/b;
		int r=a%b;
		int[] num=extendedGCD(b,r);
		array[0]=num[1];
		array[1]=num[0]-q*num[1];
		return array;
	}//extended Euclidean algorithm
	
	public int[] getPublicKey(){
		int[] publicKey=new int[2];
		publicKey[0]=e;
		publicKey[1]=N;
		return publicKey;
	}
	
	public int[] getPrivateKey(){
		int[] privateKey=new int[2];
		privateKey[0]=d;
		privateKey[1]=N;
		return privateKey;
	}
	
	public static String encode(String[] message, int[] key){
		int[] intMessage=new int[message.length];
		for(int i=0; i<message.length; i++){
			intMessage[i]=Integer.parseInt(message[i]);
		}
		int[] result=new int[message.length];
		for(int i=0; i<message.length; i++){
			result[i]=Key.modPower(intMessage[i], key[0], key[1]);
		}
		String output="";
		for(int i=0; i<result.length; i++){
			if(i==result.length-1){
				output+=result[i];
			}
			else{
				output+=result[i]+"\n";
			}
		}
		return output;
	}
	
	public static String decode(String[] message, int[] key){
		int[] intMessage=new int[message.length];
		for(int i=0; i<message.length; i++){
			intMessage[i]=Integer.parseInt(message[i]);
		}
		int[] result=new int[message.length];
		for(int i=0; i<message.length; i++){
			result[i]=Key.modPower(intMessage[i], key[0], key[1]);
		}
		String output="";
		for(int i=0; i<result.length; i++){
			if(i==result.length-1){
				output+=result[i];
			}
			else{
				output+=result[i]+"\n";
			}
		}
		return output;
	}
	
	private static int modPower(int b, int e, int m){
		if(e==0){
			return 1%m;
		}
		if(e%2==0){
			return sqr(modPower(b,e/2,m))%m;
		}
		else{
			return b*modPower(b,e-1,m)%m;
		}
	}
	
	private static int sqr(int a){
		return a*a;
	}
}
