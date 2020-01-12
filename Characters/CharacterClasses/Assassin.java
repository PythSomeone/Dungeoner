package Characters.CharacterClasses;


import Characters.Hero;
import CombatSystem.Ability;

public class Assassin extends Hero {

	public Assassin(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name, title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.baseHealthIncrease = 5;
		this.baseManaIncrease = 5;
		
		
		addAbility(abilityID,"Regular attack", 100, 0);
		addAbility(abilityID,"Power stroke", 150, 50);
		addAbility(abilityID,"Head butt", 300, 250);
		addAbility(abilityID,"Ground stomp", 300, 250);
		addAbility(abilityID,"Sword vortex", 300, 250);
		
		
	}
	
	
	


}