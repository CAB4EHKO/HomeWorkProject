package pro.sky.homeworksavchenko.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homeworksavchenko.entity.Employee;
import pro.sky.homeworksavchenko.service.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Optional<Employee> getMaxSalaryEmployee(@RequestParam("departmentID") Integer departmentID) {
        return departmentService.getMaxSalaryEmployee(departmentID);
    }

    @GetMapping(path = "/min-salary")
    public Optional<Employee> getMinSalaryEmployee(@RequestParam("departmentID") Integer departmentID) {
        return departmentService.getMinSalaryEmployee(departmentID);
    }

    @GetMapping(path = "/all/{departmentID}")
    public List<Employee> getEmployeeByDepartment(@PathVariable Integer departmentID) {
        return departmentService.getEmployeeByDepartment(departmentID);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployeesByDepartment();
    }

    @GetMapping("/{id}/salary/sum")
    public Integer getSumSalaryDepartment(@PathVariable Integer id) {
        return departmentService.getSumSalaryDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public OptionalInt getMinSalaryDepartment(@PathVariable Integer id) {
        return departmentService.getMinSalaryDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public OptionalInt getMaxSalaryDepartment(@PathVariable Integer id) {
        return departmentService.getMaxSalaryDepartment(id);
    }
}
