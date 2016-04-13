package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Basket;
import ru.kpfu.itis.model.BasketItem;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.BasketItemRepository;
import ru.kpfu.itis.repository.BasketRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.BasketItemService;

import java.util.List;

@Service
public class BasketItemServiceImpl implements BasketItemService {

    @Autowired
    BasketItemRepository basketItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BasketRepository basketRepository;

    @Override
    public void saveItem(Book book, User user) {
        BasketItem item = new BasketItem();
        item.setTitle(book.getTitle());
        item.setAuthor(book.getAuthor());
        item.setPrice(book.getPrice());
        item.setImagePath(book.getImagePath());
        item.setBook_id(book.getId());
        item.setBasket(basketRepository.findOneByUser(user));
        basketItemRepository.save(item);
    }

    @Override
    @Modifying
    public void deleteItemById(Long id){
        basketItemRepository.delete(id);
    }

    @Override
    public List<BasketItem> getItemsByUserId(Long userId) {
        User user = userRepository.findOneById(userId);
        Basket basket = basketRepository.findOneByUser(user);
        List<BasketItem> items = basketItemRepository.findByBasket(basket);
        return items;
    }

    @Override
    public Basket findByUser(User user) {
        return basketRepository.findOneByUser(user);
    }
}
