package app.repository;

import app.domain.entities.User;

public interface UserRepository {
    void saveUser(User user);
    User findByUsernameAndPassword(String username, String password);
}
