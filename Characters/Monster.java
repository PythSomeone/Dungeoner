package Characters;

import java.util.Collections;
import CombatSystem.Ability;

public class Monster extends Character {
	
	public Monster(String name, int health, int mana, int strenght, int agility, int inteligence, int luck,int toughness,int level) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness);
	}


	protected int experience;

	
	public void addAbility(int abilityID, String name, int multiplier, int manaUsage) {
		abilities.add(new Ability(abilityID,name,multiplier,manaUsage));
	}
	
	public Ability getRandomAbility() {
		Collections.shuffle(abilities);
		Ability abilty=abilities.get(0);
		return abilty;
	}
	
	public boolean isMonster() {
		return true;
	}

}
