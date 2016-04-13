package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.Basket;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.BasketRepository;
import ru.kpfu.itis.service.BasketService;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.EmailSender;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    BasketService basketService;

    private static EmailSender emailSender = new EmailSender();

    @RequestMapping(value = "/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("userform", new UserRegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(
            @ModelAttribute("userform") @Valid UserRegistrationForm form,
            BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        User user = userService.transformFormToUser(form);
        userService.saveNewUser(user);
        Basket basket = new Basket();
        basket.setUser(user);
        basketService.save(basket);
        emailSender.send("Регистрация прошла успешно",
                "Вы успешно зарегестрировались на сайте localhost:8082 с логином "+user.getUsername(),
                "kazkachi2@gmail.com",
                user.getEmail());
        return "redirect:/";
    }

}
