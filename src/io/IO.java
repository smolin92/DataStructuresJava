package io;

import java.io.*;

public final class IO {
	public static BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
	public static PrintStream stdout=System.out;
	public static PrintStream stderr=System.err;
	
	public static String readFile(String name){
		String s="",line;
		BufferedReader f;
		try{
			f=new BufferedReader(new FileReader(name));
			while((line=f.readLine()) !=null){
				s+=line + "\n";
			}
			f.close();
		}
		catch(IOException e){
			stderr.println("Can't open file: " + name);
		}
		return s;
	}
	
	public static String prompt(String s){
		try{
			stdout.print(s);
			stdout.flush();//makes it print but doesn't advance to next line
			return stdin.readLine();
		}
		catch(IOException e){
			stderr.println(e);
			return "";
		}
	}
	
	public static int promptInt(String s, int lo, int hi){
		try{
			stdout.print(s + " [" + lo + " to " + hi + "]");
			stdout.flush();
			int result=Integer.parseInt(stdin.readLine());
			if(result<lo || result>hi){
				throw new IOException("Out of range.");
			}
			return result;
		}
		catch(Exception e){
			stderr.println(e);
			return lo-1;
		}
	}
	
	public static boolean affirmative(String yn){
		return (yn.charAt(0)=='y') || (yn.charAt(0)=='Y');
	}
}
