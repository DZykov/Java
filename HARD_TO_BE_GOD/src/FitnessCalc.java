

public class FitnessCalc 
{

    static int[] solution = new int[32];
    
    // Set a candidate solution as a int array
    public static void setSolution(int[] newSolution) 
    {
        solution = newSolution;
    }

    //use this method to set our candidate solution
    static void setSolution(String newSolution) 
    {
        solution = new int[newSolution.length()];
        //loop through each character of our string and save it in our int array
        for (int i = 0; i < newSolution.length(); i++) 
        {
            String character = newSolution.substring(i, i + 1);
                solution[i] = Integer.parseInt(character);
        }
    }

    //calculate individuals fittness by comparing it to our candidate solution
    static int getFitness(Individual individual) 
    {
        int fitness = 0;
        //loop through our individuals genes and compare them to our candidates
        for (int i = 0; i < individual.size(); i++) 
        {	
        	//if solution is set, uncomment code below	
        	if (individual.getGene(i) == solution[i]){fitness+=100;}
             
        }
        return fitness;
    }
    
    // Get optimum fitness
    static int getMaxFitness() 
    {
    	//set it to a big number to run forever
        int maxFitness = 100000000;
        return maxFitness;
    }
}