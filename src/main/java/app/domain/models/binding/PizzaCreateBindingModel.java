package app.domain.models.binding;

import java.math.BigDecimal;

public class PizzaCreateBindingModel {

    private String pizzaName;
    private String description;
    private BigDecimal price;

    public PizzaCreateBindingModel() {
    }

    public String getPizzaName() {
        return pizzaName;
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
