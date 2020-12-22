package com.AdvanceAlgoProject;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicProgrammingApproach {
    public static void findLis(ArrayList<Integer> list) {


        if (list.size() == 0)
            return;

        ArrayList<Integer> sequence = new ArrayList<>();

        int length = 1;


        sequence.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {

//            int b = 0,e = 0 + length
            int lower_bound_index = Math.abs(Arrays.binarySearch(sequence.toArray(), 0, length, list.get(i))) - 1;
            if (lower_bound_index == 0 + length)
                sequence.add(length++, list.get(i));
            else
                sequence.set(lower_bound_index, list.get(i));
        }
        System.out.println("Largest common subsequence is of Length: " + sequence.size());
    }

    public static void main(String[] args) {

        ArrayList<Integer> sequence = new ArrayList<Integer>(Arrays.asList(10, 22, 9, 33, 21, 50, 41, 60));
        findLis(sequence);


    }
}
