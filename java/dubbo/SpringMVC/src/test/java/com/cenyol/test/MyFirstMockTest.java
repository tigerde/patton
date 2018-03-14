package com.cenyol.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:mvc-dispatcher-servlet.xml")
public class MyFirstMockTest {
	

	@Test
	public void test() {
		System.out.println("testing");
		Assert.assertEquals(3.00,3.1,0.001);
	}
}
