package GameEngine;

import Characters.Hero;
import Characters.CharacterClasses.Assassin;
import Characters.CharacterClasses.Mage;
import Characters.CharacterClasses.Warrior;
import Items.Armor;
import Items.Weapon;

public class GameManager {
	
	private static Weapon beginnerWeapon = new Weapon("Wooden stick", 1, 1);
	private static Armor beginnerArmor = new Armor("Tattered cloth", 1, 1);
	private static Hero heroCreated;
	
	public static void greetingMessage() {
		String nameCreate;
		String classCreate = "noone";
		
		 Log.info("Welcome to the Dungeoner. It is a dangerous place where danger lurks in every corner. ");
		 Log.info("But you know why you're here. For the same reason as everyone else - gold and magic glitters.");
		 Log.info("I don't want to stop you too long, but I would love to know your adventurer name.");
		 nameCreate = Log.scanString();
		 Log.info("It's really nice meeting you "+ nameCreate +". And what techniques do you use in combat? Are you a damage-resistant,");
		 Log.info("muscular WARRIOR? Or maybe a silent and quick ASSASSIN? There is also an option that you spent your young years studying powerful"); 
		 Log.info("magic techniques as a MAGE. Don't make me guess, I'm dying of curiosity.");	
		 while(!classCreate.equalsIgnoreCase("Warrior") && !classCreate.equalsIgnoreCase("Assassin") && !classCreate.equalsIgnoreCase("Mage")) {
			 classCreate = Log.scanString();
			//[NAME][TITLE][HP][MP][STR][AGI][INT][LCK][TGH]//
			 if(classCreate.equalsIgnoreCase("Warrior"))		heroCreated = new Warrior(nameCreate,"Warrior",50,50,5,5,5,5,5);
			 else if(classCreate.equalsIgnoreCase("Assassin"))	heroCreated = new Assassin(nameCreate,"Assassin",50,50,5,5,5,5,5);
			 else if(classCreate.equalsIgnoreCase("Mage"))		heroCreated = new Mage(nameCreate,"Mage",50,50,5,5,5,5,5);
		 }
		 Log.info("Allrighty mighty " + heroCreated.getTitle() + ". Let me explain the rules here. Entering these ancient dungeons involves great risk.");
		 Log.info("You don't know when they will let you leave, so I hope you have prepared the necessary equipment. Oh, did you come empty-handed?"); 
		 Log.info("Don't worry, I have something for you.");
		 heroCreated.equipWeapon(beginnerWeapon);
		 heroCreated.equipArmor(beginnerArmor);
		 Log.info("Now you are ready to face the Dungeoner. Good luck and don't look back!");
		 Log.pressAnyKeyToContinue();
	}
	
	public static Hero getHero() {
		return heroCreated;
	}
	
}

