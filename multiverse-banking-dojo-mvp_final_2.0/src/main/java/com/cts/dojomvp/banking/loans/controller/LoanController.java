package com.cts.dojomvp.banking.loans.controller;

import com.cts.dojomvp.banking.loans.model.LoanAccountDetails;
import com.cts.dojomvp.banking.loans.model.LoanAppliedResponse;
import com.cts.dojomvp.banking.loans.model.LoanRequest;
import com.cts.dojomvp.banking.loans.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoanController {

    Logger logger = LoggerFactory.getLogger(LoanController.class);

    LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loan")
    public ModelAndView showHomePage(Model model){
        ModelAndView modelAndView = new ModelAndView("loan");
        return modelAndView;
    }

    @GetMapping(value = "/loan/loan-request-page")
    public ModelAndView getLoanRequestPage(@ModelAttribute("loanRequestModel") LoanRequest loanRequestModel
    , Model model) {
        logger.info("Open LoanRequestPage");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");
        ModelAndView modelAndView = new ModelAndView("loanrequestscreen",httpHeaders);
        model.addAttribute("loanRequestModel", new LoanRequest());
        return modelAndView;
    }

    @GetMapping(value = "/loan/loan-account-page")
    public ModelAndView getLoanAccountDetails(Model model) {
        logger.info("show LoanAccountDetails");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");
        LoanAppliedResponse loanAppliedResponse = new LoanAppliedResponse();
        ModelAndView modelAndView = new ModelAndView("loanaccountres", httpHeaders);
        try{
            LoanAccountDetails loanAccountResponse = loanService.viewLoanDetails();
            loanAppliedResponse.setStatusCode("200");
            loanAppliedResponse.setStatusDescription("Successfully Retrieved Loan Account Details");
            loanAppliedResponse.setLoanAccountResponse(loanAccountResponse);
            model.addAttribute("loanResModel", loanAccountResponse);
        }
        catch (Exception e){
            loanAppliedResponse.setStatusCode("404");
            loanAppliedResponse.setStatusDescription("No Loan Account Exist " + e.getMessage());
        }
        return modelAndView;
    }

    @PostMapping(value = "/loan/loan-account-request")
    public ModelAndView loanAccountRequestAndCreation(
            @ModelAttribute("loanRequestModel") LoanRequest loanRequestModel
            , Model model
    ){
        logger.info("applying loan");
        LoanAppliedResponse loanAppliedResponse = new LoanAppliedResponse();
        LoanAccountDetails loanAccountResponse = new LoanAccountDetails();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");
        ModelAndView modelAndView = new ModelAndView("loanaccountdetailscreen",httpHeaders);

        try{
            loanAccountResponse = loanService.applyLoan(loanRequestModel, loanAccountResponse);
            loanAppliedResponse.setStatusCode("201");
            loanAppliedResponse.setStatusDescription("Request successful - Loan Account created");
            loanAppliedResponse.setLoanAccountResponse(loanAccountResponse);
            logger.info("loanAccountResponse: {}", loanAccountResponse);
            model.addAttribute("loanResModel", loanAccountResponse);
        }
        catch (Exception e){
            loanAppliedResponse.setStatusCode("400");
            loanAppliedResponse.setStatusDescription("Exception occurred " + e.getMessage());
        }
        return modelAndView;
    }

}
