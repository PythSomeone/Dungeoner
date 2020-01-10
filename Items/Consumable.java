package Items;

public class Consumable extends _Item {

	private int power;	
	
	public Consumable(int value, String name, int power) {
		super(value,name);
		this.power = power;
	}
	
	public int getPower() {
		return power;
	}
	
	public boolean isConsumable() {
		return true;
	}
	
}
