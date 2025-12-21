package main.java.dsa150q;

import java.util.Arrays;

public class CountArray_Q {
    public static void main(String[] args) {
//        countArrayForString("Ardhamaindharaja");
//        countArrayForNums(new int[]{9, 8, 4, 8, 6, 4, 7, 3, 8, 6, 4});
//        countArrayForNums(new int[]{2,3,5});
        countArrayForSorting(new int[]{9, 2, 8, 6, 4, 7, 3, 1, 6, 5});
    }
    public static void countArrayForNums(int[] array){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i: array){
            if(min>i) min=i;
            if(max<i) max=i;
        }
        int[] count = new int[max-min+1];
        for(int i: array){
            count[i-min]++;
        }
        System.out.println(Arrays.toString(count));

//*****************  To find max and 2nd max and least and 2nd least *********************
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        int firstMinNum = 0, secondMinNum = 0;
        int firstMaxNum = 0, secondMaxNum = 0;

//        To get max and 2nd max
        for(int i=0;i<count.length;i++){
            if(count[i]==0) continue;
            int freq = count[i];
            int value = i+min;
            if(freq>firstMax){
                secondMax = firstMax;
                secondMaxNum = firstMaxNum;

                firstMax = freq;
                firstMaxNum = value;
            }else if(freq > secondMax && freq<firstMax) {
                secondMax = freq;
                secondMaxNum = value;
            }
        }
        System.out.println("fist and second max "+firstMaxNum+" : "+secondMaxNum);

        for(int i=0;i<count.length;i++){
            if(count[i]==0) continue;
            int freq = count[i];
            int value = min+i;
            if(freq<firstMin){
                secondMin = firstMin;
                secondMinNum = firstMinNum;

                firstMin = freq;
                firstMinNum = value;
            }else if(freq > firstMin && freq < secondMin){
                secondMin = freq;
                secondMinNum = value;
            }
        }
        System.out.println("fist and second min "+firstMinNum+" : "+secondMinNum);

        /*output:
             3, 4, 5, 6, 7, 8, 9 distinct elements from array
            [1, 3, 0, 2, 1, 3, 1]  there counts
            fist and second max 4 : 6
            fist and second min 3 : 6 */
    }
    public static void countArrayForString(String str){

        str = str.toLowerCase();
        int[] count = new int[26];

        for(char c: str.toCharArray()){
            count[c-'a']++;
        }
        System.out.println(Arrays.toString(count));


        //To find least and 2nd least value;
        // To find max and 2nd max < with > and vise versa and change first and second to Integer.MIN_VALUE
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        char firstChar =' ';
        char secondChar = ' ';
        for(int i=0;i<count.length;i++) {
            if(count[i]==0) continue;
            if (count[i] < first){
                second = first;
                secondChar = firstChar;

                first = count[i];
                firstChar = (char) (i+'a');
            }else if (count[i]< second && count[i] > first) {
                second=count[i];
                secondChar = (char)(i+'a');
            }
        }
        System.out.println(firstChar);
        System.out.println(secondChar);
        /*OutPut for least ele counts
             a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
            [6, 0, 0, 2, 0, 0, 0, 2, 1, 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0]
            least and 2nd least
            i
            d */

    }

    public static void countArrayForSorting(int[] array){
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        for(int i:array){
            if(i>max) max = i;
            if(i<min) min = i;
        }
        int[] count = new int[max-min+1];

        for(int i: array){
            count[i-min]++;
        }
        int k=0;
        for(int i=0;i<count.length;i++){
            if(count[i]==0) continue;
            for(int j = count[i] ; j > 0 ; j--) {
                array[k] = i + min;
                k++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
