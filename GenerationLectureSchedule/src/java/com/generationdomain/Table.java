package java.com.generationdomain;

import java.util.ArrayList;

public class Table {
	 ArrayList <String> days;
	 ArrayList <Float> startLesson;
	 ArrayList <Float> endLesson;
	 int tablo[][]=new int[10][6];

	 void createTablo(){
		 for(int s=0;s<tablo.length;s++){
			 for(int j=0;j<tablo[s].length;j++){
				 tablo[s][j]=0;
			 }
		 }
	 }
	 void createDays(){
		 days=new ArrayList<String>();
		 days.add(0, "");
		 days.add(1, "Monday");
		 days.add(2, "Tuesday");
		 days.add(3, "Wednesday");
		 days.add(4, "Thursday");
		 days.add(5, "Friday");
		 days.add(6, "Saturday");
		 days.add(7, "Sunday");
	 }
	 void createLesson(){
		 startLesson=new ArrayList<Float>();
		 endLesson=new ArrayList<Float>();
		 startLesson.add(0, (float) 0);
		 startLesson.add(1, (float) 8.45);
		 startLesson.add(2, (float) 9.45);
		 startLesson.add(3, (float) 10.45);
		 startLesson.add(4, (float) 11.45);
		 startLesson.add(5, (float) 13.30);
		 startLesson.add(6, (float) 14.30);
		 startLesson.add(7, (float) 15.30);
		 startLesson.add(8, (float) 16.30);
		 
		 endLesson.add(0, (float) 0);
		 endLesson.add(1, (float) 9.30);
		 endLesson.add(2, (float) 10.30);
		 endLesson.add(3, (float) 11.30);
		 endLesson.add(4, (float) 12.30);
		 endLesson.add(5, (float) 14.15);
		 endLesson.add(6, (float) 15.15);
		 endLesson.add(7, (float) 16.15);
		 endLesson.add(8, (float) 17.15);
		 
	 }
	 public Table(){
		 createDays();
		 createLesson();
		 createTablo();
	 }
	 public Table(int i,int j){
		 createDays();
		 createLesson();
		 createTablo();
		 
		 tablo[i][j]=1;		 
	 }
	 public void doldur(int i,int j){
		 tablo[i][j]=1;
	 }
	 public void printfTable(){
		 for(int i=0;i<this.tablo.length;i++){
			 for(int j=0;j<this.tablo[i].length;j++){
				 System.out.print(tablo[i][j]);
			 }
			 System.out.println("\n");
		 }
	 }
	 
	 @Override
	 public String toString(){
		return this.tablo.toString()+"";
		 
	 }
//	 public static void main(String [] args){
//		 Table t=new Table(1,3);
//		 t.printfTable();
//		
//		}
}
