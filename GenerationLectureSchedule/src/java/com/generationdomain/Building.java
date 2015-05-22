package java.com.generationdomain;

import java.util.ArrayList;

public class Building {
	ArrayList<Room> room;
	ArrayList<Department> department;
	String name;
	
	public Building(){
		room=new ArrayList<Room>();
		department=new ArrayList <Department>();
	}
	
	public Building(ArrayList<Room> room,ArrayList<Department> department,String name){
		this.room=room;
		this.department=department;
		this.name=name;
	}
	
	@Override
	 public String toString(){
		return "Building name : "+this.name+
				"room size: "+this.room.size()+
				"department size: "+this.department;
	}
}
