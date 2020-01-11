package Interfaces;

public interface ItemsInterface 
{
	String getName();
	String getType();
	int getStats();
	int getValue();
	int getID();
	
	boolean canBeEquipped();
	boolean canBeSold();
	boolean isConsumable();
	boolean isWeapon();
	boolean isArmor();
}
