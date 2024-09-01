package com.cts.dojomvp.banking.userregn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "password")
    private String passWord;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "pan")
    private String pan;
    @Column(name = "mobile_number")
    private Long mobileNumber;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name = "amount")
    private BigDecimal amount;
}
