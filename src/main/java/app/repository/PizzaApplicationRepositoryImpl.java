package app.repository;

import app.domain.entities.PizzaApplication;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class PizzaApplicationRepositoryImpl implements PizzaApplicationRepository {
    private final EntityManager entityManager;

    @Inject
    public PizzaApplicationRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(PizzaApplication pizzaApplication) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(pizzaApplication);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<PizzaApplication> findAll() {
        this.entityManager.getTransaction().begin();
        List<PizzaApplication> pizzas = this.entityManager
                .createQuery("SELECT p FROM PizzaApplication p", PizzaApplication.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return pizzas;
    }

    @Override
    public PizzaApplication findById(String id) {
        this.entityManager.getTransaction().begin();
        PizzaApplication pizza = this.entityManager.createQuery(
                "SELECT p FROM PizzaApplication p WHERE p.id = :id", PizzaApplication.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return pizza;
    }

    @Override
    public void delete(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery(
                "DELETE FROM PizzaApplication p WHERE p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        this.entityManager.getTransaction().commit();

    }
}
