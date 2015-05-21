package java.com.generationdomain;

import java.util.ArrayList;

public class Student {
	 int id;
	 ArrayList<Lecture> alacagidersler;
	 String name;
	 int sinifi;
	
	public Student(int id,int sinif,ArrayList<Lecture> lectures,String name){
		this.id=id;
		this.sinifi=sinif;
		this.alacagidersler=new ArrayList<Lecture>(lectures);
		this.name=name;
	}
	public Student(){
		this.id=0;
		this.sinifi=0;
		this.alacagidersler=new ArrayList<Lecture>();
		this.name=null;
	}
	
	@Override
	 public String toString(){
		return "\n\tid :"+this.id
				+"\n\tname: "+this.name
				+"\n\talacagý dersler: "+this.alacagidersler
				+"\n\tsýnýfý: "+this.sinifi+"\n";
	}
}
