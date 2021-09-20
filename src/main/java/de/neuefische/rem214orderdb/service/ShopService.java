package de.neuefische.rem214orderdb.service;

import de.neuefische.rem214orderdb.model.Order;
import de.neuefische.rem214orderdb.model.Product;
import de.neuefische.rem214orderdb.repo.OrderRepo;
import de.neuefische.rem214orderdb.repo.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShopService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Order orderProducts(List<String> productIds) {
        List<Product> productsToOrder = new ArrayList<>();
        for (String productId : productIds) {
            Product productToAdd = getProduct(productId);
            productsToOrder.add(productToAdd);
        }
        String id = UUID.randomUUID().toString();
        return orderRepo.addOrder(new Order(id, productsToOrder));
    }

    private Product getProduct(String productId){
        Optional<Product> optionalProduct = productRepo.getProduct(productId);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new IllegalArgumentException("Product with ID " + productId + " not found");
        }
    }

    public List<Order> listOrders(){
        return orderRepo.listOrders();
    }
}
