package package2;

import package3.Character;
import package3.Monster;
import java.util.Scanner;
import package3.Rat;
import package3.Skieleton;
import package3.Wolf;

public class Start 
{
	
	public static void setup()
	{
		
		
		Scanner skan1=new Scanner(System.in);
		Log.info("Whats ur name?");
		String name = skan1.nextLine();
		Character champion =new Character(name,10,0,1,15,20);
		Log.info("Hello "+name);
		MainGame game =new MainGame(champion);
		Tavern tavern =new Tavern(champion);
	

		
		Monster rat=new Rat(5,10);
		Monster wolf = new Wolf(15,30);
		Monster skieleton = new Skieleton(45,90);
		game.play();
		skan1.close();
		
	}

}
