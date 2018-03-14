package com.cenyol.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cenyol.example.service.PattonService;

public class PattonServiceTest {
	private PattonService ps ;
	@Before
	public void init() {
		ps = new PattonService();
	}

	@Test
	public void testGetName() {
		assertEquals("ok","zhaoer",ps.getName("zhao"));
	}

	@Test
	public void testGetNickName() {
		assertNotEquals(2.00, 2.01, 0.001);
	}

}
