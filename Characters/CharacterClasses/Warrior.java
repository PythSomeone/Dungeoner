package Characters.CharacterClasses;



import Characters.Hero;
import CombatSystem.Ability;

public class Warrior extends Hero {

	public Warrior(String name, String title, int health, int mana, int strenght, int agility, int inteligence, int luck, int toughness) {
		super(name,title, health, mana, strenght, agility, inteligence, luck, toughness);
		this.title="warrior";
		this.baseHealthIncrease = 8;
		this.baseManaIncrease = 2;
		
		abilities.add(new Ability("Regular attack", 100, 0));
		abilities.add(new Ability("Power stroke", 150, 50));
		abilities.add(new Ability("Head butt", 300, 250));
		abilities.add(new Ability("Ground stomp", 300, 250));
		abilities.add(new Ability("Sword vortex", 300, 250));
		
	}
	

	

}
