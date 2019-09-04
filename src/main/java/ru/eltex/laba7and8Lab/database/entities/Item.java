package ru.eltex.laba7and8Lab.database.entities;


import ru.eltex.laba7and8Lab.utils.ItemType;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private int id;

    @Column(name = "name")
    public String name;

    @Column(name = "price")
    public int price;

    @Column(name = "provider")
    public String provider;

    @Column(name = "country")
    public String country;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    public ItemType type;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Item() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", provider='" + provider + '\'' +
                ", country='" + country + '\'' +
                ", type=" + type +
                '}';
    }
}
