package main.java.dsa150q;


import java.util.*;
import java.util.stream.Collectors;

public class KFrequent {
    public static void main(String[] args) {
        int[] array = {1,1,3,2,4,2,1,5};
//        int[] array = {1};
        int k = 2;
        HashMap<Integer,Integer> feq = new HashMap<>();
        for(int i:array)
            feq.put(i,feq.getOrDefault(i,0)+1);

//        Using streams which costs time and memory where it create intermediate objects/boxing/unboxing sorting entire dataset.
        int[] result = feq.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();//return array
//                .forEach(e-> System.out.println(e.getKey()));//prints the values
        System.out.println(Arrays.toString(result));

        // Using bucket sorting optimistic
        HashMap<Integer,List<Integer>> occ = new HashMap<>();
        int maxFreq = 0;
        for(Map.Entry<Integer,Integer> e : feq.entrySet()){
            occ.computeIfAbsent(e.getValue(), x->new ArrayList<>())
                    .add(e.getKey());
            maxFreq = Math.max(maxFreq,e.getValue());
            /*List<Integer> exist = new ArrayList<>();
            if(occ.containsKey(e.getValue())) {
                exist = occ.get(e.getValue());
                exist.add(e.getKey());
                occ.put(e.getValue(), exist);
            }else {
                exist.add(e.getKey());
                occ.put(e.getValue(), exist);
            }
            if(e.getValue()>maxFreq)
                maxFreq = e.getValue();*/
        }
        System.out.println(occ);
        int index=0;
        int[] output = new int[k];
        while(maxFreq>0&& index<k){
            if(occ.containsKey(maxFreq)){
                for(int num : occ.get(maxFreq)){
                    if(index<k)
                        output[index++]=num;
                }
            }
            maxFreq--;
        }
        System.out.println(Arrays.toString(output));


        //Using PriorityQueue to fetch K frequent numbers;
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        /*PriorityQueue has head which stores smallest value
        and remaining may not in sorted
        priorityQueue.offer() insert value into queue.
        .poll() will remove at head, Once value is removed then it auto adjust and reassign smallest value at head position.
        */
        System.out.println("*************** Queue *********");
        System.out.println(pq);
        for(Map.Entry<Integer,Integer> e : feq.entrySet()){
            pq.offer(e);
            if(pq.size()>k){
                pq.poll();
            }
        }
        System.out.println(pq);
        int i=0;
        int[] res = new int[k];
        while(!pq.isEmpty()){
            res[i++] =pq.poll().getKey();
        }
        System.out.println(Arrays.toString(res));
    }
    /*output
    [1, 2]
    {1=[3, 4, 5], 2=[2], 3=[1]}
    [1, 2]
    *************** Queue *********
    []
    [2=2, 1=3]
    [2, 1]
    * */
}
