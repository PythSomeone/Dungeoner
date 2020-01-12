package Characters.Inventory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Characters.Hero;
import GameEngine.Log;
import Interfaces.ItemsInterface;
import Items.Weapon;
import Items.Armor;
import Items.Consumable;

public class Inventory {
	
	private final int inventorySize = 12;
	
	private int gold = 0;
	
	private ArrayList<ItemsInterface> inventory = new ArrayList<>();
	
	private void deleteItem(int ID) {
		
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
	private void useItem(Hero hero, int ID) {
		 Consumable consumable = hero.inventory.getConsumable(ID);
		if(consumable != null)	{
			if(hero.inventory.getConsumable(ID).getName().equals("Life potion"))  {
				hero.recoverHealth(inventory.get( inventory.indexOf(consumable) ).getStats()*hero.getLevel());
			}
			if(hero.inventory.getConsumable(ID).getName().equals("Mana potion"))  {
				hero.recoverMana(inventory.get( inventory.indexOf(consumable) ).getStats()*hero.getLevel());
			}
			deleteItem(ID);
			Log.info();
		}
		else Log.info("You dont have this consumable in inventory");
	}
	private Consumable getConsumable(int ID) {
		Consumable pushItem = null;
		for(ItemsInterface item : inventory) { // LOOK FOR ID
			if(item.getID() == ID) {
				if(item.isConsumable()) pushItem = (Consumable) item;
			}
		}
		if(pushItem != null)	return pushItem;
		else return null;
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
	private void equip(Hero hero, int ID) {
		if(isInInventory(ID)) {
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
		else {
			Log.info("You dont have this item in inventory");
		}
	}
	private void inventoryInfo() {
		if(inventory.isEmpty())	Log.info("Your inventory is empty!");
		else {
			Log.info("[INVENTORY]   " + inventory.size() + "/" + inventorySize);
			Log.info();
			for(ItemsInterface item : inventory) {
				Log.info("ID : " + item.getID());
				Log.info("Name : " + item.getName());
				Log.info("Type : " + item.getType());
				if(item.getType().equals("Weapon"))				Log.info("Damage : " + item.getStats());
				else if(item.getType().equals("Armor")) 		Log.info("Defence : " + item.getStats());
				else if(item.getType().equals("Consumable"))	Log.info("Amount : " + item.getAmount());
				Log.info("Value : " + item.getValue());
				Log.info();
			}
		}	
	}
	private boolean isDuplicate(int ID) {
		for(ItemsInterface item : inventory) {
			if(item.getID() == ID) return true;
		}
		return false;
	}
	private boolean isFull() {
		if(inventory.size() == inventorySize) return true;
		else return false;
	}
	private boolean isInInventory(int ID) {
		for(ItemsInterface item : inventory) {
			if(item.getID() == ID) return true;
		} return false;
	}
	
	private int scanInt() {
		Scanner scanner = new Scanner(System.in);
		int sentence = scanner.nextInt();
		//scanner.close();
		return sentence;
	}
	private String scanString() {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.next();
		//scanner.close();
		return sentence;
	}
	
	public void setGold(int value) {
		gold += value;
	}
	public int getGold() {
		return gold;
	}
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
	public void openMenu(Hero hero) {
		boolean closed = false;
		String action = null;
		
		hero.inventory.inventoryInfo();
		Log.info();
		Log.info("Actions available : ");
		Log.info("REMOVE item");
		Log.info("EQUIP item");
		Log.info("USE item");
		Log.info("SHOW inventory");
		Log.info("CLOSE inventory");
		
		while(closed == false) {
			action = scanString();
			//REMOVE ITEM
			if(action.equalsIgnoreCase("Remove")) {
				try {
					Log.info("Give ID of an item : ");
					hero.inventory.deleteItem(scanInt());
				}
				catch(InputMismatchException e) {
					Log.info("NIEPOPRAWNY FORMAT!");
				}	
			}
			//EQUIP ITEM
			else if(action.equalsIgnoreCase("Equip")) {
				try {
					Log.info("Give ID of an item : ");
					hero.inventory.equip(hero, scanInt());
				}
				catch(InputMismatchException e) {
					Log.info("NIEPOPRAWNY FORMAT!");
				}	
			}
			//USE ITEM
			else if(action.equalsIgnoreCase("Use")) {
				if(hero.isHurt() || hero.needsMana()) {
					try {
						Log.info("Give ID of an item : ");
						hero.inventory.useItem(hero, scanInt());
					}
					catch(InputMismatchException e) {
						Log.info("NIEPOPRAWNY FORMAT!");
					}	
				}else Log.info("You dont need a potion");	
			}
			//SHOW INVENTORY
			else if(action.equalsIgnoreCase("Show"))	hero.inventory.inventoryInfo();
			//CLOSE INVENTORY
			else if(action.equalsIgnoreCase("Close")) closed = true;
			
			else Log.info("Wrong input");
		}
	}
	
	

	
}
