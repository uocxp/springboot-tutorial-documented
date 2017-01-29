package com.documented.spring.tutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.documented.spring.tutorial.SpringTutorialApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTutorialApplication.class)
@WebAppConfiguration
public class SpringTutorialApplicationTests {

	@Test
	public void contextLoads() {
	}

}
