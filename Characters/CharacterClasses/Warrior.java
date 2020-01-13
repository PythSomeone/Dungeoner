package Characters.CharacterClasses;



import Characters.Hero;

public class Warrior extends Hero {

	public Warrior(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name,title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.baseHealthIncrease = 8;
		this.baseManaIncrease = 2;
		
		addAbility(abilityID,"Regular attack", 1, 0);
		addAbility(abilityID,"Power strike", 2, 5);
		addAbility(abilityID,"Head butt", 3, 25);
		addAbility(abilityID,"Ground stomp", 4, 50);
		addAbility(abilityID,"Sword vortex", 5, 80);
		
	}
	

	

}
