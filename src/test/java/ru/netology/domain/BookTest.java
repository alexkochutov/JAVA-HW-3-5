package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Product item1 = new Product(1, "t-shirt", 1200);
    Product item2 = new Product(2, "Cover book", 200);
    Product item3 = new Product(3, "Cover book", 300);
    Product item4 = new Book(4, "book 1", 2700, "O'Reilly");
    Product item5 = new Book(5, "book 2", 4900, "Oracle");
    Product item6 = new Book(6, "journal", 850, "O'Reilly");
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
            if (product.matches("book")) {
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
            if (product.matches("O'Reilly")) {
                Product[] tempStorage = new Product[actual.length + 1];
                System.arraycopy(actual, 0, tempStorage, 0, actual.length);
                tempStorage[tempStorage.length - 1] = product;
                actual = tempStorage;
            }
        }
        Product[] expected = {item4, item6};
        assertArrayEquals(expected, actual);
    }
}