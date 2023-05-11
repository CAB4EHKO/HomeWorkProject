package interfaces;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    String addEmployee(String firstName, String lastName);
}
