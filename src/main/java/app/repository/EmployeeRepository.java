package app.repository;

import app.domain.entities.Employee;


public interface EmployeeRepository {
    void saveEmployee(Employee employee);
    Employee findByUsernameAndPasswordE(String username, String password);
}
