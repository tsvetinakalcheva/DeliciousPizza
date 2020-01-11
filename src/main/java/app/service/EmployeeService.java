package app.service;

import app.domain.models.service.EmployeeServiceModel;


public interface EmployeeService {
    void save(EmployeeServiceModel employee);
    EmployeeServiceModel findEmployeeByUandP(String username, String password);
}
