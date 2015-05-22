package java.com.generation;

import java.com.generationdomain.Lecturer;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Fitness {
	private static final Logger log = Logger.getLogger( Individual.class.getName() );
	
	static ArrayList<Individual> certainLectureSchedule=new ArrayList <Individual>(); //%100 suitable lecture schedules
	static ArrayList<Individual> lessCompatibleLectureSchedule =new ArrayList<Individual>(); // less ones than %100

	public static int getFitness(Individual individual){
		int fitness=0;
		
		fitness=calculatedFitness(individual);
		
		if(fitness>85&&fitness<100)
			lessCompatibleLectureSchedule.add(individual);
		else if(fitness==100)
			certainLectureSchedule.add(individual);
		return fitness;			
	}
	
	private static int calculatedFitness(Individual individual) {
		for(int i=0;i<GenerationClass.genUzunluðu;i++){
			others(individual.gen.get(i));
		}
		return 0;	
	}

	//zorunlu durumlar
	public static int obligatoryState(){
		int fitness = 0;
		return fitness;			
	}
	private static int others(Gen gen){
		//zorunlu olmayanlar
		int fitness = 0;
		if(gen.lecturer.type==Lecturer.Type.PARTTIME){
			
		}else{
			
		}
		return fitness;	
	}

}
