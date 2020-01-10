package Items;

import Interfaces.ItemsInterface;

public class _Item implements ItemsInterface {
	
	private static int SET_ID = 0;
	private int id;
	private int value;
	private String name;
	
	public _Item(int value, String name) {
		this.value = value;
		this.name = name;
		this.id = _Item.SET_ID;
		_Item.SET_ID++;
	}
	
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

}
