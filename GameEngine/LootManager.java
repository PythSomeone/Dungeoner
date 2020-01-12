package GameEngine;

import java.util.Random;

import Characters.Hero;
import Items.Armor;
import Items.Consumable;
import Items.Weapon;
import Items.Generators.ArmorGenerator;
import Items.Generators.WeaponGenerator;

public class LootManager {
	
	private static final int MAX_PERCENT = 100;
	private static final int GOLD_DROP_RATE = 10;
	
	private static int weaponChance = 10;
	private static int armorChance = 10;
	private static int consumableChance = 30;
	
	private static Consumable lifePotion = new Consumable("Life potion", 10, 5);
	private static Consumable manaPotion = new Consumable("Mana potion", 10, 5);
	
	private static int roll(int maxValue) {
		Random generator = new Random();
        return (generator.nextInt(maxValue) + 1);
	}
	
	public static void monsterDrop(Hero hero) {
		int chanceRoll = roll(MAX_PERCENT);
		if(chanceRoll <= weaponChance) {
			Weapon weapon = new Weapon( WeaponGenerator.getRandomWarriorName(), 	//WEAPON GENERATOR
					WeaponGenerator.generateValue( hero ),
					WeaponGenerator.generateDamage( hero ) );
			hero.inventory.addItem(weapon);
		}else if(chanceRoll <= armorChance) {
			Armor armor = new Armor( ArmorGenerator.getRandomName(), 				//ARMOR GENERATOR
					ArmorGenerator.generateValue( hero ),
					ArmorGenerator.generateArmor( hero ) );
			hero.inventory.addItem(armor);
		}else if(chanceRoll <= consumableChance) {
			if(chanceRoll < consumableChance/2) hero.inventory.addItem(lifePotion);
			else hero.inventory.addItem(manaPotion);								
		}
		int goldRoll = roll(GOLD_DROP_RATE);
		hero.inventory.setGold( goldRoll * hero.getLevel() );
		Log.info( "You received " + ( goldRoll * hero.getLevel() ) + " gold" );
	}
	
	public static void chestDrop(Hero hero) {
		int chanceRoll = roll(MAX_PERCENT);
		if(chanceRoll <= weaponChance+40) {
			Weapon weapon = new Weapon( WeaponGenerator.getRandomWarriorName(), 	//WEAPON GENERATOR
					WeaponGenerator.generateValue( hero ),
					WeaponGenerator.generateDamage( hero ) );
			hero.inventory.addItem(weapon);
		}else if(chanceRoll <= armorChance+40) {
			Armor armor = new Armor( ArmorGenerator.getRandomName(), 				//ARMOR GENERATOR
					ArmorGenerator.generateValue( hero ),
					ArmorGenerator.generateArmor( hero ) );
			hero.inventory.addItem(armor);
		}else if(chanceRoll <= consumableChance-30) {
			if(chanceRoll < consumableChance/2) hero.inventory.addItem(lifePotion);
			else hero.inventory.addItem(manaPotion);								
		}
		int goldRoll = roll(GOLD_DROP_RATE);
		hero.inventory.setGold( goldRoll * hero.getLevel() * 10 );
		Log.info( "You received " + ( goldRoll * hero.getLevel() * 10 ) + " gold" );
	}

}
