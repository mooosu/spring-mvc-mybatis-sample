/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.common;

import com.zqgame.models.User;
import com.zqgame.services.UserService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author roscus
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/zqgame/unittest-mapper.xml"})
public class UserServiceTest {
    @Autowired
    protected UserService userService;

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
    @Test
    public void testCreate()
    {
        User user = new User();
        user.setUsername("testcase");
        user.setPassword("123123");
        user.setEmail("testcase@1.com");
        userService.create(user);
    }
}
