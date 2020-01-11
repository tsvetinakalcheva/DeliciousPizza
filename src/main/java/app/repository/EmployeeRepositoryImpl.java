package app.repository;

import app.domain.entities.Employee;
import app.domain.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EntityManager entityManager;

    @Inject
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(employee);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Employee findByUsernameAndPasswordE(String username, String password) {
        this.entityManager.getTransaction().begin();
        Employee employee = this.entityManager.createQuery(
                "SELECT e FROM Employee e WHERE e.username = :username " +
                        "AND e.password = :password", Employee.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return employee;

    }
}
