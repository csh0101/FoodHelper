package com.csh.food.user.base.domain.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class RegisterRequest  {

    @NotEmpty(message = "it should be construct of  number or character ")
    String userName;

    @Size(min = 5 , max = 12 , message = "密度的长度应该在5-12之间")
    String userPassword;

//    @NotEmpty
//    String userPhoneNumber;
//
//    @NotEmpty
//    Date userBirthDay;
//
//    @Email
//    String userEmail;


}
