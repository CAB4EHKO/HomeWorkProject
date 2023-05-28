package service;

import org.springframework.stereotype.Service;
import pro.sky.homeworksavchenko.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface DepartmentService {

    Optional<Employee> getMaxSalaryEmployee(Integer department);

    Optional<Employee> getMinSalaryEmployee(Integer departmentID);


    List<Employee> getEmployeeByDepartment(Integer department);

    Map<Integer, List<Employee>> getAllEmployees();
}
