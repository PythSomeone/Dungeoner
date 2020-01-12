package Characters.CharacterClasses;



import Characters.Hero;
import CombatSystem.Ability;

public class Mage extends Hero {

	public Mage(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name,title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.title="mage";
		this.baseHealthIncrease = 3;
		this.baseManaIncrease = 7;
		
		abilities.add(new Ability(0,"Regular attack", 100, 5));
		abilities.add(new Ability(1,"Fire Ball", 150, 50));
		abilities.add(new Ability(2,"Meteor Storm", 300, 250));
		abilities.add(new Ability(3,"Regular attack", 100, 0));
		abilities.add(new Ability(4,"Power stroke", 150, 50));
		
		
	}
	

	

}