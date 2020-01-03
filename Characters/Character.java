package package3;

import package2.Log;

import package2.Start;
import package4.Interface;
import package2.MainGame;
import java.util.Scanner;

public class Character implements Interface
{
	private String name;
	private int hp;
	private int exp;
	private int lv;
	private int dmg;
	private int gold;
	
	private String bow;//bronze silver gold 
	private String armor;
	private Interface champion;
	private boolean m1 =false;
	private boolean m2 = false;
	private boolean m3 = false;
	
	public int count_kill_rats=0;
	public int count_kill_wolfs=0;
	public int count_kill_skieletons=0;
	
	
	public Character(String name,int hp,int exp,int lv,int dmg,int gold)
	{
		this.name=name;
		this.hp=hp;
		this.exp=exp;
		this.lv=lv;
		this.dmg=dmg;
		this.gold=gold;
	}
	
	
	public  void  LvUp() 
	{	
		  if (this.exp>=100)
		  {
			  this.lv++;
			  this.exp=0;
			  Log.info("LeveL UP GJ");
		  }	
	}
	
	public void items() 
	{
		if(this.bow=="bronze bow")
		{
			this.dmg=this.dmg*2;
		}

		if(this.bow=="silver bow")
		{
			this.dmg=this.dmg*2;
		}
		
		if(this.bow=="bronze armor")
		{
			this.hp=this.hp*2;
		}
		
		if(this.bow=="silver armor")
		{
			this.hp=this.hp*2;
		}

	}
	
	public int whichlv()
	{
		return this.lv;
	}
	
	public void showstats() 
	{
		Log.info("ur lv ="+ this.lv);
		Log.info("ur hp ="+ this.hp);
		Log.info("ur dmg ="+ this.dmg);
		Log.info("ur hp="+ this.hp);
		Log.info("ur hp="+ this.gold);
		Log.info("u have "+ this.bow);
		Log.info("u have "+ this.armor);
	}
	
	public void checkmission()
	{
		Log.info("first mission = "+this.m1);
		Log.info("second mission = "+this.m2);
		Log.info("last mission = "+this.m3);
		
		
		
		
	}
		
	public boolean mission(int x)
	{
		if(this.count_kill_rats>=x)
		{
			Log.info("u finish first misson ( +20 gold)");
			this.gold=this.gold+20;
			return this.m1=true;
		}
		else
		{
			return this.m1=false;	
		}	
	}
	
	
	
	public boolean mission1(int x)
	{
		if(this.count_kill_wolfs>=x)
		{
			Log.info("u finish second misson ( +40 gold)");
			this.gold=this.gold+40;
			return this.m2=true;
		}
		else
		{
			return this.m2=false;	
		}
	}
	
	
	
	
	public boolean mission2(int x)
	{
		if(this.count_kill_skieletons>=x)
		{
			Log.info("u finish second misson ( +70 gold)");
			this.gold=this.gold+70;
			return this.m3=true;
		}
		else
		{
			return this.m3=false;	
		}
	}
	
	
	public  void buyItems()
	{
		int k=0;
		
			Log.info("press 1  healt potion (5 gold)\"");
			Log.info(" press 2 bronze bow (25 gold)");
			Log.info("press 3 silver bow (50 gold)");
			Log.info(" press 4bronze armor (25 gold)");
			Log.info(" press 5silver armor(50 gold)");
			System.out.println("press 6 to quit");
			 
		while(k!=6)	
		{
			 
			 Scanner skan2 = new Scanner(System.in);
				k=skan2.nextInt();
		switch (k) {
		    case 1:
		        
		        if(this.gold>=5)
		        {
		        	this.hp=this.hp+10;
		        	this.gold=this.gold-5;
		        	Log.info("ur hp"+this.hp);
		        }else
		        {
		        	Log.info("not enought money");
		        }
		        break;
		    case 2:
		        
		        if((this.gold>=25)||(this.bow!="bronze bow"))
		        {
		        	this.bow="bronze bow";
		        	this.gold=this.gold-25;
		        	Log.info("u have bronze bow now");
		        	champion.items();
		        }else
		        {
		        	Log.info("not enought money or u already have this stuff ");
		        }
		        break;
		    case 3:
		        
		        if((this.gold>=50)||(this.bow!="silver bow"))
		        {
		        	this.bow="silver bow";
		        	this.gold=this.gold-50;
		        	Log.info("u have silver bow now");
		        	champion.items();
		        }else
		        {
		        	Log.info("not enought money or u already have this stuff ");
		        }
		        break;    
		    case 4:
		    
		        if((this.gold>=25)||(this.armor!="bronze armor"))
		        {
		        	this.armor="bronze armor";
		        	this.gold=this.gold-25;
		        	Log.info("u have bronze armor now");
		        	champion.items();
		        }else
		        {
		        	Log.info("not enought money or u already have this stuff ");
		        }
		        break;
		    case 5:
		        
		        if((this.gold>=50)||(this.armor!="silver armor"))
		        {
		        	this.armor="silver armor";
		        	this.gold=this.gold-50;
		        	Log.info("u have silver armor now");
		        	champion.items();
		        }else
		        {
		        	Log.info("not enought money or u already have this stuff ");
		        }
		        break;     
		    case 6:
		        
		        break;
		
		}}
	
		}




	




	
	}
	





