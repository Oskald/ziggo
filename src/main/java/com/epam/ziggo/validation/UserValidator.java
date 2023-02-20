package com.epam.ziggo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.epam.ziggo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidator implements ConstraintValidator<UserValidationConstraint, String> {
    private final UserService userService;

    @Override
    public void initialize(UserValidationConstraint constraint) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return userService.findByEmail(email).isPresent();
    }
}
