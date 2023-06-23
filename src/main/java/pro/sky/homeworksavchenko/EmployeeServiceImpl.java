package pro.sky.homeworksavchenko;

import exceptions.EmployeeAlreadyAddedException;
import exceptions.EmployeeNotFoundException;
import exceptions.EmployeeStorageIsFullException;
import exceptions.UnexpectedCharacterException;
import org.apache.commons.lang3.StringUtils;
import service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employeeMap = new HashMap<>();
    private static final int MAX_EMPLOYEES = 15;

    @Override
    public String addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        validateInputDate(employee.getFirstName(), employee.getLastName());
        if (employeeMap.containsKey(employee.checkFullName())) {
            throw new EmployeeAlreadyAddedException("<p style=\"color:red;\">EMPLOYEE_ALREADY_EXIST<p>");
        } else if (employeeMap.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("<p style=\"color:red;\">NUMBER_OF_EMPLOYEES_EXCEEDED<p>");
        }
        employeeMap.put(employee.checkFullName(), employee);
        return employee.toString() + "<p style=\"color:green;\">Добавлен в список сотрудников.<p>";
    }


    @Override
    public String removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        validateInputDate(employee.getFirstName(), employee.getLastName());
        if (!employeeMap.containsKey(employee.checkFullName())) {
            throw new EmployeeNotFoundException("<p style=\"color:red;\">EMPLOYEE_NOT_FOUND<p>");
        }
        employeeMap.remove(employee.checkFullName(), employee);
        return employee.toString() + "<p style=\"color:red;\">Удалён из списка сотрудников.<p>";
    }


    @Override
    public String findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        validateInputDate(employee.getFirstName(), employee.getLastName());
        if (!employeeMap.containsKey(employee.checkFullName())) {
            throw new EmployeeNotFoundException("<p style=\"color:red;\">EMPLOYEE_NOT_FOUND<p>");
        }
        return employee.toString();
    }

    @Override
    public Collection<Employee> listEmployees() {

        return Collections.unmodifiableCollection(employeeMap.values());
    }

    private void validateInputDate(String... values){
        for (String value : values) {
            if (!StringUtils.isAlpha(value)) {
                throw new UnexpectedCharacterException("Unexpected character in " + value);
            }
        }
    }
}


