package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.Repository;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        this.repository.save(product);
    }

    public Product[] searchBy(String keyword) {
        Product[] result = new Product[0];

        for (Product product : repository.findAll()) {
            if (product.matches(keyword)) {
                Product[] tempStorage = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tempStorage[i] = result[i];
                }
                tempStorage[tempStorage.length - 1] = product;
                result = tempStorage;
            }
        }

        return result;
    }
}
