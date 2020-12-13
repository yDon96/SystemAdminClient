/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class ParcelTest {
    
    Parcel instance;
    
    @Before
    public void setUp() {
        instance = new Parcel();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of writeString method, of class Parcel.
     */
    @Test
    public void testWriteString() {
        System.out.println("writeString");
        String string = "firstTest";
        instance.writeString(string);
        assertEquals(instance.stringList.get(0), string);
    }

    /**
     * Test of writeInteger method, of class Parcel.
     */
    @Test
    public void testWriteInteger() {
        System.out.println("writeInteger");
        Integer integer = 100;
        instance.writeInteger(integer);
        assertEquals(instance.integerList.get(0), integer);
    }

    /**
     * Test of writeStringArray method, of class Parcel.
     */
    @Test
    public void testWriteStringArray() {
        System.out.println("writeStringArray");
        String[] stringArray = {"one", "two","three"};
        instance.writeStringArray(stringArray);
        assertArrayEquals(instance.stringArrayList.get(0), stringArray);
    }
    
    /**
     * Test of writeParcel method, of class Parcel.
     */
    @Test
    public void testWriteParcel() {
        System.out.println("writeParcel");
        Parcel element = new Parcel();
        instance.writeParcel(element);
        assertEquals(instance.parcelList.get(0), element);
    }
    
    @Test
    public void shouldWriteStringEvenWithNullValue() {
        System.out.println("writeStringWithNullValue");
        String string = null;
        instance.writeString(string);
        assertEquals(instance.stringList.get(0), string);
    }

    /**
     * Test of writeInteger method, of class Parcel.
     */
    @Test
    public void shouldWriteIntegerEvenWithNullValue() {
        System.out.println("writeIntegerWithNullValue");
        Integer integer = null;
        instance.writeInteger(integer);
        assertEquals(instance.integerList.get(0), integer);
    }

    /**
     * Test of writeStringArray method, of class Parcel.
     */
    @Test
    public void shouldWriteStringArrayEvenWithNullValue() {
        System.out.println("writeStringArrayWithNullValue");
        String[] stringArray = null;
        instance.writeStringArray(stringArray);
        assertArrayEquals(instance.stringArrayList.get(0), stringArray);
    }
    
    /**
     * Test of writeParcel method, of class Parcel.
     */
    @Test
    public void shouldWriteParcelEvenWithNullValue() {
        System.out.println("writeParcelEvenWithNullValue");
        Parcel element = null;
        instance.writeParcel(element);
        assertEquals(instance.parcelList.get(0), element);
    }

    /**
     * Test of readString method, of class Parcel.
     */
    @Test
    public void testReadString() {
        System.out.println("readString");
        String expResult = "readTest";
        instance.stringList = new ArrayList<>();
        instance.stringList.add(expResult);
        String result = instance.readString();
        assertEquals(expResult, result);
    }

    /**
     * Test of readInteger method, of class Parcel.
     */
    @Test
    public void testReadInteger() {
        System.out.println("readInteger");
        Integer expResult = 200;
        instance.integerList = new ArrayList<>();
        instance.integerList.add(expResult);
        Integer result = instance.readInteger();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of readStringArray method, of class Parcel.
     */
    @Test
    public void testReadStringArray() {
        System.out.println("readStringArray");
        String[] expResult = {"one", "two","three"};
        instance.stringArrayList = new ArrayList<>();
        instance.stringArrayList.add(expResult);
        String[] result = instance.readStringArray();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of readStringArray method, of class Parcel.
     */
    @Test
    public void testReadParcel() {
        System.out.println("readParcel");
        Parcel expResult = new Parcel();
        instance.parcelList = new ArrayList<>();
        instance.parcelList.add(expResult);
        Parcel result = instance.readParcel();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of readString method, of class Parcel.
     */
    @Test
    public void shouldReturnNullReadStringIfRequiredMoreThanItsSize() {
        System.out.println("shouldReturnNullReadStringIfRequiredMoreThanItsSize");
        String element = "readTest";
        instance.stringList = new ArrayList<>();
        instance.stringList.add(element);
        instance.readString();
        String result = instance.readString();
        assertEquals(null, result);
    }

    /**
     * Test of readInteger method, of class Parcel.
     */
    @Test
    public void shouldReturnNullReadIntegerIfRequiredMoreThanItsSize() {
        System.out.println("shouldReturnNullReadIntegerIfRequiredMoreThanItsSize");
        Integer element = 200;
        instance.integerList = new ArrayList<>();
        instance.integerList.add(element);
        instance.readInteger();
        Integer result = instance.readInteger();
        assertEquals(null, result);
        
    }

    /**
     * Test of readStringArray method, of class Parcel.
     */
    @Test
    public void shouldReturnNullReadStringArrayIfRequiredMoreThanItsSize() {
        System.out.println("shouldReturnNullReadStringArrayIfRequiredMoreThanItsSize");
        String[] element = {"one", "two","three"};
        instance.stringArrayList = new ArrayList<>();
        instance.stringArrayList.add(element);
        instance.readStringArray();
        String[] nullResult = instance.readStringArray();
        assertArrayEquals(null, nullResult);
    }
    
    /**
     * Test of readParcel read method, of class Parcel.
     */
    @Test
    public void shouldReturnNullReadParcelIfRequiredMoreThanItsSize() {
        System.out.println("shouldReturnNullReadParcelIfRequiredMoreThanItsSize");
        Parcel element = new Parcel();
        instance.parcelList = new ArrayList<>();
        instance.parcelList.add(element);
        instance.readParcel();
        Parcel nullResult = instance.readParcel();
        assertEquals(null, nullResult);
    }
    
    /**
     * Test of readString method, of class Parcel.
     */
    @Test
    public void shouldReturnNullReadStringUseANotInstancieteArrayList() {
        System.out.println("shouldReturnNullReadStringUseANotInstancieteArrayList");
        String result = instance.readString();
        assertEquals(null, result);
    }

    /**
     * Test of readInteger method, of class Parcel.
     */
    @Test
    public void shouldReturnNullReadIntegerUseANotInstancieteArrayList() {
        System.out.println("shouldReturnNullReadIntegerUseANotInstancieteArrayList");
        Integer result = instance.readInteger();
        assertEquals(null, result);
        
    }

    /**
     * Test of readStringArray method, of class Parcel.
     */
    @Test
    public void shouldReturnNullReadStringArrayUseANotInstancieteArrayList() {
        System.out.println("shouldReturnNullReadStringArrayUseANotInstancieteArrayList");
        String[] nullResult = instance.readStringArray();
        assertArrayEquals(null, nullResult);
    }
    
    /**
     * Test of readParcel method, of class Parcel.
     */
    @Test
    public void shouldReturnNullReadParcelUseANotInstancieteArrayList() {
        System.out.println("shouldReturnNullReadSParcelUseANotInstancieteArrayList");
        Parcel nullResult = instance.readParcel();
        assertEquals(null, nullResult);
    }
    
}
