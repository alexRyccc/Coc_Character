package com.coc.character.Util.enums;

/**
 * @author ran_ych
 * @create 2020-01-20  16:09
 * @desc 短信业务常量
 */
public interface SMSHelper {
    //短信编号
    String SMS_NUMBER = "smsnumber";
    //短信下发间隔过短
    String SMS_INTERVAL_SHORT ="shortintervalsms";
    //短信频次正常
    String SMS_NORMAL ="normal";

    //免短信检查
    String SMS_FREE ="0";
    String NO_SMS_FREE ="1";
    //免短信验证通过
    String SMS_FREE_TRUE ="smstrue";

    //登陆短信
    String SMS_STATYS_SIGN="1";
    String REDIS_SMS_STATUS_SIGN ="smsstatussign";


    //注册短信
    String SMS_STATYS_REGISTER="0";
    //短信频次数量
    String REDIS_SMS_QUANTITY ="smsquantity";
    //短信自身状态
    String REDIS_SMS_STATUS ="smsstatus";
    //短信频次超频
    String SMS_REDUNDANCE ="redundancesms";
}
