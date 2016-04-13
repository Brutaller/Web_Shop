package ru.kpfu.itis.service;

import ru.kpfu.itis.form.OrderForm;
import ru.kpfu.itis.model.Order;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
public interface OrderService {

    Order transformFormToOrder(OrderForm form);

    void saveNewOrder(Order order);
}
