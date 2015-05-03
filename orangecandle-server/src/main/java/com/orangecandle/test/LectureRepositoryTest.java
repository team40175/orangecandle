package com.orangecandle.test;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.orangecandle.domain.Lecture;
import com.orangecandle.domain.Role;
import com.orangecandle.domain.User;

public class LectureRepositoryTest {
	private @PersistenceContext EntityManager em;

	private Role adminRole;

	private @Autowired com.orangecandle.repository.Lecture repository;

	private User first, second, third, fourth;
	private Lecture lectureOne, lectureTwo, lectureThree, lectureFour;

	@Before
	public void setup() {
		lectureOne = new Lecture("CENG316", "Software Engineering");
		lectureTwo = new Lecture("MAN206", "Business and Workplace");
		lectureThree = new Lecture("CHEM203", "Organic Chemistry II");
		lectureFour = new Lecture();

		first.setUserName("kasım");
		second.setUserName("ayşe");
		third.setUserName("körebe");
		fourth.setUserName("Çekoslovakyalılaştıramadıklarımızdan");

		lectureOne.addLecturer(first);
		lectureOne.addLecturer(second);
		lectureThree.addLecturer(fourth);

		adminRole = Role.Administrator;

	}

	private void flushTestLecture() {
		em.persist(adminRole);

		lectureOne = repository.save(lectureOne);
		lectureTwo = repository.save(lectureTwo);
		lectureThree = repository.save(lectureThree);
		lectureFour = repository.save(lectureFour);

		repository.flush();
		// is lecture not null?
		assertThat(lectureOne, is(notNullValue()));
		assertThat(lectureTwo, is(notNullValue()));
		assertThat(lectureThree, is(notNullValue()));
		assertThat(lectureFour, is(notNullValue()));

		// is lecture added in repository?
		assertThat(repository.exists(lectureOne.getLectureCode()), is(true));
		assertThat(repository.exists(lectureTwo.getLectureCode()), is(true));
		assertThat(repository.exists(lectureThree.getLectureCode()), is(true));
		assertThat(repository.exists(lectureFour.getLectureCode()), is(false));
	}

	@Test
	public void testCreationLecture() {
		Query countQuery = em.createQuery("select count(u) from lecture u");
		Long before = (Long) countQuery.getSingleResult();

		flushTestLecture();
		// does database have 4 lecture?
		assertThat((Long) countQuery.getSingleResult(), is(before + 4));
	}

	@Test
	public void testCreationLectureRead() {
		flushTestLecture();
		Lecture foundLecture = repository.findOne(lectureOne.getLectureCode());

		assertThat(lectureOne.getLectureCode(), is(foundLecture));
	}

	@Test
	public void testReadByIdReturnsNullForNotFoundEntities() {

		flushTestLecture();
		// Is accept to be not found entity?
		assertThat(repository.findOne("küçük"), is(nullValue()));
	}

	@Test
	public void savesCollectionCorrectly() throws Exception {

		List<Lecture> result = repository.save(Arrays.asList(lectureOne,
				lectureTwo, lectureThree));
		// without flushTestLecture function,Is saved Lecture with collection?
		assertThat(result, is(notNullValue()));
		assertThat(result.size(), is(3));
		assertThat(result, hasItems(lectureOne, lectureTwo, lectureThree));
	}

	@Test
	public void savingNullCollectionIsNoOp() throws Exception {

		List<Lecture> result = repository.save((Collection<Lecture>) null);
		// Is saved null collection?
		assertThat(result, is(notNullValue()));
		assertThat(result.isEmpty(), is(true));
	}

	@Test
	public void savingEmptyCollectionIsNoOp() throws Exception {

		List<Lecture> result = repository.save(new ArrayList<Lecture>());
		// is saved empty collection?
		assertThat(result, is(notNullValue()));
		assertThat(result.isEmpty(), is(true));
	}

	@Test
	public void testUpdateLectureCode() {

		flushTestLecture();
		String strr = lectureOne.getLectureCode();
		Lecture foundLecture = repository.findOne(strr);
		foundLecture.setLectureName("Schlicht");

		Lecture updatedLecture = repository.findOne(strr);
		// update user name?
		assertThat(updatedLecture.getLectureName(),
				is(foundLecture.getLectureName()));
	}

	@Test
	public void returnsAllSortedCorrectly() throws Exception {

		flushTestLecture();
		List<Lecture> result = repository.findAll(new Sort(Sort.Direction.ASC,
				"name"));
		// is correctly sorted
		assertThat(result, is(notNullValue()));
		assertThat(result.size(), is(4));
		assertThat(result.get(0), is(lectureOne));
		assertThat(result.get(2), is(lectureTwo));
		assertThat(result.get(1), is(lectureThree));
		assertThat(result.get(3), is(lectureFour));
	}

}
