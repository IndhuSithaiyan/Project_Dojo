package com.cts.dojomvp.banking.loans.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanAccount implements Serializable {

    @Id
    @Column(name = "Loan_Account_Number")
    private Long loanAcctNumber;
    @Column(name = "Loan_Description")
    private String loanDescription;
    @Column(name = "Loan_Type")
    private String loanType;
    @Column(name = "Interest_Type")
    private String interestType;
    @Column(name = "Issued_Date")
    private String issuedDate;
    @Column(name = "Principal_Amount")
    private Long principalAmount;
    @Column(name = "Loan_Duration")
    private int loanDuration;
    @Column(name = "Rate_Of_Interest")
    private BigDecimal roi;
    @Column(name = "EMI")
    private int emi;
}
