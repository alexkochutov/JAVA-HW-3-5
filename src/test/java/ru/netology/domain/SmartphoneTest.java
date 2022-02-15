package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Product item1 = new Product(1, "t-shirt", 1200);
    Product item2 = new Product(2, "phone case", 1500);
    Product item3 = new Product(3, "phone glass", 1000);
    Product item4 = new Smartphone(4, "smartphone 1", 120000, "apple");
    Product item5 = new Smartphone(5, "smartphone 2", 55000, "xiaomi");
    Product item6 = new Smartphone(6, "smart watch", 25000, "xiaomi");

    @Test
    void shouldReturnEmptyResult() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        Product[] expected = {};
        Product[] actual = manager.searchBy("phone");
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
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnResultFromThis() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Product[] expected = {item5, item6};
        Product[] actual = manager.searchBy("xiaomi");
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
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, actual);
    }
}