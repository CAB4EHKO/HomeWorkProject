package pro.sky.homeworksavchenko;

import exceptions.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Service

public class EmployeeServiceImpl {
    List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Ivan", "Ivanov")
    ));

    public String addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("<p style=\"color:red;\">EMPLOYEE_ALREADY_EXIST<p>");
        }
        employeeList.add(employee);
        return employee.toString();
    }

}


