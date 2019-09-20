package com.sen.springboot.util;

import java.util.List;
import java.util.function.Function;

public class ValidationFunction implements Function<List<Foo>, ValidationResult> {

    @Override
    public ValidationResult apply(List<Foo> fooList) {
        ValidationResult validationResult = new ValidationResult();
        fooList.forEach(s -> {
            if (s.getAmount() < 0) {
                validationResult.setResult(false);
                validationResult.setMessage("amount must bigger than 0");
            }
        });
        validationResult.setResult(true);
        return validationResult;
    }
}
