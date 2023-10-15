package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinMaxValidator implements ConstraintValidator<ValidMinMax, Part> {


    @Override
    public void initialize(ValidMinMax constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

//    @Override
//    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
//        if (part.getInv() <= part.getMax_inv() && part.getInv() >= part.getMin_inv()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();

        return constraintMin(part, constraintValidatorContext) && constraintMax(part, constraintValidatorContext);
    }

    //validates whether inventory is greater than the minimum
    public boolean constraintMin(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() < part.getMin_inv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory must be greater than min.").addConstraintViolation();
            return false;
        }
        return true;
    }

    //validates whether inventory is less than the maximum
    public boolean constraintMax(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() > part.getMax_inv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory must be less than max.").addConstraintViolation();
            return false;
        }
        return true;
    }
}