package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.Basket;
import ru.kpfu.itis.model.BasketItem;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.UserRole;
import ru.kpfu.itis.repository.BasketItemRepository;
import ru.kpfu.itis.repository.BasketRepository;
import ru.kpfu.itis.service.BasketItemService;

import java.util.List;

@Controller
public class BasketController {

    @Autowired
    BasketItemService basketItemService;

    @RequestMapping(value = "/basket/{id}")
    public String getBasketPage(@PathVariable("id") Long id, Model model){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.getId().equals(id)){
            return "redirect:/basket/"+user.getId();
        }
        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated() ||user.getRole().equals(UserRole.ROLE_ADMIN)){
            return "redirect:/";
        }

        List<BasketItem> items = basketItemService.getItemsByUserId(id);

        model.addAttribute("items", items);
        model.addAttribute("user", user);
        return "basket";
    }

    @RequestMapping(value = "/deletefrombasket")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFromBasket(@RequestParam("id") Long id){
        basketItemService.deleteItemById(id);
    }

    @RequestMapping(value = "/basket/getAll/{id}", method = RequestMethod.GET)
    public String getAllBasketItems(@PathVariable ("id") Long id,Model model) {
        List<BasketItem> items = basketItemService.getItemsByUserId(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("items", items);
        model.addAttribute("user", user);
        return "basket-items";
    }
}
