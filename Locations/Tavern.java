package Locations;

import Characters.Character;
import GameEngine.Log;

public class Tavern 
{
	private  static Character champion;
	
	public Tavern(Character champion)
	{
		this.champion=champion;
	}
	
	
	
	
	public static void tavern()
	{
		if(champion.whichlv()<=5)
		{
			champion.mission(5);
			Log.info("u get first mission (u have to kill 5 rats)");
			
		}
		else if((champion.whichlv()>=5)&&(champion.whichlv()<=10))
		{
			champion.mission1(5);
			Log.info("u get second mission( u have to kill 5 wolfs)");
		}
		else if(champion.whichlv()>11)
		{
			champion.mission2(5);
			Log.info("u get last mission( u have to kill 5 skieletons)");
		}	
	}


}
