package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.BookService;
import ru.kpfu.itis.service.CategoryService;

@Controller
public class AdminController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @Secured("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getLoginPage() {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getRole().ordinal() == 0){
            return "redirect:/";
        }

        return "add-page";
    }

}


