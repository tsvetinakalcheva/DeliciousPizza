package app.domain.entities;

import app.web.beans.BaseBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "pizza_app")
public class PizzaApplication extends BaseEntity {
    private String pizzaName;
    private String description;
    private BigDecimal price;

    public PizzaApplication() {
    }

    @Column(name = "pizza_name", nullable = false, unique = true)
    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getDescription() {
        return description;
    }

    @Column(name = "description", nullable = false)
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "price", nullable = false)
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
