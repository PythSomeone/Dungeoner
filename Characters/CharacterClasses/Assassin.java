package Characters.CharacterClasses;


import GameEngine.Log;
import Characters.Hero;

public class Assassin extends Hero {

	public Assassin(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name, title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.baseHealthIncrease = 5;
		this.baseManaIncrease = 5;
	}
	
	
	


}