package com.qeer.entity;

import java.util.Comparator;

public class Compare implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int i=0;
        if(o1.getAge()<o2.getAge()){
            i=1;
            System.out.println("haha"+i);
        }
        return i;
    }

}
