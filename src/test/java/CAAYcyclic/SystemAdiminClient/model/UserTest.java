/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.model;

import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of convertToParcel method, of class User.
     */
    @Test
    public void testConvertToParcel() {
        System.out.println("convertToParcel");
        User instance = new User();
        Parcel expResult = null;
        Parcel result = instance.convertToParcel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFromParcel method, of class User.
     */
    @Test
    public void testCreateFromParcel() {
        System.out.println("createFromParcel");
        Parcel parcel = null;
        User instance = new User();
        instance.createFromParcel(parcel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
