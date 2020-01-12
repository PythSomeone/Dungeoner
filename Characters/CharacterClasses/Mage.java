package Characters.CharacterClasses;



import Characters.Hero;
import CombatSystem.Ability;

public class Mage extends Hero {

	public Mage(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name,title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.baseHealthIncrease = 3;
		this.baseManaIncrease = 7;
		
		addAbility(abilityID,"Regular attack", 100, 0);
		addAbility(abilityID,"Fire Ball", 150, 50);
		addAbility(abilityID,"Head butt", 300, 250);
		addAbility(abilityID,"Meteor Storm", 300, 250);
		addAbility(abilityID,"Power stroke", 150, 50);
		
		
	}
	

	

}