package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Category;

/**
 * Created by Azat Zaripov on 30.03.16.
 */
public interface CategoryRepository extends JpaRepository<Category, Long>{

    Category getOneById(Long id);

}
