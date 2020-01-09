package CombatSystem;

public class Ability {
	
	private String name;
	private int multiplier;
	private int manaUsage;
	
	public Ability(String name, int multiplier, int manaUsage) {
		this.name = name;
		this.multiplier = multiplier;
		this.manaUsage = manaUsage;
	}
}
