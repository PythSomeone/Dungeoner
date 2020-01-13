package Characters.CharacterClasses;



import Characters.Hero;

public class Mage extends Hero {

	public Mage(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name,title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.baseHealthIncrease = 3;
		this.baseManaIncrease = 7;
		
		addAbility(abilityID,"Regular magic attack", 2, 5);
		addAbility(abilityID,"Magic missle", 3, 30);
		addAbility(abilityID,"Flaming tongue", 4, 125);
		addAbility(abilityID,"Icy wind", 5, 250);
		addAbility(abilityID,"Fireball", 6, 500);
		
		
	}
	

	

}