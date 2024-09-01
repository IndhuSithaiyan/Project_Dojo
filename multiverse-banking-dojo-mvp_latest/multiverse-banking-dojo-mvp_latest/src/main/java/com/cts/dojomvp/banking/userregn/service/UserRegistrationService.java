package com.cts.dojomvp.banking.userregn.service;

import com.cts.dojomvp.banking.userregn.entity.User;
import com.cts.dojomvp.banking.userregn.model.UserRequest;
import com.cts.dojomvp.banking.userregn.model.UserResponse;

import java.util.List;

public interface UserRegistrationService {

    public UserResponse saveUserDetails(UserRequest userRequest, UserResponse userResponse);
    public User validateUser(int customerId,String password);
    public List<User> getAllUsers();
    public void deleteUserbyUserName(int customerId);
}
