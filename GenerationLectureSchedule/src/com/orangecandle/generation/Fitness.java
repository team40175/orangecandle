package com.orangecandle.generation;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fitness {
	private static final Logger log = Logger.getLogger(Individual.class
			.getName());
	private @Autowired GenerationConstants constants;
	ArrayList<Individual> certainLectureSchedule = new ArrayList<Individual>();
	ArrayList<Individual> lessCompatibleLectureSchedule = new ArrayList<Individual>();

	public int getFitness(Individual individual) {
		int fitness = 0;

		fitness = calculatedFitness(individual);

		if (fitness > 85 && fitness < 100)
			lessCompatibleLectureSchedule.add(individual);
		else if (fitness == 100)
			certainLectureSchedule.add(individual);
		return fitness;
	}

	private int calculatedFitness(Individual individual) {
		for (int i = 0; i < constants.geneLength(); i++) {
			nonForcedState(individual.gen.get(i));
		}
		return 0;
	}

	public boolean forcedState() {
		boolean fitness = false;
		return fitness;
	}

	private int nonForcedState(Gene gen) {
		int fitness = 0;
		if (gen.lecturer.isPartTime()) {

		} else {

		}
		return fitness;
	}

}
