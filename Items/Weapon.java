package Items;

public class Weapon extends _Item {
	
	private int damage;
	
	public boolean equipped = false;
	
	
	public Weapon(int value, String name, int damage) {
		super(value,name);
		this.damage = damage;
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
	
	public boolean canBeEquipped() {
		return true;
	}
	
	public boolean isWeapon() {
		return true;
	}

}
