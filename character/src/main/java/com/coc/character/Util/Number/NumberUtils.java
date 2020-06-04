package com.coc.character.Util.Number;

/**
 * @author ran_ych
 * @create 2020-05-28  15:29
 * @desc
 */
public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {

    /**
     * @param value
     * @param defaultVal
     * @return
     */
    public static Integer getDefaultIfNull(Integer value, Integer defaultVal) {
        if(null == value) {
            return defaultVal;
        }
        return value;
    }

    /**
     * @param value
     * @param defaultVal
     * @return
     */
    public static Long getDefaultIfNull(Long value, Long defaultVal) {
        if(null == value) {
            return defaultVal;
        }
        return value;
    }

}
