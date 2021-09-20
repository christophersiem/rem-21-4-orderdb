package de.neuefische.rem214orderdb.repo;

import de.neuefische.rem214orderdb.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    @DisplayName("listProducts should return all available products")
    public void testListProducts(){
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "piano"),
                new Product("2", "guitar"),
                new Product("3", "drums")
        );
        ProductRepo productRepo = new ProductRepo(products);
        //WHEN
        List<Product> actual = productRepo.listProducts();

        //THEN
        assertEquals(products, actual);
    }

    @Test
    @DisplayName("getProduct should return product with matching id")
    public void testGetProductWithExistingId(){
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "piano"),
                new Product("2", "guitar"),
                new Product("3", "drums")
        );
        ProductRepo productRepo = new ProductRepo(products);

        //WHEN
        Optional<Product> actual = productRepo.getProduct("2");

        //THEN
        assertEquals(new Product("2", "guitar"), actual.get());

    }

    @Test
    @DisplayName("getProduct should return product with matching id")
    public void testGetProductWithNonExistingId(){
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "piano"),
                new Product("2", "guitar"),
                new Product("3", "drums")
        );
        ProductRepo productRepo = new ProductRepo(products);

        //WHEN
        Optional<Product> actual = productRepo.getProduct("4");

        //THEN
        assertTrue(actual.isEmpty());

    }

}