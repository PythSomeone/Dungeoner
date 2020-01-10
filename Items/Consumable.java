package Items;

public class Consumable extends _Item {

	private int power;	
	private int amount;
	
	public Consumable(String name, int value, int damage) {
		super(name);
		this.power = power;
		this.value = value;
	}
	
	public int getPower() {
		return power;
	}
	
	public void addConsumable() {
		amount++;
	}
	
	public void drinkConsumable() {
		amount--;
	}
	
	public boolean isConsumable() {
		return true;
	}
	
}
