package ru.kpfu.itis.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.model.Category;
import ru.kpfu.itis.repository.CategoryRepository;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Azat Zaripov on 05.04.16.
 */
@Aspect
@Component
public class CategoriesAspect {

    @Autowired
    HttpServletRequest request;

    @Autowired
    CategoryRepository categoryRepository;

    @Pointcut("@annotation(ru.kpfu.itis.aop.annotations.IncludeCategoriesList)")
    public void includeCategoriesList(){
    }

    @Before("includeCategoriesList()")
    public void includeCategories() throws IOException {
        List<Category> categories = categoryRepository.findAll();
        request.setAttribute("categories", categories);
    }

}
