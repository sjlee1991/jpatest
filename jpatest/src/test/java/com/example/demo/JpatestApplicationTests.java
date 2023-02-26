package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@Slf4j
@ActiveProfiles("...")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class JpatestApplicationTests {

	@Autowired
    UserRepository userRepository;

    @BeforeEach
    void insertTestData() {
        Users user = new Users();
        user.setUsername("lee sujin");
        userRepository.save(user);

        user = new Users();
        user.setUsername("seo hyojun");
        userRepository.save(user);

        user = new Users();
        user.setUsername("kim junho");
        userRepository.save(user);

        user = new Users();
        user.setUsername("gang nam");
        userRepository.save(user);

        user = new Users();
        user.setUsername("kim teihyung");
        userRepository.save(user);
    }

    @Test
    void findAllTest() {
        List<Users> userList = userRepository.findAll();
        for(Users u : userList) log.info("[FindAll]: " + u.getID() + " | " + u.getUsername());

    }

    @Test
    void find2ByNameTest() {
        List<Users> userList = userRepository.findFirst2ByUsernameLikeOrderByIDDesc("kim%");
        for(Users u : userList) log.info("[FindSome]: " + u.getID() + " | " + u.getUsername());
    }

}
