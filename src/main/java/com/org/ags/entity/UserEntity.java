package com.org.ags.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    public Integer userId;

    @NonNull
    public String userName;
    @NonNull
    public String password;
    @NonNull
    public String userRole;
    @NonNull
    public String status;

    @Override
    public String toString() {
        return new StringBuffer(" User : { ")
                .append(" userId=").append(userId).append(",")
                .append(" userName=").append(userName).append(",")
                .append(" password=").append(password).append(",")
                .append(" userRole=").append(userRole).append(",")
                .append(" status=").append(status).append("}").toString();
    }
}
