package com.org.ags.model;

import lombok.Data;

@Data
public class AccountDetails {
    private String name;
    private Integer accountId;
    private String dateOfBirth;
    private String occupation;
    private String permanentAccountNumber;
    private String aadharNumber;
    private Long openingBalance;
    private String address;
    private String contactNumber;
    private String status;
}
