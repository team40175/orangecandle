package java.com.generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

public class Population {
	
	private static final Logger log = Logger.getLogger( Individual.class.getName() );

	ArrayList <Individual> population=new ArrayList <Individual>();
	ArrayList <Individual> newJeneration=new ArrayList <Individual>();
	
	final static int MAX_JENERATION=Integer.MAX_VALUE;
	
	static float elitismRatio;
	static float mutationalRatio;
	static float crossoverRatio;
	
	static float elitismSize;
	static float mutationSize;
	static float crossoverSize;
	static int population_size=150;

	public Population(float elitsm, float mutation, float crossover,boolean isOtomation){
		log.info("population class without population size");
		
		initializing(elitsm,  mutation,  crossover);
		
		calculation();
		
		if(isOtomation)
			otomation();
	}
	
	public Population(float elitsm, float mutation, float crossover,int population_size,boolean isOtomation){
		log.info("population class with population size");

		Population.population_size=population_size;	
		
		initializing(elitsm,  mutation,  crossover);
		
		calculation();
		
		if(isOtomation)
			otomation();
	}
	
	//description ratio in popuation
	private void initializing(float elitsm, float mutation, float crossover){
		log.info("initializing population class");

		Population.elitismRatio=elitsm;
		Population.crossoverRatio=crossover;
		Population.mutationalRatio=mutation;
		
	}
	
	//calculation size according to the ratios
	private void calculation(){
		log.info("calculating some sizes in population class");

		elitismSize=population_size*elitismRatio;
		mutationSize=population_size*mutationalRatio;
		crossoverSize=population_size*crossoverRatio;
	}
	
	private void otomation(){
		log.info("otomating to run genetic algoritm for population class");

		generateIndividual();
		log.info("after create individuals in population");

		for(int i=0;i<MAX_JENERATION;i++){
			log.info("jeneration");

			fitness();
			log.info("after runnning fitness function");
			
			sortByFitness();
			log.info("after runnning sortByFitness function");
			
			elitism();
			log.info("after running elitism function");

			crossover();
			log.info("after running crossover function");

			mutation();
			log.info("after running mutation function");

//			if(!isSuitable()) 
//				repair();
//			log.info("after running repair function");
			
			Collections.copy(population,newJeneration);

		}
	}

	private boolean isSuitable() {
		//
		return false;
	}

	public void repair() {
		//
	}

	public void fitness() {
		for(int i=0;i<population_size;i++){
			population.get(i).fitness=population.get(i).calculateFitness();
		}
	}

	//created first jeneration of population and sorting according to fitness
	public void generateIndividual(){
		log.info("evolve function in population class");

		for(int i=0;i<population_size;i++){
			Individual individual=new Individual();
			
			population.add(individual);
		}
	}
	
	//elit population
	public void elitism(){
		log.info("elitism function in population class");
		
		//all population copy new jeneration
		//So, after crossover and elitism, new jeneration size is equal to population
		//and non-crossovered individuals are moved new jeneration
		Collections.copy(newJeneration,population);

		for(int i=0;i<elitismSize;i++){
			newJeneration.add(i,population.get(i));
		}
	}
	
	//tournament selection between individuals is used for crossover 
	void crossover(){
		log.info("crossover function in population class");
		
		int firstNumberForTournament;
		int secondNumberForTournament;
		ArrayList <Individual> newIndividuals;
		
		for(int i=0;i<crossoverSize;i++){
			
			firstNumberForTournament=selectNumberForTournament();
			secondNumberForTournament=selectNumberForTournament();
			
			newIndividuals= new ArrayList <Individual>();
			
			Collections.copy(newIndividuals,
					population.get(firstNumberForTournament)
														.crossover(population.get(secondNumberForTournament)));
			
			log.info("end of crossover function in individual class");

			newJeneration.get(firstNumberForTournament).setGen(newIndividuals.get(0).gen);
			newJeneration.get(secondNumberForTournament).setGen(newIndividuals.get(1).gen);	
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
			
			newJeneration.get(random).mutation();
		}		
	}
	
	//Random Tournament for genetic algorithm
	//individual that has larger fitness value is selected for Random Tournament
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
