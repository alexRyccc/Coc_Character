package com.coc.character.Util;

import com.coc.character.Util.enums.ParamHelper;

/**
 * @author ran_ych
 * @create 2020-01-21  15:09
 * @desc 过滤敏感字符
 */
public class FilterSpecialCharactersUtil {
    /**
     * 替换敏感字符
     * @param message
     * @return
     */
    public static String replaceSpecialCharacters(String message) {
        if (StringUtil.isBlank(message)) {
            return "";
        }
        for (String var : ParamHelper.FILETER_CHARACTERS) {
            message = message.replaceAll(var.trim(), ParamHelper.STITCHING_CHARACTERS);
        }
        return message;
    }
}
