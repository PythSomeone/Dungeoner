package Items.Generators;

public class WeaponGenerator {
	
	private static int value;
	private static int damage;
	
	private static String[] adjectives = {"Heavy", "Powerful", "Legendary", "Magical", "Fairy", "Ultimate", "Common", "Uneasy", "Dizzy", "Weird", "Tiny", "Shiny", "Unique", "Manly"};
	
	public static String getRandomWarriorName() {
        String[] names = {"Battle Axe", "Axe", "Stick", "Sword", "Two Handed Sword", "Rapier", "Mace", "Polearm"};
        return (adjectives[(int) (Math.random() * adjectives.length)]+" "+names[(int) (Math.random() * names.length)]);
    }
	
	public static String getRandomAssasinName() {
        String[] names = {"Dagger", "Katana", "Scythe", "Kusarigama", "Kunai", "Tekko-Kagi", "Manriki-Gusari", "Tekken", "Nekode", "Shikomizue"};
        return (adjectives[(int) (Math.random() * adjectives.length)]+" "+names[(int) (Math.random() * names.length)]);
    }
	
	public static String getRandomMageName() {
        String[] names = {"Wand", "Staff", "Rod", "Magic book"};
        String[] magicType = {"Fire","Water","Earth","Love","Death","Electicity","Poison","Destruction"};
        return (adjectives[(int) (Math.random() * adjectives.length)] + " " + names[(int) (Math.random() * names.length)] + " of " + magicType[(int) (Math.random() * magicType.length)]);
    }

}
