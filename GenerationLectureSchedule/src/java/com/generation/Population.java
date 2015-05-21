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
	
	static float elitismRatio;
	static float mutationalRatio;
	static float crossoverRatio;
	
	static float elitismSize;
	static float mutationSize;
	static float crossoverSize;
	static int population_size=150;

	public Population(float elitsm, float mutation, float crossover){
		log.info("population class without population size");
		
		initializing(elitsm,  mutation,  crossover);
		
		calculation();
		
		//otomation();
		
	}
	
	public Population(float elitsm, float mutation, float crossover,int population_size){
		log.info("population class with population size");

		Population.population_size=population_size;	
		
		initializing(elitsm,  mutation,  crossover);
		
		calculation();
		
		//otomation();
	}
	
	//description ratio in popuation
	void initializing(float elitsm, float mutation, float crossover){
		log.info("initializing population class");

		Population.elitismRatio=elitsm;
		Population.crossoverRatio=crossover;
		Population.mutationalRatio=mutation;
		
	}
	
	//calculation size according to the ratios
	void calculation(){
		log.info("calculating some sizes in population class");

		elitismSize=population_size*elitismRatio;
		mutationSize=population_size*mutationalRatio;
		crossoverSize=population_size*crossoverRatio;
	}
	
	void otomation(){
		log.info("otomating to run genetic algoritm for population class");

		evolve();
		log.info("after create individuals in population");

		for(int i=0;i<MAX_JENERATION;i++){
			log.info("jeneration");

			//fitness();
			log.info("after runnning fitness function");
			
			sortByFitness();
			log.info("after runnning sortByFitness function");
			
			elitism();
			log.info("after running elitism function");

			crossover();
			log.info("after running crossover function");

			mutation();
			log.info("after running mutation function");

			//repair();
			log.info("after running repair function");

		}
	}

	//created first jeneration of population and sorting according to fitness
	void evolve(){
		log.info("evolve function in population class");

		for(int i=0;i<population_size;i++){
			Individual individual=new Individual();
			
			population.add(individual);
		}
		sortByFitness();
	}
	//elitism
	void elitism(){
		log.info("elitism function in population class");
		
		elitPopulationPart=new ArrayList<Individual>();

		for(int i=0;i<elitismSize;i++){
			elitPopulationPart.add(i,population.get(i));
		}
	}
	
	//tournament selection between individuals is used for crossover 
	void crossover(){
		log.info("crossover function in population class");
		
		for(int i=0;i<crossoverSize;i++){
			
			int firstNumberForTournament=selectNumberForTournament();
			int secondNumberForTournament=selectNumberForTournament();
			
			ArrayList <Individual> newIndividuals=(ArrayList<Individual>) population.get(firstNumberForTournament)
				.crossover(population.get(secondNumberForTournament));
			
			log.info("end of crossover function in individual class");

			population.get(firstNumberForTournament).gen=newIndividuals.get(0).gen;
			population.get(secondNumberForTournament).gen=newIndividuals.get(1).gen;	
		}
	
		log.info("end of crossover function in population class");
	}
	//mutation but random size 
	void mutation(){
		log.info("mutation function in population class");

		int random;
		int mutantSize=(int) (Math.random()*mutationSize);
		
		for(int i=0;i<mutantSize;i++ ){
			random=(int) (Math.random()*population_size);
			
			population.get(random).mutation();
		}
		
	}
	
	//Random Tournament for genetic algorithm
	int selectNumberForTournament(){
		log.info("start selectNumberForTournament");

		int first=(int) (Math.random()*(population_size-elitismSize)+elitismSize);
		int temp =(int) (Math.random()*(population_size-elitismSize)+elitismSize);
		
		if(temp<first)  first=temp;
		
		log.info("winner : "+first+". individual in population");

		return first;
	}
	
	//after generation or creation, sorting by descending fitness value
	void sortByFitness(){
		log.info("descending sortByFitness function in population class");
		
		//descending sort
		Collections.sort(population,new Comparator<Individual>(){
            public int compare(Individual s1,Individual s2){
				return s2.fitness-s1.fitness;
            }});
		
	}
}
