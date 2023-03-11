/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author eck
 */
class Employee {
    public static enum Gender {
        MALE, FEMALE
    }

    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;
    private UUID employeeID;

    private Employee(String name, Gender gender, LocalDate dob,
            double income) {
        
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
        this.employeeID = UUID.randomUUID();
    }

    public Employee() {
    }

    public double getIncome() {
        return income;
    }

    public static List<Employee> persons() {
        Employee p1 = new Employee( "Jake", Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        Employee p2 = new Employee("Jack", Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        Employee p3 = new Employee( "Jane", Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        Employee p4 = new Employee("Jode", Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        Employee p5 = new Employee( "Jeny", Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        Employee p6 = new Employee( "Jason", Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }

    public static void statistics() {
        // To do
        int sum = persons().stream().mapToInt(x -> (int)(x.getIncome())).sum();
        System.out.println("Accumulated income of all employees is " + sum);
    }

    public static void personsStatsByGenderCount() {
        long cntMale = persons().stream().filter(x -> x.gender==Gender.MALE).count();
        long cntFemale = persons().stream().filter(x -> x.gender==Gender.FEMALE).count();
        System.out.printf("Count of male employees - %d\nCount of female employees - %d\n", cntMale, cntFemale);
    }

    public static void personsStatsByGenderList() {
        List<Employee> males = persons().stream().filter(x -> x.gender==Gender.MALE).collect(Collectors.toList());
        List<Employee> females = persons().stream().filter(x -> x.gender==Gender.FEMALE).collect(Collectors.toList());
        System.out.println("Male employees:");
        males.stream().forEach(x -> System.out.println(x.name));
        System.out.println("Female employees:");
        females.stream().forEach(x -> System.out.println(x.name));
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.income, income)==0 &&
                Objects.equals(name, employee.name) &&
                gender==employee.gender &&
                Objects.equals(dob, employee.dob) &&
                Objects.equals(employeeID, employee.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, dob, income, employeeID);
    }

    @Override
    public String toString() {
        return String.format("Employee name - " + name +
                             " | Gender - " + gender +
                             " | Dob - " + dob +
                             " | Income - " + income +
                             " | employeeID - " + employeeID);
    }

//    public static void main(String[] args) {
//        List<Employee> list = persons();
//        for(var x : list) {
//            System.out.println(x);
//        }
//        statistics();
//        personsStatsByGenderCount();
//        personsStatsByGenderList();
//    }
}

