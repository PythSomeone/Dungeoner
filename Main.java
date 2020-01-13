import Characters.Hero;
import GameEngine.GameManager;
import Locations.Dungeon;


public class Main 
{
	public static void main(String[] args) 
	{
		// INIT //
		
		Hero hero;
		
		// GAME //
		
		GameManager.greetingMessage();
		hero = GameManager.getHero();
		 Dungeon dungeon = new Dungeon(hero);
		
}
}
