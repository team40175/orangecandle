package com.orangecandle.server.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;

import com.orangecandle.domain.Group;
import com.orangecandle.domain.Lecture;
import com.orangecandle.domain.Role;
import com.orangecandle.domain.User;

@CustomTestAnnotation
public class UserRepositoryTest {
	
	@Mock	
	private EntityManager em;
	@Mock
	private User first, second, third, fourth;
	
	private Group gfirst, gsecond, gthird, gfourth;
	private Role adminRole;
	
	
	@InjectMocks
	private com.orangecandle.repository.User repository;
	
	
	@Before
	public void setup() {

		em=mock(EntityManager.class);
		repository=mock(com.orangecandle.repository.User.class);
		
		first=mock(User.class);
		second=mock(User.class);
		third=mock(User.class);
		fourth=mock(User.class);
		
		gfirst=new Group();
		gsecond=new Group();
		gthird=new Group();
		gfourth=new Group();
		
		first.setUserName("abdullah");
		second.setUserName("hatun");
		third.setUserName("ömer");
		fourth.setUserName("kuyruksallayangillersizleştiricileştiriveremeyebileceklerimizdenmişsinizcesine");

		gfirst.setGroupName("java");
		gsecond.setGroupName("tennis");
		gthird.setGroupName("paintpall");
		gfourth.setGroupName("bicycle");

		gfirst.addUser(first);
		gsecond.addUser(first);
		gsecond.addUser(second);
		gsecond.addUser(third);
		gsecond.addUser(fourth);
		gthird.addUser(second);
		gthird.addUser(fourth);
		// fourth group is empty
		
		adminRole = Role.Administrator;
	}
	

	// user has a name and user is added in database
	private void flushTestUsers() {

		em.persist(adminRole);

		//first=repository.save(first);
		when(repository.save(first)).thenReturn(first);
		when(repository.save(second)).thenReturn(second);
		when(repository.save(third)).thenReturn(third);
		when(repository.saveAndFlush(fourth)).thenReturn(fourth);

		// is user name not null?
		assertThat(first, is(notNullValue()));
		assertThat(second, is(notNullValue()));
		assertThat(third, is(notNullValue()));
		assertThat(fourth, is(notNullValue()));

		// is user added in repository?
		assertThat(repository.exists(first.getUserName()), is(true));
		assertThat(repository.exists(second.getUserName()), is(true));
		assertThat(repository.exists(third.getUserName()), is(true));
		assertThat(repository.exists(fourth.getUserName()), is(true));
	}

	@Test
	public void testCreationUser() {
		Query countQuery=Mockito.mock(Query.class);
		when(em.createQuery(new String("select count(u) from User u"))).thenReturn(countQuery);
		Long before =(long) 0;
		when(countQuery.getSingleResult()).thenReturn(before);

		flushTestUsers();
		
		// does database have 4 user?
		Long d5=null;
		when(countQuery.getSingleResult()).thenReturn(d5);

		assertThat(d5, is(before + 4));
	}

	@Test
	public void testCreationUserRead() {
		flushTestUsers();
		User foundUser = repository.findOne(first.getUserName());

		assertThat(first.getUserName(), is(foundUser));
	}

	@Test
	public void testReadByIdReturnsNullForNotFoundEntities() {

		flushTestUsers();
		// Is accept to be not found entity?
		assertThat(repository.findOne("küçük"), is(nullValue()));
	}

	@Test
	public void savesCollectionCorrectly() throws Exception {

		List<User> result = new ArrayList<User> ();
		result.add(first);
		result.add(third);
		result.add(second);

		when(repository.save(result)).thenReturn(result);
		// without flushTestUsers function,Is saved user with collection?
		assertThat(result, is(notNullValue()));
		assertThat(result.size(), is(3));
		assertThat(result, hasItems(first, second, third));
	}

	@Test
	public void savingNullCollectionIsNoOp() throws Exception {

		List<User> result = repository.save((Collection<User>) null);
		// Is saved null collection?
		assertThat(result, is(notNullValue()));
		assertThat(result.isEmpty(), is(true));
	}

	@Test
	public void savingEmptyCollectionIsNoOp() throws Exception {

		List<User> result = repository.save(new ArrayList<User>());
		// is saved empty collection?
		assertThat(result, is(notNullValue()));
		assertThat(result.isEmpty(), is(true));
	}

	@Test
	public void testUpdate() {

		flushTestUsers();
		
		String strr = first.getUserName();
		User foundPerson =Mockito.mock(User.class); 
		when(repository.findOne(strr)).thenReturn(foundPerson);
		foundPerson.setUserName("Schlicht");

		User updatedPerson = repository.findOne(strr);
		// update user name?
		assertThat(updatedPerson.getUserName(), 
				is(foundPerson));
	}

	@Test
	public void returnsAllSortedCorrectly() throws Exception {

		flushTestUsers();
		List<User> result = repository.findAll(new Sort(Sort.Direction.ASC,
				"name"));
		// is correctly sorted
		assertThat(result, is(notNullValue()));
		assertThat(result.size(), is(4));
		assertThat(result.get(0), is(first));
		assertThat(result.get(1), is(second));
		assertThat(result.get(2), is(fourth));
		assertThat(result.get(3), is(third));
	}

	@Test
	public void testUserHasAGroup() {
		flushTestUsers();
		// IS exist group?
		assertThat(repository.exists(gfirst.getGroupName()), is(true));
		assertThat(repository.exists(gsecond.getGroupName()), is(true));
		assertThat(repository.exists(gthird.getGroupName()), is(true));
		assertThat(repository.exists(gfourth.getGroupName()), is(true));
		assertThat(repository.exists("kuantum"), is(false));

	}

}
