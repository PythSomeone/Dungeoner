package Characters;

import java.util.ArrayList;

import CombatSystem.Ability;
import GameEngine.Log;

public abstract class Character {
	
	protected int level = 1;
	protected int maxHealth;
	protected int currentHealth;
	protected int maxMana;
	protected int currentMana;
	
	private String name;
	
	protected int strenght;
	protected int agility;
	protected int inteligence;
	protected int luck;
	protected int toughness;
	
	protected ArrayList<Ability> abilities = new ArrayList<Ability>();
	
	public Character(String name, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness)
	{
		this.name = name;
		this.maxHealth = health;
		this.currentHealth = health;
		this.maxMana = mana;
		this.currentMana = mana;
		this.strenght = strenght;
		this.agility = agility;
		this.inteligence = inteligence;
		this.luck = luck;
		this.toughness = toughness;
	}
	
	public boolean isAlive()
	{
		if(currentHealth > 0) return true;
		else return false;
	}
	
	public int getStrenght() {
		return this.strenght;
	}
	public int getInteligence() {
		return this.inteligence;
	}
	public int getToughness() {
		return this.toughness;
	}
	public String getName() {
		return this.name;
	}
	public void dealDamage(int value) {
		Log.info(this.name + " received " + value + " damage");
		this.currentHealth-=value;
	}
	
	public void recoverHealth(int value) {
		if(this.currentHealth + value > this.maxHealth) {
			Log.info("You've replenished " + ( value - ( (this.currentHealth + value) - this.maxHealth) ) + " health");
			this.currentHealth = this.maxHealth;
		}
		else {
			this.currentHealth += value;
			Log.info("You've replenished " + value + " health");
		}
	}
	
	public void burnMana(int value) {
		this.currentMana-=value;
	}
	
	public void recoverMana(int value) {
		if(this.currentMana + value > this.maxMana) {
			Log.info("You've replenished " + ( value - ( (this.currentMana + value) - this.maxMana) ) + " mana");
			this.currentMana = this.maxMana;
		}
		else {
			this.currentMana += value;
			Log.info("You've replenished " + value + " mana");
		}
	}
	
}
