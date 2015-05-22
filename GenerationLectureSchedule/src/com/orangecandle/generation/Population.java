package com.orangecandle.generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {

	ArrayList<Individual> currentGen = new ArrayList<Individual>();
	ArrayList<Individual> newGen = new ArrayList<Individual>();

	int MAX_GEN = Integer.MAX_VALUE;
	private float elitism;
	private int population = 150;
	private float crossover;
	private float mutation;

	public Population(float elitism, float mutation, float crossover) {
		// mutation should be between %1 and %.1
		this.elitism = elitism;
		this.crossover = 1 - this.elitism;
		this.mutation = mutation;
		generate();
	}

	public Population(float elitsm, float mutation, float crossover,
			int population_size) {
		this(elitsm, mutation, crossover);
		this.population = population_size;
	}

	private void generate() {
		for (int i = 0; i < population; i++) {
			Individual individual = new Individual();
			currentGen.add(individual);
		}
		for (int i = 0; i < MAX_GEN; i++) {
			for (Individual in : currentGen) {
				in.fitnessValue = in.calculateFitness();
			}
			Collections.sort(currentGen, (p0, p1) -> p1.fitnessValue
					- p0.fitnessValue);
			naturalSelection();
			crossover();
			mutation();
			if (!isSuitable())
				repair();
			Collections.copy(currentGen, newGen);
			if (isSuitable())
				break;
		}
	}

	private boolean isSuitable() {
		return false;
	}

	public void repair() {
	}

	public void naturalSelection() {
		Collections.copy(newGen, currentGen);
		for (int i = 0; i < population * elitism; i++) {
			newGen.add(currentGen.get(i));
		}
	}

	void crossover() {
		List<Individual> crossed;
		for (int i = 0; i < population * crossover; i++) {
			int k1 = elitistRandom();
			int k2 = elitistRandom();
			crossed = currentGen.get(k1).crossover(currentGen.get(k2));
			newGen.get(k1).replaceGenepool(crossed.get(0).genePool);
			newGen.get(k2).replaceGenepool(crossed.get(1).genePool);
		}
	}

	void mutation() {
		int random;
		int mutantSize = (int) (Math.random() * population * mutation);
		for (int i = 0; i < mutantSize; i++) {
			random = (int) (Math.random() * population);
			newGen.get(random).mutate();
		}
	}

	int elitistRandom() {
		int rand0 = (int) (population * (Math.random() * crossover + elitism));
		int rand1 = (int) (population * (Math.random() * crossover + elitism));
		return rand0 > rand1 ? rand0 : rand1;
	}
}
