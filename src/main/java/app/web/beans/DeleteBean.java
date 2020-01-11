package app.web.beans;

import app.domain.models.view.PizzaViewModel;
import app.service.PizzaAppService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class DeleteBean extends  BaseBean {
    private PizzaAppService pizzaAppService;
    private ModelMapper modelMapper;

    public DeleteBean() {
    }

    @Inject
    public DeleteBean(PizzaAppService pizzaAppService, ModelMapper modelMapper) {
        this.pizzaAppService = pizzaAppService;
        this.modelMapper = modelMapper;
    }

    public PizzaViewModel getPizzaById(String id){
        return this.modelMapper.map(this.pizzaAppService.getById(id),
                PizzaViewModel.class);
    }
    public void delete(){
        String id = ((HttpServletRequest) FacesContext.
                getCurrentInstance().getExternalContext()
                .getRequest()).getParameter("id");
        this.pizzaAppService.delete(id);
        this.redirect("/home-employee");

    }

}
