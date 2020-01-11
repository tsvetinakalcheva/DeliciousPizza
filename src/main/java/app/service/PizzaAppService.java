package app.service;

import app.domain.models.service.PizzaAppServiceModel;

import java.util.List;

public interface PizzaAppService {
    void save(PizzaAppServiceModel pizza);
    List<PizzaAppServiceModel> getAll();
    PizzaAppServiceModel getById(String id);
    void delete(String id);

}
