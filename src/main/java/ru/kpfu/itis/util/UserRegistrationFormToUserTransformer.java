package ru.kpfu.itis.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.UserRole;

public class UserRegistrationFormToUserTransformer {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User transform(UserRegistrationForm form) {
        if (form == null) {
            return null;
        }
        User user = new User();
        user.setUsername(form.getUsername().toLowerCase());
        user.setRole(UserRole.ROLE_USER);
        user.setPassword(encoder.encode(form.getPassword()));
        user.setAddress(form.getAddress());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setPostIndex(form.getPostIndex());
        user.setEmail(form.getEmail());
        return user;
    }
}
