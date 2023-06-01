package pro.sky.homeworksavchenko;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int department;

    public Employee(String firstName, String lastName, int salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "<br>Имя: " + firstName + " Фамилия: " + lastName + "<br>Зарплата: " + salary + " Отдел: " + department;
    }

}
