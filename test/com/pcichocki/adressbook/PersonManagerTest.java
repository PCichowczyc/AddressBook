package com.pcichocki.adressbook;

import com.pcichocki.adressbook.exceptions.PersonNotUniqueException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonManagerTest {

    private List<Person> persons;

    private Person person;
    private Person person1;
    private Person person2;
    private Person person3;
    private Date date;
    private Date date1;
    private Date date2;
    private Date date3;
    private PersonManager personManager = new PersonManager();

    @Before
    public void setup() throws PersonNotUniqueException {


        person = new Person();
        person1 = new Person();
        person2 = new Person();
        person3 = new Person();

        date = new Date(2000,12,10);
        date1 = new Date(1989,01,05);
        date2 = new Date(1994,10,23);
        date3 = new Date(1984,9,01);

        person.setName("Władek");
        person.setSurname("Bąkowski");
        person.setBirthDay(date);
        person.setPhoneNumber("506-540-342");

        person1.setName("Elżbieta");
        person1.setSurname("Kalinowska");
        person1.setBirthDay(date1);
        person1.setPhoneNumber("606-240-442");

        person2.setName("Włodzimierz");
        person2.setSurname("Szaranowicz");
        person2.setBirthDay(date2);
        person2.setPhoneNumber("456-123-392");

        person3.setName("Adam");
        person3.setSurname("Gaworski");
        person3.setBirthDay(date3);
        person3.setPhoneNumber("256-723-122");

        personManager.addPerson(person);
        personManager.addPerson(person1);
        personManager.addPerson(person2);

    }

    @Test
    public void addPersonShouldAddPersonIntoTheList() throws PersonNotUniqueException {
        int before = personManager.persons.size();
        personManager.addPerson(person3);
        int after = personManager.persons.size();
        Assert.assertEquals(after, before+1);
    }





}