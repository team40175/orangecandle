package java.com.generationdomain;

import java.util.ArrayList;

public class Department {
	ArrayList<Lecture> lec;
	ArrayList<Lecturer> lecr;
	ArrayList<Student> std;
	ArrayList<Building> build;
	String name;
	
	public Department(){
		
		this.lec=new ArrayList<Lecture>();
		this.lecr=new ArrayList<Lecturer>();
		this.build=new ArrayList<Building>();
		this.std=new ArrayList<Student>();
		this.name="";
	}
	
	public Department(ArrayList<Lecture> lec,
			ArrayList<Lecturer> lecr,
			ArrayList<Student> std,
			ArrayList<Building> build, String name){
		
		this.lec=lec;
		this.lecr=lecr;
		this.build=build;
		this.std=std;
		this.name=name;
	}
	
	@Override
	 public String toString(){
		 
		return "department name"+this.name+
				"lecture number"+this.lec.size()+
					"lecturer number"+this.lecr.size()+
					"building number"+this.build.size()+
					"student number number"+this.std.size()+"\n";
	}
}
