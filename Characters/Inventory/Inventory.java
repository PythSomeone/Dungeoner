package Characters.Inventory;

import java.util.ArrayList;

import Characters.Hero;
import GameEngine.Log;
import Interfaces.ItemsInterface;
import Items.Weapon;
import Items.Armor;

public class Inventory {
	
	private final int inventorySize = 10;
	
	private int gold = 0;
	
	private ArrayList<ItemsInterface> inventory = new ArrayList<>();
	
	public void addItem(ItemsInterface item) {		
		if(isDuplicate(item.getID())) {
			if(!item.allowMultiple()) Log.info("You allready have this item in your inventory");
			else {
				item.addAmount();
				Log.info(item.getName() + " have been added to your inventory");
			}
		}
		else {
			if(!isFull()) {
				inventory.add(item);
				Log.info(item.getName() + " have been added to your inventory");
			}
			else {
				Log.info("Inventory is full! You cant pick it up");
			}
		}
	}
	
	public void deleteItem(int ID) {
		
		int index = -1;
		String name = null;
		boolean allowMultiple = false;
		
		for(ItemsInterface item : inventory) { // LOOK FOR ID
			if(item.getID() == ID) {
				name = item.getName();
				if(!item.allowMultiple()) index = inventory.indexOf(item);	
				else {
					allowMultiple = true;
					if(item.getAmount() > 1) {
						item.decreaseAmount();
						Log.info(name + " have been removed from your inventory");
					}
					else {
						index = inventory.indexOf(item);
					}
				}
			}
		}
		
		if(index != -1) {
			inventory.remove(index);
			Log.info(name + " have been removed from your inventory");
		}
		else if(!allowMultiple) Log.info("You dont have this item in inventory");
		
	}
	
	private Weapon getWeapon(int ID) {
		Weapon pushItem = null;
		for(ItemsInterface item : inventory) { // LOOK FOR ID
			if(item.getID() == ID) {
				if(item.isWeapon()) pushItem = (Weapon) item;
			}
		}
		if(pushItem != null)	return pushItem;
		else return null;
	}
	
	private Armor getArmor(int ID) {
		Armor pushItem = null;
		for(ItemsInterface item : inventory) { // LOOK FOR ID
			if(item.getID() == ID) {
				if(item.isArmor()) pushItem = (Armor) item;
			}
		}
		if(pushItem != null)	return pushItem;
		else return null;
	}
	
	public void equip(Hero hero, int ID) {

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
	
	public void inventoryInfo() {
		if(inventory.isEmpty())	Log.info("Your inventory is empty!");
		else {
			for(ItemsInterface item : inventory) {
				Log.info("ID : " + item.getID());
				Log.info("Name : " + item.getName());
				Log.info("Type : " + item.getType());
				if(item.getType().equals("Weapon"))				Log.info("Damage : " + item.getStats());
				else if(item.getType().equals("Armor")) 		Log.info("Defence : " + item.getStats());
				else if(item.getType().equals("Consumable"))	Log.info("Amount : " + item.getStats());
				Log.info("Value : " + item.getValue());
				Log.info();
			}
		}	
	}
	
	public void setGold(int value) {
		gold += value;
	}
	
	public int getGold() {
		return gold;
	}
	
	public boolean isDuplicate(int ID) {
		for(ItemsInterface item : inventory) {
			if(item.getID() == ID) return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(inventory.size() == inventorySize) return true;
		else return false;
	}

}
