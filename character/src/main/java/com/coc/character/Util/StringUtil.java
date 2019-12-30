package com.coc.character.Util;

/**
 * @author ran_ych
 * @create 2019-12-30  19:43
 * @desc
 */
public class StringUtil {
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
