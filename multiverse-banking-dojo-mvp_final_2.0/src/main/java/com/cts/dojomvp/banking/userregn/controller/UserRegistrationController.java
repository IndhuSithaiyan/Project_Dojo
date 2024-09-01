package com.cts.dojomvp.banking.userregn.controller;

import com.cts.dojomvp.banking.userregn.entity.User;
import com.cts.dojomvp.banking.userregn.model.UserLogin;
import com.cts.dojomvp.banking.userregn.model.UserRegistrationResponse;
import com.cts.dojomvp.banking.userregn.model.UserRequest;
import com.cts.dojomvp.banking.userregn.model.UserResponse;
import com.cts.dojomvp.banking.userregn.service.UserDetailsFetching;
import com.cts.dojomvp.banking.userregn.service.UserRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@RestController
public class UserRegistrationController {
    Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

    UserRegistrationService userRegistrationService;

    @Autowired
    UserDetailsFetching userDetailsFetching;

    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    static Long userAcct;
    static int userId;
    static BigDecimal amount;

    @RequestMapping("/index")
    public ModelAndView showHomePage(Model model){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping(value = "/show/user-regn-page")
    public ModelAndView getUserRegnPage(@ModelAttribute("userRequestModel") UserRequest userRequestModel
    , Model model) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");
        ModelAndView modelAndView = new ModelAndView("userregn",httpHeaders);
        model.addAttribute("userRequestModel",new UserRequest());
        return modelAndView;
    }

    @PostMapping(value = "/user-regn/createAccount")
    public ModelAndView registerUserAndCreateAccount(
            @ModelAttribute("userRequestModel") UserRequest userRequest
            , Model model
    ){
        UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
        UserResponse userResponse = new UserResponse();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");
        ModelAndView modelAndView = new ModelAndView("responsescreen",httpHeaders);

        try{
            userResponse = userRegistrationService.saveUserDetails(userRequest,userResponse);
            userRegistrationResponse.setStatusCode("200");
            userRegistrationResponse.setStatusDescription("Request successful - Account created");
            userRegistrationResponse.setUserResponse(userResponse);
        }
        catch (Exception e){
            userRegistrationResponse.setStatusCode("400");
            userRegistrationResponse.setStatusDescription("Exception occurred " + e.getMessage());
        }
        return modelAndView;
    }
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("login", new UserLogin());
        request.getSession().invalidate();
        return mav;
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("login", new UserLogin());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") UserLogin login,Model model) {
        ModelAndView mav = null;
        try {
            User user= userRegistrationService.validateUser(login.getUsername(),login.getPassword());
            if(user.getCustomerId()==login.getUsername() && user.getPassWord().equals(login.getPassword())) {
                mav = new ModelAndView("customerprofile");
                model.addAttribute("updateDetailsModel", user);
                userAcct = user.getAccountNumber();
                userId= user.getCustomerId();
                amount = user.getAmount();
            } else {
                mav = new ModelAndView("index");
                mav.addObject("message", "Username or Password is invalid!!");
            }

        }catch (Exception e){
            mav = new ModelAndView("index");
            mav.addObject("message", "Username or Password is invalid!!");
        }
        return mav;
    }

    @GetMapping(value = "/home-page")
    public ModelAndView getCustHomePage(Model model) {
        logger.info("show CustHomePage");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");
        ModelAndView mav = null;
        try{
                mav = new ModelAndView("customerprofile");
                User user = new User();
                user.setCustomerId(userId);
                user.setAccountNumber(userAcct);
                user.setAmount(amount);
                model.addAttribute("updateDetailsModel", user);
        }
        catch (Exception e){ logger.error("exception: {}", e.getMessage());
        }
        return mav;
    }

    @PostMapping("/user/user-details-updated")
    public ModelAndView updateUserDetails(@ModelAttribute("user") User user
            , Model model)
    {
        user= userDetailsFetching.updateDetails(user);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");

        ModelAndView modelAndView = new ModelAndView("customerprofile",httpHeaders );
        model.addAttribute("updateDetailsModel", user);
        return modelAndView;

    }

    @RequestMapping(value ="/show/user-registration-update")
    public ModelAndView getUserDetails(@RequestParam int customerId )
    {
        User user = userDetailsFetching.getAll(customerId);
        logger.info("User Details from controller:{} ", user.getPan());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");

        ModelAndView modelAndView = new ModelAndView("updatedetails",httpHeaders );

        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
