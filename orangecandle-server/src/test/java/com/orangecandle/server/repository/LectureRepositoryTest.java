package com.orangecandle.server.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import com.orangecandle.domain.Lecture;
import com.orangecandle.domain.Role;
import com.orangecandle.domain.User;
@CustomTestAnnotation
public class LectureRepositoryTest {
	@Mock 
	@PersistenceContext
	private EntityManager em;

	private Role adminRole;

	private @InjectMocks com.orangecandle.repository.Lecture repository;

	private User first, second, third, fourth;
	private Lecture lectureOne, lectureTwo, lectureThree, lectureFour;

	@Before
	public void setup() {
		em=Mockito.mock(EntityManager.class);
		repository=Mockito.mock(com.orangecandle.repository.Lecture.class);
		
		lectureOne =Mockito.mock(Lecture.class);
		lectureTwo =Mockito.mock(Lecture.class);
		lectureThree = Mockito.mock(Lecture.class);
		lectureFour =Mockito.mock(Lecture.class);
		
		first=new User();
		second=new User();
		third=new User();
		fourth=new User();

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
		
		when(repository.save(lectureOne)).thenReturn(lectureOne);
		when(repository.save(lectureTwo)).thenReturn(lectureTwo);
		when(repository.save(lectureThree)).thenReturn(lectureThree);
		when(repository.saveAndFlush(lectureFour)).thenReturn(lectureFour);
		
		// is lecture not null?
		assertThat(lectureOne, is(notNullValue()));
		assertThat(lectureTwo, is(notNullValue()));
		assertThat(lectureThree, is(notNullValue()));
		assertThat(lectureFour, is(notNullValue()));

		// is lecture added in repository?
		assertThat(repository.exists(lectureOne.getLectureName()), is(true));
		assertThat(repository.exists(lectureTwo.getLectureName()), is(true));
		assertThat(repository.exists(lectureThree.getLectureName()), is(true));
		assertThat(repository.exists(lectureFour.getLectureName()), is(true));
	}

	@Test
	public void testCreationLecture() {
		Query countQuery=Mockito.mock(Query.class);
		when(em.createQuery("select count(u) from lecture u")).thenReturn(countQuery);
		Long before = (long) 0;
		when(countQuery.getSingleResult()).thenReturn(before);

		flushTestLecture();
		Long d3=null;
		when(countQuery.getSingleResult()).thenReturn(d3);

		// does database have 4 lecture?
		assertThat(d3, is(before + 4));
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

		List<Lecture> result =new ArrayList<Lecture> ();
		result.add(lectureOne);
		result.add(lectureTwo);
		result.add(lectureThree);

		when(repository.save(result)).thenReturn(result);

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
		Lecture foundLecture = Mockito.mock(Lecture.class);
		when(repository.findOne(strr)).thenReturn(foundLecture);
		foundLecture.setLectureName("Schlicht");

		Lecture updatedLecture = repository.findOne(strr);
		// update user name?
		assertThat(updatedLecture.getLectureName(),
				is(foundLecture.getLectureName()));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void returnsAllSortedCorrectly() throws Exception {

		flushTestLecture();
		List<Lecture> result =Mockito.mock(List.class);
		when(repository.findAll(new Sort(Sort.Direction.ASC,
				"lecture.name"))).thenReturn(result);
		// is correctly sorted
		assertThat(result, is(notNullValue()));
		assertThat(result.size(), is(4));
		assertThat(result.get(0), is(lectureOne));
		assertThat(result.get(2), is(lectureTwo));
		assertThat(result.get(1), is(lectureThree));
		assertThat(result.get(3), is(lectureFour));
	}

}
