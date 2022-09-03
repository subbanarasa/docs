package com.java.test;

import java.util.Objects;

public  class Employee {

    private static volatile Employee employee;
    private  Integer id;
    private  String name;
    private  Double salary;
    private String division;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /*public static Employee getEmployee() {
        return employee;
    }*/

    public static void setEmployee(Employee employee) {
        Employee.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

   /* @Override
    public String toString() {
        return "com.java.test.Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", division='" + division + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary) && Objects.equals(division, employee.division);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, division);
    }*/
}
