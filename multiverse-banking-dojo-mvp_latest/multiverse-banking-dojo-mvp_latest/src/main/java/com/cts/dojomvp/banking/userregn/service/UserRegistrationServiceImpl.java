package com.cts.dojomvp.banking.userregn.service;

import com.cts.dojomvp.banking.userregn.entity.User;
import com.cts.dojomvp.banking.userregn.model.UserRequest;
import com.cts.dojomvp.banking.userregn.model.UserResponse;
import com.cts.dojomvp.banking.userregn.repository.UserRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {



    UserRegistrationRepository userRegistrationRepository;

    public UserRegistrationServiceImpl(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    @Override
    public UserResponse saveUserDetails(UserRequest userRequest, UserResponse userResponse) {
        User user = new User();
        int customerId = generateCustId();
        long accountNumber = generateAccountNumber();
        System.out.println("***======"+userRequest.getFirstName());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPan(userRequest.getPan());
        user.setEmailId(userRequest.getEmailId());
        user.setPassWord(userRequest.getPassWord());
        user.setAccountType(userRequest.getAccountType());
        user.setMobileNumber(userRequest.getMobileNumber());
        user.setCustomerId(userRequest.getCustomerId());
        user.setAccountNumber(userRequest.getAccountNumber());
        user.setAmount(userRequest.getAmount());
        System.out.println("**********"+userRequest.getCustomerId());
        userRegistrationRepository.saveAndFlush(user);
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCustomerId(user.getCustomerId());
        userResponse.setPan(user.getPan());
        userResponse.setMobileNumber(user.getMobileNumber());
        userResponse.setEmailId(user.getEmailId());
        userResponse.setAccountNumber(user.getAccountNumber());
        return userResponse;
    }

    public User validateUser(int customerId, String password) {
        User userDetails = userRegistrationRepository.findById(customerId).get();
        return userDetails;
    }
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        userRegistrationRepository.findAll().forEach(employee -> users.add(employee));
        return users;
    }

    public void deleteUserbyUserName(int customerId) {
        userRegistrationRepository.deleteById(customerId);
    }

    private static long generateAccountNumber() {
        long accountNumber = (long) (Math.random() * 100000000000000L);
        return accountNumber;
    }

    private static int generateCustId() {
        return (int) (Math.random() * 100000000);
    }


}
