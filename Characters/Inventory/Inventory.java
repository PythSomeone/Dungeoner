package Characters.Inventory;

import java.util.ArrayList;
import GameEngine.Log;
import Interfaces.ItemsInterface;

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
