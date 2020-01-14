package Interfaces;

public interface ItemInterface 
{
	String getName();
	String getType();
	int getStats();
	int getValue();
	int getID();
	int getAmount();
	
	void addAmount();
	void decreaseAmount();
	
	boolean canBeEquipped();
	boolean canBeSold();
	boolean allowMultiple();
	boolean isConsumable();
	boolean isWeapon();
	boolean isArmor();
}
