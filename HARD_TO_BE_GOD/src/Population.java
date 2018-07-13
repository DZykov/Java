
public class Population 
{

	static Individual[] individuals = new Individual[Environment.POPULATION];
	
	 // Create a population
	 public Population(int populationSize, boolean initialise)
	 {
	     //initialize population
		 if (initialise) 
	     {
			 //create individuals
	         for (int i = 0; i < size(); i++) 
	         {
	        	 Individual newIndividual = new Individual((int)(Math.random()*Environment.WIDTH), (int)(Math.random()*Environment.HEIGHT));
	             newIndividual.generateIndividual();
	             saveIndividual(i, newIndividual);
	         }
	     }
	 }

	 //static!
	 public static Individual getIndividual(int index) 
	 {
		 return individuals[index];
	 }
	 
	 public Individual getFittest() 
	 {
		 Individual fittest = individuals[0];
	     //find fittest
	     for (int i = 0; i < size(); i++) 
	     {
	    	 if (fittest.getFitness() <= getIndividual(i).getFitness()) 
	         {
	    		 fittest = getIndividual(i);
	         }
	     }
	     return fittest;
	 }
	 
	 //get population size
	 public int size() 
	 {
		 return individuals.length;
	 }

	 //save individual
	 public void saveIndividual(int index, Individual indiv) 
	 {
		 individuals[index] = indiv;
	 }
}
	
