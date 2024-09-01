Create schema CTS;

DROP TABLE IF EXISTS CTS.Loan_Account;

CREATE TABLE CTS.Loan_Account(
Loan_Account_Number BIGINT(14) PRIMARY KEY,
Loan_Description VARCHAR2(50),
Loan_Type VARCHAR2(30),
Interest_Type VARCHAR2(30),
Issued_Date VARCHAR2(20),
Principal_Amount BIGINT(14),
Loan_Duration INTEGER ,
Rate_Of_Interest NUMBER(5,2),
EMI INTEGER
);

INSERT INTO CTS.Loan_Account VALUES (9929361876962, 'Loan applied successfully for Car', 'Car Loan','Fixed', curdate(), 1000000, 8, 8.75, 25000);

SELECT * FROM CTS.LOAN_ACCOUNT;