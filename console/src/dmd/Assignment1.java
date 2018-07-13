package dmd;

import javax.swing.JOptionPane;
//poke cleave stab smash
class Assignment1 {
	
	//setting variables
	public static int num = 0;
	public static int enemyHealth = 0;
	public static int myHp = 0;
	public static int enemyHp = 0; 
	public static int lvlChoice = 0;
	public static int choice;
	public static int choiceWeapon = 0;
	public static String weapon[] = {"sword", "bow", "dagger", "spear", "nothing"};
	public static String enemy[] = {"null", "zombie", "skeleton","grizzly", "barbarian", "assasin"};
	public static int enemyRandom = 0;
	public static int enemyDamage = 0;
	public static String boss[] = {"null", "dragon", "big mice", "BATMAN", "Shrek"};
	public static int bossRandom = 0;
	public static int bossHp = 0;
	public static int bossDamage = 0;
	public static int rand = 0;
	public static int damage = 0;
	public static int enemyNum = 0;
	public static String story = " ";
	public static String name = " ";
	public static String actor = " ";
	public static char sound;
	public static int doorChoice = 0;
	public static int maxL = 0;
	public static String door[] = {"right", "left", "straight"};
	public static int rightWay = 0;
	public static int treasureRnd = 0;
	public static int pillHealth = 0;
	public static int saveHpEnemy = 0;
			
	public static void main(String[] args) {
        
		
        //confirm to start a game
		choice = JOptionPane.showConfirmDialog(null, "Do you want to start a game?", "Start game", 0);
		System.out.println(choice);
        
		int play = checkClose(choice, choiceWeapon, lvlChoice);
        
        if (play == 1){
        	//run method level
        	level();
        	//run method repeat
        	repeat();
        }	
	}//end of method
	
	public static int checkClose(int choice, int choiceWeapon, int lvlChoice){
		//if player click on close
		 if(choice == JOptionPane.CLOSED_OPTION){
			 //close game
			 return 0;
			}
		//if player click on close
		 else if(choiceWeapon == JOptionPane.CLOSED_OPTION){
			 return 0;		 
			}
		//if player click on close
		else if(lvlChoice == JOptionPane.CLOSED_OPTION){
			return 0;			 
		}
		//if player click on close
		 if(choice == JOptionPane.NO_OPTION){
			return 0;			
		}	 
		 return 1;
	}//end of method
	
	
	public static void level(){
		//setting variables
		String levelChoice[] = {"peacefull", "easy", "medium", "hard"};
		lvlChoice = 0;
		//player need to choose difficality
		//msg output
		lvlChoice = JOptionPane.showOptionDialog(null, "Choose your difficalty", "LVL", JOptionPane.YES_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, null, levelChoice, 0);
		//gamepeace choice
		if(lvlChoice == 0){
			gamePeace();
		}
		//easy choice
		if(lvlChoice == 1){
			num = 2;
			game();
		}
		//medium choce
		if(lvlChoice == 2){
			num = 4;
			game();
		}
		//hard choice
		if(lvlChoice == 3){
			num = 7;
			game();
		}
		//if player close window, close game
		checkClose(choice, choiceWeapon, lvlChoice);
	}//end of method
	
	public static void repeat(){
		//asking for new game
		choice = JOptionPane.showConfirmDialog(null,"Do you want to play again?", "New game?", 0);
		//if player click on NO or CLOSED - close game
		checkClose(choice, choiceWeapon, lvlChoice);
		// if player click on YES - play a new game
		if(choice == JOptionPane.YES_OPTION){
			level();
		}
	}//end of method
	
	public static void gamePeace(){
		//msg input name (string)
        name = JOptionPane.showInputDialog(null, "What is your name?", "", JOptionPane.QUESTION_MESSAGE);
        //if player click to close - close game
        if ( ( name != null ) && ( name.length( ) >= 0) ) {
        } else {
            System.exit(0);
        }
       
        //msg input age (int)
        int age =  Integer.parseInt(JOptionPane.showInputDialog(null, name + ", how old are you?", "", JOptionPane.QUESTION_MESSAGE));
        
        //msg input city (string)
        String city = JOptionPane.showInputDialog(null, name + ", where you from?\nExample: country, city", "", JOptionPane.QUESTION_MESSAGE);
        //if player click to close - close game
        if ( ( city != null ) && ( city.length( ) >= 0) ) {
        } else {
            System.exit(0);
        }
        
        //msg input actor (string)
        actor = JOptionPane.showInputDialog(null, "What is your favorite actor?", "", JOptionPane.QUESTION_MESSAGE);
        
        //message about story
        //setting variable for story
        story = "There was " + name + "."+ name + " was " + age + " ." + name + " was living in " + city + 
        			    ". His favorite actor was " + actor + ".\nOnce upone time, " + name + " and " + actor + " met each other.\n" +
        				 "They fell in love imiditally. After 5 weeks they played marriage";
        //output story
        JOptionPane.showMessageDialog(null, story, "", JOptionPane.PLAIN_MESSAGE);
        //ask for new game
        repeat();

	}//end of method
	
	public static void game() {
		
		//generating health for player
		myHp = 100; 
		//setting this variables 
		lvlChoice = 1;
		choice = 0;
		choiceWeapon = 0;
		//generating boss
        bossRandom = $DZ.getRand(4);
        bossHp = $DZ.getRand(num)*10;
        bossDamage = $DZ.getRand(num)*6;
        
        //msg input name (string)
        name = JOptionPane.showInputDialog(null, "What is your name?", "", JOptionPane.QUESTION_MESSAGE);
        if ( ( name != null ) && ( name.length( ) >= 0) ) {
        } else {
            System.exit(0);
        }
       
        //msg input age (int)
        int age =  Integer.parseInt(JOptionPane.showInputDialog(null, name + ", how old are you?", "", JOptionPane.QUESTION_MESSAGE));
        
        //msg input letter (char)
        sound = JOptionPane.showInputDialog(null,"Enter you favorite letter").charAt(0);
        
        //msg input city (string)
        String city = JOptionPane.showInputDialog(null, name + ", where you from?\nExample: country, city", "", JOptionPane.QUESTION_MESSAGE);
        //if player click to close - close game
        if ( ( city != null ) && ( city.length( ) >= 0) ) {
        } else {
            System.exit(0);
        }
        
        //msg input actor (string)
        actor = JOptionPane.showInputDialog(null, "What is your favorite actor?", "", JOptionPane.QUESTION_MESSAGE);
        
        //message about story
        //setting story variable
        story = "There was " + name + ". " + name + " was " + age + "." + name + " was living in " + city + 
           ". His favorite actor was " + actor + ".\nOnce upone time, someone occupied " + actor + "'s house. Every one who was trying to save " +
        	   actor + " die... " + name + " decided to save " + actor + "." + "\n" + name + " went to " + actor +"'s house." + 
        	      " No one was defeating entrence to " + actor + "'s house. " + name + " went into the house. A door imidetally was locked...\n" +
        			       name + " saw a treausure near door...";
        //output mag story
        JOptionPane.showMessageDialog(null, story, "", JOptionPane.PLAIN_MESSAGE);
        
        //treasure system 1
        //ask to open
        choice = JOptionPane.showConfirmDialog(null, "Do you want to open a treasure?", "TREASURE", 0); 
        //if player choice to open
        if(choice == JOptionPane.YES_OPTION){	
        	//option to choose weapon
            choiceWeapon = JOptionPane.showOptionDialog(null, "You find weapons. What you want to take?", "Weapon choice", JOptionPane.YES_OPTION, 
    															JOptionPane.INFORMATION_MESSAGE, null, weapon, 0);
            checkClose(choice, choiceWeapon, lvlChoice);
            //msg about weapon
            JOptionPane.showMessageDialog(null, "You have " + weapon[choiceWeapon], "", JOptionPane.INFORMATION_MESSAGE);
	        }
		 else {choiceWeapon = 4;
		    //msg about weapon
	        JOptionPane.showMessageDialog(null,"You have " + weapon[choiceWeapon]+"\nYour damage is" + damage + "\nYour health is" + myHp
	        		, "", JOptionPane.INFORMATION_MESSAGE);
		 }
        //if player click on close - close game
        checkClose(choice,choiceWeapon, lvlChoice);
        //go to room
        maze();
                
   }//end of method
	
	public static void maze(){
		//generating enemy
		enemyHp = $DZ.getRand(num)*5; 
        enemyRandom = $DZ.getRand(5);
        enemyHealth = $DZ.getRand(num)*7;
        enemyDamage = $DZ.getRand(num)*3;
        //generating right door
		rightWay = $DZ.getRand(3)-1;
		//checking tries
		if (maxL == 6*num){
			boss();
		}
		//generating treasure
		treasureRnd = $DZ.getRand(400);
		//msg story
		JOptionPane.showMessageDialog(null,name + " went to another room.", "", JOptionPane.INFORMATION_MESSAGE);
		//spawn of treasure
		if (treasureRnd >= 30*num){
			JOptionPane.showMessageDialog(null,"He saw a treasure.", "", JOptionPane.INFORMATION_MESSAGE);
			//ask to open a treasure
			choice = JOptionPane.showConfirmDialog(null, "Do you want to open a treasure?", "TREASURE", 0);
			//if player choose to open
	        if(choice == JOptionPane.YES_OPTION){
	        	JOptionPane.showMessageDialog(null,"You find a PILL_OF_HEALTH!", "Health", JOptionPane.INFORMATION_MESSAGE);
	        	pillHealth = $DZ.getRand(4*num);
	        	myHp = myHp + pillHealth;
	        	JOptionPane.showMessageDialog(null,"You just used a PILL_OF_HEALTH\nYou hp: " +myHp, "Health", JOptionPane.INFORMATION_MESSAGE);
	        }
		}
		else if (treasureRnd <30*num){
			JOptionPane.showMessageDialog(null,"He saw a treasure.", "", JOptionPane.INFORMATION_MESSAGE);
			//ask to open a treasure
			choice = JOptionPane.showConfirmDialog(null, "Do you want to open a treasure?", "TREASURE", 0);
			//if player choose to open
	        if(choice == JOptionPane.YES_OPTION){
	        	JOptionPane.showMessageDialog(null,"SnAKE!!!", "OoooOPS!", JOptionPane.INFORMATION_MESSAGE);
	        	myHp = myHp - $DZ.getRand(2)*num;
	        	JOptionPane.showMessageDialog(null,"Snake bite you!!!\nYou hp: " +myHp, "OoooOPS!", JOptionPane.INFORMATION_MESSAGE);
	        }
		}
		//choice to go to another room(2 wrong rooms and 1 right to a boss)
		doorChoice = JOptionPane.showOptionDialog(null, "In which door you want to go?", "Door choice", JOptionPane.YES_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, null, door, 0);
		//going to boss if player choose right door
		if (doorChoice == rightWay){
			boss();
		}
		//if player accidentally close window ignore it and go to another random room with enemies
		else if (doorChoice == JOptionPane.CLOSED_OPTION){
			fightSystem();
			maxL = maxL+1;
			}
		//if player choose wrong door go to another room with enemies
		else{
	       fightSystem();
	       maxL = maxL+1;
		}
	}//end of method
	
	public static void weaponCheck(){
	    //damage system (checking weapon and give damage to player)
        damage = 0;
        if(choiceWeapon == 0){
        	damage = 15;
        }
        else if (choiceWeapon == 1){
        	damage = 15;
        }
        else if (choiceWeapon == 2){
        	damage = 8;
        }
        else if (choiceWeapon == 3){
        	damage = 12;
        }
        else if (choiceWeapon == 4){
        	damage = 6;
        }
	}//end of method
	
	public static void fightSystem(){
		//generating number of enemies
        enemyNum = $DZ.getRand(num)+1;
        //msg about story
        story = "Our character went into room. " + name + " heard " + sound + " sound. He saw " + enemyNum + " "  + enemy[enemyRandom] + ".";
        JOptionPane.showMessageDialog(null, story, "", JOptionPane.INFORMATION_MESSAGE);
        
        //check weapon
        weaponCheck();
        
        //asking player to fight
        choice = JOptionPane.showConfirmDialog(null, "Do you want to fight with " + enemyNum + " " + enemy[enemyRandom] + "?", "FIGHT?", 0);
        
        //generating variable for first attack (who is going first: enemy or player)
        rand = $DZ.getRand(100);
        //if player choose to fight with enemies
        if (choice == JOptionPane.YES_OPTION){	
        	//msg with info
        	JOptionPane.showMessageDialog(null,"FIGHT", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        	JOptionPane.showMessageDialog(null,"Your damage is " + damage + ".You have " + myHp + " hp.\n" + "Each of " + enemy[enemyRandom] 
        			+ " have " + enemyHp + " health. You are going to fight " + enemyNum + " of them." , "Fight", JOptionPane.INFORMATION_MESSAGE);
        	//saving enemyHp  
        	saveHpEnemy = enemyHp;
        	//generating first attack (who is going first: enemy or player)
        	if (rand <50){
        		JOptionPane.showMessageDialog(null,"You go first!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		//calculating health
        		while (myHp >0 & enemyNum >0){
        			enemyHp = enemyHp - damage;
        			//if player kill enemy
        			if (enemyHp <0){
        				//number of enemies -1
        				enemyNum = enemyNum-1;
        				//return enemyHp to a normal Health (without this enemyHp will be <0 and player will kill enemy with one attack)
        				enemyHp = saveHpEnemy;
        			}
        			if (enemyNum >0){
        			myHp = myHp - enemyDamage;}
        			// shows info about battle
        			JOptionPane.showMessageDialog(null,"My hp: " + myHp + "\nEnemy health: " + enemyHp + "\nNumber of enemies: " + enemyNum , 
        																								"FIGHT", JOptionPane.INFORMATION_MESSAGE);
        			
        			}
        	}else{
        		//generating first attack (who is going first: enemy or player)
        		JOptionPane.showMessageDialog(null,"You go second!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		//calculating health
        		while (myHp >0 & enemyNum >0){
    				myHp = myHp - enemyDamage;	
    				enemyHp = enemyHp - damage;
    				//if player kill enemy
    				if (enemyHp <0){
    					//number of enemies -1 (one of them already died)
        				enemyNum = enemyNum-1; 
        				//return enemyHp to a normal Health (without this enemyHp will be <0 and player will kill enemy with one attack)
        				enemyHp = saveHpEnemy;}
    				// shows info about battle
        			JOptionPane.showMessageDialog(null,"My hp: " + myHp + "\nEnemy health: " + enemyHp + "\nNumber of enemies: " + enemyNum , 
        																							"FIGHT", JOptionPane.INFORMATION_MESSAGE);
        			
    				}
        	}
        	//checking health 
        	//if player win battle
        	if (myHp >0 & enemyHp<=0){
        		JOptionPane.showMessageDialog(null,"You won the fight! You health: " + myHp, "FIGHT", JOptionPane.INFORMATION_MESSAGE);
            	JOptionPane.showMessageDialog(null,"You went to a door. There was a ladder. " + name + " went upstairs.", 
            																				"", JOptionPane.INFORMATION_MESSAGE);
        	}
        	//if player lose
        	else if (myHp <=0 & enemyHp>0){
        		JOptionPane.showMessageDialog(null,"You die...", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,"Game over!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		repeat();
        	}
        	//if player still alive go to another room
           maze();
        	}
        else {
        	//if player run away go to another room
        	maze();
        }
	}//end of method

	public static void boss(){
        //check weapon
        weaponCheck();
		
		//story msg + JOption
		story = "When he went in a door, he saw " + actor + " tied with chain to wall. Near " + actor + " was " + boss[bossRandom] + 
																					". " + name + " came closer to " + boss[bossRandom];
        JOptionPane.showMessageDialog(null,story, "", JOptionPane.INFORMATION_MESSAGE);
        //system boss choice
        //checking of a boss
        //batman
        if (bossRandom ==3){
        	//what happens if you have to fight with batman
        	JOptionPane.showMessageDialog(null,"He started to attack you.\n AND...", "", JOptionPane.INFORMATION_MESSAGE);
        	JOptionPane.showMessageDialog(null,"AND...", "", JOptionPane.INFORMATION_MESSAGE);
        	JOptionPane.showMessageDialog(null,"AND...", "", JOptionPane.INFORMATION_MESSAGE);
        	JOptionPane.showMessageDialog(null,"You die in a fight with BATMAN! No one can beat BATMAN", "GAMEOVER", JOptionPane.INFORMATION_MESSAGE);
        }
        //shrek
        else if (bossRandom ==4){
        	//msg input answer
        	//shrek is a boss
        	//you replic to shrek
            String answer = JOptionPane.showInputDialog(null, "He asked you:\n -What do you want from me?", "DIALOG", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showInternalInputDialog(null, null,"We're here Cadet, here's a map of the house."
            	    + "\nIn every room there will be about 2-3 enemies, you have"
            	    + "\nto fight every single one of them, and it will get rather"
            	    + "\nhard. We will give you health kit[s] to use, but they"
            	    + "\nonly heal 25 HP, so be careful nonetheless." , JOptionPane.YES_OPTION, null, boss,door);
            //exit game if press closed option
            if ( ( answer != null ) && ( answer.length( ) >= 0) ) {
            } else {
                System.exit(0);
            }
            //story msg
        	JOptionPane.showMessageDialog(null,"He yell at you:\n -THIS IS MY SWAMP!!!" + "\n -What do you want from me?", "DIALOG", 
        																								JOptionPane.INFORMATION_MESSAGE);
        	JOptionPane.showMessageDialog(null,"After 3 days talking, you got drunk!", "AT LEAST YOU GOT DRUNK", JOptionPane.INFORMATION_MESSAGE);
        }
        //dragon
        else if (bossRandom ==1){
        	//msg with info
        	JOptionPane.showMessageDialog(null,boss[bossRandom] + " started to attack you.\n AND...", "", JOptionPane.INFORMATION_MESSAGE);
        	//generating variable for first attack (who is going first: enemy or player)
        	rand = $DZ.getRand(100);
        	//generating first attack (who is going first: enemy or player)
        	if (rand <50){
        		//msg with info
        		JOptionPane.showMessageDialog(null,"Your damage is " + damage + ".You have " + myHp + " hp.\n" + boss[bossRandom] + " have " 
						 + bossHp + " health." , "Fight", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,"You go first!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		//calculating health
        		while (myHp >0 & bossHp >0){
        			bossHp = bossHp - damage;
        			myHp = myHp - bossDamage;
        			// shows info about battle
        			JOptionPane.showMessageDialog(null,"My hp: " + myHp + "\nBoss health:" + bossHp, "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        			}
        	//generating first attack (who is going first: enemy or player)
        	}else{
        		//msg with info
        		JOptionPane.showMessageDialog(null,"Your damage is " + damage + ".You have " + myHp + " hp.\n" + boss[bossRandom] + " have " 
						 + bossHp + " health." , "Fight", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,"You go second!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		//calculating health
        		while (myHp >0 & bossHp >0){
    				myHp = myHp - bossDamage;	
    				bossHp = bossHp - damage;
    				// shows info about battle
        			JOptionPane.showMessageDialog(null,"My hp: " + myHp + "\nBoss health:" + bossHp, "FIGHT", JOptionPane.INFORMATION_MESSAGE);	
        		}
        	}
        	//checking health 
        	//if player win battle
        	if (myHp >0 & bossHp<=0){
        		JOptionPane.showMessageDialog(null,"You won the fight! You health: " + myHp, "FIGHT", JOptionPane.INFORMATION_MESSAGE);
            	JOptionPane.showMessageDialog(null,"YOU WON!!!" , "CONGRATZ", JOptionPane.INFORMATION_MESSAGE);
        	}
        	//if player lose battle
        	else if (myHp <=0 & bossHp>0){
        		JOptionPane.showMessageDialog(null,"You die...", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,"Game over!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);}
        	}else if (myHp<=0 & bossHp<=0) {
        		JOptionPane.showMessageDialog(null,"You die both...", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,"Game over!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        	}
        //big mice
        else if(bossRandom ==2) {
        	//msg with info
        	JOptionPane.showMessageDialog(null,boss[bossRandom] + " started to attack you.\n AND...", "", JOptionPane.INFORMATION_MESSAGE);
        	//generating variable for first attack (who is going first: enemy or player)
        	rand = $DZ.getRand(100);
        	//generating first attack (who is going first: enemy or player)
        	if (rand <50){
        		//msg with info
        		JOptionPane.showMessageDialog(null,"Your damage is " + damage + ".You have " + myHp + " hp.\n" + boss[bossRandom] + " have " 
						 + bossHp + " health." , "Fight", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,"You go first!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		//calculating health
        		while (myHp >0 & bossHp >0){
        			bossHp = bossHp - damage;
        			myHp = myHp - bossDamage;
        			// shows info about battle
        			JOptionPane.showMessageDialog(null,"My hp: " + myHp + "\nBoss health: " + bossHp, "FIGHT", JOptionPane.INFORMATION_MESSAGE);	
        		}
        	//generating first attack (who is going first: enemy or player)
        	}else{
        		//msg with info
        		JOptionPane.showMessageDialog(null,"Your damage is " + damage + ".You have " + myHp + " hp.\n" + boss[bossRandom] + " have " 
						 + bossHp + " health." , "Fight", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,"You go second!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		//calculating health
        		while (myHp >0 & bossHp >0){
    				myHp = myHp - bossDamage;	
    				bossHp = bossHp - damage;
    				// shows info about battle
        			JOptionPane.showMessageDialog(null,"My hp: " + myHp + "\nBoss health: " + bossHp, "FIGHT", JOptionPane.INFORMATION_MESSAGE);	
        		}
        	}
        	//checking health 
        	//if player win battle
        	if (myHp >0 & bossHp<=0){
        		JOptionPane.showMessageDialog(null,"You won the fight! You health: " + myHp, "FIGHT", JOptionPane.INFORMATION_MESSAGE);
            	JOptionPane.showMessageDialog(null,"YOU WON!!!" , "CONGRATZ", JOptionPane.INFORMATION_MESSAGE);
        	}
        	//if player lose battle
        	else if (myHp <=0 & bossHp>0){
        		JOptionPane.showMessageDialog(null,"You die...", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,"Game over!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else if (myHp<=0 & bossHp<=0){
        		JOptionPane.showMessageDialog(null,"You die both...", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        		JOptionPane.showMessageDialog(null,"Game over!", "FIGHT", JOptionPane.INFORMATION_MESSAGE);
        	}
        }
        //ask for new game
        repeat();

	}//end of method


}//end of class