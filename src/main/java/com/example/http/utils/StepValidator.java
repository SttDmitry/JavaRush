package com.example.http.utils;

import com.example.http.hw5.entities.MStep;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StepValidator implements ConstraintValidator<AStep, MStep> {

    @Override
    public boolean isValid(MStep mStep, ConstraintValidatorContext constraintValidatorContext) {
        if (mStep == null || mStep.getStepX() == null || mStep.getStepY() == null) {
            return false;
        } else return TicTacToe.isCellValid(Integer.parseInt(mStep.getStepX())-1, Integer.parseInt(mStep.getStepY())-1);
    }
}
