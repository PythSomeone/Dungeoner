package Items;

public class Armor extends _Item {

	private int defence;
	
	public boolean equipped;
	
	
	public Armor(int value, String name, int defence) {
		super(value,name);
		this.defence = defence;
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
