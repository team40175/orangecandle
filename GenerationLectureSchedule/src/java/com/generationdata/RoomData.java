package java.com.generationdata;

import java.com.generationdomain.Room;
import java.util.ArrayList;

public class RoomData {
	static public ArrayList<Room> odalar=new ArrayList<Room>();
	static int size=4;
	public static void main(String[] args){
		created();
		System.out.println(odalar.toString());
	}

	public static void created() {
		odalar.add(0, new Room(20,"oda1"));
		odalar.add(1, new Room(20,"oda2"));
		odalar.add(2, new Room(20,"oda3"));
		odalar.add(3, new Room(20,"oda4"));
		
	}
}
