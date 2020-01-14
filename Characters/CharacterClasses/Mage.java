package Characters.CharacterClasses;



import Characters.Hero;

public class Mage extends Hero {

	public Mage(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name,title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.baseHealthIncrease = 3;
		this.baseManaIncrease = 7;
		
		addAbility(abilityID,"Regular magic attack", 1, 0);
		addAbility(abilityID,"Magic missle", 2, 30);
		addAbility(abilityID,"Flaming tongue", 3, 125);
		addAbility(abilityID,"Icy wind", 4, 250);
		addAbility(abilityID,"Fireball", 5, 500);
		
		
	}
	

	

}