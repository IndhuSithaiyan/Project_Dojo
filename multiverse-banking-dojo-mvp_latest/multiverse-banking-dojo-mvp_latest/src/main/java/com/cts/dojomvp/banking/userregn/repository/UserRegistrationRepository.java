package com.cts.dojomvp.banking.userregn.repository;

import com.cts.dojomvp.banking.userregn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository<User, Integer> {
}
