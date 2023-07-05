package pro.sky.homeworksavchenko.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworksavchenko.entity.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);

    Employee removeEmployee(String firstName, String lastName);

    Collection<Employee> listEmployees();

    Employee findEmployee(String firstName, String lastName);
}
