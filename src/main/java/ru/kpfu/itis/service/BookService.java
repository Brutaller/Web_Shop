package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Book;

import java.util.List;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
public interface BookService {

    void save(Book book);

    Book findOneById(Long id);

    List<Book> findByCategoryId(Long id);

    List<Book> findAll();
}
