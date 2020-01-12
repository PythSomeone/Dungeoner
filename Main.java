import GameEngine.Log;
import GameEngine.LootManager;
import GameEngine.MainGame;

import Items.Armor;
import Items.Weapon;
import Items._Item;
import Items.Generators.ArmorGenerator;
import Items.Generators.WeaponGenerator;
import Locations.Dungeon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import Characters.Hero;
import Characters.CharacterClasses.Assassin;
import Characters.CharacterClasses.Warrior;
import Characters.Inventory.Inventory;
import CombatSystem.Combat;

public class Main 
{
public static void main(String[] args) 
{
	// TEST //
	Hero hero;
	hero = new Warrior("Bob","Warrior",10,10,5,5,5,5,5);

		LootManager.monsterDrop(hero, 10);
		LootManager.chestDrop(hero);
		hero.inventory.inventoryInfo();

		
		
	// SAVE //
	/* 
	Scanner skan1=new Scanner(System.in);
	Log.info("Whats Your name?");	
	String name = skan1.nextLine();
	
	
  	Log.info("Whats Your class would be?");	
   String characterclass = skan1.nextLine();
   
   Hero hero;
	   if(characterclass.equalsIgnoreCase("warrior")) {
		   //[NAME][TITLE][HP][MP][STR][AGI][INT][LCK][TGH]//
			hero = new Warrior(name,"Warrior",50,50,5,5,5,5,5);
			
		}
		else if(characterclass.equalsIgnoreCase("assassin")) {
			hero = new Assassin(name,"Assasin",50,50,5,5,5,5,5);
		}
		else {
			hero = new Hero(name,"Mage",50,50,5,5,5,5,5);
		}
		*/

}
}
