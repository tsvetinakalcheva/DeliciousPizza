package app.web.beans;

import app.domain.models.binding.EmployeeRegisterBinding;
import app.domain.models.service.EmployeeServiceModel;
import app.service.EmployeeService;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class RegisterEmployeeBean extends BaseBean{
    private EmployeeRegisterBinding employee;
    private EmployeeService employeeService;
    private ModelMapper modelMapper;

    public RegisterEmployeeBean() {
    }
    @Inject
    public RegisterEmployeeBean(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }
    @PostConstruct
    public void init(){
        this.employee = new EmployeeRegisterBinding();
    }
    public void register() {
        if(!this.employee.getPassword().equals(this.employee.getConfirmPassword())){
            return;
        }
        employee.setPassword(DigestUtils.sha256Hex(employee.getPassword()));
        this.employeeService.save(this.modelMapper.map(employee, EmployeeServiceModel.class));
        this.redirect("/loginEmployee");
    }

    public EmployeeRegisterBinding getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeRegisterBinding employee) {
        this.employee = employee;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

}
