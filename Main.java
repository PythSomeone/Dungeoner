import GameEngine.Log;
import GameEngine.MainGame;

import java.util.Scanner;

import Characters.Hero;

public class Main 
{
public static void main(String[] args) 
{
	// GAME SETUP //
	Scanner skan1=new Scanner(System.in);
	Log.info("Whats ur name?");	
	String name = skan1.nextLine();
	Log.info("Hello "+ name);
	
	Hero hero = new Hero(name,50,50,5,5,5,5,5);
	// GAME SETUP //
	
	
}
}
