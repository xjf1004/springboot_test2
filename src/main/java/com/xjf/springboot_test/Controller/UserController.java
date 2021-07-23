package com.xjf.springboot_test.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xjf.springboot_test.Service.UserService;
import com.xjf.springboot_test.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Wrapper;

/**
 * @author Refrain_ouc
 * @create 2021-07-21 10:35
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/xjf01")
    public String xjf01(@RequestParam("id") Long id,
                        @RequestParam("name") String name,
                        Model model)
    {

        User user = userService.getById(id);
        model.addAttribute("user",user);
        System.out.println("hello");
        return "table";

    }

    @GetMapping(value = "/")
    public String xjf02(){
        return "table";
    }

    @PostMapping("/xjf03")
    public String xjf03(@RequestParam("photos")MultipartFile[] photos,@RequestParam("name")String name,
                        @RequestParam("email")String email,@RequestParam("age")Integer age,
                        Model model) throws IOException {
        for (MultipartFile photo : photos) {
            String photoname = photo.getOriginalFilename();
            photo.transferTo(new File("D:\\java_learn\\springboot_test\\src\\main\\resources\\static\\img\\"+photoname));
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);
        userService.save(user);
        model.addAttribute("user",user);
        model.addAttribute("id",user.getId());
        model.addAttribute("name",name);
        model.addAttribute("email",email);
        model.addAttribute("age",age);
        return "table";


    }


}
