package de.neuefische.rem214orderdb.repo;

import de.neuefische.rem214orderdb.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {
    private final Map<String, Order> orders = new HashMap<>();

    public List<Order> listOrders(){
        return List.copyOf(orders.values());
    }

    public Order addOrder(Order newOrder){
        orders.put(newOrder.getId(), newOrder);
        return newOrder;
    }
}
