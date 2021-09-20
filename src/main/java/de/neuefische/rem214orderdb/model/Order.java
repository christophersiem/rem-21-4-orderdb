package de.neuefische.rem214orderdb.model;

import java.util.List;
import java.util.Objects;

public class Order {
private final String id;
private final List<Product> productList;

    public Order(String id, List<Product> productList) {
        this.id = id;
        this.productList = productList;
    }

    public String getId() {
        return id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(productList, order.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productList);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", productList=" + productList +
                '}';
    }
}
