package pro.sky.homeworksavchenko.controller;

import org.springframework.web.bind.annotation.*;
import service.DepartmentService;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public String getMaxSalaryEmployee(@RequestParam("departmentID") Integer departmentID) {
        return departmentService.getMaxSalaryEmployee(departmentID).toString();
    }
    @GetMapping(path = "/min-salary")
    public String getMinSalaryEmployee(@RequestParam("departmentID") Integer departmentID) {
        return departmentService.getMinSalaryEmployee(departmentID).toString();
    }
    @GetMapping(path = "/all/{departmentID}")
    public String getEmployeeByDepartment(@PathVariable Integer departmentID) {
        return departmentService.getEmployeeByDepartment(departmentID).toString();
    }

    @GetMapping(path = "/all")
    public String getAllEmployees() {
        return departmentService.getAllEmployees().toString();
    }
}
