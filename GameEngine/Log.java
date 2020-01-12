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
    }
    
    public static int scanInt() {
		Scanner scanner = new Scanner(System.in);
		int sentence = scanner.nextInt();
		//scanner.close();
		return sentence;
	}
	public static String scanString() {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.next();
		//scanner.close();
		return sentence;
	}

}