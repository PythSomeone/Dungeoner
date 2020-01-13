package Locations;

import java.util.ArrayList;
import java.util.Random;

import Characters.Hero;
import Characters.Monster;
import CombatSystem.Combat;
import GameEngine.Log;
import GameEngine.LootManager;
import GameEngine.MonsterGenerator;

public class Dungeon {

	private int dungeonLevel;
	private int roomCount;
	private ArrayList<Monster> monsters = new ArrayList<>();
	
	private Random rand = new Random();
	
	public Dungeon(Hero hero) {
		
		this.dungeonLevel=hero.getLevel();
		
		
		for(int i=0;i<rand.nextInt(8)+3;i++) {
			boolean prize=false;

			if(rand.nextInt(20)%19==0) {
				Log.info("You've stumbled upon the TREASURE ROOM!");
				Log.info("Following items have dropped : ");
				LootManager.chestDrop(hero);
				Log.pressAnyKeyToContinue();
			}
			
			else {
				MonsterGenerator.setGenerator(getNumber(),getNumber(),getNumber());
				monsters = MonsterGenerator.generate(hero);
				
				if(monsters.size() > 1)					Log.info("You enter the next room. It is filled with all kinds of aggressive monsters. You have no choice but to fight.");
				else if(monsters.size() == 1)			Log.info("You enter the next room. An enemy is running at you from his center. Get ready to fight.");
				else if(monsters.size() < 1)			Log.info("You enter the next room. Apart from dirt and dried blood on the walls, there is nothing interesting here.");
				
				for(Monster enemy:monsters) {
					Combat fight = new Combat(hero, enemy);
					fight.getWinner();
					if(!hero.isAlive()) break;
				}
				if(!hero.isAlive()) { 
					Log.info("You died! Game over, good luck next time!");
					break;
				}else prize = true;
				Log.info("Following items have dropped : ");
				if(prize) LootManager.monsterDrop(hero, monsters.size());
				Log.pressAnyKeyToContinue();
			}
		}

		
		
	}
	private int getNumber() {
		int number = rand.nextInt(2);
		return number;
	}

}
