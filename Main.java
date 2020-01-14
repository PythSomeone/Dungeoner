import Characters.Hero;
import GameEngine.GameManager;
import Locations.Dungeon;


public class Main 
{
	public static void main(String[] args) 
	{
		// INIT //
		
		Hero hero; //initialize hero
		
		// GAME //
		
		GameManager.greetingMessage(); //introduction and hero creation
		hero = GameManager.getHero(); //send created hero into proper slot
		Dungeon dungeon = new Dungeon(hero); //starts adventure in dungeon
		
}
}
