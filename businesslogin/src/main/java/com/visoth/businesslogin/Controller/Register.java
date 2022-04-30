package com.visoth.businesslogin.Controller;

import com.visoth.businesslogin.Entity.User;
import com.visoth.businesslogin.Service.UserService;
import com.visoth.businesslogin.Validate.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class Register {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(getClass().getName());
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/show")
    public String register(Model model)
    {
        model.addAttribute("validateUser",new ValidateUser());
        return "register";
    }
    @PostMapping("/process")
    public String registerNewAcc(@Valid @ModelAttribute("validateUser") ValidateUser validateUser, BindingResult errors, Model model){

        String user=validateUser.getEmail();
        logger.info("Processing registration form for: " + user);
        if(errors.hasErrors()){
            return "register";
        }
        User exist=userService.findUsername(user);
        if(exist !=null){
            model.addAttribute("validateUser",new ValidateUser());
            model.addAttribute("registerError","Username is not available");
            logger.warning("Username is not available");
            return "register";
        }
        userService.save(validateUser);
        logger.info("Success"+user);
        return "index";
    }
}
