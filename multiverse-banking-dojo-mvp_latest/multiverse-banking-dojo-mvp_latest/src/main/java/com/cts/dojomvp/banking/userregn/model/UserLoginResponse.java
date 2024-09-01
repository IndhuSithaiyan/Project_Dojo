package com.cts.dojomvp.banking.userregn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponse {

    private String statusCode;
    private String statusDescription;
    private UserLogin userLogin;

    @Override
    public String toString() {
        return "userLoginResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", statusDescription='" + statusDescription + '\'' +
                ", userLogin=" + userLogin +
                '}';
    }

}
