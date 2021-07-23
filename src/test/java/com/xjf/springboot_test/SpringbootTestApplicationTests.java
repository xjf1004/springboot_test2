package com.xjf.springboot_test;

import com.xjf.springboot_test.Mapper.UserMapper;
import com.xjf.springboot_test.Service.UserService;
import com.xjf.springboot_test.bean.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SpringbootTestApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {

        User user=new User();
        user.setAge(18);
        user.setEmail("1440@qq.com");
        user.setName("吴亦凡");
        int insert = userMapper.insert(user);
        log.info("插入的数量为：{}",insert);

    }

    @Test
    void test01(){
        User user = userMapper.selectById(6);
        log.info("{}",user);
    }

    @Test
    @DisplayName("测试逻辑删除")
    void test02(){
        User user = userMapper.selectById(6);
        int i = userMapper.deleteById(user.getId());

    }
    @Test
    @DisplayName("测试controller")
    void test03(){
        User user = userService.getById(7);
        System.out.println(user);

    }

}
