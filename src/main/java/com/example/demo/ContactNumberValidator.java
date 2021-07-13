package com.example.demo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements
        ConstraintValidator<ContactNumberConstraint, String> {

    @Override
    public void initialize(ContactNumberConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        int size=contactField.length();
        if(contactField==null)return false;
        if(size<10 || size>12)return false;
        else if(size==11 && (contactField.charAt(0)!='0' || contactField.charAt(2)<'7' ||  contactField.charAt(2)>'9'))return false;
        else if(size==12 && (contactField.charAt(0)!='9' || contactField.charAt(1)!='1'  || contactField.charAt(2)<'7' ||  contactField.charAt(2)>'9'))return false;
        else{
            return contactField.matches("[0-9]+");
        }
    }

}