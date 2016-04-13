package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Basket;
import ru.kpfu.itis.repository.BasketRepository;
import ru.kpfu.itis.service.BasketService;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    BasketRepository basketRepository;

    @Override
    public void save(Basket basket) {
        basketRepository.save(basket);
    }
}
