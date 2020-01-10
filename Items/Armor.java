package Items;

public class Armor extends _Item {

	private int defence;
	
	public boolean equipped;
	
	
	public Armor(String name, int damage) {
		super(name);
		this.defence = defence;
		this.value = value * defence;
	}
	
	public int getDefence() {
		return defence;
	}
	
	public boolean canBeEquipped() {
		return true;
	}
	
	public boolean isArmor() {
		return true;
	}

	
}
