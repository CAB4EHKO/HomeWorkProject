package service;

import org.springframework.stereotype.Service;
import pro.sky.homeworksavchenko.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {

    String addEmployee(String firstName, String lastName, Integer salary, Integer department);

    String removeEmployee(String firstName, String lastName);

    Collection<Employee> listEmployees();

    String findEmployee(String firstName, String lastName);
}
