package com.orangecandle.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.orangecandle.test.controller.LinkControllerTest;
import com.orangecandle.test.controller.UserControllerTest;
import com.orangecandle.test.domain.UserTest;
import com.orangecandle.test.filter.CorsFilterTest;
import com.orangecandle.test.repository.BuildingRepositoryTest;
import com.orangecandle.test.repository.ConstraintRepositoryTest;
import com.orangecandle.test.repository.DepartmentRepositoryTest;
import com.orangecandle.test.repository.FacultyRepositoryTest;
import com.orangecandle.test.repository.GroupRepositoryTest;
import com.orangecandle.test.repository.LectureRepositoryTest;
import com.orangecandle.test.repository.RoomRepositoryTest;
import com.orangecandle.test.repository.SchoolRepositoryTest;
import com.orangecandle.test.repository.UserRepositoryTest;

// specify a runner class: Suite.class
@RunWith(Suite.class)
// specify an array of test classes
@Suite.SuiteClasses({
	LinkControllerTest.class,
	UserControllerTest.class,
	CorsFilterTest.class,
	BuildingRepositoryTest.class,
	DepartmentRepositoryTest.class,
	ConstraintRepositoryTest.class,
	FacultyRepositoryTest.class,
	GroupRepositoryTest.class,
	LectureRepositoryTest.class,
	RoomRepositoryTest.class,
	SchoolRepositoryTest.class,
	UserRepositoryTest.class,
	UserTest.class

})
public class GeneralTestSuite {

}
