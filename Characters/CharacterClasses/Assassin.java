package Characters.CharacterClasses;



import Characters.Hero;

public class Assassin extends Hero {

	public Assassin(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name, title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.baseHealthIncrease = 5;
		this.baseManaIncrease = 5;
		
		addAbility(abilityID,"Regular attack", 1, 0);
		addAbility(abilityID,"Throw poison bomb", 2, 5);
		addAbility(abilityID,"Silent move", 3, 25);
		addAbility(abilityID,"Backstab", 4, 50);
		addAbility(abilityID,"Hijutsu strike", 5, 80);
		
		
	}
	
	
	


}