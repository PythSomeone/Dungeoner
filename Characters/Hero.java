package Characters;

import java.util.ArrayList;

import CombatSystem.Ability;
import GameEngine.Log;
import Inventory.Inventory;
import Inventory.Items.Armor;
import Inventory.Items.Weapon;

public class Hero extends Character {

	private Inventory inventory;
	private Weapon weapon;
	private Armor armor;
	
	public Hero(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness);	
		this.title = title;
		inventory = new Inventory();
	}
	
	protected String title;
	private int requiredExpIncrease = 50;
	private int requiredExp = 100;
	private int currentExp = 0;
	private int statAmount = 0;
	
	protected int abilityID = 1;
	protected int baseHealthIncrease;
	protected int baseManaIncrease;
	
	
	private String[] availableAttributes = {"strenght","agility","inteligence","luck","toughness"};
	
	public void printCharacter() {
		Log.info("Name : " + name);
		Log.info("Level : " + level);
		Log.info("Experience : " + currentExp + "/" + requiredExp);
		Log.info("Health : " + currentHealth + "/" + maxHealth);
		Log.info("Mana : " + currentMana + "/" + maxMana);
		Log.info("Strenght : " + strenght);
		Log.info("Agility : " + strenght);
		Log.info("Inteligence : " + strenght);
		Log.info("Luck : " + luck);
		Log.info("Toughness : " + toughness);
	}
	
	public void levelUpCheck()
	{
		while(currentExp >= requiredExp) {
			currentExp -= requiredExp;
			requiredExp += requiredExpIncrease;
			requiredExpIncrease *= 2;
			maxHealth += level * baseHealthIncrease;
			maxMana += level * baseManaIncrease;
			currentHealth = maxHealth;
			currentMana = maxMana;
			statAmount += 5;
			level++;
			
			Log.info("You've leveled up!  (+" 
			+ level * baseHealthIncrease + " health | +" 
			+ level * baseManaIncrease + " mana)");		
		}
	}
	public void distributePoints() {	
		String choice;
		if(statAmount > 0) {
			for(int i = 0; i < this.statAmount; i++) {
				Log.info("Choose attribute ( " + printAvailableAttributes() + ") :");
				
				choice = Log.scanString();
				
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
		}else {
			Log.info("You don't have skill points to distribute");
		}
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
		return weapon;
	}
	public Armor getArmor() {
		return armor;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void giveExp(int value) {
		currentExp += value;
	}
	public void heroMenu(Hero hero) {
		//[CHOICE]//
			boolean closed = false;
			String action = null;
			
			Log.info("Actions available : ");
			Log.info("Hero INFO");
			Log.info("DISTRIBUTE skill points");
			Log.info("BACK");

			while(!closed) {
				action = Log.scanString();
				//[HERO INFO]//
				if(action.equalsIgnoreCase("Info")) printCharacter();
				//[DISTRIBUTE POINTS]//
				else if(action.equalsIgnoreCase("Distribute")) distributePoints();
				//[BACK]//
				else if(action.equalsIgnoreCase("Back")) closed = true;

				else Log.info("Wrong input");
		}
	}
	
}
