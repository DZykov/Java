

public class Individual {

	Environment main;
	
    static int defaultGeneLength = 32;
    private int[] genes = new int[defaultGeneLength];
    
	public int direction = 1;
	public int health = 100;
	public int xPos;
	public int yPos;
	public int xPosPrev;
	public int yPosPrev;
	public int apple_COUNT = 0;
	public int poison_COUNT= 0;
	public boolean food = false;
	public boolean poison = false;
	public boolean wall = false;
	public static final int STEP = 20;
	public boolean alive = true;
    // Cache
    private int fitness = 0;

    public Individual(int x, int y) 
    {
    	xPos = x;
		yPos = y;
	}

	// Create a random individual
    public void generateIndividual() 
    {
        for (int i = 0; i < size(); i++) 
        {
        	//multiple on the amount of commands
            int gene = (int)(Math.random()*7);
            //System.out.println(gene);
            genes[i] = gene;
        }
    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) 
    {
        defaultGeneLength = length;
    }
    
    public int getGene(int index)
    {
        return genes[index];
    }

    public void setGene(int index, int value)
    {
        genes[index] = value;
        fitness = 0;
    }

    /* Public methods */
    public int size()
    {
        return genes.length;
    }

    public int getFitness() 
    {
        if (fitness == 0)
        {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() 
    {
        String geneString = "";
        for (int i = 0; i < size(); i++) 
        {
            geneString += getGene(i);
        }
        return geneString;
    }
    
    public void move()
	{
    	/*
    	if(direction>4 || direction<0)
    	{
    		direction = 0;
    	}
    	*/
    	
    	/*
    	if(genes[]==0)
    	{
    		direction++;
    	}
    	
    	if(genes[]==1)
    	{
    		direction--;
    	}
    	*/
    	
		xPosPrev =  xPos;
		yPosPrev =  yPos;
		
		//apples
		for(int b=0; b<	Environment.AMOUNT_APPLE;b++)
		{
			if (xPos == Environment.apple[b].xPos && yPos == Environment.apple[b].yPos) 
				{
				fitness=+10;
				}
		}
		
		//poison actions
		for(int b=0; b<	Environment.AMOUNT_POISON;b++)
		{
			if (xPos == Environment.poison[b].xPos && yPos == Environment.poison[b].yPos) 
				{
				fitness=-10;
				}
		}
		
		if(this.health<1 && this.alive==true)
		{
			direction=9999;
			this.alive=false;
			this.fitness += Environment.TIME_GEN*40; //getting fitness for seconds
			Environment.DIED++;
		}
		//move
		//top
		if(direction==0)
		{
			yPos--;
			health--;
		}
		//right
		if(direction==1){xPos++;health--;}
		//down
		if(direction==2){yPos++;health--;}
		//left
		if(direction==3){xPos--;health--;}
		//collide
		//edges of the field (blocking) X-axis
		if(xPos>Environment.WIDTH-1){xPos--;}
		if(xPos<0){xPos++;}
		//edges of the field (blocking) Y-axis
		if(yPos>Environment.HEIGHT-1){yPos--;}
		if(yPos<0){yPos++;}
		//look
		//top
		if(direction==4)
		{
			for(int i=0; i<Environment.AMOUNT_APPLE;i++)
			{
				if(yPos-1==Environment.apple[i].yPos && xPos==Environment.apple[i].xPos){fitness+=30;food=true;};
				if(yPos-2==Environment.apple[i].yPos && xPos==Environment.apple[i].xPos){fitness+=20;food=true;};
				if(yPos-3==Environment.apple[i].yPos && xPos==Environment.apple[i].xPos){fitness+=10;food=true;};
			}
			//wrath
			for(int i=0; i<Environment.AMOUNT_POISON;i++)
			{
				if(yPos-1==Environment.poison[i].yPos  && xPos==Environment.poison[i].xPos){fitness-=30;poison=true;};
				if(yPos-2==Environment.poison[i].yPos  && xPos==Environment.poison[i].xPos){fitness-=20;poison=true;};
				if(yPos-3==Environment.poison[i].yPos  && xPos==Environment.poison[i].xPos){fitness-=10;poison=true;};
			}
		}
		//right
		if(direction==5)
		{
			//apples
			for(int i=0; i<Environment.AMOUNT_APPLE;i++)
			{
				if(xPos+1==Environment.apple[i].xPos && yPos==Environment.apple[i].yPos){fitness+=30;food=true;};
				if(xPos+2==Environment.apple[i].xPos && yPos==Environment.apple[i].yPos){fitness+=20;food=true;};
				if(xPos+3==Environment.apple[i].xPos && yPos==Environment.apple[i].yPos){fitness+=10;food=true;};
			}
			//wrath
			for(int i=0; i<Environment.AMOUNT_POISON;i++)
			{
				if(xPos+1==Environment.poison[i].xPos && yPos==Environment.poison[i].yPos){fitness-=30;poison=true;};
				if(xPos+2==Environment.poison[i].xPos && yPos==Environment.poison[i].yPos){fitness-=20;poison=true;};
				if(xPos+3==Environment.poison[i].xPos && yPos==Environment.poison[i].yPos){fitness-=10;poison=true;};
			}
		}
		//down
		if(direction==6)
		{
			//apples
			for(int i=0; i<Environment.AMOUNT_APPLE;i++)
			{
				if(xPos==Environment.apple[i].xPos && yPos+1==Environment.apple[i].yPos){fitness+=30;food=true;};
				if(xPos==Environment.apple[i].xPos && yPos+2==Environment.apple[i].yPos){fitness+=20;food=true;};
				if(xPos==Environment.apple[i].xPos && yPos+3==Environment.apple[i].yPos){fitness+=10;food=true;};
			}
			//wrath
			for(int i=0; i<Environment.AMOUNT_POISON;i++)
			{
				if(xPos==Environment.poison[i].xPos && yPos+1==Environment.poison[i].yPos){fitness-=30;poison=true;};
				if(xPos==Environment.poison[i].xPos && yPos+2==Environment.poison[i].yPos){fitness-=20;poison=true;};
				if(xPos==Environment.poison[i].xPos && yPos+3==Environment.poison[i].yPos){fitness-=10;poison=true;};
			}
		}
		//left
		if(direction==7)
		{
			//apples
			for(int i=0; i<Environment.AMOUNT_APPLE;i++)
			{
				if(xPos-1==Environment.apple[i].xPos && yPos==Environment.apple[i].yPos){fitness+=30;food=true;};
				if(xPos-2==Environment.apple[i].xPos && yPos==Environment.apple[i].yPos){fitness+=20;food=true;};
				if(xPos-3==Environment.apple[i].xPos && yPos==Environment.apple[i].yPos){fitness+=10;food=true;};
			}
			//wrath
			for(int i=0; i<Environment.AMOUNT_POISON;i++)
			{
				if(xPos-1==Environment.poison[i].xPos && yPos==Environment.poison[i].yPos){fitness-=30;poison=true;};
				if(xPos-2==Environment.poison[i].xPos && yPos==Environment.poison[i].yPos){fitness-=20;poison=true;};
				if(xPos-3==Environment.poison[i].xPos && yPos==Environment.poison[i].yPos){fitness-=10;poison=true;};
			}
		}
		//set to standard
		poison=false;
		food=false;

	}//end move

    
}