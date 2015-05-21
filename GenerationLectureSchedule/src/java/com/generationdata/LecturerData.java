package java.com.generationdata;

import java.com.generationdomain.Lecture;
import java.com.generationdomain.Lecturer;
import java.com.generationdomain.Table;
import java.util.ArrayList;

public class LecturerData {
	public static ArrayList<Lecturer> hocalar0 =new ArrayList<Lecturer>();

	public static void main(String[] args){
		
		created();
		//3 part time 2 full time
		System.out.println(hocalar0.toString());
	}

	public static void created() {
		
		ArrayList <Lecture> lec=new ArrayList <Lecture>();
		lec.add(LectureData.donemDersleri0.get(1));
		lec.add(LectureData.donemDersleri2.get(2));
		hocalar0.add(0, new Lecturer("hoca1",
				lec,null, Lecturer.Type.PARTTIME));
		
		lec=new ArrayList <Lecture>();
		lec.add(LectureData.donemDersleri0.get(0));
		lec.add(LectureData.donemDersleri2.get(1));
		hocalar0.add(0, new Lecturer("hoca2",
				lec,new Table (), Lecturer.Type.PARTTIME));
		
		lec=new ArrayList <Lecture>();
		lec.add(LectureData.donemDersleri0.get(2));
		lec.add(LectureData.donemDersleri2.get(0));
		lec.add(LectureData.donemDersleri3.get(1));
		hocalar0.add(0, new Lecturer("hoca3",
				lec,new Table (), Lecturer.Type.FULLTIME));
		
		lec=new ArrayList <Lecture>();
		lec.add(LectureData.donemDersleri1.get(2));
		lec.add(LectureData.donemDersleri3.get(2));
		lec.add(LectureData.donemDersleri1.get(0));
		hocalar0.add(0, new Lecturer("hoca4",
				lec,new Table (), Lecturer.Type.FULLTIME));
		
		lec=new ArrayList <Lecture>();
		lec.add(LectureData.donemDersleri1.get(1));
		lec.add(LectureData.donemDersleri3.get(0));
		hocalar0.add(0, new Lecturer("hoca5",
				lec,new Table (), Lecturer.Type.PARTTIME));
	}
	
}
