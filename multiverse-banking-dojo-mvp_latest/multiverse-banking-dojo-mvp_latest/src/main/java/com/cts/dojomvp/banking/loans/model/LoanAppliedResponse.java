package com.cts.dojomvp.banking.loans.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanAppliedResponse {

    private String statusCode;
    private String statusDescription;

    private LoanAccountDetails loanAccountResponse;

    @Override
    public String toString() {
        return "LoanAppliedResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", statusDescription='" + statusDescription + '\'' +
                ", loanAccountResponse=" + loanAccountResponse +
                '}';
    }

}
