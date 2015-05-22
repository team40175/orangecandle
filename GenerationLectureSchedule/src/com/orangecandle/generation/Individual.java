package com.orangecandle.generation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
	ArrayList<Gene> genePool = new ArrayList<Gene>();
	int fitnessValue = 0;

	private static final Logger log = LoggerFactory.getLogger(Individual.class);

	public Individual() {
		sData.generate();
		lData.generate();
		rData.generate();
		lrData.generate();
		for (int i = 0; i < constants.geneLength(); i++) {
			Gene genetic = new Gene();
			genePool.add(i, genetic);
		}
	}

	public void replaceGenepool(ArrayList<Gene> genes) {
		this.genePool = genes;
		this.fitnessValue = calculateFitness();
	}

	public void mutate() {
		swapDays(constants.radiationValue(), constants.radiationValue());
	}

	void swapDays(int day0, int day1) {
		Individual one = this.clone();
		for (int i = 0; i < constants.getLectureCount(); i++) {
			Gene gen = one.genePool.get(day0 + i);
			one.genePool.add(day0 + i, one.genePool.get(day1 + i));
			one.genePool.add(day1 + i, gen);
		}
	}

	List<Individual> crossover(Individual partner) {
		log.info("crossover function in Individual class");
		int number = (int) (Math.random() * constants.geneLength());
		Individual one = this.clone();
		Individual other = partner.clone();
		for (int i = number; i < constants.geneLength(); i++) {
			Gene gen = one.genePool.get(i);
			one.inject(other.genePool.get(i));
			other.inject(gen);
		}
		return Arrays.asList(one, other);
	}

	@Override
	protected Individual clone() {
		Individual clone = new Individual();
		Collections.copy(this.genePool, clone.genePool);
		return clone;
	}

	public void repair() {
	}

	int calculateFitness() {
		return fitness.getFitness(this);
	}

	public void inject(Gene gene) {
		genePool.add(gene);
	}

	public Gene extract(int i) {
		return genePool.get(i);
	}
}