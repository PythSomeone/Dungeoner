package Items;

import GameEngine.Log;

public class Weapon extends _Item {
	
	private int damage;
	
	public boolean equipped = false;
	
	
	public Weapon(String name, int value, int damage) {
		super(name);
		this.damage = damage;
		this.value = value * damage * 4;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void equip() {
		equipped = true;
	}
	
	public void unequip() {
		equipped = false;
	}
	
	public void weaponInfo() {
		Log.info("Your current weapon : ");
		Log.info("Name : " + this.name);
		Log.info("Damage : " + this.damage);
		Log.info("Value : " + this.value);
	}
	
	public boolean canBeEquipped() {
		return true;
	}
	
	public boolean isWeapon() {
		return true;
	}

}
