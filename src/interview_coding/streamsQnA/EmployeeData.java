package interview_coding.streamsQnA;

import java.util.List;

public class EmployeeData {
static List<Employee> employees;
   static{
        employees = List.of(
            // IT Department (4 employees)
            new Employee("Alice", "IT", 90000),
            new Employee("Bob", "IT", 85000),
            new Employee("Charlie", "IT", 95000),
            new Employee("David", "IT", 88000),

            // HR Department (3 employees)
            new Employee("Eva", "HR", 60000),
            new Employee("Frank", "HR", 65000),
            new Employee("Grace", "HR", 62000),

            // Finance Department (5 employees)
            new Employee("Henry", "Finance", 92000),
            new Employee("Ivy", "Finance", 87000),
            new Employee("Jack", "Finance", 91000),
            new Employee("Karen", "Finance", 89000),
            new Employee("Leo", "Finance", 94000),

            // Sales Department (4 employees)
            new Employee("Mona", "Sales", 70000),
            new Employee("Nate", "Sales", 75000),
            new Employee("Olivia", "Sales", 72000),
            new Employee("Paul", "Sales", 78000)
        );
    }
}