package main.java.streams_Q;

import com.sun.source.doctree.EndElementTree;

import java.util.*;
import java.util.stream.Collectors;

public class IntermediateOpt {
    public static void main(String[] args) {
        List<String> list = List.of("apple","banana","mango","grapes","papaya","kiwi","apricot");
        list.stream()
                .filter(x->x.length()<=5) // intermediate opt
                .forEach(System.out::println);// print all fruits length less or equal 5
//print len of each fruit
        /*list.stream()
                .map(String::length)
                .forEach(System.out::println);
        */
        List<Fruit> fruits = List.of(new Fruit("apple",12,5)
                ,new Fruit("banana",6,30)
                ,new Fruit("mango",3,60)
                ,new Fruit("grapes",2,45)
                ,new Fruit("papaya",4,30)
                ,new Fruit("apricot",8,12)
                ,new Fruit("kiwi",16,15));

        //fruits.forEach(System.out::println);

        System.out.println("print fruits cost less than 150");
        fruits.stream()
                .filter(x->x.getQuantity()* x.getPrice()<150)
                .forEach(System.out::println);

        List<String> fruitsNames = fruits.stream()
                .filter(x->x.getQuantity()* x.getPrice()>=150)
                .map(Fruit::getFruitName)
//                .toList();
                .collect(Collectors.toList());//both toList can be used
        System.out.println(STR."List of fruits cost >150 : \{fruitsNames}");

        List<String> sortedByPrice = fruits.stream()
                .sorted(Comparator.comparing(Fruit::getPrice).reversed())
                .map(Fruit::getFruitName)
                .toList();
        System.out.println("DSC list "+sortedByPrice);
        List<String> sortedByPriceAsc = fruits.stream()
                .sorted(Comparator.comparing(Fruit::getPrice))
                .map(Fruit::getFruitName)
                .toList();
        System.out.println("ASC list "+sortedByPriceAsc);

        List<String> sortedByTotalPrice = fruits.stream()
                .sorted(Comparator.comparing(fruit -> fruit.getPrice()*fruit.getQuantity()))
                .map(Fruit::getFruitName)
                .toList();
        System.out.println(sortedByTotalPrice);
        List<String> sortedByTotalPriceDSC = fruits.stream()
                .sorted(Comparator.comparing(fruit -> fruit.getPrice()*fruit.getQuantity(),
                        Comparator.reverseOrder()))
                .map(Fruit::getFruitName)
                .toList();
        System.out.println(sortedByTotalPriceDSC);

        Map<String,Double> sortedByTotalPriceMap = fruits.stream()
                .sorted(Comparator.comparing(fruit -> fruit.getPrice()*fruit.getQuantity()))
                .collect(Collectors.toMap(Fruit::getFruitName
                        ,fruit -> fruit.getPrice()*fruit.getQuantity()
                        ,(e,n)->e, LinkedHashMap::new
                        ));
        System.out.println(sortedByTotalPriceMap);
        Map<String,Double> sortedByTotalPriceMapDSC = fruits.stream()
                .sorted(Comparator.comparing(fruit -> fruit.getPrice()*fruit.getQuantity(),Comparator.reverseOrder()))
                .collect(Collectors.toMap(Fruit::getFruitName
                        ,fruit -> fruit.getPrice()*fruit.getQuantity()
                        ,(e,n)->e, LinkedHashMap::new
                ));
        System.out.println(sortedByTotalPriceMapDSC);
        //write code if price same then compare names
        Map<String,Double> withSecondaryCompare2 = fruits.stream()
                .collect(Collectors.toMap(Fruit::getFruitName,
                        fruit -> fruit.getPrice()* fruit.getQuantity()))
                .entrySet().stream()
                .sorted(Map.Entry.<String,Double>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey
                        ,Map.Entry::getValue
                        ,(e,n)->e,LinkedHashMap::new));
        System.out.println("DSC key in asc "+withSecondaryCompare2);
        Map<String,Double> withSecondaryCompare = fruits.stream()
                .collect(Collectors.toMap(Fruit::getFruitName,
                        fruit -> fruit.getPrice()* fruit.getQuantity()))
                .entrySet().stream()
                .sorted(Map.Entry.<String,Double>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
                .collect(Collectors.toMap(Map.Entry::getKey
                        ,Map.Entry::getValue
                        ,(e,n)->e,LinkedHashMap::new));
        System.out.println("DSC key in dsc "+withSecondaryCompare);
        Map<String,Double> withSecondaryCompareASC = fruits.stream()
                        .collect(Collectors.toMap(Fruit::getFruitName
                                ,x->x.getQuantity()*x.getPrice()))
                                .entrySet().stream()
                        .sorted(Map.Entry.<String,Double>comparingByValue()
                                .thenComparing(Map.Entry.comparingByKey()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey
                                ,Map.Entry::getValue
                                ,(e,n)->e
                                ,LinkedHashMap::new));
        System.out.println("ASC "+withSecondaryCompareASC);
    }

}
class Fruit{
    private final String fruitName;
    private final long quantity;
    private final double price;

    public Fruit(String fruitName, long quantity, double price) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getFruitName() {
        return fruitName;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fruitName='" + fruitName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}