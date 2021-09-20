package de.neuefische.rem214orderdb.service;

import de.neuefische.rem214orderdb.model.Order;
import de.neuefische.rem214orderdb.model.Product;
import de.neuefische.rem214orderdb.repo.OrderRepo;
import de.neuefische.rem214orderdb.repo.ProductRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ShopServiceTest {

    @Test
    @DisplayName("OrderProducts with existing products should create a new Order")
    public void orderProducts() {
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "piano"),
                new Product("2", "guitar"),
                new Product("3", "drums")
        );
        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //WHEN
        Order actual = shopService.orderProducts(List.of("1", "3"));

        //THEN
        List<Product> expected = List.of(
                new Product("1", "piano"),
                new Product("3", "drums")
        );
        assertEquals(expected, actual.getProductList());
    }

    @Test
    @DisplayName("OrderProducts with non-existing products should throw an exception")
    public void testOrderProducts() {
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "piano"),
                new Product("2", "guitar"),
                new Product("3", "drums")
        );
        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        try {
            //WHEN
            shopService.orderProducts(List.of("1", "4"));
            fail();
        } catch (IllegalArgumentException actual) {
            //THEN
            assertEquals("Product with ID 4 not found", actual.getMessage());
        }
    }

}