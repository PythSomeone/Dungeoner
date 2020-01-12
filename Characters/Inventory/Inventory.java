package Characters.Inventory;

import java.util.ArrayList;

import Characters.Hero;
import GameEngine.Log;
import Interfaces.ItemsInterface;
import Items._Item;
import Items.Weapon;
import Items.Armor;

public class Inventory {
	
	private static final int inventorySize = 10;
	
	private static ArrayList<ItemsInterface> inventory = new ArrayList<>();
	
	public static void addItem(ItemsInterface item) {
		if(!isFull()) {
			inventory.add(item);
			Log.info(item.getName() + " have been added to your inventory");
		}
		else {
			Log.info("Inventory is full! You cant pick it up");
		}
	}
	
	public static void deleteItem(int ID) {
		int index = -1;
		String name = null;
		for(ItemsInterface item : inventory) { // LOOK FOR ID
			if(item.getID() == ID) {
				index = inventory.indexOf(item);
				name = item.getName();
			}
		}
		if(index != -1) {
			inventory.remove(index);
			if(name != null)	Log.info(name + " have been removed from your inventory");
			else Log.info("Dupa");
		}
		else Log.info("You dont have this item in inventory");
	}
	
	public static Weapon getWeapon(int ID) {
		Weapon pushItem = null;
		for(ItemsInterface item : inventory) { // LOOK FOR ID
			if(item.getID() == ID) {
				if(item.isWeapon()) pushItem = (Weapon) item;
			}
		}
		if(pushItem != null)	return pushItem;
		else return null;
	}
	
	public static Armor getArmor(int ID) {
		Armor pushItem = null;
		for(ItemsInterface item : inventory) { // LOOK FOR ID
			if(item.getID() == ID) {
				if(item.isArmor()) pushItem = (Armor) item;
			}
		}
		if(pushItem != null)	return pushItem;
		else return null;
	}
	
	public static void equip(Hero hero, int ID) {
		if(hero.inventory.getArmor(ID) != null)	{
			if(hero.armor != null) hero.inventory.addItem(hero.armor);
			hero.equipArmor(hero.inventory.getArmor(ID));
			deleteItem(ID);
			Log.info();
		}
		else if(hero.inventory.getWeapon(ID) != null)	{
			if(hero.weapon != null) hero.inventory.addItem(hero.weapon);
			hero.equipWeapon(hero.inventory.getWeapon(ID));
			deleteItem(ID);
			Log.info();
		}
	}
	
	public static void inventoryInfo() {
		if(inventory.isEmpty())	Log.info("Your inventory is empty!");
		else {
			for(ItemsInterface item : inventory) {
				Log.info("ID : " + item.getID());
				Log.info("Name : " + item.getName());
				Log.info("Type : " + item.getType());
				if(item.getType().equals("Weapon"))		Log.info("Damage : " + item.getStats());
				else if(item.getType().equals("Armor")) Log.info("Defence : " + item.getStats());
				Log.info("Value : " + item.getValue());
				Log.info();
			}
		}	
	}
	
	public static boolean isFull() {
		if(inventory.size() == inventorySize) return true;
		else return false;
	}

}
