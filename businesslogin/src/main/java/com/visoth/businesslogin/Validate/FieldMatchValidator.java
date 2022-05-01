package com.visoth.businesslogin.Validate;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<CustomPasswordAnnotation, Object> {
    private String firstFieldName;
    private String secondFieldName;
    private String message;
    @Override
    public void initialize(CustomPasswordAnnotation constraintAnnotation) {
        firstFieldName=constraintAnnotation.first();
        secondFieldName=constraintAnnotation.second();
        message=constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid=true;
        try{
            final Object firstObject=new BeanWrapperImpl(o).getPropertyValue(firstFieldName);
            final Object secondObject=new BeanWrapperImpl(o).getPropertyValue(secondFieldName);
            valid=firstObject==null && secondObject==null || firstObject != null &&firstObject.equals(secondObject);
        }catch (final Exception ignor){

        }
        if(!valid){
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(secondFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }
}
