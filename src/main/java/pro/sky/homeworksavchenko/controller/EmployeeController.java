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
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("salary") Integer salary,
                              @RequestParam("department") Integer department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(lastName, firstName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
            return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public Collection<Employee> listEmployees() {
        return employeeService.listEmployees();
    }
}