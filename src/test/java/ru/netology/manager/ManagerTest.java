package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    /*
        Set of tests for covering manager.add method
     */

    @Test
    void shouldAddIntoEmptyRepository() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product item1 = new Product(1, "product 1", 1000);
        manager.add(item1);

        Product[] expected = {item1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddIntoNonEmptyRepository() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product item1 = new Product(1, "product 1", 1000);
        Product item2 = new Product(2, "product 2", 1100);
        manager.add(item1);
        manager.add(item2);

        Product[] expected = {item1, item2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddDifferentProducts() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product item1 = new Product(1, "product 1", 1000);
        Product item2 = new Book(2, "book 1", 100, "author");
        Product item3 = new Smartphone(3, "smartphone 1", 10000, "apple");

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
        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        Product[] expected = {};
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, expected);
    }

    @Test
    void shouldSearchInRepositoryWithOneItem() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product item1 = new Product(1, "product 1", 1000);
        manager.add(item1);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, expected);
    }

    @Test
    void shouldReturnEmptyResultWithWrongKeyword() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product item1 = new Product(1, "product", 1000);
        manager.add(item1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, expected);
    }

    @Test
    void shouldSearchProductInRepositoryWithDifferentObjects() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product item1 = new Product(1, "product 1", 1000);
        Product item2 = new Book(2, "book 1", 100, "author");
        Product item3 = new Smartphone(3, "smartphone", 100000, "apple");
        Product item4 = new Smartphone(4, "smartphone", 50000, "samsung");
        Product item5 = new Smartphone(4, "smartphone", 25000, "xiaomi");

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);

        Product[] expected = {item3, item4, item5};
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, expected);
    }
}