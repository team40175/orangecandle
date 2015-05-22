package com.orangecandle.generationdata;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.orangecandle.domain.Lecture;

@Component
public class LectureData {
	public int size = 3;
	public int totalSize = 12;

	public ArrayList<ArrayList<Lecture>> all = new ArrayList<ArrayList<Lecture>>();

	public ArrayList<Lecture> lessons0 = new ArrayList<Lecture>();
	public ArrayList<Lecture> lessons1 = new ArrayList<Lecture>();
	public ArrayList<Lecture> lessons2 = new ArrayList<Lecture>();
	public ArrayList<Lecture> lessons3 = new ArrayList<Lecture>();

	public void generate() {
		lessons0.add(new Lecture("CENG101", "test0", true, 1, 3));
		lessons0.add(new Lecture("CENG102", "test1", false, 1, 3));
		lessons0.add(new Lecture("CENG103", "test2", true, 1, 4));

		lessons1.add(new Lecture("CENG201", "test3", true, 2, 5));
		lessons1.add(new Lecture("CENG202", "test4", false, 2, 3));
		lessons1.add(new Lecture("CENG203", "test5", true, 2, 3));

		lessons2.add(new Lecture("CENG301", "test6", true, 3, 4));
		lessons2.add(new Lecture("CENG302", "test7", false, 3, 3));
		lessons2.add(new Lecture("CENG303", "test8", true, 3, 3));

		lessons3.add(new Lecture("CENG401", "test9", true, 4, 5));
		lessons3.add(new Lecture("CENG402", "testA", true, 4, 4));
		lessons3.add(new Lecture("CENG403", "testB", true, 4, 3));

		all.addAll(Arrays.asList(lessons0, lessons1, lessons2, lessons3));

	}
}
