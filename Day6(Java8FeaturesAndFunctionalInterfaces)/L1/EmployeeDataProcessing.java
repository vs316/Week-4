package java8Features;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee{
    String id;
    String name;
    String department;
    Double salary;

    public Employee(String id, String name, String department, double salary) {
    this.id=id;
    this.name=name;
    this.department=department;
    this.salary=salary;
    }

    public Employee(String key, List<Employee> value) {

    }

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<Employee> filterByEngineeringHighSalary(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals("Engineering") && employee.getSalary() > 80000)
                .toList();
    }

    public static List<Employee> sortByDescendingSalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static Map<String, Double> calculateAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }
}
public class EmployeeDataProcessing {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("1", "Alice", "Engineering", 90000),
                new Employee("2", "Bob", "Engineering", 75000),
                new Employee("3", "Charlie", "HR", 70000),
                new Employee("4", "David", "Engineering", 85000),
                new Employee("5", "Eve", "Sales", 60000)
        );

        // Filter employees
        List<Employee> filteredEmployees = Employee.filterByEngineeringHighSalary(employees);

        // Sort employees
        List<Employee> sortedEmployees = Employee.sortByDescendingSalary(filteredEmployees);

        // Group by department
        Map<String, List<Employee>> groupedEmployees = Employee.groupByDepartment(sortedEmployees);

        // Calculate average salary
        Map<String, Double> avgSalaryByDept = Employee.calculateAverageSalaryByDepartment(sortedEmployees);

        // Output results
        groupedEmployees.forEach((department, empList) -> {
            System.out.println("Department: " + department);
            empList.forEach(emp -> System.out.println(emp.getName() + " - " + emp.getSalary()));
        });

        System.out.println("Average Salary by Department:");
        avgSalaryByDept.forEach((department, avgSalary) ->
                System.out.println(department + ": " + avgSalary)
        );
    }
}
