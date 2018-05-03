package com.vicente.light.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shiweisen
 * @since 2018-01-29
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Object> {
    //临时变量，保存flag值列表
    private String values;

    //初始化values的值
    @Override
    public void initialize(FlagValidator flagValidator) {
        //将注解内配置的值赋给临时变量
        this.values = flagValidator.values();
    }

    //实现验证
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String[] array = values.split(",");
        boolean isFlag = false;
        for (int i=0;i<array.length;i++){
            if (array[i].equals(value)){
                isFlag = true;
                break;
            }
        }
        return  isFlag;
    }
}