package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        int [][] arr1 = {{1,2,3,1},
                        {4,5,6,4},
                        {7,8,9,7},
                        {7,8,9,7}};

        for (int i = 0; i < arr1.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < arr1.length; j++) {
                temp.add(arr1 [i] [j]);
            }
            list.add(temp);
        }

        

        List<Integer> recursion = recursion(list);
        recursion.toArray();
        recursion.forEach(System.out::print);

    }

    public static List<Integer> recursion(List<List<Integer>> list) {
        List<Integer> result = new ArrayList<>();
        if (list.isEmpty()) {
            return result;
        }

        for (int i = 0; i < list.size() ; i++) {
            result.add(list.get(0).get(i));

        }

        for (int i = 1; i < list.size(); i++) {           //{{1,2,3,1},
            result.add(list.get(i).get(list.size()-1));   //{4,5,6,4},
        }                                                 //{7,8,9,7},
                                                          //{7,8,9,7}};
        for (int i = list.size() -2; i >= 0; i--) {
            result.add(list.get(list.size() -1).get(i));
        }

        for (int i = list.size() -2; i > 0; i--) {
            result.add(list.get(i).get(0));
        }

        List<List<Integer>>  sublist = new ArrayList<>();
        for (int i =1; i < list.size()-1; i++) {
            sublist.add(list.get(i).subList(1,list.size()-1));
        }

        result.addAll(recursion(sublist));

        return result;

    }
}
