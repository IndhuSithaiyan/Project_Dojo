package com.cts.dojomvp.banking.userregn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationResponse {

    private String statusCode;
    private String statusDescription;
    private UserResponse userResponse;

    @Override
    public String toString() {
        return "UserRegistrationResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", statusDescription='" + statusDescription + '\'' +
                ", userResponse=" + userResponse +
                '}';
    }

}
