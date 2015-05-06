package com.orangecandle.test.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import com.orangecandle.domain.Group;
import com.orangecandle.domain.Role;
import com.orangecandle.domain.User;

public class UserRepositoryTest {
	@PersistenceContext
	private EntityManager em;

	private User first, second, third, fourth;
	private Group gfirst, gsecond, gthird, gfourth;
	private Role adminRole;
	private String id;
	@Autowired
	private com.orangecandle.repository.User repository;

	@Before
	public void setup() {
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

		first = repository.save(first);
		second = repository.save(second);
		third = repository.save(third);
		fourth = repository.save(fourth);

		repository.flush();

		id = first.getUserName();

		// is user name not null?
		assertThat(id, is(notNullValue()));
		assertThat(second.getUserName(), is(notNullValue()));
		assertThat(third.getUserName(), is(notNullValue()));
		assertThat(fourth.getUserName(), is(notNullValue()));

		// is user added in repository?
		assertThat(repository.exists(id), is(true));
		assertThat(repository.exists(second.getUserName()), is(true));
		assertThat(repository.exists(third.getUserName()), is(true));
		assertThat(repository.exists(fourth.getUserName()), is(true));
	}

	@Test
	public void testCreation() {
		Query countQuery = em.createQuery("select count(u) from User u");
		Long before = (Long) countQuery.getSingleResult();

		flushTestUsers();
		// does database have 4 user?
		assertThat((Long) countQuery.getSingleResult(), is(before + 4));
	}

	@Test
	public void testCreationRead() {
		flushTestUsers();
		User foundUser = repository.findOne(id);

		assertThat(first.getUserName(), is(foundUser.getUserName()));
	}

	@Test
	public void testReadByIdReturnsNullForNotFoundEntities() {

		flushTestUsers();
		// Is accept to be not found entity?
		assertThat(repository.findOne("küçük"), is(nullValue()));
	}

	@Test
	public void savesCollectionCorrectly() throws Exception {

		List<User> result = repository
				.save(Arrays.asList(first, second, third));
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

		User foundPerson = repository.findOne(id);
		foundPerson.setUserName("Schlicht");

		User updatedPerson = repository.findOne(id);
		// update user name?
		assertThat(updatedPerson.getUserName(), is(foundPerson.getUserName()));
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
