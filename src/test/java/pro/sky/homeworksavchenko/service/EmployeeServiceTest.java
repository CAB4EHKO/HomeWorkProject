package pro.sky.homeworksavchenko.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.homeworksavchenko.entity.Employee;
import pro.sky.homeworksavchenko.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworksavchenko.exceptions.EmployeeNotFoundException;
import pro.sky.homeworksavchenko.exceptions.EmployeeStorageIsFullException;
import pro.sky.homeworksavchenko.exceptions.UnexpectedCharacterException;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void shouldReturnUnexpectedCharacterException() {
        assertThrows(UnexpectedCharacterException.class,
                () -> employeeService.addEmployee("Tom", "Brady12", 50000, 1));
        assertThrows(UnexpectedCharacterException.class,
                () -> employeeService.findEmployee("Tom", "Brady12"));
        assertThrows(UnexpectedCharacterException.class,
                () -> employeeService.removeEmployee("Tom", "Brady12"));
    }

    @Test
    public void shouldReturnEmployeeNotFoundException() {
        employeeService.addEmployee("Tom", "Brady", 50000, 1);
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee("Patrick", "Mahomes"));
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findEmployee("Patrick", "Mahomes"));
    }

    @Test
    public void shouldReturnEmployeeStorageIsFullException() {
        for (int i = 0; i < EmployeeServiceImpl.MAX_EMPLOYEES; i++) {
            employeeService.addEmployee("Tom" + (char) (i + 65), "Brady", 50000, 1);
        }
        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.addEmployee("Patrick", "Mahomes", 40000, 1));
    }

    @Test
    public void shouldReturnEmployeeAlreadyAddedException() {
        employeeService.addEmployee("Tom", "Brady", 50000, 1);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee("Tom", "Brady", 50000, 1));
    }

    @Test
    public void shouldReturnAddedEmployee() {
        Employee expectedTom = new Employee("Tom", "Brady", 50000, 1);
        assertEquals(expectedTom,
                employeeService.addEmployee("Tom", "Brady", 50000, 1));
    }

    @Test
    public void shouldReturnRemovedEmployee() {
        Employee expectedTom = new Employee("Tom", "Brady", 50000, 1);
        employeeService.addEmployee("Tom", "Brady", 50000, 1);
        assertEquals(expectedTom,
                employeeService.removeEmployee("Tom", "Brady"));
    }  @Test
    public void shouldReturnFoundEmployee() {
        Employee expectedTom = new Employee("Tom", "Brady", 50000, 1);
        employeeService.addEmployee("Tom", "Brady", 50000, 1);
        assertEquals(expectedTom,
                employeeService.findEmployee("Tom", "Brady"));
    }

    @Test
    public void shouldReturnListEmployee() {
        Collection<Employee> employees =employeeService.listEmployees();
        employeeService.addEmployee("Tom", "Brady", 50000, 1);
        employeeService.addEmployee("Patrick", "Mahomes", 40000,1);

        assertEquals(2, employees.size());
        assertTrue(employees.contains(new Employee("Tom", "Brady", 50000, 1)));
        assertTrue(employees.contains(new Employee("Patrick", "Mahomes", 40000,1)));
    }
}

