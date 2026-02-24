package interview_coding.streamsQnA;

import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

public class StreamsDemo {
    public static void main(String[] args) {
        EmployeeData.employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);

//        get sum of all emp
        double sum = EmployeeData.employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(sum);
        double sum2 = EmployeeData.employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0,Double::sum);
        System.out.println(sum2);

        Optional<Double> secondHighestSalary = EmployeeData.employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(4)
                .findFirst();
        System.out.println(secondHighestSalary.orElse(0.0));

//        get max

        Double maxValue = EmployeeData.employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::max);
        System.out.println("maxvalue: "+maxValue);
        OptionalDouble maxValue_2 = EmployeeData.employees.stream()
                .mapToDouble(Employee::getSalary)
                .max();
        System.out.println("maxvalue2: "+maxValue_2.orElse(0.0));

        EmployeeData.employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getDepartment))
                .skip(2)
                .limit(5)
                .forEach(System.out::println);

    }
}
