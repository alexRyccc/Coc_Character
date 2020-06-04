//package com.hjb.ccp;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Field;
//import java.util.Objects;
//
///**
// * @author ran_ych
// * @create 2020-05-26  11:25
// * @desc sm4加密解密切面
// */
//@Order(-2147483648)
//@Aspect
//@Component
//@ConditionalOnProperty(prefix = "sm4", value = "enable", matchIfMissing = false)
//public class Sm4Aspect {
//    private Logger log = LoggerFactory.getLogger(Sm4Aspect.class);
//    private static final String DEFAULT_KEY = "cc9368581322479ebf3e79348a2757d9";
//    public Sm4Aspect() {
//    }
//    @Pointcut("@annotation(com.hjb.ccp.EncryptMethod)")
//    public void EncryptAOPCut() {
//    }
//
//    @Pointcut("@annotation(com.hjb.ccp.DecryptMethod)")
//    public void DecryptAOPCut() {
//    }
//
//    @Around("EncryptAOPCut()")
//    public Object encryptMethodAop(ProceedingJoinPoint joinPoint) {
//        Object responseObj = null;
//        try {
//            responseObj = joinPoint.proceed();
//            this.handleEncrypt(responseObj);
//            //md5加密
//            String md5Data = Md5Utils.getMD5String(new Gson().toJson(responseObj));
//            SpringContextUtil.getHttpServletResponse().setHeader("md5",md5Data);
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            this.log.error("encryptMethodAop处理出现异常{}", throwable);
//        }
//        return responseObj;
//    }
//
//    @Around("DecryptAOPCut()")
//    public Object decryptMethodAop(ProceedingJoinPoint joinPoint) {
//        Object responseObj = null;
//        try {
//            responseObj = joinPoint.getArgs()[0];
//            //throw new RuntimeException("md5校验失败");
//            this.handleDecrypt(responseObj);
//            String md5 = "";
//            md5 = Md5Utils.getMD5String(new Gson().toJson(responseObj));
//            System.out.println(md5);
//            String origianlMd5 = "";
//            origianlMd5 = SpringContextUtil.getHttpServletRequest().getHeader("md5");
//            if(origianlMd5.equals(md5)){
//                responseObj = joinPoint.proceed();
//            }else{
//                this.log.error("参数的md5校验不同，可能存在篡改行为，请检查！");
//                throw new Exception("参数的md5校验不同，可能存在篡改行为，请检查！");
//            }
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            this.log.error("decryptMethodAop处理出现异常{}", throwable);
//        }
//        return responseObj;
//    }
//    private void handleEncrypt(Object requestObj) throws Exception {
//        if (!Objects.isNull(requestObj)) {
//            Field[] fields = requestObj.getClass().getDeclaredFields();
//            Field[] fieldsCopy = fields;
//            int fieldLength = fields.length;
//            for(int i = 0; i < fieldLength; ++i) {
//                Field field = fieldsCopy[i];
//                boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
//                if (hasSecureField) {
//                    field.setAccessible(true);
//                    String plaintextValue = (String)field.get(requestObj);
//                    String encryptValue = Sm4Utils.encryptEcb(DEFAULT_KEY, plaintextValue, "");
//                    field.set(requestObj, encryptValue);
//                }
//            }
//        }
//    }
//
//    private Object handleDecrypt(Object responseObj) throws Exception {
//        if (Objects.isNull(responseObj)) {
//            return null;
//        } else {
//            Field[] fields = responseObj.getClass().getDeclaredFields();
//            Field[] fieldsCopy = fields;
//            int fieldLength = fields.length;
//            for(int i = 0; i < fieldLength; ++i) {
//                Field field = fieldsCopy[i];
//                boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
//                if (hasSecureField) {
//                    field.setAccessible(true);
//                    String encryptValue = (String)field.get(responseObj);
//                    String plaintextValue = Sm4Utils.decryptEcb(DEFAULT_KEY, encryptValue, "");
//                    field.set(responseObj, plaintextValue);
//                }
//            }
//            return responseObj;
//        }
//    }
//}
