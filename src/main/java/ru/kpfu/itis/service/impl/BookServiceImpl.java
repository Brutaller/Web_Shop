package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.repository.BookRepository;
import ru.kpfu.itis.service.BookService;

import java.util.List;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findOneById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public List<Book> findByCategoryId(Long id) {
        return bookRepository.findByCategoryId(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
