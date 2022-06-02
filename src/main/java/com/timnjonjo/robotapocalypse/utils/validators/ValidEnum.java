package com.timnjonjo.robotapocalypse.utils.validators;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Constraint(validatedBy = EnumClassValidator.class)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnum {
    String message() default "Invalid Value.";
    Class<? extends Enum> enumClass();
    Class<?>[] groups() default {};
    Class<? extends javax.validation.Payload>[] payload() default {};
}
