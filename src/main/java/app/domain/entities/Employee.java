package app.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity{
    private String username;
    private String password;
    private String position;
    private String email;

    public Employee() {
    }

    @Column(name = "username" , nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password" , nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "position" , nullable = false)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    @Column(name = "email" , nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
