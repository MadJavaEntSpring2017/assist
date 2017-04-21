package com.bnisler.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MappingUtils {

    public void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }
}
