package pro.sky.homeworksavchenko;

import exceptions.EmployeeAlreadyAddedException;
import exceptions.EmployeeNotFoundException;
import exceptions.EmployeeStorageIsFullException;
import interfaces.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service

public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>();
    private static final int MAX_EMPLOYEES = 5;

    @Override
    public String addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("<p style=\"color:red;\">EMPLOYEE_ALREADY_EXIST<p>");
        } else if (employeeList.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("<p style=\"color:red;\">NUMBER_OF_EMPLOYEES_EXCEEDED<p>");
        }
        employeeList.add(employee);
        return employee.toString() + "<p style=\"color:green;\">Добавлен в список сотрудников.<p>";
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("<p style=\"color:red;\">EMPLOYEE_NOT_FOUND<p>");
        }
        employeeList.remove(employee);
        return employee.toString() + "<p style=\"color:red;\">Удалён из списка сотрудников.<p>";
    }

    @Override
    public String listEmployees() {
        return employeeList.toString();
    }
    @Override
    public String findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("<p style=\"color:red;\">EMPLOYEE_NOT_FOUND<p>");
        }
        return employee.toString();
    }

}


