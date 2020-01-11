package app.repository;

import app.domain.entities.PizzaApplication;

import java.util.List;

public interface PizzaApplicationRepository {
    void save(PizzaApplication pizzaApplication);
    List<PizzaApplication> findAll();
    PizzaApplication findById(String id);
    void delete(String id);
}
