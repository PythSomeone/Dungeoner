package Characters.CharacterClasses;



import Characters.Hero;
import CombatSystem.Ability;

public class Mage extends Hero {

	public Mage(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name,title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.title="mage";
		this.baseHealthIncrease = 3;
		this.baseManaIncrease = 7;
		
		abilities.add(new Ability("Regular attack", 100, 5));
		abilities.add(new Ability("Fire Ball", 150, 50));
		abilities.add(new Ability("Meteor Storm", 300, 250));
		abilities.add(new Ability("Regular attack", 100, 0));
		abilities.add(new Ability("Power stroke", 150, 50));
		
		
	}
	

	

}