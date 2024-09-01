package com.cts.dojomvp.banking.loans.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanAccountDetails {

    private Long loanAcctNumber;

    private String loanDescription;

    private String loanType;

    private String interestType;

    private String issuedDate;

    private Long principalAmount;

    private int loanDuration;

    private BigDecimal roi;

    private int emi;

}
