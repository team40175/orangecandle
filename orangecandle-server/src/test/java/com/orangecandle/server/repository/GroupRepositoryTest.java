package com.orangecandle.server.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matcher.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
public class GroupRepositoryTest {
	
	@Mock
	private EntityManager em;

	private User first, second, third, fourth;
	private Group gfirst, gsecond, gthird, gfourth;
	private Role adminRole;
	
	@InjectMocks
	private com.orangecandle.repository.Group repository;

	@Before
	public void setup() {
		em=Mockito.mock(EntityManager.class);
		repository=Mockito.mock(com.orangecandle.repository.Group.class);
		first=new User();
		second=new User();
		third=new User();
		fourth=new User();
		
		gfirst=Mockito.mock(Group.class);
		gsecond=Mockito.mock(Group.class);
		gthird=Mockito.mock(Group.class);
		gfourth=Mockito.mock(Group.class);
		
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
		when(repository.save(gfirst)).thenReturn(gfirst);
		when(repository.save(gsecond)).thenReturn(gsecond);
		when(repository.save(gthird)).thenReturn(gthird);
		when(repository.saveAndFlush(gfourth)).thenReturn(gfourth);
		repository.saveAndFlush(gfirst);

		
		// is getGroupName name not null?
		assertThat(gfirst, is(notNullValue()));
		assertThat(gsecond, is(notNullValue()));
		assertThat(gthird, is(notNullValue()));
		assertThat(gfourth, is(notNullValue()));
//System.out.println(repository.count());
		// is Group added in repository?
		assertThat(repository.exists(gfirst.getGroupName()), is(true));
		assertThat(repository.exists(gsecond.getGroupName()), is(true));
		assertThat(repository.exists(gthird.getGroupName()), is(true));
		assertThat(repository.exists(gfourth.getGroupName()), is(true));
	}

	@Test
	public void testCreationGroup() {
		Query countQuery=Mockito.mock(Query.class);
		when(em.createQuery(new String("select count(u) from Group u"))).thenReturn(countQuery);

		Long before = (long) 0;
		when(countQuery.getSingleResult()).thenReturn(before);

		flushTestGroup();
		Long d3=null;
		when(countQuery.getSingleResult()).thenReturn(d3);

		// does database have 4 lecture?
		assertThat(d3, is(before + 4));
	}

	@Test
	public void testCreationGroupRead() {
		flushTestGroup();
		Group foundGroup = repository.findOne(gfirst.getGroupName());

		assertThat(gfirst.getGroupName(), is(foundGroup));
	}

	@Test
	public void testReadByIdReturnsNullForNotFoundEntities() {

		flushTestGroup();
		// Is accept to be not found entity?
		assertThat(repository.findOne("küçük"), is(nullValue()));
	}

	@Test
	public void savesCollectionCorrectly() throws Exception {

		List<Group> result = new ArrayList<Group>();
		result.add(gfirst);
		result.add(gthird);
		result.add(gsecond);

		when(repository.save(result)).thenReturn(result);
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
		String strr = gfirst.getGroupName();
		Group foundGroup = Mockito.mock(Group.class);
		when(repository.findOne(strr)).thenReturn(foundGroup);
		foundGroup.setGroupName("Schlicht");

		Group updatedGroup = repository.findOne(strr);
		// update user name?
		assertThat(updatedGroup.getGroupName(),
				is(foundGroup.getGroupName()));

		}

	@Test
	public void returnsAllSortedCorrectly() throws Exception {

		List<Group> result =new ArrayList<Group>();
		
		flushTestGroup();
		
		when(repository.findAll(new Sort(Sort.Direction.ASC,
				"name"))).thenReturn(result);
		
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
		assertThat(repository.exists(gfirst.getGroupName()), is(gfirst));
		assertThat(repository.exists(gsecond.getGroupName()), is(true));
		assertThat(repository.exists(gthird.getGroupName()), is(true));
		assertThat(repository.exists(gfourth.getGroupName()), is(true));
		assertThat(repository.exists("kuantum"), is(false));

	}
}
