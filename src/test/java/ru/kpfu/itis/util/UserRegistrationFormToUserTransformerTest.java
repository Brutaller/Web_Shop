package ru.kpfu.itis.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.model.User;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Azat Zaripov on 13.04.16.
 */
public class UserRegistrationFormToUserTransformerTest {

    UserRegistrationForm form;

    UserRegistrationFormToUserTransformer transformer;

    @Before
    public void setUp() {
        transformer = new UserRegistrationFormToUserTransformer();
        transformer.encoder = mock(BCryptPasswordEncoder.class);
        when(transformer.encoder.encode(anyString())).thenReturn("654321");
        form = new UserRegistrationForm();
        form.setEmail("a@m.c");
        form.setUsername("qwerty");
        form.setPassword("123456");
    }

    @Test
    public void transformTest() {
        User u = transformer.transform(form);
        Assert.assertNotNull(u);
    }

    @Test
    public void emailTest() {
        User u = transformer.transform(form);
        Assert.assertEquals("a@m.c", u.getEmail());
    }

    @Test
    public void usernameTest() {
        User u = transformer.transform(form);
        Assert.assertEquals("qwerty", u.getUsername());
    }

    @Test
    public void passTest() {
        User u = transformer.transform(form);
        Assert.assertEquals("654321", u.getPassword());
    }

}
