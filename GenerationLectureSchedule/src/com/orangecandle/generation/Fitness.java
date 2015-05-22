package com.orangecandle.generation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fitness {
	private @Autowired GenerationConstants constants;
	ArrayList<Individual> certainSchedule = new ArrayList<Individual>();
	ArrayList<Individual> uncertainSchedule = new ArrayList<Individual>();

	public int getFitness(Individual individual) {
		int fitness = 0;
		fitness = calculatedFitness(individual);
		if (85 < fitness && fitness < 100)
			uncertainSchedule.add(individual);
		else if (fitness == 100)
			certainSchedule.add(individual);
		return fitness;
	}

	private int calculatedFitness(Individual individual) {
		for (int i = 0; i < constants.geneLength(); i++) {
			nonForcedState(individual.genePool.get(i));
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
