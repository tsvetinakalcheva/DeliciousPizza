package app.service;

import app.domain.entities.Employee;
import app.domain.models.service.EmployeeServiceModel;
import app.repository.EmployeeRepository;
import app.repository.UserRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class EmployeeServiceImpl implements EmployeeService{
    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    @Inject
    public EmployeeServiceImpl(ModelMapper modelMapper, UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(EmployeeServiceModel employee) {
        //this.userRepository.save(this.modelMapper.map(employee, User.class));
        this.employeeRepository.saveEmployee(this.modelMapper.map( employee, Employee.class));
    }

    @Override
    public EmployeeServiceModel findEmployeeByUandP(String username, String password) {
        return this.modelMapper.map(this.employeeRepository.findByUsernameAndPasswordE
                (username, password), EmployeeServiceModel.class);
    }
}
