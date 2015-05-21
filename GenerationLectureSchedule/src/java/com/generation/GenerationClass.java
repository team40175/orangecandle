package java.com.generation;

public class GenerationClass {
	static final int MAX_LECTURE_NUMBER_IN_A_DAY=8;
	static final int DAY_NUMBER=5;
	public static final int CLASS=4;
	static final int MAX_DEPARTMENT=1;
	public static final int genUzunluðu=calculationGenLength();

	static int calculationGenLength(){
		return GenerationClass.DAY_NUMBER
				*GenerationClass.MAX_DEPARTMENT
				*GenerationClass.MAX_LECTURE_NUMBER_IN_A_DAY
				*GenerationClass.CLASS;
	}
}
