import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Environment extends JPanel implements ActionListener 
{

	//set variables
	private static final long serialVersionUID = 1L;
	public JFrame jFrame;
	public final int SCALE = 20; //scale
	public static final int POPULATION = 50; //population
	public static final int WIDTH = 60; //width
	public static final int HEIGHT = 40; //height
	public final static int SPEED = 10;//speed
	public final static int HEALTH_APPLE = 10; //health per food
	public final static int HEALTH_POISON = -10; //health per poison
	public final static int POINTS_APPLE = 10; //points of fitness per food
	public final static int POINTS_POISON = -10; //points of fitness per poison
	public static int DIED = 0; //population of died individuals
	public static int AMOUNT_APPLE = 60; //set to 60
	public static int AMOUNT_POISON = 60; //set to 60
	public static int COUNT_APPLE = 0; //counting food
	public static int COUNT_POISON = 0; //counting poison
	public static int GENERATION = 1; //counting generation
	public static int COUNTS = 0; // counts per (timer)loop
	public static int TIME_GEN = 0; // time in seconds for generation
	public static int TIME = 0; // time of running in seconds 
	public static int run = 1; //for first run
	public static int gene_number = 0; 
	
	//n position in a second
	Timer timer = new Timer(1000/SPEED, this);
	
	// Create an initial population
    Population myPop = new Population(POPULATION, true);
    
	//objects
	public static Poison[] poison = new Poison[AMOUNT_POISON];
	public static Apples[] apple = new Apples[AMOUNT_APPLE];
	
	public static int heightV = (int)(Math.random()*HEIGHT);
	public static int widthV = (int)(Math.random()*WIDTH);
	public static int lengthV = (int)(Math.random()*heightV+3);
	public static VerticalWall wallV = new VerticalWall (widthV, heightV, lengthV);
	
	public static int heightH = (int)(Math.random()*HEIGHT);
	public static int widthH = (int)(Math.random()*WIDTH);
	public static int lengthH = (int)(Math.random()*widthH+3);
	public static HorizontalWall wallH = new HorizontalWall (widthH, heightH, lengthH);
		
	public Environment()
	{
		//setting solution to null, so GA can run forever
		FitnessCalc.setSolution("66666666666666666666666666666666");
		
		setFocusable(true);
		
		//create a window
		jFrame = new JFrame("Environment");
		//set settings for window
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setSize(WIDTH*SCALE+8,HEIGHT*SCALE+42);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		jFrame.add(this);
		
		//start timer
		timer.start();
		
		//set apples
		for(int a=0; a<AMOUNT_APPLE;a++)
		{
			apple[a] = new Apples ((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
		}
		//set apples
		for(int a=0; a<AMOUNT_POISON;a++)
		{
			poison[a] = new Poison ((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
		}
	}

	public void paint (Graphics g)
	{
		//colour background to blue
		g.setColor(color(85, 85, 255));
		g.fillRect(0, 0, WIDTH*SCALE,HEIGHT*SCALE);
		
		//draw indoviduals and their health
		for(int a=0; a<POPULATION;a++)
		{
			String hp = Integer.toString(Population.individuals[a].health);
			g.setColor(color(255, 215, 0));
			g.fillRect(Population.individuals[a].xPos*SCALE, Population.individuals[a].yPos*SCALE, SCALE, SCALE);
			g.setColor(color(0, 0, 0));
			g.drawString(hp, Population.individuals[a].xPos*SCALE+2, Population.individuals[a].yPos*SCALE+14);
			//check is individual is alive or not
			if(Population.individuals[a].alive==false)
			{
				//set colour of individual to blue
				g.setColor(color(85, 85, 255));
				g.fillRect(Population.individuals[a].xPos*SCALE, Population.individuals[a].yPos*SCALE, SCALE, SCALE);
				g.setColor(color(255, 215, 0));
			}
		}
				
		
		//draw lines vertical | 
		g.setColor(color(255, 215, 0));
		for(int xx =  0; xx<=WIDTH*SCALE; xx+=SCALE)
		{
			g.drawLine(xx, 0, xx, WIDTH*SCALE);
		}	
		//draw lines horizontal - 
		for(int yy =  0; yy<=HEIGHT*SCALE; yy+=SCALE)
		{
			g.drawLine(0, yy, WIDTH*SCALE, yy);
		}
		
		//draw wall vertical
		g.setColor(color(169, 169, 169));
		g.fillRect(wallV.posX*SCALE+1, wallV.posY*SCALE+1, SCALE-1, SCALE-1);

		for(int i = 0; i<=wallV.endY; i++)
		{
			g.fillRect(wallV.posX*SCALE+1, (wallV.posY-i)*SCALE+1, SCALE-1, SCALE-1);
			
		}
		
		//draw wall horizontal
		g.setColor(color(169, 169, 169));
		g.fillRect(wallH.posX*SCALE+1, wallH.posY*SCALE+1, SCALE-1, SCALE-1);

		for(int i = 0; i<=wallH.endX; i++)
		{
			g.fillRect((wallH.posX-i)*SCALE+1, wallH.posY*SCALE+1, SCALE-1, SCALE-1);
			
		}

		//draw apples
		for(int a=0; a<AMOUNT_APPLE;a++)
		{
			g.setColor(color(255, 0, 0));
			g.fillRect(apple[a].xPos*SCALE, apple[a].yPos*SCALE, SCALE, SCALE);
		}
		//draw poison
		for(int a=0; a<AMOUNT_POISON;a++)
		{
			g.setColor(color(0, 255, 0));
			g.fillRect(poison[a].xPos*SCALE, poison[a].yPos*SCALE, SCALE, SCALE);
		}
	}
	
	//get color
	public Color color(int r, int g, int b)
	{
		return new Color(r, g, b);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		COUNTS++;
		TIME_GEN = COUNTS/SPEED; // getting seconds
		//System.out.println(DIED);
		//if everyone is died
		if(POPULATION<=DIED || DIED == POPULATION-5)
		{
			//create txt file
			File file = new File("Individual Info.txt");
			//if file doesn't exists, create it
			if(!file.exists())
			{
				try {file.createNewFile();} 
				catch (IOException UHM) 
				{UHM.printStackTrace();}
			}
			//true = append file
		    try 
		    {
		    	//write information to txt
	    		FileWriter fileWritter = new FileWriter(file.getName(),true);
	    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	    	    bufferWritter.newLine();
	    	    bufferWritter.write("Generation: "+GENERATION);
	    	    bufferWritter.newLine();
				bufferWritter.write("Generation time: "+TIME_GEN);
				bufferWritter.newLine();
			    for (int in=0;in<POPULATION; in++)
				{
			    	bufferWritter.newLine();
			    	bufferWritter.append("Individual: "+in+" Gene: "+Population.getIndividual(in)+" Fitness: "+
			    			Population.getIndividual(in).getFitness()+" Apples: "+Population.individuals[in].apple_COUNT
			    			+" Poison: "+Population.individuals[in].poison_COUNT);
				}
				bufferWritter.newLine();
				bufferWritter.close();
			} 
		    catch (IOException WOW){WOW.printStackTrace();}
			
			//printing information
			/*
			System.out.println("Generation: "+GENERATION);
			for (int in=0;in<POPULATION; in++)
			{
				System.out.println("Individual: "+in+" Gene: "+Population.getIndividual(in)+" Fitness: "+Population.getIndividual(in).getFitness());
			}
			*/
			//System.out.println(GENERATION);
		    //create new population (KIDOS)
			myPop = Algorithm.evolvePopulation(myPop);
			//create apples
			for(int a=0; a<AMOUNT_APPLE;a++)
			{
				apple[a] = new Apples ((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
			}
			//create apples
			for(int a=0; a<AMOUNT_POISON;a++)
			{
				poison[a] = new Poison ((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
			}
			//create horizontal wall
			heightH = (int)(Math.random()*HEIGHT);
			widthH = (int)(Math.random()*WIDTH);
			lengthH = (int)(Math.random()*widthH+3);
			wallH = new HorizontalWall(widthH, heightH, lengthH);
			//create vertical wall
			heightV = (int)(Math.random()*HEIGHT);
			widthV = (int)(Math.random()*WIDTH);
			lengthV = (int)(Math.random()*heightV+3);
			wallV = new VerticalWall (widthV, heightV, lengthV);
			//restarting variables
			gene_number = 0;
			COUNT_POISON = 0;
			COUNT_APPLE = 0;
			GENERATION++;
			TIME = TIME + TIME_GEN;
			TIME_GEN = 0;
			COUNTS = 0;
			DIED = 0;
		}
		
		//action for individuals
		for(int a=0; a<POPULATION;a++)
		{
			//controlling chromosome
			if (gene_number<32){gene_number++;}
			//i am not using else statement, because java jumps over it sometimes
			//that happens because of the timer
			if (gene_number==32){gene_number = 0;}
			
			//System.out.println("Individual: "+a+" Chromosome: "+Population.individuals[a].getGene(chromosome_number));
			//checking if individual is died or not
			if(Population.individuals[a].alive)
			{
				//if individual is alive do a command
				Population.individuals[a].direction = Population.individuals[a].getGene(gene_number);
				Population.individuals[a].move();
			//if individual is died, don't do anything
			}else{Population.individuals[a].direction=9999;}

			//collide Vertical wall
			for(int i = 0; i<=wallV.endY; i++)
			{
				if(Population.individuals[a].xPos ==wallV.posX && Population.individuals[a].yPos == wallV.posY-i)
				{
					Population.individuals[a].xPos=Population.individuals[a].xPosPrev;
					Population.individuals[a].yPos=Population.individuals[a].yPosPrev;
				}
			}
			//collide Horizontal wall
			for(int i = 0; i<=wallH.endX; i++)
			{
				if(Population.individuals[a].xPos ==wallH.posX-i && Population.individuals[a].yPos == wallH.posY)
				{
					Population.individuals[a].xPos=Population.individuals[a].xPosPrev;
					Population.individuals[a].yPos=Population.individuals[a].yPosPrev;
				}				
			}

			//apple actions
			for(int b=0; b<	AMOUNT_APPLE;b++)
			{
				//actions for individuals
				if(Population.individuals[a].xPos==apple[b].xPos && Population.individuals[a].yPos==apple[b].yPos)
				{
					Population.individuals[a].health+=HEALTH_APPLE;
					apple[b] = new Apples ((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
					COUNT_APPLE++;
					Population.individuals[a].apple_COUNT++;
				}

				//actions for Vertical wall
				for(int i = 0; i<=wallV.endY; i++)
				{
					//if apples appears on a wall, set another position for apple
					if(apple[b].xPos ==wallV.posX && apple[b].yPos == wallV.posY-i)
					{
						apple[b] = new Apples ((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
					}
				}

				//action for Horizontal wall
				for(int i = 0; i<=wallH.endX; i++)
				{
					//if apples appears on a wall, set another position for apple
					if(apple[b].xPos ==wallH.posX-i && apple[b].yPos == wallH.posY)
					{
						apple[b] = new Apples ((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
					}				
				}

			}
			//poison action
			for(int b=0; b<  AMOUNT_POISON;b++)
			{
				//actions for individuals
				if(Population.individuals[a].xPos==poison[b].xPos && Population.individuals[a].yPos==poison[b].yPos)
				{
					Population.individuals[a].health+=HEALTH_POISON;
					poison[b] = new Poison ((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
					COUNT_POISON++;
					Population.individuals[a].poison_COUNT++;
				}

				//actions for Vertical wall
				for(int i = 0; i<=wallV.endY; i++)
				{
					//if poison appears on a wall, set another position for poison
					if(poison[b].xPos ==wallV.posX && poison[b].yPos == wallV.posY-i)
					{
						poison[b] = new Poison ((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
					}
				}

				//action for Horizontal wall
				for(int i = 0; i<=wallH.endX; i++)
				{
					//if poison appears on a wall, set another position for poison
					if(poison[b].xPos ==wallH.posX-i && poison[b].yPos == wallH.posY)
					{
						poison[b] = new Poison ((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
					}				
				}
			}
		}
			
		//generate a window with information
		//i know, that this is really bad crunch
		if(run==1){new information().setVisible(true);run--;}
		repaint();
	}

	public long getSerialVersionUID() 
	{
		return serialVersionUID;
	}

	
}
