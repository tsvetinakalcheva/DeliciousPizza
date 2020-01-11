package app.web.beans;

import app.domain.models.view.PizzaViewModel;
import app.service.PizzaAppService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class PizzaListBean {

    private List<PizzaViewModel> pizzas;
    private PizzaAppService pizzaAppService;
    private ModelMapper modelMapper;

    public PizzaListBean() {
    }

    @Inject
    public PizzaListBean(PizzaAppService pizzaAppService, ModelMapper modelMapper) {
        this.pizzaAppService = pizzaAppService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        this.setPizzas(this.pizzaAppService.getAll().stream()
        .map(p -> this.modelMapper.map(p, PizzaViewModel.class))
        .collect(Collectors.toList()));
        this.getPizzas().forEach(j -> j.setPizzaName(j.getPizzaName()));
    }

    public List<PizzaViewModel> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaViewModel> pizzas) {
        this.pizzas = pizzas;
    }
}
