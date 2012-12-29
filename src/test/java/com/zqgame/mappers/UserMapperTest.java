/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.mappers;

import com.zqgame.models.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roscus
 */
public class UserMapperTest {

    public UserMapperTest() {
    }

    @Before
    public void setUp() {
        User user = new User();
        user.setUsername("testcase1");
        user.setPassword("123123");
        user.setUsername("testcase1");
        user.setUsername("testcase1");
        user.setUsername("testcase1");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findById method, of class UserMapper.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        UserMapper instance = new UserMapperImpl();
        User expResult = null;
        User result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByUsername method, of class UserMapper.
     */
    @Test
    public void testFindByUsername() {
        System.out.println("findByUsername");
        String username = "";
        UserMapper instance = new UserMapperImpl();
        User expResult = null;
        User result = instance.findByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class UserMapper.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        User user = null;
        UserMapper instance = new UserMapperImpl();
        int expResult = 0;
        int result = instance.save(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class UserMapperImpl implements UserMapper {

        public User findById(int id) {
            return null;
        }

        public User findByUsername(String username) {
            return null;
        }

        public int save(User user) {
            return 0;
        }
    }
}
