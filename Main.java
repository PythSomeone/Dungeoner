import GameEngine.Log;
import GameEngine.MainGame;
import Items.Weapon;
import Items._Item;
import Items.Generators.WeaponGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import Characters.Hero;
import Characters.CharacterClasses.Assassin;
import Characters.CharacterClasses.Warrior;

public class Main 
{
public static void main(String[] args) 
{
	// INTRODUCTION //
	Hero hero;
	hero = new Warrior("Bob","Warrior",50,50,5,5,5,5,5);

	for(int i = 0; i<300; i++) {
		Weapon weapon = new Weapon( WeaponGenerator.getRandomWarriorName(), 
				WeaponGenerator.generateValue( hero ),
				WeaponGenerator.generateDamage( hero ) );
		weapon.equip();
		weapon.weaponInfo();	
		hero.levelUp();
	}
	// INTRODUCTION //
	
	/*
	// GAME SETUP //
	Scanner skan1=new Scanner(System.in);
	Log.info("Whats Your name?");	
	String name = skan1.nextLine();
	
	
  	Log.info("Whats Your class would be?");	
   String characterclass = skan1.nextLine();
   
   Hero hero;
   Hero hh;
	   if(characterclass.equalsIgnoreCase("warrior")) {
		   //[NAME][TITLE][HP][MP][STR][AGI][INT][LCK][TGH]//
		   hh = new Warrior(characterclass, characterclass, 0, 0, 0, 0, 0, 0, 0);
			hero = new Warrior(name,"Warrior",50,50,5,5,5,5,5);
			
		}
		else if(characterclass.equalsIgnoreCase("assassin")) {
			hero = new Assassin(name,"Assasin",50,50,5,5,5,5,5);
		}
		else {
			hero = new Hero(name,"Mage",50,50,5,5,5,5,5);
		}

	
	

	Log.info("Hello "+ name + "!");
	hero.printAbilityList();
	hero.distributePoints();
	// GAME SETUP //
	
	
	// START GAME //
	hero.levelUp();
	hero.levelUp();
	hero.distributePoints();
	// START GAME //
	
	//FIGHTSTATES//
	// 1 - */
}
}
