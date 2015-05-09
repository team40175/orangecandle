package com.orangecandle.test.repository;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.orangecandle.Actuator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Actuator.class)
@Transactional
@ContextConfiguration(locations = { "classpath : application.properties" })
//@ContextConfiguration(classes = {WebConfig.class})
//TestAppConfig would contain your 
//datasource/entitymanager/repository scan configuration.
public @interface CustomTestAnnotation {

}
