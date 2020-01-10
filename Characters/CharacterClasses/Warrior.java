package Characters.CharacterClasses;



import Characters.Hero;
import CombatSystem.Ability;

public class Warrior extends Hero {

	public Warrior(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name,title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.title="warrior";
		this.baseHealthIncrease = 8;
		this.baseManaIncrease = 2;
		
		abilities.add(new Ability("Regular attack", 100, 0));
		abilities.add(new Ability("Fire Ball", 150, 50));
		abilities.add(new Ability("Meteor Storm", 300, 250));
		
	}
	

	

}
