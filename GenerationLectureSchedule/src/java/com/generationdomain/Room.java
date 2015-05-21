package java.com.generationdomain;

import java.util.Random;

public class Room {
	public int size;
	public String name;
	static public int id;

	public Room(int size,String name){
		this.name=name;
		this.size=size;
		id=new Random().nextInt();

	}

	public Room() {
		id=new Random().nextInt();
	}
	@Override
	 public String toString(){
		 
		return "\n\tname: "+this.name+"\n\tsize: "+this.size+"\n";
	}
}
