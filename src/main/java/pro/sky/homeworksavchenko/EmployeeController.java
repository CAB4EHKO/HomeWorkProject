package pro.sky.homeworksavchenko;

import exceptions.EmployeeAlreadyAddedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        try {
            return employeeServiceImpl.addEmployee(firstName, lastName);
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Произошла ошибка при добавлении сотрудника: EMPLOYEE_ALREADY_EXIST");
            return e.getMessage();
        }
    }

}
