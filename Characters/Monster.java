package Characters;

import GameEngine.Start;

abstract public class Monster 
{
	
	public int hp;
	public int dmg;
	
	public Monster(int hp,int dmg)
	{
		this.hp=hp;
		this.dmg=dmg;
		
	}

	public abstract void fight();
	public  abstract void drop();
		
	
	
	
}
