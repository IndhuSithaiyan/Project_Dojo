package com.cts.dojomvp.banking.loans.repository;

import com.cts.dojomvp.banking.loans.entity.LoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanAccount, Long> {
}
