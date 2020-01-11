package app.service;

import app.domain.entities.PizzaApplication;
import app.domain.models.service.PizzaAppServiceModel;
import app.repository.PizzaApplicationRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaAppServiceImpl implements PizzaAppService {
    private final PizzaApplicationRepository pizzaApplicationRepository;
    private final ModelMapper modelMapper;

    @Inject
    public PizzaAppServiceImpl(PizzaApplicationRepository pizzaApplicationRepository, ModelMapper modelMapper) {
        this.pizzaApplicationRepository = pizzaApplicationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(PizzaAppServiceModel pizza) {
        this.pizzaApplicationRepository.save(this.modelMapper.map(pizza, PizzaApplication.class));
    }

    @Override
    public List<PizzaAppServiceModel> getAll() {
        return this.pizzaApplicationRepository.findAll()
                .stream()
                .map(j -> this.modelMapper.map(j, PizzaAppServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public PizzaAppServiceModel getById(String id) {
        return this.modelMapper.map(this.pizzaApplicationRepository.findById(id),PizzaAppServiceModel.class);
    }

    @Override
    public void delete(String id) {
        this.pizzaApplicationRepository.delete(id);
    }
}
