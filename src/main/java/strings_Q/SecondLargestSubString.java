package main.java.strings_Q;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondLargestSubString {
    public static void main(String[] args) {
        String str ="hello world in java word hello in hello java hello java practice  to practice first hello world in in";
        Map<String,Long> map =  Arrays.stream(str.split("\\s+"))// split at whiteSpaces
                .filter(s->!s.isEmpty())//filter any space if exist
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

                /* used to sort the whole map and again collect it as linkedHashMap

                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))//Comparator.reverseOrder() used to reverse the asce order into desc
                .collect(Collectors.toMap(Map.Entry::getKey // use toMap to convert stream<Entry> to required Map.
                , Map.Entry::getValue
                , (o,n)->o// use to resolve conflicts if any duplicate keys.
                , LinkedHashMap::new));// specified to return specific type if here order is imp so used LinkedHashMap

                */
        System.out.println(map);


        /* used to find 2nd highest String.
        map.entrySet().stream()
//                .filter(s->!s.getKey().isEmpty())
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);*/
        // Optimal solution:
        long highest = Long.MIN_VALUE;
        long secondHighest = Long.MIN_VALUE;
        String secondHighestString="";
        String highestString="";
        for(Map.Entry<String,Long> e: map.entrySet()){
            long value = e.getValue();
            if(value>highest){
                secondHighest = highest;
                highest = value;
                secondHighestString = highestString;
                highestString = e.getKey();

            }else if(value>secondHighest && value<highest) {
                secondHighest = value;
                secondHighestString = e.getKey();
            }
        }
        System.out.println(secondHighestString +" : "+secondHighest);

        int index = 0;
        int target = 1;//to find 2 value in map, which is not in order.
        for(Map.Entry<String,Long> e: map.entrySet()){
            if(index==target){
                System.out.println(e.getKey()+" : "+e.getValue());
                break;
            }
            index++;
        }
/* output:
{practice=2, java=3, world=2, in=4, to=1, hello=5, word=1, first=1}
in : 4
java : 3*/
    }
}
