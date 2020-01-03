package GameEngine;

import Characters.Character;
import Characters.Rat;
import Locations.Tavern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;


public class MainGame
{
	

	private static Character champion;
	
	public MainGame(Character champion)
	{
		this.champion=champion;
	}
	
	
	public void play()
	{
	
		Scanner skan=new Scanner(System.in);
		
		 try {
	            while (true) 
	            {
	                System.out.println();
	                Log.info("What would you like to do?");
	                Log.info();
	                Log.info("Write show if u want to see ur champ");
	                Log.info("Write shop if u want go to shop");
	                Log.info("Write tavern if u want go to tavern");
	                Log.info("Write showmission if u want  to ur missions");
	                Log.info("Write underground if u want go to underground (lv<5)");
	                Log.info("Write forest if u want go to forest (lv<10)");
	                Log.info("Write dungeon if u want go to dungeon (lv<15)");
	                Log.info("Write exit if u want stop playing");
	                
	                
	                
	                String method = skan.nextLine();
	                this.findMethod(method);
	            }
		 	}	 catch (Throwable exception) 
		 	{
	            System.out.println(exception.getMessage());
		 	}
		 skan.close();
		 
	}

	 private void findMethod(String method) throws Throwable 
	 {
	        try {
	            Method reflectedMethod = this.getClass().getDeclaredMethod(method);
	            reflectedMethod.setAccessible(true);
	            reflectedMethod.invoke(this);
	        } catch (NoSuchMethodException | IllegalAccessException exception) {
	            System.out.println("There's no method like " + method);
	        } catch (InvocationTargetException exception) {
	            throw new Exception(exception.getTargetException().getMessage());
	        }
	  }
	

	 
	 
	 
	 
	 private  static void show() throws Exception 
	 {	 
		 champion.showstats();
	 }
	 
	 private  static void shop() throws Exception 
	 {
		 Log.info("welcome in shop");
		 champion.buyItems();
	 }
	 
	 private static void showmission() throws Exception 
	 {
		 
		 champion.checkmission();
	 }
	 
	 
	 
	 private void tavern() throws Exception
	 {
		 Log.info("welcome in tavern ");
		 Tavern.tavern();
	 }
	 
	 private void underground() throws Exception
	 {
		 
	 }
	 
	 private void forest() throws Exception
	 {
		 
	 }
	 
	 private void dungeon() throws Exception
	 {
		 
	 }
	 
	 private void exit() throws Exception
	 {
		 this.stop();
	 }
	 
	 private void stop() throws Exception 
	 {
	        throw new Exception("Game stopped.");
	 }
	 
	 
}
