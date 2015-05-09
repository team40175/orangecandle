package com.orangecandle.server.repository;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.orangecandle.domain.Building;
@CustomTestAnnotation
public class BuildingRepositoryTest {
	
	@Mock private EntityManager em;
	@InjectMocks private com.orangecandle.repository.Building repository;
	Building bi;
	@Before
	public void setup(){
		em=Mockito.mock(EntityManager.class);
		repository=Mockito.mock(com.orangecandle.repository.Building.class);
	}
	@Test
	public void testOneSaving() {
		when(repository.saveAndFlush(new Building())).thenReturn(new Building());
		assertThat(repository.count(),is((long)1));
	}
	@Test
	public void updateTest(){
		Building b=Mockito.mock(Building.class);
		b.setBuildingName("building1");
		when(repository.saveAndFlush(b)).thenReturn(b);
		b.setBuildingName("delirdi");
		
		Building updatedBuilding = repository.findOne("delirdi");
		// update user name?
		assertThat(updatedBuilding, 
				is(b.getBuildingName()));
	}
		
	
}
