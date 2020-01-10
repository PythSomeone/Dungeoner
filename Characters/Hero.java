package Characters;

import java.util.ArrayList;
import java.util.Scanner;

import CombatSystem.Ability;
import GameEngine.Log;

public class Hero extends Character {

	public Hero(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness);	
	}
	
	protected String title;
	private int requiredExp;
	private int currentExp = 0;
	private int statAmount = 0;
	

	
	protected int baseHealthIncrease;
	protected int baseManaIncrease;
	
	
	private String[] availableAttributes = {"strenght","agility","inteligence","luck","toughness"};
	
	public void levelUp()
	{
		this.maxHealth += level * baseHealthIncrease;
		this.maxMana += level * baseManaIncrease;
		this.currentHealth = this.maxHealth;
		this.currentMana = this.maxMana;
		this.statAmount += 5;
		level++;
		
		Log.info("You've leveled up!  (+" 
		+ level * baseHealthIncrease + " health | +" 
		+ level * baseManaIncrease + " mana)");		
	}
	
	public void distributePoints() {
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < this.statAmount; i++) {
			Log.info("Choose attribute ( " + printAvailableAttributes() + ") :");
			
			String choice = scan.nextLine();
			
			if(choice.equalsIgnoreCase("strenght")) this.strenght++;
			else if(choice.equalsIgnoreCase("agility")) this.agility++;
			else if(choice.equalsIgnoreCase("inteligence")) this.inteligence++;
			else if(choice.equalsIgnoreCase("luck")) this.luck++;
			else if(choice.equalsIgnoreCase("toughness")) this.toughness++;
			else {
				Log.info("Skill point have not been distributed. Try again!");
				i--;
			}
			Log.info("You've added 1 point to " + choice.toUpperCase());
		}
		Log.info("");
	}
	
	public String printAvailableAttributes() {
		String sentence = "";
		for(String attribute : availableAttributes) {
			sentence += "["+attribute.toUpperCase()+"] ";

		}
		return sentence;	
	}
	public void printAbilityList(){
		Log.info("Available abilities: ");
		for(Ability ability: abilities) {
			Log.info();
			Log.info("["+ability.getName()+"]["+ability.getManaUsage()+"]");
		}
	}

}
