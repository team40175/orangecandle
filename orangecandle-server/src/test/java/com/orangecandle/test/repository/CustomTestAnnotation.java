package com.orangecandle.test.repository;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.orangecandle.test.StandaloneDataJpaConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { StandaloneDataJpaConfig.class })
@Transactional
public @interface CustomTestAnnotation {

}
