package com.cts.dojomvp.banking.loans.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

    private String loanRequestType;

    private String interestType;

    private Long loanAmount;

    private int loanDuration;

    private BigDecimal roi;
}
