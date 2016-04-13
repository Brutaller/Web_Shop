package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Basket;
import ru.kpfu.itis.model.BasketItem;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.model.User;

import java.util.List;

public interface BasketItemService {

    public void saveItem(Book book, User user);

    public void deleteItemById(Long id);

    public List<BasketItem> getItemsByUserId(Long userId);

    public Basket findByUser(User user);
}
