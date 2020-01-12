import GameEngine.Log;
import GameEngine.MainGame;
import Items.Armor;
import Items.Weapon;
import Items._Item;
import Items.Generators.ArmorGenerator;
import Items.Generators.WeaponGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import Characters.Hero;
import Characters.CharacterClasses.Assassin;
import Characters.CharacterClasses.Warrior;
import Characters.Inventory.Inventory;

public class Main 
{
public static void main(String[] args) 
{
	// INTRODUCTION //
	Hero hero;
	hero = new Warrior("Bob","Warrior",10,10,5,5,5,5,5);

		for(int i = 0; i < 5; i++) {
			Weapon weapon = new Weapon( WeaponGenerator.getRandomWarriorName(), 	//WEAPON GENERATOR
					WeaponGenerator.generateValue( hero ),
					WeaponGenerator.generateDamage( hero ) );
			Armor armor = new Armor( ArmorGenerator.getRandomName(), 				//ARMOR GENERATOR
					ArmorGenerator.generateValue( hero ),
					ArmorGenerator.generateArmor( hero ) );
			hero.equipWeapon(weapon);
			hero.equipArmor(armor);
			hero.weapon.weaponInfo();
			hero.armor.armorInfo();
			hero.inventory.addItem(weapon);
			hero.inventory.addItem(armor);
			Log.info();
			hero.inventory.inventoryInfo();
			hero.inventory.deleteItem(5);
			Log.info(".....................................................................................................");
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

	
	

	Log.info("Hello "+ name + "!");
	hero.printAbilityList();
	hero.distributePoints();
	// GAME SETUP //
	
	
	// START GAME //

	// START GAME //
	 */
}
}
