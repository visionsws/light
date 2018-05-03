package com.vicente.light.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author shiweisen
 * @since 2018-01-29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
    //flag的有效值，多个用","隔开
    String values();
    //提示内容
    String message() default "flag不存在";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
