package com.example.demoSpringJPAExample.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = OnlyLettersValidator.class
)
public @interface OnlyLetters {

    String message() default "Only letters allowed here";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
