package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.BasketItemService;
import ru.kpfu.itis.service.BookService;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BasketItemService basketItemService;


    @RequestMapping(value = "/books/{id}")
    public String getBookPage(@PathVariable("id") Long id, Model model){
        Book book = bookService.findOneById(id);
        model.addAttribute("book", book);
        return "book";
    }

    @RequestMapping(value = "/addtobasket")
    @ResponseStatus(HttpStatus.OK)
    public void addToBasket(@RequestParam ("id") Long id){
        Book book = bookService.findOneById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        basketItemService.saveItem(book,user);
    }


}
