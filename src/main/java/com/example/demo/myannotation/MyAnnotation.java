package com.example.demo.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定義標籤
 *
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/25 上午 10:53
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface MyAnnotation {

    String describe() default "靠北";
    boolean needWrite() default false;

}
