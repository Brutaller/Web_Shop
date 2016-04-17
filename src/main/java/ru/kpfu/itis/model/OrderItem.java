package ru.kpfu.itis.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Azat Zaripov on 15.04.16.
 */
@Entity
@Table(name = "order_items")
public class OrderItem extends Item{

    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}