package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {
    private Product[] dataStorage = new Product[0];

    public void save(Product item) {
        Product[] tempStorage = new Product[dataStorage.length + 1];

        for (int i = 0; i < dataStorage.length; i++) {
            tempStorage[i] = dataStorage[i];
        }

        tempStorage[tempStorage.length - 1] = item;
        dataStorage = tempStorage;
    }

    public Product[] findAll() {
        return dataStorage;
    }

    public void removeByID(int id) {
        Product[] tempStorage = new Product[dataStorage.length - 1];
        int tempIndex = 0;

        for (int i = 0; i < dataStorage.length; i++) {
            if (dataStorage[i].getId() != id) {
                tempStorage[tempIndex] = dataStorage[i];
                tempIndex++;
            }
        }
        dataStorage = tempStorage;
    }
}