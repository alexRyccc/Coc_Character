package com.hjb.ccp;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author ran_ych
 * @create 2020-05-26  11:06
 * @desc
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Order(-2147483648)
public @interface EncryptMethod {
}
