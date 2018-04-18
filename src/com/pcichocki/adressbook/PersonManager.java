package com.pcichocki.adressbook;

import com.pcichocki.adressbook.exceptions.PersonNotFoundException;
import com.pcichocki.adressbook.exceptions.PersonNotUniqueException;

import java.util.*;


public class PersonManager {

    List<Person> persons = new ArrayList<Person>();


    public List<Person> getAllPersons ()
    {
        return persons;
    }

    public List<Person> getSortedByName()
    {
        Collections.sort(persons, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return persons;
    }
    public List<Person> getSortedBySurname()
    {
        Collections.sort(persons, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        return persons;
    }
    public List<Person> getSortedByBirthDay()
    {
        Collections.sort(persons, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getBirthDay().compareTo(o2.getBirthDay());
            }
        });
        return persons;
    }


    public Person addPerson(Person person) throws PersonNotUniqueException
    {

        if (persons.contains(person)) {
            throw new PersonNotUniqueException("Person already exists.");
        }
        else persons.add(person);


        return person;
    }

    public Person deletePerson(Person person) throws PersonNotFoundException
    {

        if (persons.contains(person))
        {
            persons.remove(person);
        }
        else
        {
            throw new PersonNotFoundException("Person doesn't exists");
        }

        return person;
    }


}
