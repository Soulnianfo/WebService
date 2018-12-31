/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2;

import com.classphoto2.classphoto2.DTO.UserDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Souleymane
 */
class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserDTO user = (UserDTO) value;
        return user.getPassword().equals(user.getMatchingPassword());  //To change body of generated methods, choose Tools | Templates.
    }
    
}
