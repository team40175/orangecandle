package java.com.generationdomain;

import java.util.Random;

public class Lecture {
	
	public class Type{
		public static final String ZorunluDers="zorunlu ders";
		public static final String SecmeliDers="seçmeli ders";
	}
	static public int id;
	public String name;
	public String type;
	public int donem;
	public int lectureHours;
	Room room;
	
	public Lecture(String name,String type,int donem,Room room,int hours){
		this.name=name;
		this.type=type;
		this.donem=donem;
		this.lectureHours=hours;
		id=new Random().nextInt();
	}

	public Lecture() {
		id=new Random().nextInt();
	}
	@Override
	 public String toString(){
		 
		return "\n\tname: "+this.name
				+"\n\ttype: "+this.type
				+"\n\tdönem: "+this.donem+"\n";
	}
}
