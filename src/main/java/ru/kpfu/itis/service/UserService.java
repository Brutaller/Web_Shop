package ru.kpfu.itis.service;

import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.User;

public interface UserService {

    void saveNewUser(User user);

    User transformFormToUser(UserRegistrationForm form);
}
