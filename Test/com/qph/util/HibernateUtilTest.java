package com.qph.util;

import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateUtilTest {
	
	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if(sessionFactory != null)
			sessionFactory.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Test
	public void testGetSessionFactory() {
		fail("Not yet implemented");
	}
	
	@Test(expected=ExceptionInInitializerError.class)
	public void testGetSessionFactoryWithHibernateException() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

}
