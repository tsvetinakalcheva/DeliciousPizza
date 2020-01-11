package app.web.beans;

import app.domain.models.binding.EmployeeLoginBindingModel;
import app.domain.models.service.EmployeeServiceModel;
import app.service.EmployeeService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class LoginEmployeeBean extends BaseBean{
    private EmployeeLoginBindingModel employee;
    private EmployeeService employeeService;

    public LoginEmployeeBean() {
    }

    @Inject
    public LoginEmployeeBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostConstruct
    public void init(){
        this.employee = new EmployeeLoginBindingModel();
    }

    public void login()  {
        EmployeeServiceModel user = this.employeeService.findEmployeeByUandP(this.employee.getUsername(),
                DigestUtils.sha256Hex(this.employee.getPassword()));
        if(user == null){
            this.redirect("/login-employee");
        }
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap();
        sessionMap.put("username", user.getUsername());
        this.redirect("/home-employee");
    }

    public EmployeeLoginBindingModel getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeLoginBindingModel employee) {
        this.employee = employee;
    }
}
