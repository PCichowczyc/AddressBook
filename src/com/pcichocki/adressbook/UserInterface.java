package com.pcichocki.adressbook;

import com.pcichocki.adressbook.exceptions.PersonNotFoundException;
import com.pcichocki.adressbook.exceptions.PersonNotUniqueException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterface {

    Scanner input = new Scanner(System.in);
    PersonManager personService = new PersonManager();
    int inValue;


    public static void main(String[] args) {
        new UserInterface();
    }

    public  Integer inputValue() {
        boolean valid = false;
        do {
            if (input.hasNextInt()) {
                inValue = input.nextInt();
                valid = true;
            } else {
                System.out.println("Please input a correct value.");
                input.next();
            }
        }
        while (valid == false);
        return inValue;
    }

    public  void showPersons() {

        List<Person> persons = personService.getAllPersons();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < persons.size(); i++) {

            sb.append(persons.get(i).getName().toString() + " " + persons.get(i).getSurname().toString() + " " + persons.get(i).getPhoneNumber().toString() + "\n");
        }
        System.out.println(sb);
    }

    public  void sortList() {
        do {
            System.out.println("Choose your LIST sorting option ...");
            System.out.println("1. by Name");
            System.out.println("2. by Surname");
            System.out.println("3. by Birthdate");
            System.out.println("4. go back");

            inputValue();

            if (inValue == 1) {
                personService.getSortedByName();
                inValue = 4;
            } else if (inValue == 2) {
                System.out.println("Sorting by Surname...");
                personService.getSortedBySurname();
                inValue = 4;
            } else if (inValue == 3) {
                System.out.println("Sorting by date of birth...");
                personService.getSortedByBirthDay();
                inValue = 4;
            } else if (inValue == 4) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Something wrong... try again");
            }
        } while (inValue != 4);
    }

    public  void deletePerson() {

        Scanner getUserInput = new Scanner(System.in);
        Person person = new Person();
        System.out.println("Which  person would you like to delete?");
        System.out.println("Insert name:");
        person.setName(getUserInput.nextLine());
        System.out.println("Insert surname:");
        person.setSurname(getUserInput.nextLine());
        do
        {
            System.out.println("Person date of birth (in yyyy.MM.dd format): ");
            person.setBirthDay(birthDateChecker(getUserInput.nextLine()));
        }
        while (person.getBirthDay() == null);
        do {
            System.out.println("Person phone number (in 000-000-000 format): ");
            person.setPhoneNumber(phoneNumberChecker(getUserInput.nextLine()));

        } while (person.getPhoneNumber() == null);;

        try{
            personService.deletePerson(person);
        }
        catch (PersonNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public String phoneNumberChecker(String phoneNumber)
    {
        Pattern phoneFormat = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{3}");
        String phone = null;
        if (phoneFormat.matcher(phoneNumber).matches()) {
            phone = phoneNumber;
        }
        return phone;
    }


    public Date birthDateChecker(String birthDate) {
        //date of bd
        Pattern dateFormat = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date date = null;
        if (dateFormat.matcher(birthDate).matches()) {
            try {
                date = sdf.parse(birthDate);
            } catch (ParseException e) {
                e.getMessage();
            }
        }
        return date;
    }

//TODO dopisać dodawanie adresu do persony
    public void addPerson() {

        Person person = new Person();
        Scanner getUserInput = new Scanner(System.in);

        // name
        System.out.println("Person name:");
        person.setName(getUserInput.nextLine());

        //surname
        System.out.println("Person surname:");
        person.setSurname(getUserInput.nextLine());

        //date of bd
        do
        {
            System.out.println("Person date of birth (in yyyy.MM.dd format): ");
            person.setBirthDay(birthDateChecker(getUserInput.nextLine()));
        }
        while (person.getBirthDay() == null);

        //phone number
        do {
            System.out.println("Person phone number (in 000-000-000 format): ");
            person.setPhoneNumber(phoneNumberChecker(getUserInput.nextLine()));

        } while (person.getPhoneNumber() == null);

        try {
            personService.addPerson(person);
        }
        catch (PersonNotUniqueException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public UserInterface() {
        do {
            // Display menu graphics
            System.out.println("===============================");
            System.out.println("|        Adress Book Menu     |");
            System.out.println("===============================");
            System.out.println("| Options:                    |");
            System.out.println("|        1. Add Person        |");
            System.out.println("|        2. Show Persons      |");
            System.out.println("|        3. Delete Person     |");
            System.out.println("|        4. Sort List by...   |");
            System.out.println("|        5. Exit              |");
            System.out.println("===============================");
            System.out.println("Select option: ");
            inputValue();

            if (inValue == 1) {
                System.out.println("Adding person ...");
                addPerson();
            } else if (inValue == 2) {
                System.out.println("Showing Persons...");
                showPersons();
            } else if (inValue == 3) {
                System.out.println("Deleting person...");
                deletePerson();
            } else if (inValue == 4) {
                System.out.println("Sorting...");
                sortList();
            } else if (inValue == 5) {
                System.out.println("Closing application...");
                break;
            } else {
                System.out.println("Something wrong... try again");
            }
        } while (inValue != 5);
    }
}

