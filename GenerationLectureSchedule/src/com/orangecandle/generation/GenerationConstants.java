package com.orangecandle.generation;

import org.springframework.stereotype.Component;

@Component
public class GenerationConstants {
	private final int LECTURES_PER_DAY = 8;
	private final int WORK_DAY_COUNT = 5;
	private final int YEARS_TO_GRADUATE = 4;
	private final int DEPT_MAX = 1;

	public int geneLength() {
		return WORK_DAY_COUNT * DEPT_MAX * LECTURES_PER_DAY * YEARS_TO_GRADUATE;
	}

	public int randomDept() {
		return (int) (Math.random() * DEPT_MAX);
	}

	public int randomDay() {
		return (int) (Math.random() * WORK_DAY_COUNT);
	}

	public int randomYear() {
		return (int) (Math.random() * YEARS_TO_GRADUATE);
	}

	public int randomTimeSlot() {
		return (int) (Math.random() * LECTURES_PER_DAY);
	}

	public int radiationValue() {
		return LECTURES_PER_DAY * randomDay() + 1 + randomDept() * geneLength()
				/ DEPT_MAX + randomYear() * geneLength()
				/ (DEPT_MAX * YEARS_TO_GRADUATE);
	}

	public int getLectureCount() {
		return LECTURES_PER_DAY;
	}
}
