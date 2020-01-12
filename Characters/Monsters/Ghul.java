package Characters.Monsters;

import Characters.Monster;
import CombatSystem.Ability;

public class Ghul extends Monster {

	public Ghul(String name, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness, int level) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness, level);
		abilities.add(new Ability("Slice", 1, 5));
		abilities.add(new Ability("Slash", 2, 50));
		abilities.add(new Ability("Hack", 3, 250));
	}
	

}
