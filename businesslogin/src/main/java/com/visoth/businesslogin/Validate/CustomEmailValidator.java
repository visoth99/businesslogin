package com.visoth.businesslogin.Validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomEmailValidator implements ConstraintValidator<ValidateEmailAnnotation,String> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_FORM="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean isValid(final String s, final ConstraintValidatorContext constraintValidatorContext) {
        pattern=Pattern.compile(EMAIL_FORM);
        if(s==null){
            return false;
        }
        matcher=pattern.matcher(s);
        return matcher.matches();
    }
}
