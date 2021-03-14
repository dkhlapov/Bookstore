package com.example.Bookstore;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsernameShouldReturnUser(){
        User user = userRepository.findUserByUsername("user");
        Assertions.assertThat(user.getEmail()).isEqualTo("user@gmail.com");
    }

    @Test
    public void createNewUser(){
        User user = new User("Dima", "$2y$10$7wmRQ9oTvN86JiEi6E4WduRC6wA3doI4Z94zQUjr3TJoQWmDcS3Y2 ", "USER", "dima@gmail.com");
        userRepository.save(user);
        Assertions.assertThat(user.getId()).isNotNull();
    }

    @Test
    public void deleteUser(){
        long id = userRepository.findUserByUsername("user").getId();
        userRepository.deleteById(id);
        Assertions.assertThat(userRepository.findById(id)).isEmpty();
    }
}
