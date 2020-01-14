package Inventory.Items;

import Interfaces.ItemInterface;

public abstract class _Item implements ItemInterface {
	
	private static int SET_ID = 0;
	
	protected int id;
	protected int value;
	protected int amount = 1;
	
	protected String name;
	protected String type;
	
	public _Item(String name) {
		this.name = name;
		this.id = _Item.SET_ID;
		_Item.SET_ID++;
	}
	
	//[INTERFACE]//
	public int getID() {
		return id;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}

	public boolean canBeEquipped() {
		return false;
	}

	public boolean canBeSold() {
		return true;
	}

	public boolean isConsumable() {
		return false;
	}

	public boolean isWeapon() {
		return false;
	}

	public boolean isArmor() {
		return false;
	}

	public int getStats() {
		return 0;
	}

	public String getType() {
		return type;
	}

	public int getAmount() {
		return amount;
	}

	public void addAmount() {
		amount++;
	}
	
	public void decreaseAmount() {
		amount--;
	}

	public boolean allowMultiple() {
		return false;
	}

}
