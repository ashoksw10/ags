package com.org.ags.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AccountDetailsEntity {
    private String name;
    @Id
    @GeneratedValue
    private Integer accountId;
    private String dateOfBirth;
    private String occupation;
    private String permanentAccountNumber;
    private String aadharNumber;
    private Long openingBalance;
    private String address;
    private String contactNumber;
    private String status;

    @Override
    public String toString() {
        return new StringBuffer(" AccountInformation : { ")
                .append(" name=").append(name).append(",")
                .append(" accountId=").append(accountId).append(",")
                .append(" dateOfBirth=").append(dateOfBirth).append(",")
                .append(" occupation=").append(occupation).append(",")
                .append(" permanentAccountNumber=").append(permanentAccountNumber).append(",")
                .append(" aadharNumber=").append(aadharNumber).append(",")
                .append(" openingBalance=").append(openingBalance).append(",")
                .append(" address=").append(address).append(",")
                .append(" contactNumber=").append(contactNumber).append(",")
                .append(" status=").append(status).append("}").toString();
    }
}
