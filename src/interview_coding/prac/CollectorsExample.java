package interview_coding.prac;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {

        // Sample employee list
        List<Employee> employees = Arrays.asList(
            new Employee("IT","Alice", 5000),
            new Employee("Feature","Bob", 9000),
            new Employee("Feature","Charlie", 15000),
            new Employee("Feature","Chandu", 7000),
            new Employee("IT","Rakesh", 9000),
            new Employee("NON-IT","Rakesh", 6000),
            new Employee("NON-IT","Suresh", 8000),
            new Employee("NON-IT","Mahesh", 7000),
            new Employee("IT","David", 8000)
        );
//        // 1. Collect to List
//        List<Employee> list = employees.stream()
//                .collect(Collectors.toList());
//        System.out.println("List of employees: " + list);
//
//        // 2. Collect to Set
//        Set<Employee> set = employees.stream()
//                .collect(Collectors.toSet());
//        System.out.println("Set of employees: " + set);
//
//        // 3. Grouping by salary
//        Map<Double, List<Employee>> groupBySalary = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getSalary));
//        System.out.println("Group by salary: " + groupBySalary);
//
//        // 4. Counting employees by salary
//        Map<Double, Long> countBySalary = employees.stream().collect(Collectors.groupingBy(Employee::getSalary,
//                Collectors.counting()));
//        System.out.println("Count by salary: " + countBySalary);
//
//        // 5. Averaging salary
//        double avgSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
//        System.out.println("Average salary: " + avgSalary);
//
//        // 6. Summing salaries
//        double totalSalary = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
//        System.out.println("Total salary: " + totalSalary);
//
//        // 7. Summarizing salaries
//        DoubleSummaryStatistics stats = employees.stream()
//                .collect(Collectors.summarizingDouble(Employee::getSalary));
//        System.out.println("Salary statistics: " + stats);
//
//        // 8. Joining employee names
//        String namesJoined = employees.stream()
//                .map(Employee::getName)
//                .collect(Collectors.joining(", ","[", "]" ));
//        System.out.println("Joined names: " + namesJoined);
//
//        // 9. Convert to Map (name -> Employee)
//        Map<String, Employee> employeeMap = employees.stream()
//                .collect(Collectors.toMap(Employee::getName, Function.identity()));
//        System.out.println("Map of employees: " + employeeMap);
//
//        // 10. Partition employees with salary >= 6000
//        Map<Boolean, List<Employee>> partitioned = employees.stream()
//                .collect(Collectors.partitioningBy(e -> e.getSalary() >= 6000));
//        System.out.println("Partitioned by salary >= 6000: " + partitioned);
//
//        // 11. Find employee with max salary using collectingAndThen
//        Optional<Double> maxSalary = employees.stream()
//                .collect(Collectors.collectingAndThen(
//                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
//                        opt -> opt.map(Employee::getSalary)
//                ));
//        System.out.println("Maximum salary: " + maxSalary.orElse(0.0));
//
//        //12. get list of emp by there salary
//        Map<Double, List<String>> empCollection = employees.stream().filter(e -> e.getSalary() > 3000)
//                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));
//        System.out.println(empCollection);

//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getDepartmentName).thenComparingDouble(Employee::getSalary))

        Map<String, Optional<Double>> SecondHighestSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .map(Employee::getSalary)
                                        .sorted(Comparator.reverseOrder())
                                        .skip(2)
                                        .findFirst()
                        )
                ));
        System.out.println(SecondHighestSalary);
    }
}