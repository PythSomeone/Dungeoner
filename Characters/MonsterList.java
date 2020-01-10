package Characters;
import java.util.ArrayList;

import Characters.Monster;

public class MonsterList {

	ArrayList<Monster> monsters = new ArrayList<Monster>();
	
	Monster rat = new Monster("Rat",50,50,5,5,5,5,5,1);
	Monster fatRat = new Monster("Fat Rat",50,50,5,5,5,5,5,1);
	
	private void initializeMonsterList() {
		monsters.add(rat);	monsters.add(fatRat);
	}
	
}
