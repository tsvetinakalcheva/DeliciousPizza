package app.web.beans;

import app.domain.models.view.PizzaViewModel;
import app.service.PizzaAppService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class DetailsBean{

    private PizzaAppService pizzaAppService;
    private ModelMapper modelMapper;

    public DetailsBean() {
    }

    @Inject
    public DetailsBean(PizzaAppService pizzaAppService, ModelMapper modelMapper) {
        this.pizzaAppService = pizzaAppService;
        this.modelMapper = modelMapper;
    }


    public PizzaViewModel getPizzaById(String id){
        return this.modelMapper.map(this.pizzaAppService.getById(id), PizzaViewModel.class);
    }

}
