package Characters.CharacterClasses;



import Characters.Hero;

public class Warrior extends Hero {

	public Warrior(String name, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name, health, mana, strenght, agility, inteligence, luck, toughness);	
		this.baseHealthIncrease = 80;
		this.baseManaIncrease = 2;
	}
	

	

}
