package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Basket;
import ru.kpfu.itis.model.User;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findOneByUser(User user);

}
