import GameEngine.Log;
import GameEngine.MainGame;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import Characters.Hero;
import Characters.CharacterClasses.Warrior;

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
	
	
  	Log.info("Whats Your class would be?");	
   String characterclass = skan1.nextLine();
   
   Hero hero;
	   if(characterclass.equalsIgnoreCase("warrior")) {
			hero = new Hero(name,"Warrior",50,50,5,5,5,5,5);
			
		}
		else if(characterclass.equalsIgnoreCase("assassin")) {
			hero = new Hero(name,"Assasin",50,50,5,5,5,5,5);
		}
		else {
			hero = new Hero(name,"Mage",50,50,5,5,5,5,5);
		}

	
	
	skan1.close();

	Log.info("Hello "+ name + "!");
	hero.distributePoints();
	// GAME SETUP //
	
	
	// START GAME //
	hero.levelUp();
	hero.levelUp();
	hero.distributePoints();
	// START GAME //
	
	//FIGHTSTATES//
	// 1 - 
}
}
