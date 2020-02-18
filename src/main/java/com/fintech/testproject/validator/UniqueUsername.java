package com.fintech.testproject.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UsernameUniqueValidator.class)
@Target({FIELD, ANNOTATION_TYPE, PARAMETER})
@Retention(RUNTIME)
public @interface UniqueUsername {
    String message() default "Username already exists!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}