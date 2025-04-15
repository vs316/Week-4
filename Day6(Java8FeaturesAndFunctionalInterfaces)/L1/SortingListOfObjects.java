package java_functional_interfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person{
    private String name;
    private Integer age;
    private Double salary;

    public Person(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }
}
public class SortingListOfObjects {
    List<Person> persons = new ArrayList<>();
    public SortingListOfObjects() {
        persons.add(new Person("Alice", 30, 50000.0));
        persons.add(new Person("Bob", 25, 60000.0));
        persons.add(new Person("Charlie", 35, 70000.0));
        persons.add(new Person("David", 28, 80000.0));
    }
    public List<Person> getPersons() {
        return persons;
    }
    public void sortByAge(){
//persons.sort(Comparator.comparing(Person::getAge));
        persons.sort((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
    }

    public static void main(String[] args) {
        SortingListOfObjects sortingListOfObjects = new SortingListOfObjects();
        System.out.println("Before sorting:");
        for (Person person : sortingListOfObjects.getPersons()) {
            System.out.println(person.getAge());
        }
        sortingListOfObjects.sortByAge();
        System.out.println("After sorting:");
        for (Person person : sortingListOfObjects.getPersons()) {
            System.out.println(person.getAge());
        }
    }
}
