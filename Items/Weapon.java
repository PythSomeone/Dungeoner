package Items;

import GameEngine.Log;

public class Weapon extends _Item {
	
	private int damage;
	
	
	public Weapon(String name, int value, int damage) {
		super(name);
		this.damage = damage;
		this.value = value * damage;
		this.type = "Weapon";
	}
	
	//[INTERFACE]//
	
	public int getStats() {
		return damage;
	}
	
	public void weaponInfo() {
		Log.info("Your current weapon : ");
		Log.info("Name : " + this.name);
		Log.info("Damage : " + this.damage);
		Log.info("Value : " + this.value);
		Log.info();
	}
	
	public boolean canBeEquipped() {
		return true;
	}
	
	public boolean isWeapon() {
		return true;
	}

}
