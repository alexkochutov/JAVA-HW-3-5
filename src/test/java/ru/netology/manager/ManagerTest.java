package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    Product item1 = new Product(1, "product 1", 1000);
    Product item2 = new Book(2, "book 1", 100, "author");
    Product item3 = new Smartphone(3, "smartphone", 100000, "apple");
    Product item4 = new Smartphone(4, "smartphone", 50000, "samsung");
    Product item5 = new Smartphone(4, "smartphone", 25000, "xiaomi");

    /*
        Set of tests for covering manager.add method
     */

    @Test
    void shouldAddIntoEmptyRepository() {
        manager.add(item1);

        Product[] expected = {item1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddIntoNonEmptyRepository() {
        manager.add(item1);
        manager.add(item2);

        Product[] expected = {item1, item2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddDifferentProducts() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    /*
        Set of tests for covering manager.searchBy method
     */

    @Test
    void shouldNotSearchInEmptyRepository() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchInRepositoryWithOneItem() {
        manager.add(item1);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("product");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyResultWithWrongKeyword() {
        manager.add(item1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchProductInRepositoryWithDifferentObjects() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);

        Product[] expected = {item3, item4, item5};
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, actual);
    }
}