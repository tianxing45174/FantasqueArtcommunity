package com.fantasque.common.validator.brandgroup.Custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Documented
//指定校验器
@Constraint(
        validatedBy = { ListValueConstraintValidator.class }
)
//作用位置
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
//作用时间
@Retention(RetentionPolicy.RUNTIME)
//可重复注解
//@Repeatable(List.class)
public @interface ListValue {
    //校验出错后错误信息在 {} 中取
    String message() default "{com.fantasque.common.validator.brandgroup.Custom.ListValue.message}";
    //支持分组校验
    Class<?>[] groups() default {};
    //自定义负载信息
    Class<? extends Payload>[] payload() default {};

    int[] vals() default { };
}
