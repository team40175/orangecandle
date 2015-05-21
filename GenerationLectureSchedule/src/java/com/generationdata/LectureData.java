package java.com.generationdata;
import java.com.generationdomain.*;
import java.util.ArrayList;
public class LectureData {
	static public int size=3;
	static public int totalSize=12;

	static public ArrayList<ArrayList<Lecture>> dersler=new ArrayList<ArrayList<Lecture>>();

	static public ArrayList<Lecture> donemDersleri0 =new ArrayList<Lecture>();
	static public ArrayList<Lecture> donemDersleri1 =new ArrayList<Lecture>();
	static public ArrayList<Lecture> donemDersleri2 =new ArrayList<Lecture>();
	static public ArrayList<Lecture> donemDersleri3 =new ArrayList<Lecture>();
	
	public static void main(String[] args){
		
		created();
		
		System.out.println(dersler.toString());
	}
	
	public static void created(){
		donemDersleri0.add(0, new Lecture("ders1-1",Lecture.Type.ZorunluDers,1,null,3));
		donemDersleri0.add(1, new Lecture("ders1-2",Lecture.Type.SecmeliDers,1,null,3));
		donemDersleri0.add(2, new Lecture("ders1-3",Lecture.Type.ZorunluDers,1,null,4));
		
		donemDersleri1.add(0, new Lecture("ders2-1",Lecture.Type.ZorunluDers,2,null,5));
		donemDersleri1.add(1, new Lecture("ders2-2",Lecture.Type.SecmeliDers,2,null,3));
		donemDersleri1.add(2, new Lecture("ders2-3",Lecture.Type.ZorunluDers,2,null,3));
		
		donemDersleri2.add(0, new Lecture("ders3-1",Lecture.Type.ZorunluDers,3,null,4));
		donemDersleri2.add(1, new Lecture("ders3-2",Lecture.Type.SecmeliDers,3,null,3));
		donemDersleri2.add(2, new Lecture("ders3-3",Lecture.Type.SecmeliDers,3,null,3));
		
		donemDersleri3.add(0, new Lecture("ders4-1",Lecture.Type.ZorunluDers,4,null,5));
		donemDersleri3.add(1, new Lecture("ders4-2",Lecture.Type.ZorunluDers,4,null,4));
		donemDersleri3.add(2, new Lecture("ders4-3",Lecture.Type.ZorunluDers,4,null,3));
		
		dersler.add(donemDersleri0);
		dersler.add(donemDersleri1);
		dersler.add(donemDersleri2);
		dersler.add(donemDersleri3);
		
	}
}
