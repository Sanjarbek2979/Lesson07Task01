package com.example.task01.aop;

import java.lang.annotation.*;

/**
 * @author Sanjarbek Allayev, вс 16:12. 24.04.2022
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPermission {
    String value();
}
