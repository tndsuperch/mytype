package cn.mytype.utils;

import org.springframework.beans.BeanUtils;

public class BeanUtil {
    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }
}
