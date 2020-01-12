package CombatSystem;

public class Ability {
	
	private String name;
	private int abilityID;
	private int multiplier;
	private int manaUsage;
	
	public Ability(int abilityID, String name, int multiplier, int manaUsage) {
		this.abilityID = abilityID;
		this.name = name;
		this.multiplier = multiplier;
		this.manaUsage = manaUsage;
	}
	public String getName() {
		return this.name;
	}
	
	public int getManaUsage() {
		return manaUsage;
	}
	
	public int getMultiplier() {
		return multiplier;
	}
	public int getID() {
		return abilityID;
	}
}
