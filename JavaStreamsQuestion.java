import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStreamsQuestion {
    public static void main(String[] args) {

    }

    private static void longestString(List<String> strs) {
        System.out.println("Longest String: " + strs.stream().max(Comparator.comparingInt(String::length)).get());
    }

    private static void averageAge(List<Person> persons) {
        System.out.println("Average of a persons: " + persons.stream().mapToInt(Person::getAge).average());
    }

    private static void partitionList(List<Integer> nums) {
        Map<Boolean, List<Integer>> partitionValue = nums.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        List<Integer> even = partitionValue.get(true);
        List<Integer> odd = partitionValue.get(false);

        System.out.println("Odd nums: " + odd + " even nums: " + even);
    }

    public static class Person {
        private String name;
        private Integer age;

        public Integer getAge() {
            return this.age;
        }
    }

    public static class Employee {
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
    }

    public static void groupEmployeeByDepartment() {
        List<Employee> employees = List.of(new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "HR"),
                new Employee("David", "IT"));

        Map<String, List<String>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println(collect);
    }

}
