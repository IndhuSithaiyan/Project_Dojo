package com.cts.dojomvp.banking.userregn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String firstName;

    private String lastName;

    private String passWord;

    private String accountType;

    private String pan;

    private Long mobileNumber;

    private String emailId;

    private int customerId;

    private Long accountNumber;
}
