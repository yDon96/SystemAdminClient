/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class UserTest {

    private User instance;

    @Before
    public void setUp() {
        instance = new User();
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
        instance.userId = 5;
        Integer result = instance.getUser_id();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Procedure.
     */
    @Test
    public void shouldGetIdNullIfNotSet() {
        System.out.println("getId");
        Integer expResult = null;
        Integer result = instance.getUser_id();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Procedure.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = 5;
        instance.setUser_id(id);
        assertEquals(id, instance.userId);
    }

    /**
     * Test of setId method, of class Procedure.
     */
    @Test
    public void shouldSetIdNullIfNullIsGiven() {
        System.out.println("setId");
        Integer id = null;
        instance.setUser_id(id);
        assertEquals(id, instance.userId);
    }

    /**
     * Test of getDob method, of class User.
     */
    @Test
    public void testGetDob() {
        System.out.println("getDob");
        LocalDate localDate = LocalDate.now();
        instance.dateOfBirth = localDate;
        LocalDate result = instance.getDob();
        assertEquals(localDate, result);
    }

    /**
     * Test of getDobString method, of class User.
     */
    @Test
    public void testGetDobString() {
        System.out.println("getDobString");
        LocalDate localDate = LocalDate.now();
        instance.dateOfBirth = localDate;
        String expResult = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String result = instance.getDobString();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDob method, of class User.
     */
    @Test
    public void testSetDob() {
        System.out.println("setDob");
        LocalDate localDate = LocalDate.now();
        instance.setDob(localDate);
        assertEquals(localDate, instance.dateOfBirth);
    }

    /**
     * Test of SetName method, of class Procedure.
     */
    @Test
    public void testSetName() {
        System.out.println("setTitle");
        String title = "Mario";
        instance.setName(title);
        assertEquals(title, instance.name);

    }

    /**
     * Test of SetName method, of class Procedure.
     */
    @Test
    public void shouldSetNameNullIfNullIsGiven() {
        System.out.println("setTitle");
        String title = null;
        instance.setName(title);
        assertEquals(title, instance.name);
    }

    /**
     * Test of GetName method, of class Procedure.
     */
    @Test
    public void testGetName() {
        System.out.println("getTitle");
        String expResult = "Mario";
        instance.name = expResult;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetName method, of class Procedure.
     */
    @Test
    public void shouldGetNameNullIfNotSet() {
        System.out.println("getTitle");
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetSurname method, of class Procedure.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setTitle");
        String title = "Mario";
        instance.setSurname(title);
        assertEquals(title, instance.surname);

    }

    /**
     * Test of SetSurname method, of class Procedure.
     */
    @Test
    public void shouldSetSurnameNullIfNullIsGiven() {
        System.out.println("setTitle");
        String title = null;
        instance.setSurname(title);
        assertEquals(title, instance.surname);
    }

    /**
     * Test of GetSurname method, of class Procedure.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getTitle");
        String expResult = "Mario";
        instance.surname = expResult;
        String result = instance.getSurname();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetSurname method, of class Procedure.
     */
    @Test
    public void shouldGetSurnameNullIfNotSet() {
        System.out.println("getTitle");
        String expResult = null;
        String result = instance.getSurname();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRole method, of class User.
     */
    @Test
    public void testSetRole() {
        System.out.println("setTitle");
        String role = "Mario";
        instance.setRole(role);
        assertEquals(role, instance.role);

    }

    /**
     * Test of setRole method, of class Procedure.
     */
    @Test
    public void shouldSetRoleNullIfNullIsGiven() {
        System.out.println("setTitle");
        String role = null;
        instance.setRole(role);
        assertEquals(role, instance.role);
    }

    /**
     * Test of GetRole method, of class Procedure.
     */
    @Test
    public void testGetRole() {
        System.out.println("getTitle");
        String expResult = "Mario";
        instance.role = expResult;
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetRole method, of class Procedure.
     */
    @Test
    public void shouldGetRoleNullIfNotSet() {
        System.out.println("getTitle");
        String expResult = null;
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Procedure.
     */
    @Test
    public void testSetCompetencies() {
        System.out.println("setTitle");
        Set<String> competencies = new HashSet<>(Arrays.asList("MyDescription", "MyDescription", "MyDescription", "MyDescription"));;
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
     * Test of getTitle method, of class Procedure.
     */
    @Test
    public void testGetCompetencies() {
        System.out.println("getTitle");
        Set<String> competencies = new HashSet<>(Arrays.asList("MyDescription", "MyDescription", "MyDescription", "MyDescription"));;
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
     * Test of getParcelableDescription method, of class User.
     */
    @Test
    public void testGetParcelableDescription() {
        System.out.println("getParcelableDescription");
        String expResult = "User";
        String result = instance.getParcelableDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of convertToParcel method, of class User.
     */
    @Test
    public void testConvertToParcel() {
        System.out.println("convertToParcel");
        Integer expInt = 1000;
        String expTitle = "User";
        String expDescription = "MyDescription";
        String expRole = "MyRole";
        Set<String> competencies = new HashSet<>(Arrays.asList("MyDescription1", "MyDescription2", "MyDescription3", "MyDescription4"));
        instance.setUser_id(expInt);
        instance.setName(expTitle);
        instance.setSurname(expDescription);
        instance.setRole(expRole);
        instance.setCompetencies(competencies);
        Parcel result = instance.convertToParcel();
        assertEquals(expInt, result.readInteger());
        assertEquals(expTitle, result.readString());
        assertEquals(expDescription, result.readString());
        assertEquals(null, result.readString());
        assertEquals(expRole, result.readString());
        assertArrayEquals(competencies.toArray(new String[competencies.size()]), result.readStringArray());
    }

    /**
     * Test of createFromParcel method, of class User.
     */
    @Test
    public void testCreateFromParcel() {
        System.out.println("createFromParcel");
        Parcel parcel = new Parcel();
        User expUser = new User();
        Integer expInt = 2000;
        String expTitle = "User";
        String expDescription = "MyDescription";
        String expRole = "MyRole";
        Set<String> competencies = new HashSet<>(Arrays.asList("MyDescription", "MyDescription", "MyDescription", "MyDescription"));
        expUser.setUser_id(expInt);
        expUser.setName(expTitle);
        expUser.setSurname(expDescription);
        expUser.setCompetencies(competencies);
        expUser.setRole(expRole);
        parcel.writeInteger(expInt);
        parcel.writeString(expTitle);
        parcel.writeString(expDescription);
        parcel.writeString(null);
        parcel.writeString(expRole);
        parcel.writeStringArray(new String[]{"MyDescription", "MyDescription", "MyDescription", "MyDescription"});
        instance.createFromParcel(parcel);
        assertEquals(expUser, instance);
    }

    /**
     * Test of convetToObjectArray method, of class User.
     */
    @Test
    public void testConvetToObjectArray() {
        System.out.println("convetToObjectArray");
        Integer expInt = 1000;
        String expTitle = "User";
        String expDescritpion = "MyDescription";
        String expRole = "Role";
        LocalDate localDate = LocalDate.now();
        instance.setSurname(expDescritpion);
        instance.setUser_id(expInt);
        instance.setName(expTitle);
        instance.setDob(localDate);
        instance.setRole(expRole);
        Object[] expResult = {1000, "User", "MyDescription", localDate.format(DateTimeFormatter.ISO_DATE), "Role"};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of convetToObjectArray method, of class User.
     */
    @Test
    public void shouldConvetToObjectArrayWithAllNullIfIdAndNameIsNotSet() {
        System.out.println("convetToObjectArray");
        Object[] expResult = {null, null, null, null, null};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of convetToObjectArray method, of class User.
     */
    @Test
    public void shouldConvetToObjectArrayWithOnlyIdValue() {
        System.out.println("convetToObjectArray");
        Integer expInt = 1000;
        instance.setUser_id(expInt);
        Object[] expResult = {1000, null, null, null, null};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of convetToObjectArray method, of class User.
     */
    @Test
    public void shouldConvetToObjectArrayWithOnlyNameValue() {
        System.out.println("convetToObjectArray");
        String expName = "UserName";
        instance.setName(expName);
        Object[] expResult = {null, "UserName", null, null, null};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of convetToObjectArray method, of class User.
     */
    @Test
    public void shouldConvetToObjectArrayWithOnlySurnameValue() {
        System.out.println("convetToObjectArray");
        String expDescritpion = "User";
        instance.setSurname(expDescritpion);
        Object[] expResult = {null, null, "User", null, null};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of convetToObjectArray method, of class User.
     */
    @Test
    public void shouldConvetToObjectArrayWithOnlyLocalDateValue() {
        System.out.println("convetToObjectArray");
        LocalDate localDate = LocalDate.now();
        instance.setDob(localDate);
        Object[] expResult = {null, null, null, localDate.format(DateTimeFormatter.ISO_DATE), null};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of convetToObjectArray method, of class User.
     */
    @Test
    public void shouldConvetToObjectArrayWithOnlyRoleValue() {
        System.out.println("convetToObjectArray");
        String expRole = "Role";
        instance.setRole(expRole);
        Object[] expResult = {null, null, null, null, "Role"};
        Object[] result = instance.convetToObjectArray();
        assertArrayEquals(expResult, result);
    }

}
