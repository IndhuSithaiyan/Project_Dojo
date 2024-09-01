package com.cts.dojomvp.banking.loans.service;

import com.cts.dojomvp.banking.loans.model.LoanAccountDetails;
import com.cts.dojomvp.banking.loans.model.LoanRequest;

public interface LoanService {

    public LoanAccountDetails applyLoan(LoanRequest loanRequest, LoanAccountDetails loanResponse);
    public LoanAccountDetails viewLoanDetails();
}
