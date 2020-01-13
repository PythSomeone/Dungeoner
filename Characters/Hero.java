package Characters;

import java.util.ArrayList;
import java.util.Scanner;

import Characters.Inventory.Inventory;
import CombatSystem.Ability;
import GameEngine.Log;
import Items.Armor;
import Items.Weapon;

public class Hero extends Character {

	public Inventory inventory;
	public Weapon weapon;
	public Armor armor;
	
	public Hero(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness);	
		this.title = title;
		inventory = new Inventory();
	}
	
	protected String title;
	private int requiredExp;
	private int currentExp = 0;
	private int statAmount = 0;
	
	protected int abilityID = 1;
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
	
	public void equipWeapon(Weapon weapon) {
		Log.info("You have equipped " + weapon.getName());
		this.weapon = weapon;
	}
	
	public void equipArmor(Armor armor) {
		Log.info("You have equipped " + armor.getName());
		this.armor = armor;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String printAvailableAttributes() {
		String sentence = "";
		for(String attribute : availableAttributes) {
			sentence += "["+attribute.toUpperCase()+"] ";

		}
		return sentence;	
	}
	
	public int getLevel() {
		return this.level;	
	}
	
	public int getToughness() {
		return toughness + armor.getStats();
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addAbility(int abilityID, String name, int multiplier, int manaUsage) {
		abilities.add(new Ability(abilityID,name,multiplier,manaUsage));
		this.abilityID++;
	}
	public ArrayList<Ability> getAbilities() {
		return abilities;
	}
	public Weapon getWeapon() {
		return this.weapon;
	}
	public Armor getArmor() {
		return this.armor;
	}
}
