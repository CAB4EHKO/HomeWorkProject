package pro.sky.homeworksavchenko.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pro.sky.homeworksavchenko.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

    @Test
    public void shouldReturnGetEmployeeByDepartment() {

        List<Employee> fullList = createdTestEmployeeList(0);
        when(employeeService.listEmployees()).thenReturn(fullList);

        List<Employee> expected1 = createdTestEmployeeList(1);
        List<Employee> actual1 = out.getEmployeeByDepartment(1);
        assertEquals(expected1, actual1);

        List<Employee> expected2 = createdTestEmployeeList(2);
        List<Employee> actual2 = out.getEmployeeByDepartment(2);
        assertEquals(expected2, actual2);

        List<Employee> expectedNonExist = createdTestEmployeeList(3);
        List<Employee> actualNonExist = out.getEmployeeByDepartment(4);
        assertEquals(expectedNonExist, actualNonExist);
    }

    @Test
    public void shouldReturnGroupingEmployee() {

        List<Employee> fullList = createdTestEmployeeList(0);
        when(employeeService.listEmployees()).thenReturn(fullList);

        Map<Integer, List<Employee>> actual = out.getAllEmployeesByDepartment();

        assertNotNull(actual.get(1));
        assertNotNull(actual.get(2));
        assertNull(actual.get(3));

        assertTrue(actual.get(1).stream().allMatch(e -> e.getDepartment() == 1));
        assertTrue(actual.get(2).stream().allMatch(e -> e.getDepartment() == 2));

        assertEquals("Tom Brady", actual.get(1).get(0).checkFullName());
        assertEquals("Patrick Mahomes", actual.get(1).get(1).checkFullName());
        assertEquals("Josh Allen", actual.get(1).get(2).checkFullName());
        assertEquals("Russel Wilson", actual.get(2).get(0).checkFullName());
        assertEquals("Aaron Rogers", actual.get(2).get(1).checkFullName());
    }

    @Test
    public void shouldReturnGetSumSalaryDepartment() {

        List<Employee> fullList = createdTestEmployeeList(0);
        when(employeeService.listEmployees()).thenReturn(fullList);

        assertEquals(120000, out.getSumSalaryDepartment(1));
        assertEquals(30000, out.getSumSalaryDepartment(2));
        assertEquals(0, out.getSumSalaryDepartment(3));
    }

    @Test
    public void shouldReturnGetMaxSalaryDepartment() {

        List<Employee> fullList = createdTestEmployeeList(0);
        when(employeeService.listEmployees()).thenReturn(fullList);

        assertEquals(50000, out.getMaxSalaryDepartment(1).getAsInt());
        assertEquals(20000, out.getMaxSalaryDepartment(2).getAsInt());
        assertFalse(out.getMaxSalaryDepartment(3).isPresent());
    }

    @Test
    public void shouldReturnGetMinSalaryDepartment() {

        List<Employee> fullList = createdTestEmployeeList(0);
        when(employeeService.listEmployees()).thenReturn(fullList);

        assertEquals(30000, out.getMinSalaryDepartment(1).getAsInt());
        assertEquals(10000, out.getMinSalaryDepartment(2).getAsInt());
        assertFalse(out.getMinSalaryDepartment(3).isPresent());
    }
}

