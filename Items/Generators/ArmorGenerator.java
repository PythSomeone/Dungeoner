package Items.Generators;

import Characters.Hero;

public class ArmorGenerator {

	private static String[] adjectives = {"Heavy", "Torn", "Legendary", "Magical", "Fairy", "Well finished", "Common", "Rough", "Eternal", "Weird", "Too small", "Shiny", "Old", "Too big"};
	
	public static String getRandomName() {
        String[] names = {"Leather armor", "Bronze armor", "Wooden armor", "Iron armor", "Silver armor", "Golden armor", "Diamond armor", "Uranium armor", "Bone armor", "Dress", "Robe"};
        return (adjectives[(int) (Math.random() * adjectives.length)]+" "+names[(int) (Math.random() * names.length)]);
    }
	
	public static int generateArmor(Hero hero) {
		return (int) ( hero.getLevel() * ( Math.random() * 4 + hero.getLevel() ) );
	}
	
	public static int generateValue(Hero hero) {
		return ( hero.getLevel() );
	}
	
}
