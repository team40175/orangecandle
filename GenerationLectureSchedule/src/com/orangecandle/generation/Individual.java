package com.orangecandle.generation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.orangecandle.generationdata.LectureData;
import com.orangecandle.generationdata.LecturerData;
import com.orangecandle.generationdata.RoomData;
import com.orangecandle.generationdata.StudentData;

public class Individual {
	private @Autowired Fitness fitness;
	private @Autowired GenerationConstants constants;
	private @Autowired LectureData lData;
	private @Autowired LecturerData lrData;
	private @Autowired StudentData sData;
	private @Autowired RoomData rData;
	ArrayList<Gene> gen = new ArrayList<Gene>();
	int fitnessValue = 0;

	private static final Logger log = LoggerFactory.getLogger(Individual.class);

	public Individual() {
		log.info("Individual class");

		generateIndividual();
	}

	public void setGen(ArrayList<Gene> gen) {
		this.gen = gen;
		this.fitnessValue = calculateFitness();
	}

	/** creation of chromosome of an individual */
	void generateIndividual() {
		log.info("evolve function in Individual class");

		generateAll();

		for (int i = 0; i < constants.geneLength(); i++) {
			Gene genetic = new Gene();
			gen.add(i, genetic);
		}
	}

	private void generateAll() {
		try {
			sData.generate();
			lData.generate();
			rData.generate();
			lrData.generate();
		} catch (Exception e) {
			log.error("generateAll could not generate all", e);
		}
	}

	public void mutate() {
		swapDays(constants.radiationValue(), constants.radiationValue());
	}

	void swapDays(int arg0, int arg1) {
		log.info("changeGenInADay function in Individual class");
		Individual one = this.clone();
		for (int i = 0; i < constants.getLectureCount(); i++) {
			Gene gen = one.gen.get(arg0 + i);
			one.gen.add(arg0 + i, one.gen.get(arg1 + i));
			one.gen.add(arg1 + i, gen);
		}
	}

	ArrayList<Individual> crossover(Individual otherIndividual) {
		log.info("crossover function in Individual class");

		int number = (int) (Math.random() * constants.geneLength());
		Individual one = this.clone();
		Individual other = otherIndividual.clone();

		for (int i = number; i < constants.geneLength(); i++) {
			Gene gen = one.gen.get(i);
			one.gen.add(i, other.gen.get(i));
			other.gen.add(i, gen);
		}

		return (ArrayList<Individual>) Arrays.asList(one, other);
	}

	@Override
	protected Individual clone() {
		Individual nowInd = new Individual();
		Collections.copy(this.gen, nowInd.gen);
		return nowInd;
	}

	public void repair() {
		//
	}

	int calculateFitness() {
		return fitness.getFitness(this);
	}
}