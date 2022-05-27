package com.ms.customer.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

public class SexValidator implements ConstraintValidator<SexValidation,String> {
    ArrayList<String> sex = new ArrayList<String>();

    @Override
    public boolean isValid(String resultSex, ConstraintValidatorContext constraintValidatorContext) {

        sex.add("Masculino");
        sex.add("Feminino");


        return sex.contains(resultSex);

    }
}
