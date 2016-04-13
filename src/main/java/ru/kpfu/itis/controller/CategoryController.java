package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.aop.annotations.IncludeCategoriesList;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.model.Category;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.BookService;
import ru.kpfu.itis.service.CategoryService;

import java.util.List;


@Controller
public class CategoryController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @IncludeCategoriesList
    @RequestMapping("/category/{id}")
    public String getIndexPageByCategoryId(@PathVariable("id") Long id, Model model){

        List<Book> books = bookService.findByCategoryId(id);
        Category category = categoryService.findOne(id);
        model.addAttribute("category", category.getName());

        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute(user);
        }

        model.addAttribute("books", books);
        return "index";
    }

}
