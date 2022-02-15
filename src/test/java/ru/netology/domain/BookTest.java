package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Product item1 = new Product(1, "t-shirt", 1200);
    Product item2 = new Product(2, "Cover book", 200);
    Product item3 = new Product(3, "Cover book", 300);
    Product item4 = new Book(4, "book 1", 2700, "O'Reilly");
    Product item5 = new Book(5, "book 2", 4900, "Oracle");
    Product item6 = new Book(6, "journal", 850, "O'Reilly");

    @Test
    void shouldReturnEmptyResult() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        Product[] expected = {};
        Product[] actual = manager.searchBy("book");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnResultFromSuper() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Product[] expected = {item4, item5};
        Product[] actual = manager.searchBy("book");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnResultFromThis() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Product[] expected = {item4, item6};
        Product[] actual = manager.searchBy("O'Reilly");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnResultWithDifferentObjects() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Product[] expected = {item2, item3, item4, item5};
        Product[] actual = manager.searchBy("book");
        assertArrayEquals(expected, actual);
    }
}