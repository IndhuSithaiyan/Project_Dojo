package com.cts.dojomvp.banking.userregn.service;

import com.cts.dojomvp.banking.userregn.entity.User;
import com.cts.dojomvp.banking.userregn.model.UserResponse;
import com.cts.dojomvp.banking.userregn.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsFetching implements UserDetails {

    @Autowired
    UserRegistrationRepository userRegistrationRepository;
    List<UserResponse> userDetailsList= new ArrayList<UserResponse>();

    public User getAll(int customerId)
    {


        User user = userRegistrationRepository.findById(customerId).get();
        return user;

    }

    public User updateDetails(User user)
    {

        return  userRegistrationRepository.save(user);

    }


}
