package com.hjb.ccp;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author ran_ych
 * @create 2020-05-26  11:07
 * @desc
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Order(-2147483648)
@Inherited
public @interface DecryptMethod {
}
