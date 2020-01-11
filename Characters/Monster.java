package Characters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import CombatSystem.Ability;
import GameEngine.Log;

public class Monster extends Character {
	
	public Monster(String name, int health, int mana, int strenght, int agility, int inteligence, int luck,int toughness,int level) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness);
	}


	private int experience;
	private int gold;

	
	public void addAbility(String name, int multiplier, int manaUsage) {
		abilities.add(new Ability(name,multiplier,manaUsage));
	}
	
	public Ability randomAbility() {
		Collections.shuffle(abilities);
		Ability abilty=abilities.get(0);
		return abilty;
	}

}
