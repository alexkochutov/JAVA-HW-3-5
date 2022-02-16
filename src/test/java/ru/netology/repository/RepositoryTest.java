package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repository = new Repository();
    Product item1 = new Product(1, "product", 1000);
    Product item2 = new Book(2, "book", 100, "author");
    Product item3 = new Smartphone(3, "smartphone", 100000, "apple");

    /*
        Set of tests for covering repository.save method
     */

    @Test
    void shouldSaveToEmptyRepository() {
        repository.save(item1);

        Product[] expected = {item1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveToNonEmptyRepository() {
        repository.save(item1);
        repository.save(item2);

        Product[] expected = {item1, item2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveDifferentObjects() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    /*
        Set of tests for covering repository.findAll method
     */

    @Test
    void shouldReturnEmptyResult() {
        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindInNonEmptyRepository() {
        repository.save(item1);

        Product[] expected = {item1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    /*
        Set of tests for covering repository.removeByID method
     */

    @Test
    void shouldNotRemoveInEmptyRepository() {
        repository.removeByID(1);

        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveInRepositoryWithOneItem() {
        repository.save(item1);
        repository.removeByID(1);

        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveInRepositoryWithMultipleItems() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.removeByID(2);

        Product[] expected = {item1, item3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}