package com.pcichocki.adressbook;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person;
    private Date date;

    @Before
    public void setup()
    {
        date = new Date(2000,12,10);
        person = new Person();
        person.setName("Władek");
        person.setSurname("Bąkowski");
        person.setBirthDay(date);
        person.setPhoneNumber("506-540-342");
    }
    @Test
    public void setPersonNameTest()
    {
        String result = person.getName();
        assertNotNull(result);
        assertEquals("Władek",result);
    }
    @Test
    public void setPersonSurnameTest()
    {
        String result = person.getSurname();
        assertNotNull(result);
        assertEquals("Bąkowski",result);
    }
    @Test
    public void setPersonBirthDateTest()
    {
        Date result = person.getBirthDay();
        assertNotNull(result);
        assertEquals(date,result);
    }
    @Test
    public void setPersonPhoneNumberTest()
    {
        String result = person.getPhoneNumber();
        assertNotNull(result);
        assertEquals("506-540-342",result);
    }

}