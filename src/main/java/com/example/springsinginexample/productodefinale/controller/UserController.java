package com.example.springsinginexample.productodefinale.controller;

import com.example.springsinginexample.productodefinale.model.BloodBag;
import com.example.springsinginexample.productodefinale.model.User;
import com.example.springsinginexample.productodefinale.service.BloodBagService;
import com.example.springsinginexample.productodefinale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BloodBagService bloodBagService;

    @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();

        model.setViewName("user/login");
        return model;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signup");

        return model;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signup");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("user/login");
        }

        return model;
    }

    @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        List<BloodBag> bloodBagList = bloodBagService.listAll();
        model.addObject("BloodbagList", bloodBagList) ;


        model.addObject("userName", user.getFirstname() + " " + user.getLastname());
        model.setViewName("home/home");
        return model;
    }

    @RequestMapping(value= {"/new"}, method=RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView model = new ModelAndView();
        BloodBag bloodBag = new BloodBag() ;
        model.addObject("bloodbag", bloodBag) ;
        model.setViewName("home/new_bloodbag");

        return model;
    }
  //not finished yet
    @RequestMapping(value = {"/new"}, method=RequestMethod.POST)
    public ModelAndView createBloodBag(@Valid BloodBag bloodBag) {
        System.out.println("Atejom iki cia");
        ModelAndView model = new ModelAndView();
        bloodBagService.saveBloodBag(bloodBag);
        model.addObject("msg", "Blood bag has been registered successfully!");
        model.addObject("bloodbag", new BloodBag());
        model.setViewName("home/home");

    return model;
    }




/*
    @RequestMapping(value = {"/home/registration"}, method = RequestMethod.POST)
    public String createbloodbag(Model model){

        BloodBag bloodBag = new BloodBag() ;
       */
/* BloodBag bloodBagExists = bloodBagService.find*//*


        model.addAttribute("bloodbag", bloodBag);
        return "home/new_bloodbag";

    }
*/

    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }
}
