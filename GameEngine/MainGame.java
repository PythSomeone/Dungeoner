package GameEngine;

import Characters.Character;
import Characters.Hero;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;


public class MainGame
{
	
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
	

	 
	 
	 
	 
	 private  static void showStats(Hero hero) throws Exception 
	 {	 
		 //hero.showstats();
	 }
	 
	/* private  static void shop() throws Exception 
	 {
		 Log.info("welcome in shop");
		 champion.buyItems();
	 }*/
	 
	
	 
	 
	
	 
	 private void exit() throws Exception
	 {
		 this.stop();
	 }
	 
	 private void stop() throws Exception 
	 {
	        throw new Exception("Game stopped.");
	 }
	 
	 
}
