package com.example.demo.validation;

import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
@Component
public class UserValidator {
    ValidatorFactory factory;
    Validator validator;

    public UserValidator() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public boolean validate(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            log.warn(violation.getMessage());
        }
        return violations.isEmpty();
    }
}
