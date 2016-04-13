package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.BookService;
import ru.kpfu.itis.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by azat on 11.03.16.
 */
@Controller
public class IndexController {

    @Autowired
    BookService bookService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/")
    public String getIndexPage(Model model) {
        List<Book> books = bookService.findAll();
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute(user);
        }
        model.addAttribute("category", "Последние");
        model.addAttribute("books", books);
        model.addAttribute("categories", categoryService.findAll());

        return "index";
    }

}
