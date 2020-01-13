package Characters.Monsters;

import Characters.Monster;

public class Rat extends Monster {

	public Rat(String name, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness, int level) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness, level);
		
		this.experience = 5 * level;
		this.strenght = 5 + level;
		
		addAbility(0,"Slice", 1, 5);
		addAbility(0,"Slash", 1, 5);
		addAbility(0,"Hack", 1, 5);
		
	}
	
	
}
