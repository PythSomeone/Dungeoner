package Characters;

import java.util.Scanner;

import GameEngine.Log;

public class Hero extends Character {

	public Hero(String name, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness);	
	}
	
	private int requiredExp;
	private int currentExp;
	
	
	public void levelUp(int healthIncrease, int manaIncrease, int statAmount)
	{
		level++;
		this.maxHealth += healthIncrease;
		this.maxMana += manaIncrease;
		this.currentHealth = this.maxHealth;
		this.currentMana = this.maxMana;
		
		Log.info("You've leveled up!  (+" 
		+ healthIncrease + " health | +" 
		+ manaIncrease + " mana)");
		
		// !!!HERE NEEDS TO BE CHOOSING STATISTICS TO ADD!!!
		Scanner scan = new Scanner(System.in);
		String[] availableAttributes = {"strenght","agility","inteligence","luck","toughness"};
		
		for(int i = 0; i < statAmount; i++) {
			Log.info("Choose attribute ( Strenght, Agility, Inteligence, Luck, Toughness ) :");
			
			
			String choice = scan.nextLine();
			
			/*
			for(;;) {
				choice = scan.nextLine();
				for(String x : availableAttributes) {
					if(choice.equalsIgnoreCase(x))
						break;
				}
			}
			*/
			if(choice.equalsIgnoreCase("strenght")) this.strenght++;
			else if(choice.equalsIgnoreCase("agility")) this.agility++;
			else if(choice.equalsIgnoreCase("inteligence")) this.inteligence++;
			else if(choice.equalsIgnoreCase("luck")) this.luck++;
			else if(choice.equalsIgnoreCase("toughness")) this.toughness++;
			else {
				Log.info("Skill point have not been distributed. Try again!");
				i--;
			}

		}
		
	}
	

}
