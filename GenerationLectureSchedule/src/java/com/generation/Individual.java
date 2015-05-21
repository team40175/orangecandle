package java.com.generation;

import java.com.generationdata.LectureData;
import java.com.generationdata.LecturerData;
import java.com.generationdata.RoomData;
import java.com.generationdata.StudentData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Individual  {
	
	ArrayList<Gen> gen=new ArrayList<Gen>();
	int fitness=0;
	
	private static final Logger log = LoggerFactory.getLogger( Individual.class );
	
	public Individual(){
		log.info("Individual class");
		
		generateIndividual();
	}
	
	public void setGen(ArrayList<Gen> gen){
		this.gen=gen;
		this.fitness=calculateFitness();
	}
	
	//cromosome of Individual is created
	void generateIndividual(){
		log.info("evolve function in Individual class");
		
		//created static data from com.data
		creation();
		
		//random create gen class from data
		for(int i=0;i<GenerationClass.genUzunluðu;i++){
			Gen genetic=new Gen();
			
			gen.add(i,genetic);
		}
	}
	
	private void creation() {
		try{
			StudentData.created();
			log.info("StudentData.created in Individual class");
		
			LectureData.created();
			log.info("LectureData.created in Individual class");

			RoomData.created();
			log.info("RoomData.created in Individual class");
			
			LecturerData.created();
			log.info("LecturerData.created in Individual class");	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void mutation(){
		log.info("mutation function in Individual class");

		int numberDepartment=(int) (Math.random()*GenerationClass.MAX_DEPARTMENT);
		int numberClass=(int) (Math.random()*GenerationClass.CLASS);
		int numberDay=(int) (Math.random()*GenerationClass.DAY_NUMBER);
		int numberDay2=(int) (Math.random()*GenerationClass.DAY_NUMBER);
		
		  log.info("Created random numberDepartment: "+numberDepartment
				  +"\n\tnumberClass: "+numberClass
				  +"\n\tnumberDay: "+numberDay
				  +"\n\tnumberDay2: "+numberDay2);

		int calculateWhichOne=calculatedWhichNumber(numberDay, numberDepartment, numberClass);
		int calculateWhichTwo=calculatedWhichNumber(numberDay2, numberDepartment, numberClass);
		
		log.info("calculated location for mutation"
				  +"\n\tcalculateWhichOne: "+calculateWhichOne
				  +"\n\tcalculateWhichTwo: "+calculateWhichTwo);
		
		//change gen in a day between calculateWhichOne and calculateWhichTwo
		changeGenInADay(calculateWhichOne, calculateWhichTwo);
		
		log.info("After changeGenInADay function in Individual class");
		
	}
	
	//calculation after, which gen is change
	int calculatedWhichNumber(int numberDay,int numberDepartment,int numberClass){
		
		return GenerationClass.MAX_LECTURE_NUMBER_IN_A_DAY*numberDay+1
				+numberDepartment*GenerationClass.genUzunluðu/GenerationClass.MAX_DEPARTMENT
				+numberClass*GenerationClass.genUzunluðu/(GenerationClass.MAX_DEPARTMENT*GenerationClass.CLASS);
		
	}
	//change gen in a day between calculateWhichOne and calculateWhichTwo
	void changeGenInADay(int calculateWhichOne,int calculateWhichTwo){
		log.info("changeGenInADay function in Individual class");
		int largerOne=calculateWhichOne;
		int smallerOne=calculateWhichTwo;
		Individual one=this.clone();

		if(largerOne<calculateWhichTwo){
				largerOne=calculateWhichTwo;
				smallerOne=calculateWhichOne;
		}
		
		for(int i=0;i<GenerationClass.MAX_LECTURE_NUMBER_IN_A_DAY;i++){
			Gen gen=one.gen.get(largerOne+i);
			one.gen.add(largerOne+i,one.gen.get(smallerOne+i));
			one.gen.add(smallerOne+i,gen);
		}

	}
	
	//one point crossover between this and other individual instance
	ArrayList<Individual> crossover(Individual otherIndividual){
		log.info("crossover function in Individual class");

		int number=(int) (Math.random()*GenerationClass.genUzunluðu);
		Individual one=this.clone();
		Individual other=otherIndividual.clone();
		
		for(int i=number; i<GenerationClass.genUzunluðu;i++){
			Gen gen= one.gen.get(i);
			one.gen.add(i, other.gen.get(i));
			other.gen.add(i,gen);
		}
		
		return (ArrayList<Individual>) Arrays.asList(one,other);
	}
	
	@Override
	protected Individual clone() {
		log.info("clone function in Individual class");
		Individual nowInd=new Individual();
		Collections.copy(this.gen, nowInd.gen);
		return nowInd;
	}
	
	public void repair(){
		log.info("repair function in Individual class");
		//
	}
	
	int calculateFitness(){
		return Fitness.getFitness(this);
	}
}