package ru.kpfu.itis.util;

import ru.kpfu.itis.form.OrderForm;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.UserRole;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
public class OrderFormToOrderTransformer {

    public static Order transform(OrderForm form) {
        if (form == null) {
            return null;
        }
        Order order = new Order();
        order.setAddress(form.getAddress());
        order.setName(form.getName());
        order.setSurname(form.getSurname());
        order.setPostIndex(form.getPostIndex());
        order.setEmail(form.getEmail());
        order.setPhoneNumber(form.getPhoneNumber());
        return order;
    }
}
