package Items;

import GameEngine.Log;

public class Armor extends _Item {

	private int defence;
	
	public Armor(String name, int value, int defence) {
		super(name);
		this.defence = defence;
		this.value = value * defence * 2;
		this.type = "Armor";
	}
	
	//[INTERFACE]//
	public int getStats() {
		return defence;
	}
	
	public void armorInfo() {
		Log.info("Your current armor : ");
		Log.info("Name : " + this.name);
		Log.info("Defence : " + this.defence);
		Log.info("Value : " + this.value);
		Log.info();
	}
	
	public boolean canBeEquipped() {
		return true;
	}
	
	public boolean isArmor() {
		return true;
	}

	
}
