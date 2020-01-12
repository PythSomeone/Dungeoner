import Characters.Hero;
import GameEngine.GameManager;


public class Main 
{
	public static void main(String[] args) 
	{
		// INIT //
		
		Hero hero;
		
		// GAME //
		
		GameManager.greetingMessage();
		hero = GameManager.getHero();
		
}
}
