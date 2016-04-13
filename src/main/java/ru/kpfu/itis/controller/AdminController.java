package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.BookRepository;
import ru.kpfu.itis.repository.CategoryRepository;
import ru.kpfu.itis.service.BookService;
import ru.kpfu.itis.service.CategoryService;
import ru.kpfu.itis.util.FileSaver;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class AdminController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    final static FileSaver IMAGE_SAVER = new FileSaver();


    @Secured("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String getAddPage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("year") Long year,
            @RequestParam("price") Long price,
            @RequestParam("about") String about,
            @RequestParam("category") Long category ) {


        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        book.setPrice(price);
        book.setAbout(about);
        book.setCategory(categoryService.findOne(category));


        String name = null;

        if (!file.isEmpty()) {
            try {
                IMAGE_SAVER.save(file, book);
                bookService.save(book);
                return "add-page";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload image because the file was empty.";
        }
    }


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


