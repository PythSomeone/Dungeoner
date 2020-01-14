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
	
	public static void monsterDrop(Hero hero, int monsterAmount) {
		int roll;
		for(int i = 0; i < monsterAmount; i++) {
			roll = roll(MAX_PERCENT);
			if(roll <= weaponChance) {
				Weapon weapon = new Weapon( WeaponGenerator.getRandomName( hero ), 	//WEAPON GENERATOR
						WeaponGenerator.generateValue( hero ),
						WeaponGenerator.generateDamage( hero ) );
				hero.getInventory().addItem(weapon);
			}else if(roll <= armorChance) {
				Armor armor = new Armor( ArmorGenerator.getRandomName(), 				//ARMOR GENERATOR
						ArmorGenerator.generateValue( hero ),
						ArmorGenerator.generateArmor( hero ) );
				hero.getInventory().addItem(armor);
			}else if(roll <= consumableChance) {
				if(roll < consumableChance/2) hero.getInventory().addItem(lifePotion);
				else hero.getInventory().addItem(manaPotion);								
			}
		}
		roll = roll(GOLD_DROP_RATE);
		hero.getInventory().setGold( roll * hero.getLevel() * monsterAmount );
		Log.info( "You received " + ( roll * hero.getLevel() * monsterAmount ) + " gold" );
	}
	
	public static void chestDrop(Hero hero) {
		
		int roll;
		
			Weapon weapon = new Weapon( WeaponGenerator.getRandomName( hero ), 	//WEAPON GENERATOR
					WeaponGenerator.generateValue( hero ),
					WeaponGenerator.generateDamage( hero ) );
			hero.getInventory().addItem(weapon);

			Armor armor = new Armor( ArmorGenerator.getRandomName(), 				//ARMOR GENERATOR
					ArmorGenerator.generateValue( hero ),
					ArmorGenerator.generateArmor( hero ) );
			hero.getInventory().addItem(armor);

		roll = roll(GOLD_DROP_RATE);
		hero.getInventory().setGold( roll * hero.getLevel() * 40 );
		Log.info( "You received " + ( roll * hero.getLevel() * 40 ) + " gold" );
		
	}

}
