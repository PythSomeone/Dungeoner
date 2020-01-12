package CombatSystem;

import java.util.ArrayList;
import java.util.Scanner;

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
			
			playerAttack(player,enemy);
			if(!enemy.isAlive()) {
				setWinner(player);
				break;
			}
			
			
			enemyAttack(player,enemy);
			if(!player.isAlive()) {
				setWinner(enemy);
				break;
			}
			
		}
	}
	

	
	
	public void playerAttack(Hero player,Monster enemy){
		ArrayList<Ability> abilities = player.getAbilities();
		
		
		Scanner scan = new Scanner(System.in);
		String option;
		boolean success = false;
		int opt = 0;

		while (!success) {
			Log.info("Choose ability id to attack an enemy ");
			player.printAbilityList();
			option = scan.nextLine();
			try {
				opt = Integer.parseInt(option);
				success = true;
			}
			catch(NumberFormatException e) {
				Log.info("Wrong format");
				success = false;
			}
		}
		
		for(Ability ability: abilities)
		{
			if(opt == ability.getID()) {
				int damage = (ability.getMultiplier()*player.getStrenght())-enemy.getToughness();
				enemy.dealDamage(damage);
			}
		}			
		

	}
	
	public void enemyAttack(Hero player,Monster enemy){
		int damage=enemy.getRandomAbility().getMultiplier()*enemy.getStrenght();
		player.dealDamage(damage);
	}
	
	public void getWinner() {
		Log.info(winner.getName()+" has won");
	}
	
	public void setWinner(Character winner) {
		this.winner=winner;
	}
}
