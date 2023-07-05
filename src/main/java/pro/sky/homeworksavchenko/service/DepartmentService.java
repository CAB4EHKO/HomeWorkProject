package pro.sky.homeworksavchenko.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworksavchenko.entity.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public interface DepartmentService {

    Optional<Employee> getMaxSalaryEmployee(Integer department);

    Optional<Employee> getMinSalaryEmployee(Integer departmentID);


    List<Employee> getEmployeeByDepartment(Integer department);


    Map<Integer, List<Employee>> getAllEmployeesByDepartment();

    Integer getSumSalaryDepartment(Integer id);

    OptionalInt getMinSalaryDepartment(Integer id);

    OptionalInt getMaxSalaryDepartment(Integer id);
}
