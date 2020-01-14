package Characters.Monsters;

import Characters.Monster;

public class Skeleton extends Monster {
	
	public Skeleton(String name, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness, int level) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness, level);
		
		this.experience = 6 * level;
		
		addAbility(0,"Slice", 1, 5);
		addAbility(0,"Slash", 1, 5);
		addAbility(0,"Hack", 1, 5);
		
	}
	
}
