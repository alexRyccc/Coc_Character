package com.hjb.ccp;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author ran_ych
 * @create 2020-05-26  11:14
 * @desc
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Order(-2147483648)
public @interface EncryptField {
}
