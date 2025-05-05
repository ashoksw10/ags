package com.org.ags.model;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String userRole;
    private String status;
}
