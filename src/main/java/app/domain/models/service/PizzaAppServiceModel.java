package app.domain.models.service;

import java.math.BigDecimal;

public class PizzaAppServiceModel {
    private String id;
    private String pizzaName;
    private String description;
    private BigDecimal price;

    public PizzaAppServiceModel() {
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
