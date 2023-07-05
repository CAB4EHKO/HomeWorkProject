package pro.sky.homeworksavchenko.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pro.sky.homeworksavchenko.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceTest {

    private EmployeeService employeeService;
    private DepartmentServiceImpl out;

    @BeforeEach
    public void setUp() {
        employeeService = Mockito.mock(EmployeeService.class);
        out = new DepartmentServiceImpl(employeeService);
    }

    private List<Employee> createdTestEmployeeList(int departmentID) {
        List<Employee> employeeList = new ArrayList<>();

        if (departmentID == 1 || departmentID == 0) {
            employeeList.add(new Employee("Tom", "Brady", 50000, 1));
            employeeList.add(new Employee("Patrick", "Mahomes", 40000, 1));
            employeeList.add(new Employee("Josh", "Allen", 30000, 1));
        }
        if (departmentID == 2 || departmentID == 0) {
            employeeList.add(new Employee("Russel", "Wilson", 20000, 2));
            employeeList.add(new Employee("Aaron", "Rogers", 10000, 2));
        }
        return employeeList;
    }
}

