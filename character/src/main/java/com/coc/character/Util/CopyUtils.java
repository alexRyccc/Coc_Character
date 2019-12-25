package com.coc.character.Util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.*;

/**
 * @author ran_ych
 * @create 2019-10-12  16:57
 * @desc
 */
public class CopyUtils {

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 排除null值的拷贝
     * @param src
     * @param target
     */
    public static void copyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }
    /**
     * 转换成目标对象
     * @param src
     * @param tarClass
     * @param <T>
     * @return
     */
    public static <T> T convertObject(Object src, Class<T> tarClass){
        if (null == src){
            return null;
        }
        T t=null;
        try {
            t = tarClass.newInstance();
            copyProperties(src,t);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return t;
    }
}
