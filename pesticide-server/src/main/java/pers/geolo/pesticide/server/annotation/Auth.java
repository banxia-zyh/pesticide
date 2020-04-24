package pers.geolo.pesticide.server.annotation;

import java.lang.annotation.*;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/8/2
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
    AuthType[] value() default AuthType.ALL;
}
