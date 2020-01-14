package Inventory;

import java.util.ArrayList;
import java.util.InputMismatchException;

import Characters.Hero;
import GameEngine.GameManager;
import GameEngine.Log;
import Interfaces.ItemInterface;
import Inventory.Items.Armor;
import Inventory.Items.Consumable;
import Inventory.Items.Weapon;

public class Inventory {
	
	private final int inventorySize = 12;
	
	private int gold = 0;
	
	private ArrayList<ItemInterface> inventory = new ArrayList<>();
	
	private void deleteItem(int ID) {
		
		int index = -1;
		String name = null;
		boolean allowMultiple = false;
		
		for(ItemInterface item : inventory) { // LOOK FOR ID
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
	private void useItem(Hero hero, int ID) {
		 Consumable consumable = hero.getInventory().getConsumable(ID);
		if(consumable != null)	{
			if(hero.getInventory().getConsumable(ID).getName().equals("Life potion"))  {
				hero.recoverHealth(inventory.get( inventory.indexOf(consumable) ).getStats()*hero.getLevel());
			}
			if(hero.getInventory().getConsumable(ID).getName().equals("Mana potion"))  {
				hero.recoverMana(inventory.get( inventory.indexOf(consumable) ).getStats()*hero.getLevel());
			}
			deleteItem(ID);
		}
		else Log.info("You dont have this consumable in inventory");
	}
	private Consumable getConsumable(int ID) {
		Consumable pushItem = null;
		for(ItemInterface item : inventory) { // LOOK FOR ID
			if(item.getID() == ID) {
				if(item.isConsumable()) pushItem = (Consumable) item;
			}
		}
		if(pushItem != null)	return pushItem;
		else return null;
	}
	private Weapon getWeapon(int ID) {
		Weapon pushItem = null;
		for(ItemInterface item : inventory) { // LOOK FOR ID
			if(item.getID() == ID) {
				if(item.isWeapon()) pushItem = (Weapon) item;
			}
		}
		if(pushItem != null)	return pushItem;
		else return null;
	}
	private Armor getArmor(int ID) {
		Armor pushItem = null;
		for(ItemInterface item : inventory) { // LOOK FOR ID
			if(item.getID() == ID) {
				if(item.isArmor()) pushItem = (Armor) item;
			}
		}
		if(pushItem != null)	return pushItem;
		else return null;
	}
	private void equip(Hero hero, int ID) {
		if(isInInventory(ID)) {
			if(hero.getInventory().getArmor(ID) != null)	{
				if(hero.getArmor() != null) hero.getInventory().addItem(hero.getArmor());
				hero.equipArmor(hero.getInventory().getArmor(ID));
				deleteItem(ID);
			}
			else if(hero.getInventory().getWeapon(ID) != null)	{
				if(hero.getWeapon() != null) hero.getInventory().addItem(hero.getWeapon());
				hero.equipWeapon(hero.getInventory().getWeapon(ID));
				deleteItem(ID);
			}
		}
		else {
			Log.info("You dont have this item in inventory");
		}
	}
	private void inventoryInfo() {
		if(inventory.isEmpty())	Log.info("Your inventory is empty!");
		else {
			Log.info("[INVENTORY]   " + inventory.size() + "/" + inventorySize);
			for(ItemInterface item : inventory) {
				Log.info("ID : " + item.getID());
				Log.info("Name : " + item.getName());
				Log.info("Type : " + item.getType());
				if(item.getType().equals("Weapon"))				Log.info("Damage : " + item.getStats());
				else if(item.getType().equals("Armor")) 		Log.info("Defence : " + item.getStats());
				else if(item.getType().equals("Consumable"))	Log.info("Amount : " + item.getAmount());
				Log.info("Value : " + item.getValue());
			}
		}	
	}
	private boolean isDuplicate(int ID) {
		for(ItemInterface item : inventory) {
			if(item.getID() == ID) return true;
		}
		return false;
	}
	private boolean isFull() {
		if(inventory.size() == inventorySize) return true;
		else return false;
	}
	private boolean isInInventory(int ID) {
		for(ItemInterface item : inventory) {
			if(item.getID() == ID) return true;
		} return false;
	}
	
	
	
	public void setGold(int value) {
		gold += value;
	}
	public int getGold() {
		return gold;
	}
	public void addItem(ItemInterface item) {		
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
	public void openMenu(Hero hero) {
		String action = null;
		
		hero.getInventory().inventoryInfo();
		Log.info("Actions available : ");
		Log.info("REMOVE item");
		Log.info("EQUIP item");
		Log.info("USE item");
		Log.info("SHOW inventory");
		Log.info("BACK");
		
		for(;;) {
			action = Log.scanString();
			//REMOVE ITEM
			if(action.equalsIgnoreCase("Remove")) {
				try {
					Log.info("Give ID of an item : ");
					hero.getInventory().deleteItem(Log.scanInt());
				}
				catch(InputMismatchException e) {
					Log.info("INVALID FORMAT");
				}	
			}
			//EQUIP ITEM
			else if(action.equalsIgnoreCase("Equip")) {
				try {
					Log.info("Give ID of an item : ");
					hero.getInventory().equip(hero, Log.scanInt());
				}
				catch(InputMismatchException e) {
					Log.info("INVALID FORMAT");
				}	
			}
			//USE ITEM
			else if(action.equalsIgnoreCase("Use")) {
				if(hero.isHurt() || hero.needsMana()) {
					try {
						Log.info("Give ID of an item : ");
						hero.getInventory().useItem(hero, Log.scanInt());
					}
					catch(InputMismatchException e) {
						Log.info("INVALID FORMAT");
					}	
				}else Log.info("You dont need a potion");	
			}
			//SHOW INVENTORY
			else if(action.equalsIgnoreCase("Show")) {
				try {
					hero.getInventory().inventoryInfo();
				}
				catch(InputMismatchException e){
					Log.info("INVALID FORMAT");
				}
			}
			//BACK
			else if(action.equalsIgnoreCase("Back")) {
				try {
					GameManager.restMenu(hero);
				}
				catch(InputMismatchException e){
					Log.info("INVALID FORMAT");
				}
			}
			
			else Log.info("Wrong input");
		}
	}
	
	

	
}
