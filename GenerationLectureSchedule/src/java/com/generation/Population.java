package java.com.generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

public class Population {
	
	private static final Logger log = Logger.getLogger( Individual.class.getName() );

	ArrayList <Individual> population=new ArrayList <Individual>();
	static ArrayList <Individual> elitPopulationPart;
	final static int MAX_JENERATION=Integer.MAX_VALUE;
	static int population_size=150;
	static float elitismRatio;
	static float mutationalRatio;
	static float crossoverRatio;
	static float elitismSize;
	static float mutationSize;
	static float crossoverSize;
	int tournamentSize=2;


	public Population(float elitsm, float mutation, float crossover){
		log.info("population class");
		
		Population.elitismRatio=elitsm;
		Population.crossoverRatio=crossover;
		Population.mutationalRatio=mutation;
		
		elitismSize=population_size*elitismRatio;
		mutationSize=population_size*mutationalRatio;
		crossoverSize=population_size*crossoverRatio;
	}
	
	public void setPopulationSize(int size){
		Population.population_size=size;
	}
	
	//created first jeneration of population
	void evolve(){
		log.info("evolve function in population class");

		for(int i=0;i<population_size;i++){
			Individual individual=new Individual();
			
			population.add(individual);
		}
	}
	
	void elitism(){
		log.info("elitism function in population class");
		
		elitPopulationPart=new ArrayList<Individual>();

		for(int i=0;i<elitismSize;i++){
			elitPopulationPart.add(i,population.get(i));
		}
	}
	
	void crossover(){
		log.info("crossover function in population class");
		
		int firstNumberForTournament=selectNumberForTournament();
		int secondNumberForTournament=selectNumberForTournament();
		
		ArrayList <Individual> newIndividuals=(ArrayList<Individual>) population.get(firstNumberForTournament)
			.crossover(population.get(secondNumberForTournament));
		
		log.info("end of crossover function in individual class");

		population.get(firstNumberForTournament).gen=newIndividuals.get(0).gen;
		population.get(secondNumberForTournament).gen=newIndividuals.get(1).gen;
		
		log.info("end of crossover function in population class");
	}
	
	int selectNumberForTournament(){
		int first=(int) (Math.random()*population_size);
		int temp =(int) (Math.random()*population_size);
		
		if(temp>first)  first=temp;
		
		return first;
	}
	
	void sortByFitness(){
		log.info("descending sortByFitness function in population class");
		//descending sort
		Collections.sort(population,new Comparator<Individual>(){
            public int compare(Individual s1,Individual s2){
				return s2.fitness-s1.fitness;
            }});
	}
}
