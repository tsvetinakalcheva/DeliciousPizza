package app.web.beans;

import app.domain.models.service.PizzaAppServiceModel;
import app.domain.models.binding.PizzaCreateBindingModel;
import app.service.PizzaAppService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PizzaCreateBean extends BaseBean{

    private PizzaCreateBindingModel pizzaCreateBindingModel;
    private PizzaAppService pizzaAppService;
    private ModelMapper modelMapper;

    public PizzaCreateBean() {
    }

    @Inject
    public PizzaCreateBean(PizzaAppService pizzaAppService, ModelMapper modelMapper) {
        this.pizzaAppService = pizzaAppService;
        this.modelMapper = modelMapper;
    }
    @PostConstruct
    public void init(){
        this.pizzaCreateBindingModel = new PizzaCreateBindingModel();
    }

    public void create(){
        PizzaAppServiceModel model  = this.modelMapper.map(this.pizzaCreateBindingModel, PizzaAppServiceModel.class);
        this.pizzaAppService.save(model);
        this.redirect("/home-employee");
    }

    public PizzaCreateBindingModel getPizzaCreateBindingModel() {
        return pizzaCreateBindingModel;
    }

    public void setPizzaCreateBindingModel(PizzaCreateBindingModel pizzaCreateBindingModel) {
        this.pizzaCreateBindingModel = pizzaCreateBindingModel;
    }
}
