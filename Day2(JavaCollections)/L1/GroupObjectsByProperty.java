package JavaCollections.MapInterface;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupObjectsByProperty {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "IT"),
                new Employee("Eve", "Finance"));

        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Employees grouped by department:");
        groupedByDepartment.forEach((dept, empList) -> System.out.println(dept + ": " + empList));
    }
}