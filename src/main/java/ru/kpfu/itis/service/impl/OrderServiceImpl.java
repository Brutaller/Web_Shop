package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.OrderForm;
import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.repository.OrderRepository;
import ru.kpfu.itis.service.OrderService;
import ru.kpfu.itis.util.OrderFormToOrderTransformer;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order transformFormToOrder(OrderForm form) {
        return OrderFormToOrderTransformer.transform(form);
    }

    @Override
    public void saveNewOrder(Order order) {
        orderRepository.save(order);
    }
}
