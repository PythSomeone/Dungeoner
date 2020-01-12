package Characters.CharacterClasses;


import Characters.Hero;
import CombatSystem.Ability;

public class Assassin extends Hero {

	public Assassin(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name, title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.baseHealthIncrease = 5;
		this.baseManaIncrease = 5;
		
		addAbility(0,"Regular attack", 100, 0);
		addAbility(0,"Power stroke", 150, 50);
		addAbility(0,"Head butt", 300, 250);
		addAbility(0,"Ground stomp", 300, 250);
		addAbility(0,"Sword vortex", 300, 250);
		
		
		
	}
	
	
	


}