package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Product item1 = new Product(1, "Cover book", 1200);
    Product item2 = new Book(2, "book 1", 2700, "O'Reilly");

    @Test
    void shouldReturnFalseWithEmptyKeyword() {
        assertFalse(item1.matches("''"));
    }

    @Test
    void shouldReturnFalseWithWrongKeyword() {
        assertFalse(item1.matches("phone"));
    }

    @Test
    void shouldReturnTrueFromSuper() {
        assertTrue(item2.matches("book"));
    }

    @Test
    void shouldReturnTrueFromThis() {
        assertTrue(item2.matches("O'Reilly"));
    }
}