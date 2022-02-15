package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.Repository;

public class Manager {
    private Repository repository;

    public Manager() {

    }

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        this.repository.save(product);
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

    public Product[] searchBy(String keyword) {
        Product[] result = new Product[0];

        for (Product product: repository.findAll()) {
            if (matches(product, keyword)) {
                Product[] tempStorage = new Product[result.length + 1];
                tempStorage[result.length] = product;
                result = tempStorage;
            }
        }

        return result;
    }
}
