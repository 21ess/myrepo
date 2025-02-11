package com.suda.GoF23.factory;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/21$
 */
public abstract class Factory {
    public final Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);


}
