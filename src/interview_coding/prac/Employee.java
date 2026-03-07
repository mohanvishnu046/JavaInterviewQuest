package interview_coding.prac;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Employee {
    private String name;
    private double salary;

    private String departmentName;
    public Employee(String departmentName, String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.departmentName = departmentName;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartmentName() { return departmentName; }

    @Override
    public String toString() {
        return departmentName + " : " + name+" : "+salary;
    }
}