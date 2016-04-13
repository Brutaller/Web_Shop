package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Order;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
public interface OrderRepository extends JpaRepository<Order, Long>{

}
