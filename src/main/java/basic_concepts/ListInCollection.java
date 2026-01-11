package main.java.basic_concepts;

import java.util.ArrayList;
import java.util.List;

public class ListInCollection {
    /*
    * List created with new key word is mutable
    * List created with List.of is immutable
    * */
    public static void main(String[] args) {
        List<String> immutableList = List.of("AP","TS","MP","BR");

        List<String> mutableList = new ArrayList<>();
        mutableList.add("mohan");
        mutableList.add("vishnu");
        mutableList.add("rakesh");
        System.out.println(mutableList);
        mutableList.add("new_name");
        System.out.println(mutableList);
        System.out.println(immutableList);
//        immutableList.add("TN");// can not be performed
//        System.out.println(immutableList);
    }

}
