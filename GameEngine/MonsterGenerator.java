package GameEngine;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Characters.Hero;
import Characters.Monster;
import Characters.Monsters.Rat;
import Characters.Monsters.Skeleton;

public class MonsterGenerator {

    private static int Rat_COUNT=0;
    private static int Skeleton_COUNT=0;
    private static int Ghul_COUNT=0;
    
public static void setGenerator(int Rat,int Skeleton,int Ghul) {

		Rat_COUNT=Rat;
		Skeleton_COUNT=Skeleton;
		Ghul_COUNT=Ghul;

	
}
    public static ArrayList<Monster> generate(Hero hero) {
        ArrayList<Monster> queue = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < Rat_COUNT; i++) {
            queue.add(new Rat("Jacek",20,10,4,4,4,4,4,( hero.getLevel() + rand.nextInt(6)-3 )));
        }

        for (int i = 0; i < Skeleton_COUNT; i++) {
            queue.add(new Skeleton("Maciek",20,10,4,4,4,4,4,( hero.getLevel() + rand.nextInt(6)-3 )));
        }
        
        for (int i = 0; i < Ghul_COUNT; i++) {
            queue.add(new Skeleton("Grzegorz",20,10,4,4,4,4,4,( hero.getLevel() + rand.nextInt(6)-3 )));
        }


        Collections.shuffle(queue);

        return queue;
    }



}
