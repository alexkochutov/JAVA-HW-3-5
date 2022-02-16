package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Product item1 = new Product(1, "t-shirt", 1200);
    Product item2 = new Product(2, "phone case", 1500);
    Product item3 = new Product(3, "phone glass", 1000);
    Product item4 = new Smartphone(4, "smartphone 1", 120000, "apple");
    Product item5 = new Smartphone(5, "smartphone 2", 55000, "xiaomi");
    Product item6 = new Smartphone(6, "smart watch", 25000, "xiaomi");
    Product[] dataStorage = {item1, item2, item3, item4, item5, item6};
    Product[] actual = new Product[0];

    @Test
    void ShouldReturnEmptyResult() {
        for (Product product : dataStorage) {
            if (product.matches("keyword")) {
                Product[] tempStorage = new Product[actual.length + 1];
                System.arraycopy(actual, 0, tempStorage, 0, actual.length);
                tempStorage[tempStorage.length - 1] = product;
                actual = tempStorage;
            }
        }
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnResultFromSuper() {
        for (Product product : dataStorage) {
            if (product.matches("phone")) {
                Product[] tempStorage = new Product[actual.length + 1];
                System.arraycopy(actual, 0, tempStorage, 0, actual.length);
                tempStorage[tempStorage.length - 1] = product;
                actual = tempStorage;
            }
        }
        Product[] expected = {item2, item3, item4, item5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnResultFromThis() {
        for (Product product : dataStorage) {
            if (product.matches("xiaomi")) {
                Product[] tempStorage = new Product[actual.length + 1];
                System.arraycopy(actual, 0, tempStorage, 0, actual.length);
                tempStorage[tempStorage.length - 1] = product;
                actual = tempStorage;
            }
        }
        Product[] expected = {item5, item6};
        assertArrayEquals(expected, actual);
    }
}