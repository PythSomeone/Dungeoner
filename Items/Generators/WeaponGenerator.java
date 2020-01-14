package Items.Generators;

import Characters.Hero;

public class WeaponGenerator {
	
	private static String[] adjectives = {"Heavy", "Powerful", "Legendary", "Magical", "Fairy", "Ultimate", "Common", "Uneasy", "Dizzy", "Weird", "Tiny", "Shiny", "Unique", "Manly"};
	
	public static String getRandomWarriorName() {
        String[] names = {"Battle Axe", "Axe", "Stick", "Sword", "Two Handed Sword", "Rapier", "Mace", "Polearm"};
        return (adjectives[(int) (Math.random() * adjectives.length)]+" "+names[(int) (Math.random() * names.length)]);
    }
	
	public static String getRandomAssassinName() {
        String[] names = {"Dagger", "Katana", "Scythe", "Kusarigama", "Kunai", "Tekko-Kagi", "Manriki-Gusari", "Tekken", "Nekode", "Shikomizue"};
        return (adjectives[(int) (Math.random() * adjectives.length)]+" "+names[(int) (Math.random() * names.length)]);
    }
	
	public static String getRandomMageName() {
        String[] names = {"Wand", "Staff", "Rod", "Magic book"};
        String[] magicType = {"Fire","Water","Earth","Love","Death","Electicity","Poison","Destruction"};
        return (adjectives[(int) (Math.random() * adjectives.length)] + " " + names[(int) (Math.random() * names.length)] + " of " + magicType[(int) (Math.random() * magicType.length)]);
    }
	
	public static String getRandomName(Hero hero) {
		if(hero.getTitle().equals("Warrior")) return getRandomWarriorName();
		else if(hero.getTitle().equals("Assassin")) return getRandomAssassinName();
		else if(hero.getTitle().equals("Mage")) return getRandomMageName();
		return "dupa";
	}
	
	public static int generateDamage(Hero hero) {
		return (int) ( hero.getLevel() * ( Math.random() * 8 + hero.getLevel() ) );
	}
	
	public static int generateValue(Hero hero) {
		return ( hero.getLevel() );
	}

}
