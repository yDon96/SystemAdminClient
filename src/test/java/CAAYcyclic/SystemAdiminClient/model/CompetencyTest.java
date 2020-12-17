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
public class CompetencyTest {
    
    Competency instance;

    @Before
    public void setUp() {
        instance = new Competency();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Competency.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Integer expResult = 5;
        instance.id = 5;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Competency.
     */
    @Test
    public void shouldGetIdNullIfNotSet() {
        System.out.println("getId");
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Competency.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Mario";
        instance.name = expResult;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Competency.
     */
    @Test
    public void shouldGetNameNullIfNotSet() {
        System.out.println("getName");
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Competency.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = 5;
        instance.setId(id);
        assertEquals(id, instance.id);
    }

    /**
     * Test of setId method, of class Competency.
     */
    @Test
    public void shouldSetIdNullIfNullIsGiven() {
        System.out.println("setId");
        Integer id = null;
        instance.setId(id);
        assertEquals(id, instance.id);
    }

    /**
     * Test of setName method, of class Competency.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Mario";
        instance.setName(name);
        assertEquals(name, instance.name);

    }

    /**
     * Test of setName method, of class Competency.
     */
    @Test
    public void shouldSetNameNullIfNullIsGiven() {
        System.out.println("setName");
        String name = null;
        instance.setName(name);
        assertEquals(name, instance.name);

    }

    /**
     * Test of getParcelableDescription method, of class Competency.
     */
    @Test
    public void testGetParcelableDescription() {
        System.out.println("getParcelableDescription");
        String expResult = "Competency";
        String result = instance.getParcelableDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of convertToParcel method, of class Competency.
     */
    @Test
    public void testConvertToParcel() {
        System.out.println("convertToParcel");
        Integer expInt = 1000;
        String expName = "Competency";
        instance.setId(expInt);
        instance.setName(expName);
        Parcel result = instance.convertToParcel();
        assertEquals(expInt, result.readInteger());
        assertEquals(expName, result.readString());
    }

    /**
     * Test of createFromParcel method, of class Competency.
     */
    @Test
    public void testCreateFromParcel() {
        System.out.println("createFromParcel");
        Parcel parcel = new Parcel();
        Integer expInt = 20000;
        String expName = "Competenciesss";
        Competency expCompetency = new Competency();
        expCompetency.id = expInt;
        expCompetency.name = expName;
        parcel.writeInteger(expInt);
        parcel.writeString(expName);
        instance.createFromParcel(parcel);
        assertEquals(expCompetency, instance);
    }

    /**
     * Test of convetToObjectArray method, of class Competency.
     */
    @Test
    public void testConvetToObjectArray() {
        System.out.println("convetToObjectArray");
        Integer expInt = 1000;
        String expName = "Competency";
        instance.setId(expInt);
        instance.setName(expName);
        Object[] expResult = {1000,"Competency"};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of convetToObjectArray method, of class Competency.
     */
    @Test
    public void shouldConvetToObjectArrayWithAllNullIfIdAndNameIsNotSet() {
        System.out.println("convetToObjectArray");
        Object[] expResult = {null,null};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of convetToObjectArray method, of class Competency.
     */
    @Test
    public void shouldConvetToObjectArrayWithOnlyIdValue() {
        System.out.println("convetToObjectArray");
        Integer expInt = 1000;
        instance.setId(expInt);
        Object[] expResult = {1000,null};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of convetToObjectArray method, of class Competency.
     */
    @Test
    public void shouldConvetToObjectArrayWithOnlyNameValue() {
        System.out.println("convetToObjectArray");
        String expName = "Competency";
        instance.setName(expName);
        Object[] expResult = {null,"Competency"};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }
    
}
