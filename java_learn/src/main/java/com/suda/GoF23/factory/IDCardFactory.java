package com.suda.GoF23.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/21$
 */
public class IDCardFactory extends Factory {
    // 使用单例设计creator
    private static Factory factory = null;
    private List<String> owners = new CopyOnWriteArrayList<>();
    private static LongAdder id = new LongAdder();
    private Map<String, String> id2Owner = new ConcurrentHashMap<>();

    private IDCardFactory() {
        super();
    }

    public static Factory getInstance() {
        if (factory != null) return factory;
        synchronized (IDCardFactory.class) {
            if (factory == null) {
                factory = new IDCardFactory();
            }
            return factory;
        }
    }

    @Override
    protected IDCard createProduct(String owner) {
        Long id;
        synchronized (IDCardFactory.class) {
            this.id.add(1L);
            id = this.id.longValue();
        }
        id2Owner.put(id.toString(), owner);
        IDCard card = new IDCard(owner, id.longValue());
        return card;
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard) product).getOwner());
    }

    public List<String> getOwners() {
        return owners;
    }

    public String findOwner(String id) {
        if (id == null) return "404";
        return id2Owner.getOrDefault(id, "");
    }
}
