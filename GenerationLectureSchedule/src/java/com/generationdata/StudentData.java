package java.com.generationdata;

import java.com.generation.GenerationClass;
import java.com.generationdomain.Lecture;
import java.com.generationdomain.Student;
import java.util.ArrayList;

public class StudentData  {
	
	static int size=50;
	static int sinir2=3;
	
	static ArrayList<Student> ogrenciler=new ArrayList<Student>();
	static ArrayList<Lecture> lecture;
	public static void main(String[] args){
		runningStudent();
		
		System.out.println(ogrenciler.toString());
	}
	
	public static void runningStudent(){
		LectureData.created();
		created();
	}
	public static void created(){
		for(int i=0;i<size;i++){
 			lecture=new ArrayList<Lecture>();
 			
 			for(int j=0;j<sinir2;j++){
 				
 				int donem=(int) (Math.random()*GenerationClass.CLASS);
 				int dersNo=(int) (Math.random()*3);
 				lecture.add(j, LectureData.dersler.get(donem).get(dersNo));
 			}
 			
 			String name="name"+i;
 			int sinifi=(int) (Math.random()*GenerationClass.CLASS)+1;
 			Student std=new Student(i,
 					sinifi,
					 lecture,
					name);
 			ogrenciler.add(i,std );
 		}
		
	}
}
