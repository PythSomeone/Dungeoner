package Items;

import Interfaces.ItemsInterface;

public class _Item implements ItemsInterface {
	
	private static int SET_ID = 0;
	
	protected int id;
	protected int value;
	
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

}
