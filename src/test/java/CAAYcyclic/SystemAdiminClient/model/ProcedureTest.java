/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class ProcedureTest {
    
    
    Procedure instance = new Procedure();
    Parcel expResult = null;
    
    @Before
    public void setUp() {
        instance = new Procedure();
        expResult = new Parcel();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of convertToParcel method, of class Procedure.
     */
    @Test
    public void testConvertToParcel() {
        System.out.println("convertToParcel");
        Parcel result = instance.convertToParcel();
        assertEquals(expResult, result);
    }

    /**
     * Test of createFromParcel method, of class Procedure.
     */
    @Test
    public void testCreateFromParcel() {
        System.out.println("createFromParcel");
        Parcel parcel = null;
        Procedure instance = new Procedure();
        instance.createFromParcel(parcel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
