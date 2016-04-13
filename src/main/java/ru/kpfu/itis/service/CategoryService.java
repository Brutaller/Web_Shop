package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Category;

import java.util.List;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
public interface CategoryService {

    Category findOne(Long id);

    List<Category> findAll();

}
