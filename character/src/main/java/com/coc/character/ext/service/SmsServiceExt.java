package com.coc.character.ext.service;

import com.coc.character.pojo.PhoneCheak;

/**
 * @author ran_ych
 * @create 2020-01-20  16:03
 * @desc 短信相关 短信下发
 */
public interface SmsServiceExt {
    /**
     *  短信下发功能
     * @param phoneCheak
     */
    String  sendMessage(PhoneCheak phoneCheak);
}
