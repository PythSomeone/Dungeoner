package CombatSystem;

import Characters.Character;
import Characters.Hero;
import Characters.Monster;
import GameEngine.Log;

public class Combat {
	
	public Hero player;
	public Monster enemy;
	public Character winner;

	public Combat(Hero player, Monster enemy) {
		
		this.player=player;
		this.enemy=enemy;
		for(;;) {
			/*
			playerAttack(player,enemy);
			if(!enemy.isAlive()) {
				setWinner(player);
				break;
			}
			*/
			
			enemyAttack(player,enemy);
			if(!player.isAlive()) {
				setWinner(enemy);
				break;
			}
			
		}
	}
	

	
	
	public void playerAttack(Hero player,Monster enemy){
		Log.info("Choose your ability to attack your enemy");
		player.printAbilityList();
			
		

	}
	public void enemyAttack(Hero player,Monster enemy){
		
		int damage=enemy.getRandomAbility().getMultiplier()*enemy.getStrenght();
		player.dealDamage(damage);
		

	}
	public String getWinner() {
		return winner.getName()+"has won";
	}
	
	public void setWinner(Character winner) {
		this.winner=winner;
	}
}
