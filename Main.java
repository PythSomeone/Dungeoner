import Characters.Hero;
import GameEngine.GameManager;
import GameEngine.Log;
import Locations.Dungeon;


public class Main 
{
	public static void main(String[] args) 
	{
		GameManager.gameRunning = true; // determines if player wants to q game
		while(GameManager.gameRunning == true) {
			
			// MAIN MENU //
			GameManager.mainMenu(); // start/quit game
			
			if(GameManager.gameRunning) {
				// INIT //
				Hero hero; //initialize hero
				GameManager.greetingMessage(); // introduction and hero creation
				hero = GameManager.getHero(); // send created hero into proper slot
				
				// GAME //
				while(hero.isAlive()) {
					Dungeon dungeon = new Dungeon(hero); // starts adventure in dungeon
					//[INSERT CITY WHEN DONE]//
				}
			}else Log.info("SEE YOU NEXT TIME!");
			
		}
		
}
}
