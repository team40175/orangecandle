package java.com.generation;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.domain.Department;
import com.domain.Lecture;
import com.domain.Lecturer;
import com.domain.Room;
import com.domain.Student;

public class Gen {

	private static final Logger log = LoggerFactory.getLogger( Gen.class );

	 Department department;
	 Lecture lecture;
	 Lecturer lecturer;
	 Room room;
	 ArrayList<Student> students;
	
	public Gen(){
		log.info("Gen function");
		
		lecture=new Lecture();
		lecturer=new Lecturer();
		room = new Room();
		students=new ArrayList<Student>();
		department=new Department();
	}
	
	public Gen(Lecture lec,Lecturer lecr,Room room,ArrayList<Student> students){
		log.info("Gen(Lecture lec,...) function");

		this.lecture=lec;
		this.lecturer=lecr;
		this.room=room;
		this.students=students;
	}
	
}
