package com.orangecandle.test.repository;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.orangecandle.Actuator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Actuator.class })
@Transactional
public @interface CustomTestAnnotation {

}
