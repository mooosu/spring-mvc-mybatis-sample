/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.common;

import com.zqgame.mappers.UserMapper;
import com.zqgame.models.User;
import com.zqgame.services.UserService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author roscus
 */
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath*:application.properties")
@ContextConfiguration({"classpath*:root-context.xml"})
public class UserServiceTest {
     @Autowired
    private ApplicationContext applicationContext;
    public UserServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEnv method, of class UserService.
     */
    @Test
    public void testSetEnv() {
        System.out.println("setEnv");
        Environment env = applicationContext.getEnvironment();
        UserService instance = new UserService();
        instance.setEnv(env);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserMapper method, of class UserService.
     */
    @Test
    public void testSetUserMapper() {
        System.out.println("setUserMapper");
        UserMapper userMapper = null;
        UserService instance = new UserService();
        instance.setUserMapper(userMapper);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encodePassphrase method, of class UserService.
     */
    @Test
    public void testEncodePassphrase() {
        System.out.println("encodePassphrase");
        String rawPassphrase = "";
        String salt = "";
        UserService instance = new UserService();
        String expResult = "";
        String result = instance.encodePassphrase(rawPassphrase, salt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class UserService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        User user = null;
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.create(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalt method, of class UserService.
     */
    @Test
    public void testGetSalt() {
        System.out.println("getSalt");
        String expResult = "";
        String result = UserService.getSalt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApplicationSalt method, of class UserService.
     */
    @Test
    public void testGetApplicationSalt() {
        System.out.println("getApplicationSalt");
        UserService instance = new UserService();
        String expResult = "";
        String result = instance.getApplicationSalt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCombinedSalt method, of class UserService.
     */
    @Test
    public void testGetCombinedSalt() {
        System.out.println("getCombinedSalt");
        String salt = "";
        UserService instance = new UserService();
        String expResult = "";
        String result = instance.getCombinedSalt(salt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIterations method, of class UserService.
     */
    @Test
    public void testGetIterations() {
        System.out.println("getIterations");
        UserService instance = new UserService();
        Integer expResult = null;
        Integer result = instance.getIterations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
