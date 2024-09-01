package com.cts.dojomvp.banking.userregn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String firstName;

    private String lastName;

    private String passWord;

    private String accountType;

    private String pan;

    private Long mobileNumber;

    private String emailId;

    private int customerId = (int) (Math.random() * 100000000);

    private Long accountNumber = (long) (Math.random() * 100000000000000L);

    private BigDecimal amount;

}
