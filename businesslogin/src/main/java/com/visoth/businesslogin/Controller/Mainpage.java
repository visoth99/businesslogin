package com.visoth.businesslogin.Controller;

import com.visoth.businesslogin.Entity.User;
import com.visoth.businesslogin.Service.UserService;
import com.visoth.businesslogin.Validate.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.List;

@Controller
public class Mainpage {

    @Autowired
    private UserService  userService;

    @GetMapping("/")
    public String mainView(Model model){
        List<User> users =userService.findAll();
        model.addAttribute("employees", users);
        return "index";
    }
    @GetMapping("/loginPage")
    public String loginPage(){

        return "loginPage";
    }
    @GetMapping("/forgotPassword")
    public String forgotPassword(){
        return "forgotPassword";
    }
    @PostMapping("/forgotPassword")
    public String forgotPassword(@ModelAttribute("forgotPassword") String email){

        return "redirect:forgotPassword";
    }


}
