package Characters;

import java.util.Collections;
import CombatSystem.Ability;

public abstract class Monster extends Character {
	
	protected int experience;
	
	public Monster(String name, int health, int mana, int strenght, int agility, int inteligence, int luck,int toughness,int level) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness);
		this.maxHealth *= this.level;
		this.currentHealth = this.maxHealth;
		this.maxMana *= this.level;
		this.currentMana = this.maxMana;
		this.strenght *= this.level;
		this.agility *= this.level;
		this.inteligence *= this.level;
		this.luck *= this.level;
		this.toughness *= this.level;
	}




	
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
	
	public int getExperience() {
		return experience;
	}

}
