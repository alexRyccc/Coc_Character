package com.hjb.ccp;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ran_ych
 * @create 2020-05-26  10:10
 * @desc
 */
public class Sm4Utils {

    private static final String ENCODING = "UTF-8";
    public static final String ALGORIGTHM_NAME = "SM4";
    public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS7Padding";
    public static final int DEFAULT_KEY_SIZE = 128;

    public Sm4Utils() {
    }

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     *  @Description:生成ecb暗号
     */
    private static Cipher generateEcbCipher(String algorithmName, int mode, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithmName,BouncyCastleProvider.PROVIDER_NAME);
        Key sm4Key = new SecretKeySpec(key, ALGORIGTHM_NAME);
        cipher.init(mode, sm4Key);
        return cipher;
    }

    /**
     *  @Description:自动生成密钥
     */
    public static byte[] generateKey() throws Exception {
        return generateKey(DEFAULT_KEY_SIZE);
    }

    public static byte[] generateKey(int keySize) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(ALGORIGTHM_NAME, BouncyCastleProvider.PROVIDER_NAME);
        kg.init(keySize, new SecureRandom());
        return kg.generateKey().getEncoded();
    }


    /**
     *  @Description:加密
     */
    public static String encryptEcb(String hexKey, String paramStr, String charset) throws Exception {
        String cipherText = "";
        if (null != paramStr && !"".equals(paramStr)) {
            byte[] keyData = ByteUtils.fromHexString(hexKey);
            charset = charset.trim();
            if (charset.length() <= 0) {
                charset = ENCODING;
            }
            byte[] srcData = paramStr.getBytes(charset);
            byte[] cipherArray = encrypt_Ecb_Padding(keyData, srcData);
            cipherText = ByteUtils.toHexString(cipherArray);
        }
        return cipherText;
    }

    /**
     *  @Description:ecb秘钥生成
     */
    public static byte[] encrypt_Ecb_Padding(byte[] key, byte[] data) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
        byte[] bs = cipher.doFinal(data);
        return bs;
    }

    /**
     *  @Description:sm4解密
     */
    public static String decryptEcb(String hexKey, String cipherText, String charset) throws Exception {
        String decryptStr = "";
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        byte[] srcData = decrypt_Ecb_Padding(keyData, cipherData);
        charset = charset.trim();
        if (charset.length() <= 0) {
            charset = ENCODING;
        }
        decryptStr = new String(srcData, charset);
        return decryptStr;
    }

    /**
     *  @Description:ecb解密
     */
    public static byte[] decrypt_Ecb_Padding(byte[] key, byte[] cipherText) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(cipherText);
    }

    /**
     *  @Description:密码校验
     */
    public static boolean verifyEcb(String hexKey,String cipherText,String paramStr) throws Exception {
        boolean flag = false;
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        byte[] decryptData = decrypt_Ecb_Padding(keyData,cipherData);
        byte[] srcData = paramStr.getBytes(ENCODING);
        flag = Arrays.equals(decryptData,srcData);
        return flag;
    }

    /**
     *  @Description:测试类
     */
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(20,100,10, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        Map map=new HashMap<>();
        for (int i=0;i<1000;i++){
            int finalI = i;
            executor.submit(()->{
            System.out.println(Thread.currentThread().getName());
                int number = new Random().nextInt(100);
                try {
                    long start,end;
                    start = System.currentTimeMillis();
                    String json = "{\"name\":\"color\",\"sex\":\"man\"}"+number;
                    // 自定义的32位16进制密钥
                    String key = "888368581322491ace9q79348a2757d1";
                    String cipher = Sm4Utils.encryptEcb(key, json,ENCODING);
                    System.out.println("加密之后:"+cipher);
                    Thread.sleep(100);
                    json = Sm4Utils.decryptEcb(key, cipher,ENCODING);
                    System.out.println("解密:"+json);
                    System.out.println(Sm4Utils.verifyEcb(key, cipher, json));
                    System.out.println("密码校验:"+json);

                    end = System.currentTimeMillis();
                    System.out.println(finalI+"Run Time:" + (end - start) + "(ms)");
                    map.put(finalI,json);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        });
        }
    }

}

