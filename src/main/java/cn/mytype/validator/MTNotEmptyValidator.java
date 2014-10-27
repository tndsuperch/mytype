package cn.mytype.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.mytype.validator.constraints.MTNotEmpty;

public class MTNotEmptyValidator implements ConstraintValidator<MTNotEmpty, String>{

    public void initialize(MTNotEmpty constraintAnnotation) {

    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || "".equals(value)) {
            return false;
        }
        return true;
    }
}

