package pro.sky.homeworksavchenko.controller;

import pro.sky.homeworksavchenko.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworksavchenko.exceptions.EmployeeNotFoundException;
import pro.sky.homeworksavchenko.exceptions.EmployeeStorageIsFullException;
import pro.sky.homeworksavchenko.exceptions.UnexpectedCharacterException;
import pro.sky.homeworksavchenko.entity.Employee;
import pro.sky.homeworksavchenko.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("salary") Integer salary,
                              @RequestParam("department") Integer department) {
        try {
            return employeeService.addEmployee(firstName, lastName, salary, department);
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Произошла ошибка при добавлении сотрудника: EMPLOYEE_ALREADY_EXIST");
            return e.getMessage();
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Произошла ошибка при добавлении сотрудника: NUMBER_OF_EMPLOYEES_EXCEEDED");
            return e.getMessage();
        } catch (UnexpectedCharacterException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        try {
            return employeeService.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Произошла ошибка при удалении сотрудника: EMPLOYEE_NOT_FOUND");
            return e.getMessage();
        }
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Произошла ошибка при поиске сотрудника: EMPLOYEE_NOT_FOUND");
            return e.getMessage();
        }
    }

    @GetMapping("/list")
    public Collection<Employee> listEmployees() {
        return employeeService.listEmployees();
    }
}