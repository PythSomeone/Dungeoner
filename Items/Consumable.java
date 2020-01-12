package Items;

public class Consumable extends _Item {

	private int power;	
	
	public Consumable(String name, int value, int power) {
		super(name);
		this.power = power;
		this.value = value;
		this.type = "Consumable";
	}
	
	public int getStats() {
		return power;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public boolean isConsumable() {
		return true;
	}
	
	public boolean allowMultiple() {
		return true;
	}
	
}
