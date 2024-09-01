package com.cts.dojomvp.banking.loans.service;

import com.cts.dojomvp.banking.loans.entity.LoanAccount;
import com.cts.dojomvp.banking.loans.model.LoanAccountDetails;
import com.cts.dojomvp.banking.loans.model.LoanRequest;
import com.cts.dojomvp.banking.loans.repository.LoanRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

@Service
public class LoanServiceImpl implements LoanService {

    private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);
    private LoanRepository loanRepository;

    private ModelMapper modelMapper;

    static Long loan_acct_no;

    public LoanServiceImpl(LoanRepository loanRepository, ModelMapper modelMapper) {
        this.loanRepository = loanRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LoanAccountDetails applyLoan(LoanRequest loanRequest, LoanAccountDetails loanResponse) {
        logger.info("applying Loan based on user request :{}",loanRequest);
        LoanAccount loanAccount = new LoanAccount();
        loanAccount.setLoanAcctNumber(generateAccountNumber());
        logger.info("********** loanAccount.getLoanAcctNumber: "+loanAccount.getLoanAcctNumber());
        loanAccount.setLoanDescription("Successfully applied for "+ loanRequest.getLoanRequestType());
        loanAccount.setLoanType(loanRequest.getLoanRequestType());
        loanAccount.setInterestType(loanRequest.getInterestType());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        loanAccount.setIssuedDate((dtf.format(LocalDate.now())));
        loanAccount.setPrincipalAmount(loanRequest.getLoanAmount());
        loanAccount.setLoanDuration(loanRequest.getLoanDuration());
        loanAccount.setRoi(loanRequest.getRoi());
        loanAccount.setEmi(getEmiForAppliedLoan(loanAccount));
        logger.info("EMI : {} ", loanAccount.getEmi());
        LoanAccount savedLoan = loanRepository.saveAndFlush(loanAccount);
        logger.info("********** savedLoan Obj: "+savedLoan);
        loan_acct_no = savedLoan.getLoanAcctNumber();
        return loanDTOMapper(savedLoan);
    }

    public LoanAccountDetails viewLoanDetails(){
        LoanAccount loanAccount = loanRepository.findById(loan_acct_no).get();
        logger.info("********** fetched loanAccount: "+loanAccount);
        return loanDTOMapper(loanAccount);
    }


    private static long generateAccountNumber() {
        long accountNumber = (long) (Math.random() * 10000000000000L);
        return accountNumber;
    }

    private static int getEmiForAppliedLoan(LoanAccount loanAccount) {
        // EMI -> P x R x (1+r)^n/((1+r)^N – 1
        logger.info("getEmiForAppliedLoan");
        double roi = loanAccount.getRoi().doubleValue();
        double rate = roi/(12*100);
        double loanPeriod = roi * 12;
        int emi = (int)Math.round((loanAccount.getPrincipalAmount()*rate*Math.pow(1+rate,loanPeriod))/(Math.pow(1+rate,loanPeriod)-1));
        return emi;
    }

    private LoanAccountDetails loanDTOMapper(LoanAccount savedLoan){
        LoanAccountDetails res = modelMapper.map(savedLoan, LoanAccountDetails.class);
        logger.info("********** sloanDTOMapper: "+res);
        //UserDto userDto = this.modelMapper.map(user, UserDto.class);
        /*LoanAccountResponse res = new LoanAccountResponse();
        res.setLoanAcctNumber(savedLoan.getLoanAcctNumber());
        res.setLoanDescription(savedLoan.getLoanDescription());
        res.setPrincipalAmount(savedLoan.getPrincipalAmount());
        res.setLoanDuration(savedLoan.getLoanDuration());
        res.setLoanType(savedLoan.getLoanType());
        res.setInterestType(savedLoan.getInterestType());
        res.setRoi(savedLoan.getRoi());
        res.setIssuedDate(savedLoan.getIssuedDate());
        res.setEmi(savedLoan.getEmi());*/
        /*LoanAccountResponse res = new LoanAccountResponse();
        res.setLoanAcctNumber(savedLoan.getLoanAcctNumber());
        res.setLoanDescription(savedLoan.getLoanDescription());
        res.setPrincipalAmount(savedLoan.getPrincipalAmount());
        res.setLoanDuration(savedLoan.getLoanDuration());
        res.setLoanType(savedLoan.getLoanType());
        res.setInterestType(savedLoan.getInterestType());
        res.setRoi(savedLoan.getRoi());
        res.setIssuedDate(savedLoan.getIssuedDate());
        res.setEmi(savedLoan.getEmi());*/
        return res;
    }


}
