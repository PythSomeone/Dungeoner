import GameEngine.Log;
import GameEngine.MainGame;
import Items.Generators.WeaponGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import Characters.Hero;
import Characters.CharacterClasses.Assassin;
import Characters.CharacterClasses.Warrior;

public class Main 
{
	public static void main(String[] args) 
	{
	
		Log.info(WeaponGenerator.getRandomWarriorName());
		Log.info(WeaponGenerator.getRandomMageName());
		Log.info(WeaponGenerator.getRandomAssasinName());
	
	}
	
}