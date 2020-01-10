package Locations;

import java.util.ArrayList;
import java.util.Random;

import Characters.Hero;
import Characters.Monster;
import CombatSystem.Combat;
import GameEngine.Log;
import GameEngine.MonsterGenerator;

public class Dungeon {

	private int dungeonLevel;
	private int roomCount;
	private ArrayList<Monster> monsters = new ArrayList<>();
	
	private Random rand = new Random();
	
	public Dungeon(Hero hero) {
		
		this.dungeonLevel=hero.getLevel();
		
		
		for(int i=0;i<rand.nextInt(8)-1;i++) {
			if(rand.nextInt(20)%19==0) {
				Log.info("You've reached to the TREASURE ROOM!");
			}
			else {
				Log.info("You've stumbled upon group of enemies, prepare to fight");
				MonsterGenerator.setGenerator(getNumber(),getNumber(),getNumber());
				MonsterGenerator.generate(hero);
				for(Monster enemy:monsters) {
					Combat fight = new Combat(hero, enemy);
					fight.getWinner();
				}
			}
		}

		
		
	}
	private int getNumber() {
		int number = rand.nextInt(5);
		return number;
	}

}
