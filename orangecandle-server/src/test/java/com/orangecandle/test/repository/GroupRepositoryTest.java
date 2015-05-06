package com.orangecandle.test.repository;

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

import com.orangecandle.domain.Group;
import com.orangecandle.domain.Role;
import com.orangecandle.domain.User;

public class GroupRepositoryTest {
	@PersistenceContext
	private EntityManager em;

	private User first, second, third, fourth;
	private Group gfirst, gsecond, gthird, gfourth;
	private Role adminRole;
	private String id;
	
	@Autowired
	private com.orangecandle.repository.Group repository;

	@Before
	public void setup() {	
		first=new User();
		second=new User();
		third=new User();
		fourth=new User();
		
		gfirst=new Group();
		gsecond=new Group();
		gthird=new Group();
		gfourth=new Group();
		
		first.setUserName("sadullah");
		second.setUserName("eyvah");
		third.setUserName("vakvak");
		fourth.setUserName("Muvaffakiyetsizleştiricileştiriveremeyebileceklerimizdenmişsinizcesine");

		gfirst.setGroupName("android");
		gsecond.setGroupName("tetris");
		gthird.setGroupName("ileri paintpall");
		gfourth.setGroupName("mountain bike");

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

	private void flushTestGroup() {
			em.persist(adminRole);
		gfirst = repository.save(gfirst);
		gsecond = repository.save(gsecond);
		gthird = repository.save(gthird);
		gfourth = repository.save(gfourth);

		repository.flush();

		id = gfirst.getGroupName();

		// is getGroupName name not null?
		assertThat(id, is(notNullValue()));
		assertThat(gsecond.getGroupName(), is(notNullValue()));
		assertThat(gthird.getGroupName(), is(notNullValue()));
		assertThat(gfourth.getGroupName(), is(notNullValue()));

		// is Group added in repository?
		assertThat(repository.exists(id), is(true));
		assertThat(repository.exists(gsecond.getGroupName()), is(true));
		assertThat(repository.exists(gthird.getGroupName()), is(true));
		assertThat(repository.exists(gfourth.getGroupName()), is(true));
	}

	@Test
	public void testCreation() {
		Query countQuery = em.createQuery("select count(u) from User u");
		Long before = (Long) countQuery.getSingleResult();

		flushTestGroup();
		// does database have 4 user?
		assertThat((Long) countQuery.getSingleResult(), is(before + 4));
	}

	@Test
	public void testCreationRead() {
		flushTestGroup();
		Group foundGroup = repository.findOne(id);

		assertThat(gfirst.getGroupName(), is(foundGroup.getGroupName()));
	}

	@Test
	public void testReadByIdReturnsNullForNotFoundEntities() {

		flushTestGroup();
		// Is accept to be not found entity?
		assertThat(repository.findOne("küçük"), is(nullValue()));
	}

	@Test
	public void savesCollectionCorrectly() throws Exception {

		List<Group> result = repository.save(Arrays.asList(gfirst, gsecond,
				gthird));
		// without flushTestGroup function,Is saved Group with collection?
		assertThat(result, is(notNullValue()));
		assertThat(result.size(), is(3));
		assertThat(result, hasItems(gfirst, gsecond, gthird));
	}

	@Test
	public void savingNullCollectionIsNoOp() throws Exception {

		List<Group> result = repository.save((Collection<Group>) null);
		// Is saved null collection?
		assertThat(result, is(notNullValue()));
		assertThat(result.isEmpty(), is(true));
	}

	@Test
	public void savingEmptyCollectionIsNoOp() throws Exception {

		List<Group> result = repository.save(new ArrayList<Group>());
		// is saved empty collection?
		assertThat(result, is(notNullValue()));
		assertThat(result.isEmpty(), is(true));
	}

	@Test
	public void testUpdate() {

		flushTestGroup();

		Group foundGroup = repository.findOne(id);
		foundGroup.setGroupName("Schlicht");

		Group updatedGroup = repository.findOne(id);
		// update Group name?
		assertThat(updatedGroup.getGroupName(), is(foundGroup.getGroupName()));
	}

	@Test
	public void returnsAllSortedCorrectly() throws Exception {

		flushTestGroup();
		List<Group> result = repository.findAll(new Sort(Sort.Direction.ASC,
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
		flushTestGroup();
		// IS exist group?
		assertThat(repository.exists(gfirst.getGroupName()), is(true));
		assertThat(repository.exists(gsecond.getGroupName()), is(true));
		assertThat(repository.exists(gthird.getGroupName()), is(true));
		assertThat(repository.exists(gfourth.getGroupName()), is(true));
		assertThat(repository.exists("kuantum"), is(false));

	}
}
