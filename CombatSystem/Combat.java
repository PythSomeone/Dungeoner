package CombatSystem;


public class Combat {
	public Character player;
	public Character opponent;
	public Character winner;

	
	public Combat(Character player, Character opponent) {
		this.player=player;
		this.opponent=opponent;
		for(;;) {
			
			attack(player,opponent);
			if(!opponent.isAlive()) {
				setWinner(player);
				break;
			}
			
			attack(opponent,player);
			if(!player.isAlive()) {
				setWinner(opponent);
				break;
			}
		}
	}
	
	public String getWinner() {
		return winner.getName()+"has won";
	}
	public void setWinner(Character winner) {
		this.winner=winner;
	}
	public void attack(Character attacker,Character defender){
		String attackType = attacker.getPreferableAttack();
		if(attackType == "physical") {
			
		}
		if(attackType == "magical") {
			
		}

	}
}
