package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Product item1 = new Product(1, "t-shirt", 1200);
    Product item2 = new Smartphone(2, "smartphone 1", 120000, "apple");


    @Test
    void shouldReturnFalseWithEmptyKeyword() {
        assertFalse(item1.matches("''"));
    }

    @Test
    void shouldReturnFalseWithWrongKeyword() {
        assertFalse(item1.matches("book"));
    }

    @Test
    void shouldReturnTrueFromSuper() {
        assertTrue(item2.matches("phone"));
    }

    @Test
    void shouldReturnTrueFromThis() {
        assertTrue(item2.matches("apple"));
    }
}