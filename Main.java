import GameEngine.Log;
import GameEngine.MainGame;

import java.util.Scanner;

import Characters.Hero;

public class Main 
{
public static void main(String[] args) 
{
	// INTRODUCTION //
	
	// INTRODUCTION //
	
	
	// GAME SETUP //
	Scanner skan1=new Scanner(System.in);
	Log.info("Whats Your name?");	
	String name = skan1.nextLine();
	
	Hero hero = new Hero(name,50,50,5,5,5,5,5);
	Log.info("Hello "+ name + "!");
	hero.distributePoints();
	// GAME SETUP //
	
	
	// START GAME //
	hero.levelUp(4, 4, 1);
	hero.levelUp(4, 4, 1);
	hero.distributePoints();
	// START GAME //
	
	//FIGHTSTATES//
	// 1 - 
}
}
