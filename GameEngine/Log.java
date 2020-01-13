package GameEngine;

import java.util.Scanner;

public class Log 
{

    public static void info() 
    {
        System.out.println();
    }

    public static void info(String message)
    {
        System.out.println(message);
    	System.out.println();
    }
    
    public static void pressAnyKeyToContinue()
    { 
        System.out.println("Press Enter key to continue...");
        System.out.println();
        try
           {
               System.in.read();
           }  
        catch(Exception e)
        {}  
    }
    
    public static int scanInt() {
		Scanner scanner = new Scanner(System.in);
		int sentence = scanner.nextInt();
		Log.info();
		return sentence;
	}
	public static String scanString() {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.next();
		Log.info();
		return sentence;
	}

}