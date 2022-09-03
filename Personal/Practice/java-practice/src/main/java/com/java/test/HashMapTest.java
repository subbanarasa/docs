package com.java.test;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapTest {

    public static void main(String[] args) {

        Map<com.java.test.Employee, String> map = new HashMap<>();
        Employee emp1 = new Employee(1,"hello1");
        Employee emp2 = new Employee(1,"hello2");
        Employee emp3;
        map.put(emp1, "hello1");
        map.put(emp2, "hello2");
        emp3 = emp1;
        System.out.println(map.size());
        System.out.println(map.get(emp3));

       /* List<Integer> list = Arrays.asList(1,2,3,4,5);

        List<Integer>  finalList  = list.stream().map(i -> i*5).collect(Collectors.toList());
        System.out.println(finalList);*/

    }
}
