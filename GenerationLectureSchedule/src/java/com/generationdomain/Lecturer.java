package java.com.generationdomain;

import java.util.ArrayList;

public class Lecturer {
	public String name;
	public ArrayList <Lecture> dersleri;
	public Table uygunZamanlar;
	static public int id;
	public String type;

	public class Type{
		public static final String FULLTIME="full time";
		public static final String PARTTIME="part time";
	}
	
	public Lecturer(String name, ArrayList<Lecture> dersleri, Table uygunZamanlari,String type){
		this.name=name;
		this.dersleri=dersleri;
		this.uygunZamanlar=uygunZamanlari;
		this.type=type;
		id=(int) (Math.random()*50);
	}

	public Lecturer() {
		id=(int) (Math.random()*50);
	}
	@Override
	 public String toString(){
		 
		return "\n\tname: "+this.name
				+"\n\ttype: "+this.type
				+"\n\tdönem: "+this.dersleri
				+"\n\tuygun zamanlar"+this.uygunZamanlar+"\n";
	}
}
