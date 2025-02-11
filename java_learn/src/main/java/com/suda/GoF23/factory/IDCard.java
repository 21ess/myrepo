package com.suda.GoF23.factory;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/21$
 */
public class IDCard extends Product{
    private String owner;
    private Long id;

    IDCard(String owner) {
        System.out.println("制作" + owner + "的card");
        this.owner = owner;
    }

    IDCard(String owner, Long id) {
        System.out.println("制作" + owner + "的card id为" + id);
        this.owner = owner;
        this.id = id;
    }

    @Override
    public void use() {
        System.out.println(owner + "use card");
    }

    public String getOwner(){
        return owner;
    }
}
