package com.qeer.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.qeer.entity.NewPerson;
import com.qeer.entity.Person;

public class LambdaUtils {

    public static String[] getStrings() {
        String[] str = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro" };

        return str;
    }

    public static List<String> getStringList() {
        return (List<String>) Arrays.asList(getStrings());
    }

    public static List<NewPerson> getListJavaPerson() {
        List<NewPerson> list = new ArrayList<NewPerson>() {
            {
                add(new NewPerson("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new NewPerson("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new NewPerson("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new NewPerson("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new NewPerson("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new NewPerson("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new NewPerson("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new NewPerson("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new NewPerson("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new NewPerson("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        return list;
    }

    public static List<NewPerson> getListPHPPerson() {
        List<NewPerson> list = new ArrayList<NewPerson>() {
            {
                add(new NewPerson("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new NewPerson("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new NewPerson("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new NewPerson("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new NewPerson("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new NewPerson("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new NewPerson("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new NewPerson("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new NewPerson("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new NewPerson("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };
        return list;
    }
}
