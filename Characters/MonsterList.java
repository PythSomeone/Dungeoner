package Characters;
import java.util.ArrayList;

import Characters.Monster;

public class MonsterList {

	ArrayList<Monster> monsters = new ArrayList<Monster>();
	
	//[NAME][HP][MP][STR][AGI][INT][LCK][TGH][LVL][EXP][GOLD]//
	Monster rat = new Monster("Rat",50,50,5,5,5,5,5,1,10,1);
	Monster bat = new Monster("Bat",50,50,5,5,5,5,5,1,25,3);
	
	private void initializeMonsterList() {
		monsters.add(rat);	monsters.add(bat);
	}
	
}
