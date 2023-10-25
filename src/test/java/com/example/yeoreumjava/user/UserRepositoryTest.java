package com.example.yeoreumjava.user;

import com.example.yeoreumjava.common.constant.PageConstant;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
//@Transactional
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EntityScan(basePackageClasses = User.class)
@DataJdbcTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findUserByIds() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(6L);
        list.add(7L);
        System.out.println(list.toString());
        userRepository.findAllById(list).forEach(System.out::println);
    }

    @Test
    void loadUser() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        System.out.println(user);
    }

    @Test
    void test() {
        PageRequest pageRequest = PageRequest.of(0, PageConstant.SIZE);
    }
}