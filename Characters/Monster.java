package Characters;

import java.util.ArrayList;
import java.util.Scanner;

import CombatSystem.Ability;
import GameEngine.Log;

public class Monster extends Character {
	
	private int experience;
	private int gold;

	public Monster(String name, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness, int level, int experience, int gold) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness);	
		this.level = level;
		this.experience = experience;
		this.gold = gold;
		abilities.add(new Ability("Regular attack", 100, 0));
	}
	
	public void addAbility(String name, int multiplier, int manaUsage) {
		abilities.add(new Ability(name,multiplier,manaUsage));
	}
	
	

}
