package ru.kpfu.itis.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Azat Zaripov on 13.04.16.
 */
public class UserServiceImplTest {

    UserServiceImpl userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void saveNewUserTest() {
        User user = new User();
//        UserRegistrationForm form = new UserRegistrationForm();
        user.setEmail("a@a.a");
        user.setUsername("lorem");
        user.setPassword("ipsum");

        userService.userRepository = mock(UserRepository.class);
        userService.saveNewUser(user);

        verify(userService.userRepository).save(Mockito.any(User.class));
    }

}
