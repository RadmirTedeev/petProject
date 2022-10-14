package com.example.demo;

import com.example.demo.models.RoleEnum;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DemoApplication.class
)
@AutoConfigureMockMvc
public class CreateUser {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Ignore
    public void createUser() {
        User user = new User();
        user.setUsername("user2");
        user.setPassword("123456");
        user.setNonLocked(true);
        user.setEnabled(true);
        user.setEmail("user2@gmail.com");
        user.setRoles(List.of(RoleEnum.ADMIN, RoleEnum.USER));
        userRepository.save(user);
    }

    @Test
    @Ignore
    public void addRoleToUser() {
        Optional<User> optionalUser = userRepository.findByUsername("user1");
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setRoles(List.of(RoleEnum.USER));
            userRepository.save(user);
        }
    }
}
