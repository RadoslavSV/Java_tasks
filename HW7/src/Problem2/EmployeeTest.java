package Problem2;

import java.util.*;
import java.time.*;

public class EmployeeTest {
    List<Employee> employees;

//    @Before
    public void setup() {
        employees = new ArrayList<>();
        employees.add(new Employee(123, "Jack", "Johnson",
                                    LocalDate.of(1988, Month.APRIL, 12)));
        employees.add(new Employee(345, "Cindy", "Bower",
                                    LocalDate.of(2011, Month.DECEMBER, 15)));
        employees.add(new Employee(567, "Perry", "Node",
                                    LocalDate.of(2005, Month.JUNE, 07)));
        employees.add(new Employee(467, "Pam", "Krauss",
                                    LocalDate.of(2005, Month.JUNE, 07)));
        employees.add(new Employee(435, "Fred", "Shak",
                                    LocalDate.of(1988, Month.APRIL, 17)));
        employees.add(new Employee(678, "Ann", "Lee",
                                    LocalDate.of(2007, Month.APRIL, 12)));
        employees.add(new Employee(104, "Ann", "Anime",
                                    LocalDate.of(1999, Month.APRIL, 04)));
        employees.add(new Employee(400, "Ann", "Ziggler",
                                    LocalDate.of(2005, Month.DECEMBER, 02)));
        employees.add(new Employee(117, "Ann", "Torn",
                                    LocalDate.of(2009, Month.AUGUST, 18)));
    }

    public void printEmployeesByNumber() {
        employees.stream().sorted((a,b) -> a.getEmployeeNumber() - b.getEmployeeNumber()).forEach(System.out::println);
    }

    public void printEmployeesByHireDateDesc() {
        employees.stream().sorted(Comparator.comparing(Employee::getHireDate).reversed()).forEach(System.out::println);
    }

    public Optional<Employee> longestTenuredEmployee() {
        Optional<Employee> e1;
        e1 = employees.stream().sorted(Comparator.comparing(Employee::getHireDate)).findFirst();

        return e1;
    }

    public void printEmployeesByFirstNameAscAndLastNameDesc() {
        employees.stream().sorted(Comparator.comparing(Employee::getEmployeeLastName).reversed())
                          .sorted(Comparator.comparing(Employee::getEmployeeFirstName))
                          .forEach(System.out::println);
    }

    @Override
    public String toString() {
        String res = "";
        if(employees==null) return res;

        for(var x : employees) {
            res += x.toString() + '\n';
        }
        return res;
    }

    public static void main(String[] args) {
        EmployeeTest t1 = new EmployeeTest();
        t1.setup();

        System.out.println("All employees:");
        System.out.println(t1);

        System.out.println("Employees by employeeNumber in ascending order:");
        t1.printEmployeesByNumber();

        System.out.println("\nEmployees by hireDate in descending order:");
        t1.printEmployeesByHireDateDesc();

        if(t1.longestTenuredEmployee().isPresent()) {
            System.out.println("\nLongest tenured employee is " + t1.longestTenuredEmployee().get());
        }

        System.out.println("\nEmployees by firstName in ascending order and by lastName in descending order:");
        t1.printEmployeesByFirstNameAscAndLastNameDesc();
    }
}
