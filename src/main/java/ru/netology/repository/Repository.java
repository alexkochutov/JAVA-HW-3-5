package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {
    private Product[] dataStorage = new Product[0];

    public Product[] getDataStorage() {
        return dataStorage;
    }

    public void setDataStorage(Product[] dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void save(Product item) {
        Product[] tempStorage = new Product[dataStorage.length + 1];

        for (int i = 0; i < dataStorage.length; i++) {
            tempStorage[i] = dataStorage[i];
        }

        tempStorage[tempStorage.length - 1] = item;
        dataStorage = tempStorage;
    }

    public Product[] findAll() {
        return getDataStorage();
    }

    public void removeByID(int id) {
        if (dataStorage.length != 0) {
            Product[] tempStorage = new Product[dataStorage.length - 1];
            int tempIndex = 0;

            for (int i = 0; i < dataStorage.length; i++) {
                if (dataStorage[i].getId() != id) {
                    tempStorage[tempIndex] = dataStorage[i];
                    tempIndex++;
                }
            }
            setDataStorage(tempStorage);
        }
    }
}