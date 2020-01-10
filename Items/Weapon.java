package Items;

public class Weapon extends _Item {
	
	private int damage;
	private String characterClass;
	
	public boolean equipped;
	
	
	public Weapon(int value, String name, int damage) {
		super(value,name);
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public String getCharacterClass() {
		return characterClass;
	}
	
	public boolean canBeEquipped() {
		return true;
	}
	
	public boolean isWeapon() {
		return true;
	}

}
