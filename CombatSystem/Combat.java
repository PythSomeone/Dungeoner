package CombatSystem;

import java.util.ArrayList;
import java.util.Scanner;

import Characters.Character;
import Characters.Hero;
import Characters.Monster;
import Characters.CharacterClasses.Assassin;
import Characters.CharacterClasses.Mage;
import Characters.CharacterClasses.Warrior;
import GameEngine.Log;

public class Combat {
	
	public Hero player;
	public Monster enemy;
	public Character winner;

	public Combat(Hero player, Monster enemy) {
		
		this.player=player;
		this.enemy=enemy;
		
		Log.info("Your current oponnent : ");
		enemy.printCharacter();
		Log.pressAnyKeyToContinue();
		
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
			boolean actionDone = false;
			while(!actionDone) {
				if(opt == ability.getID()) {
					int damage = 0;
					if(player.hasEnoughMana(ability)) {
						if(player instanceof Assassin) {
							damage = ability.getMultiplier()*(player.getAgility()+player.getWeapon().getStats())-enemy.getToughness();
							Log.info(player.getName() + " use " + ability.getName());
							enemy.dealDamage(damage);
							actionDone = true;
						}
						else if(player instanceof Warrior) {
							damage = ability.getMultiplier()*(player.getStrenght()+player.getWeapon().getStats())-enemy.getToughness();
							Log.info(player.getName() + " use " + ability.getName());
							enemy.dealDamage(damage);
							actionDone = true;
						}
						else if(player instanceof Mage) {
							damage = ability.getMultiplier()*(player.getInteligence()+player.getWeapon().getStats())-enemy.getToughness();
							Log.info(player.getName() + " use " + ability.getName());
							enemy.dealDamage(damage);
							actionDone = true;
						}	
					}else Log.info("You dont have enough mana");
				}
			}
		}			
		

	}
	
	public void enemyAttack(Hero player,Monster enemy){
		Ability randomAbility = enemy.getRandomAbility();
		int damage=(randomAbility.getMultiplier()*enemy.getStrenght())-player.getArmor().getStats();
		Log.info(enemy.getName() + " use " + randomAbility.getName());
		player.dealDamage(damage);
	}
	
	public void getWinner() {
		Log.info(winner.getName()+" has won");
		Log.pressAnyKeyToContinue();
	}
	
	public void setWinner(Character winner) {
		this.winner=winner;
	}
	
}
