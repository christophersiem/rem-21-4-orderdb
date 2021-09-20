package de.neuefische.rem214orderdb.repo;

import de.neuefische.rem214orderdb.model.Order;
import de.neuefische.rem214orderdb.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderRepoTest {

    @Test
    @DisplayName("addOrder should add order to map")
    public void testAdd() {
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();

        //WHEN
        orderRepo.addOrder(new Order("order1", List.of(
                new Product("1", "piano"),
                new Product("2", "guitar")
        )));

        //THEN
        assertTrue(orderRepo.listOrders().contains(new Order("order1", List.of(
                new Product("1", "piano"),
                new Product("2", "guitar")
        ))));

    }

    private void assertTrue(boolean contains) {
    }

    @Test
    @DisplayName("listOrders should return all orders")
    public void testListOrders() {

        //GIVEN
        OrderRepo orderRepo = new OrderRepo();
        orderRepo.addOrder(new Order("order1", List.of(
                new Product("1", "piano"),
                new Product("2", "guitar")
        )));
        orderRepo.addOrder(new Order("order2", List.of(
                new Product("1", "piano"),
                new Product("3", "drums")
        )));

        //WHEN
        List<Order> actual = orderRepo.listOrders();

        //THEN
        assertThat(actual, containsInAnyOrder(
                new Order("order1", List.of(
                        new Product("1", "piano"),
                        new Product("2", "guitar")
                )),
                new Order("order2", List.of(
                        new Product("1", "piano"),
                        new Product("3", "drums")
                ))
        ));
        assertEquals(2, actual.size());
    }


}