package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.OrderForm;
import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.service.BookService;
import ru.kpfu.itis.service.OrderService;

import javax.validation.Valid;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
@Controller
public class OrderController {

    @Autowired
    BookService bookService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String returnBuyForm(@ModelAttribute("id") Long id, Model model){
        model.addAttribute("book", bookService.findOneById(id));
        model.addAttribute("buyingform", new OrderForm());
        return "order-form";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String soldBook(
            @ModelAttribute("buyingform") @Valid OrderForm form,
            BindingResult result){
        if (result.hasErrors()) {
            return "order-form";
        }
        Order order = orderService.transformFormToOrder(form);
        orderService.saveNewOrder(order);
        return "redirect:/";
    }

}
