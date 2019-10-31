package com.spring.Annotion;

import java.lang.annotation.*;

/**
 * @author ran_ych
 * @create 2019-10-30  14:45
 * @desc
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XRequestMapping {
    String value() default "";
}
