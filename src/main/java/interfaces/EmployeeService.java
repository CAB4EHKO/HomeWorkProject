package interfaces;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    String addEmployee(String firstName, String lastName);

    String removeEmployee(String firstName, String lastName);

    String listEmployees();

    String findEmployee(String firstName, String lastName);
}
