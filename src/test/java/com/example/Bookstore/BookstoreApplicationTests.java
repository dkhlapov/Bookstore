package com.example.Bookstore;

import com.example.Bookstore.web.BookController;
import com.example.Bookstore.web.UserController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() throws Exception{
		Assertions.assertThat(bookController).isNotNull();
		Assertions.assertThat(userController).isNotNull();
	}

}
