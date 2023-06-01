package pro.sky.homeworksavchenko;

import org.springframework.stereotype.Service;
import service.DepartmentService;
import service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Optional<Employee> getMaxSalaryEmployee(Integer departmentID) {
        return employeeService.listEmployees().stream()
                .filter(e -> e.getDepartment() == departmentID)
                .max(Comparator.comparingInt(Employee::getSalary));
    }
    @Override
    public Optional<Employee> getMinSalaryEmployee(Integer departmentID) {
        return employeeService.listEmployees().stream()
                .filter(e -> e.getDepartment() == departmentID)
                .min(Comparator.comparingInt(Employee::getSalary));
    }
    @Override
    public List<Employee> getEmployeeByDepartment(Integer departmentID) {
        return employeeService.listEmployees().stream()
                .filter(e -> e.getDepartment() == departmentID)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        Collection<Employee> allEmployees = employeeService.listEmployees();

        Map<Integer, List<Employee>> departmentMap = allEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));

        return departmentMap;
    }

}
