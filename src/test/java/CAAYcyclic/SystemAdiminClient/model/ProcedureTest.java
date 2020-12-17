/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class ProcedureTest {
    
    Procedure instance;

    @Before
    public void setUp() {
        instance = new Procedure();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Procedure.
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
     * Test of getId method, of class Procedure.
     */
    @Test
    public void shouldGetIdNullIfNotSet() {
        System.out.println("getId");
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Procedure.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "Mario";
        instance.title = expResult;
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Procedure.
     */
    @Test
    public void shouldGetTitleNullIfNotSet() {
        System.out.println("getTitle");
        String expResult = null;
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of getTitle method, of class Procedure.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getTitle");
        String expResult = "Mario";
        instance.description = expResult;
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Procedure.
     */
    @Test
    public void shouldGetDescriptionNullIfNotSet() {
        System.out.println("getTitle");
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of getTitle method, of class Procedure.
     */
    @Test
    public void testGetCompetencies() {
        System.out.println("getTitle");
        Set<String> competencies = new HashSet<>(Arrays.asList("MyDescription","MyDescription","MyDescription","MyDescription"));;
        instance.competencies = competencies;
        Set<String> result = instance.getCompetencies();
        assertEquals(competencies, result);
    }

    /**
     * Test of getTitle method, of class Procedure.
     */
    @Test
    public void shouldGetCompetenciesNullIfNotSet() {
        System.out.println("getTitle");
        Set<String> competencies = null;
        instance.competencies = competencies;
        Set<String> result = instance.getCompetencies();
        assertEquals(competencies, result);
    }

    /**
     * Test of setId method, of class Procedure.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = 5;
        instance.setId(id);
        assertEquals(id, instance.id);
    }

    /**
     * Test of setId method, of class Procedure.
     */
    @Test
    public void shouldSetIdNullIfNullIsGiven() {
        System.out.println("setId");
        Integer id = null;
        instance.setId(id);
        assertEquals(id, instance.id);
    }

    /**
     * Test of setTitle method, of class Procedure.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "Mario";
        instance.setTitle(title);
        assertEquals(title, instance.title);

    }
    
    /**
     * Test of setId method, of class Procedure.
     */
    @Test
    public void shouldSetTitleNullIfNullIsGiven() {
        System.out.println("setTitle");
        String title = null;
        instance.setTitle(title);
        assertEquals(title, instance.title);
    }

    /**
     * Test of setTitle method, of class Procedure.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setTitle");
        String title = "Mario";
        instance.setDescription(title);
        assertEquals(title, instance.description);

    }

    /**
     * Test of setTitle method, of class Procedure.
     */
    @Test
    public void shouldSetDescriptionNullIfNullIsGiven() {
        System.out.println("setTitle");
        String title = null;
        instance.setDescription(title);
        assertEquals(title, instance.title);
    }
    
    /**
     * Test of setTitle method, of class Procedure.
     */
    @Test
    public void testSetCompetencies() {
        System.out.println("setTitle");
        Set<String> competencies = new HashSet<>(Arrays.asList("MyDescription","MyDescription","MyDescription","MyDescription"));;
        instance.setCompetencies(competencies);
        assertEquals(competencies, instance.competencies);

    }

    /**
     * Test of setTitle method, of class Procedure.
     */
    @Test
    public void shouldSetCompetenciesNullIfNullIsGiven() {
        System.out.println("setTitle");
        Set<String> competencies = null;
        instance.setCompetencies(competencies);
        assertEquals(competencies, instance.competencies);
    }

    /**
     * Test of getParcelableDescription method, of class Procedure.
     */
    @Test
    public void testGetParcelableDescription() {
        System.out.println("getParcelableDescription");
        String expResult = "Procedure";
        String result = instance.getParcelableDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of convertToParcel method, of class Procedure.
     */
    @Test
    public void testConvertToParcel() {
        System.out.println("convertToParcel");
        Integer expInt = 1000;
        String expTitle = "Procedure";
        String expDescription = "MyDescription";
        Set<String> competencies = new HashSet<>(Arrays.asList("MyDescription1","MyDescription2","MyDescription3","MyDescription4"));
        instance.setId(expInt);
        instance.setTitle(expTitle);
        instance.setDescription(expDescription);
        instance.setCompetencies(competencies);
        Parcel result = instance.convertToParcel();
        assertEquals(expInt, result.readInteger());
        assertEquals(expTitle, result.readString());
        assertEquals(expDescription, result.readString());
        assertArrayEquals(competencies.toArray(new String[competencies.size()]), result.readStringArray());
    }

    /**
     * Test of createFromParcel method, of class Procedure.
     */
    @Test
    public void testCreateFromParcel() {
        System.out.println("createFromParcel");
        Parcel parcel = new Parcel();
        Procedure expProcedure = new Procedure();
        Integer expInt = 2000;
        String expTitle = "Procedure";
        String expDescription = "MyDescription";
        Set<String> competencies = new HashSet<>(Arrays.asList("MyDescription","MyDescription","MyDescription","MyDescription"));
        expProcedure.setId(expInt);
        expProcedure.setTitle(expTitle);
        expProcedure.setDescription(expDescription);
        expProcedure.setCompetencies(competencies);
        parcel.writeInteger(expInt);
        parcel.writeString(expTitle);
        parcel.writeString(expDescription);
        parcel.writeStringArray(new String[] {"MyDescription","MyDescription","MyDescription","MyDescription"});
        instance.createFromParcel(parcel);
        assertEquals(expProcedure, instance);
    }

    /**
     * Test of convetToObjectArray method, of class Procedure.
     */
    @Test
    public void testConvetToObjectArray() {
        System.out.println("convetToObjectArray");
        Integer expInt = 1000;
        String expTitle = "Procedure";
         String expDescritpion = "MyDescription";
        instance.setDescription(expDescritpion);
        instance.setId(expInt);
        instance.setTitle(expTitle);
        Object[] expResult = {1000,"Procedure","MyDescription"};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of convetToObjectArray method, of class Procedure.
     */
    @Test
    public void shouldConvetToObjectArrayWithAllNullIfIdAndTitleIsNotSet() {
        System.out.println("convetToObjectArray");
        Object[] expResult = {null,null,null};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of convetToObjectArray method, of class Procedure.
     */
    @Test
    public void shouldConvetToObjectArrayWithOnlyIdValue() {
        System.out.println("convetToObjectArray");
        Integer expInt = 1000;
        instance.setId(expInt);
        Object[] expResult = {1000,null,null};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of convetToObjectArray method, of class Procedure.
     */
    @Test
    public void shouldConvetToObjectArrayWithOnlyTitleValue() {
        System.out.println("convetToObjectArray");
        String expTitle = "Procedure";
        instance.setTitle(expTitle);
        Object[] expResult = {null,"Procedure",null};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of convetToObjectArray method, of class Procedure.
     */
    @Test
    public void shouldConvetToObjectArrayWithOnlyDescriptionValue() {
        System.out.println("convetToObjectArray");
        String expDescritpion = "Procedure";
        instance.setDescription(expDescritpion);
        Object[] expResult = {null,null,"Procedure"};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }
    
}
