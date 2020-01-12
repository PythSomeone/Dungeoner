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
				Log.info("You've reached to the TREASURE ROOM!");
				LootManager.chestDrop(hero);
			}
			
			else {
				Log.info("You've stumbled upon group of enemies, prepare to fight");
				MonsterGenerator.setGenerator(getNumber(),getNumber(),getNumber());
				monsters = MonsterGenerator.generate(hero);
				
				for(Monster enemy:monsters) {
					Combat fight = new Combat(hero, enemy);
					fight.getWinner();
					if(!hero.isAlive()) break;
				}
				if(!hero.isAlive()) { 
					Log.info("You died!");
					break;
				}
			prize = true;
			}
			Log.info("Following items have dropped");
			if(prize) LootManager.monsterDrop(hero, monsters.size());
		}

		
		
	}
	private int getNumber() {
		int number = rand.nextInt(2);
		return number;
	}

}
